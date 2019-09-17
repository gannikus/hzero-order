package org.hzero.hand.hzeroorder.app.service.impl;


import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.hand.hzeroorder.api.DTO.DeliveryNoteDTO;
import org.hzero.hand.hzeroorder.api.DTO.DlyNoteDisplayDTO;
import org.hzero.hand.hzeroorder.app.service.DeliveryNoteHeadService;
import org.hzero.hand.hzeroorder.domain.entity.*;
import org.hzero.hand.hzeroorder.domain.repository.DeliveryNoteHeadRepository;
import org.hzero.hand.hzeroorder.domain.repository.DeliveryNoteLineRepository;
import org.hzero.hand.hzeroorder.domain.repository.PurLineRepository;
import org.hzero.hand.hzeroorder.infra.mapper.DlyNoteDisplayDTOMapper;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 送货单头表应用服务默认实现
 *
 * @author gzm 2019-08-27 20:47:28
 */
@Service
public class DeliveryNoteHeadServiceImpl implements DeliveryNoteHeadService {
    @Autowired
    private DlyNoteDisplayDTOMapper dlyNoteDisplayDTOMapper;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;
    @Autowired
    private DeliveryNoteHeadRepository deliveryNoteHeadRepository;
    @Autowired
    private DeliveryNoteLineRepository deliveryNoteLineRepository;
    @Autowired
    private PurLineRepository purLineRepository;

    /**
     * 创建送货单前页面数据展示
     * @param pageRequest
     * @param dlyNoteDisplayDTO
     * @return
     */
    @Override
    public Page<DlyNoteDisplayDTO> deliveryList(PageRequest pageRequest, DlyNoteDisplayDTO dlyNoteDisplayDTO) {
        return PageHelper.doPage(pageRequest, () -> dlyNoteDisplayDTOMapper.dlyNoteDisplay(dlyNoteDisplayDTO));
    }

    /**
     * 新建送货单
     * @param dlyNoteDisplayDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DeliveryNoteDTO createDeliveryNote(List<DlyNoteDisplayDTO> dlyNoteDisplayDTO) {

        DeliveryNoteDTO deliveryNoteDTO = new DeliveryNoteDTO();
        List<DeliveryNoteLine> deliveryNoteLineList = new ArrayList<>();
        /**
         * 并单规则
         */
        Map<String, List<DlyNoteDisplayDTO>> map = dlyNoteDisplayDTO.stream().collect(Collectors.groupingBy(
                (d) -> {
                    return d.getCustomer() + d.getReceivedOrg() + d.getReceivedAddr();
                }
        ));
        //抛异常
        if (map.size() > 1) {
            throw new CommonException("Does not satisfy the union rule");
        }
        /**
         * 编码生成规则
         */
        String code = codeRuleBuilder.generateCode(Long.valueOf(0), "HPFM.DELIVERY_NOTE_CODE", "GLOBAL", "GLOBAL", null);
        //头数据赋值
        DeliveryNoteHead deliveryNoteHead = new DeliveryNoteHead(
                Long.valueOf(0),
                code,
                "标准送货单",
                dlyNoteDisplayDTO.get(0).getSupplier(),
                dlyNoteDisplayDTO.get(0).getCustomer(),
                dlyNoteDisplayDTO.get(0).getReceivedOrg(),
                dlyNoteDisplayDTO.get(0).getReceivedAddr(),
                dlyNoteDisplayDTO.get(0).getDemandDate(),
                dlyNoteDisplayDTO.get(0).getPromiseDate(),
                dlyNoteDisplayDTO.get(0).getSupplierAddress(),
                dlyNoteDisplayDTO.get(0).getBuyerLineRemark(),
                OrderStatusEnum.CREATED.toString()
        );
        deliveryNoteDTO.setDeliveryNoteHead(deliveryNoteHead);
        deliveryNoteHeadRepository.insert(deliveryNoteHead);
        Long headId = deliveryNoteHead.getHeadId();
        for (DlyNoteDisplayDTO dto : dlyNoteDisplayDTO) {
            //行数据循赋值
            DeliveryNoteLine deliveryNoteLine = new DeliveryNoteLine(
                    dto.getPurLineId(),
                    headId,
                    dto.getOrderLineNum(),
                    dto.getItemCode(),
                    dto.getItemName(),
                    dto.getOrderQuantity(),
                    dto.getEliverableQuantity(),
                    dto.getQuantityUom(),
                    dto.getEliverableQuantity(),
                    dto.getSupplier(),
                    dto.getOrderNum(),
                    dto.getOrderLineNum(),
                    dto.getShipmentNum(),
                    dto.getObjectVersionNumber(),
                    dto.getDemandDate(),
                    dto.getPromiseDate(),
                    dto.getPurAgent(),
                    dto.getBuyerLineRemark(),
                    dto.getLineStatus()
            );
            deliveryNoteLineList.add(deliveryNoteLine);
            deliveryNoteLineRepository.insert(deliveryNoteLine);

            //新建的同时修改采购订单的行状态为create表实已占用
            List<PurLine> purLineList = purLineRepository.select("purLineId", dto.getPurLineId());
            for (PurLine purLine : purLineList) {
                purLine.setLineStatus("create");
            }
            purLineRepository.batchUpdateOptional(purLineList, PurLine.FIELD_LINE_STATUAS);
        }
        deliveryNoteDTO.setDeliveryNoteLineList(deliveryNoteLineList);

        return deliveryNoteDTO;
    }
    /**
     * 送货单修改
     * @param deliveryNoteDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDeliveryNote(DeliveryNoteDTO deliveryNoteDTO) {
        Long headId = deliveryNoteDTO.getDeliveryNoteHead().getHeadId();
        deliveryNoteHeadRepository.updateByPrimaryKeySelective(deliveryNoteDTO.getDeliveryNoteHead());
        for (DeliveryNoteLine d : deliveryNoteDTO.getDeliveryNoteLineList()) {
            if (d.getHeadId() != null) {
                deliveryNoteLineRepository.updateByPrimaryKeySelective(d);
            } else {
                d.setHeadId(headId);
                deliveryNoteLineRepository.insert(d);
            }
        }

    }

    /**
     * 送货单删除
     * @param deliveryNoteDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDeliveryNote(DeliveryNoteDTO deliveryNoteDTO) {
        Long headId = deliveryNoteDTO.getDeliveryNoteHead().getHeadId();
        List<DeliveryNoteLine> lineList = deliveryNoteDTO.getDeliveryNoteLineList();

        deliveryNoteHeadRepository.deleteByPrimaryKey(headId);

        List<DeliveryNoteLine> deliveryNoteLineList = deliveryNoteLineRepository.select("headId", headId);
        //批量删除
        deliveryNoteLineRepository.batchDelete(deliveryNoteLineList);
        //删除的同时修改采购订单的行状态为new表示释放占用
        for (DeliveryNoteLine d : lineList) {
            Long lineId = d.getPurLineId();
            List<PurLine> purLineList = purLineRepository.select("purLineId", lineId);
            for (PurLine purLine : purLineList) {
                purLine.setLineStatus("new");
            }
            purLineRepository.batchUpdateOptional(purLineList, PurLine.FIELD_LINE_STATUAS);
        }


    }

    /**
     * 修改订单状态
     *
     * @param deliveryNoteHeads
     * @param status
     */
    @Override
    public void changeStatus(List<DeliveryNoteHead> deliveryNoteHeads, String status) {

        for (DeliveryNoteHead deliveryNoteHead : deliveryNoteHeads) {
            deliveryNoteHead.setStatus(status);
        }
        deliveryNoteHeadRepository.batchUpdateOptional(deliveryNoteHeads,
                DeliveryNoteHead.FIELD_STATUS);
    }

    /**
     * 送货单模糊查询
     * @param pageRequest
     * @param deliveryNoteHead
     * @return
     */
    @Override
    public Page<DeliveryNoteHead> selectDeliLike(PageRequest pageRequest, DeliveryNoteHead deliveryNoteHead) {
        List<DeliveryNoteHead> deliveryNoteHeadList = deliveryNoteHeadRepository.selectByCondition(
                Condition.builder(DeliveryNoteHead.class)
                        .andWhere(
                                Sqls.custom()
                                        .andLike("deliveryNum", deliveryNoteHead.getDeliveryNum())
                                        .andLike("deliveryType", deliveryNoteHead.getDeliveryType())
                        ).build()
        );
        Page<DeliveryNoteHead> deliveryNoteHeadPage = PageHelper.doPage(pageRequest, () -> deliveryNoteHeadList);
        return deliveryNoteHeadPage;
    }


}
