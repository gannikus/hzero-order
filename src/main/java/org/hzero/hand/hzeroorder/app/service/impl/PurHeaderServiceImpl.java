package org.hzero.hand.hzeroorder.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.hand.hzeroorder.api.DTO.OrderDTO;
import org.hzero.hand.hzeroorder.app.service.PurHeaderService;
import org.hzero.hand.hzeroorder.domain.entity.PurHeader;
import org.hzero.hand.hzeroorder.domain.entity.PurLine;
import org.hzero.hand.hzeroorder.domain.repository.PurHeaderRepository;
import org.hzero.hand.hzeroorder.domain.repository.PurLineRepository;
import org.hzero.hand.hzeroorder.infra.constant.PurConstants;
import org.hzero.hand.hzeroorder.infra.mapper.PurHeaderMapper;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 采购订单头表应用服务默认实现
 *
 * @author gzm 2019-08-26 14:32:24
 */
@Service
public class PurHeaderServiceImpl implements PurHeaderService {

    @Autowired
    private CodeRuleBuilder codeRuleBuilder;
    @Autowired
    private PurHeaderRepository purHeaderRepository;
    @Autowired
    private PurLineRepository purLineRepository;
    @Autowired
    private PurHeaderMapper purHeaderMapper;

    /**
     * 创建采购订单
     * @param orderDTO
     */
    @Override
    public void createPurOrder(OrderDTO orderDTO){
        //生成采购单编号
        String code = codeRuleBuilder.generateCode(Long.valueOf(0), "HPFM.ORDER_CODE", "GLOBAL","GLOBAL", null);
        PurHeader purHeader = orderDTO.getPurHeader();
        Assert.notNull(purHeader, PurConstants.ErrorCode.ERROR_BID_SUPPLIERS_NOT_EXIST);
        //传入采购单编码
        purHeader.setPurOrderNumber(code);
        //新建订单状态默认为new
        purHeader.setOrderStatus("NEW");
        purHeaderRepository.insert(purHeader);
        //查询采购订单头id
        Long purHeaderId = purHeader.getPurHeaderId();
        List<PurLine> purLineList = orderDTO.getPurLineList();
        if (CollectionUtils.isEmpty(purLineList)){
            purLineList.forEach(purLine -> purLine.setPurHeaderId(purHeaderId));

            purLineRepository.batchInsert(orderDTO.getPurLineList());
        }
        else{
            for (PurLine purLine : orderDTO.getPurLineList()){
                //判断头id是否存在，如果存在就做修改操作不存就新增
                if (purLine.getPurHeaderId()!=null){
                    purLineRepository.updateByPrimaryKeySelective(purLine);
                }
                else {
                    //将头id插入到行表
                    purLine.setPurHeaderId(purHeaderId);
                    purLineRepository.insert(purLine);
                }
            }
            }
    }

    /**
     * 修改采购订单
     * @param orderDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePurOrder(OrderDTO orderDTO) {

        Long headerId = orderDTO.getPurHeader().getPurHeaderId();
        purHeaderRepository.updateByPrimaryKeySelective(orderDTO.getPurHeader());
        for (PurLine purline: orderDTO.getPurLineList()) {
            if (purline.getPurHeaderId()!=null){
            purLineRepository.updateByPrimaryKeySelective(purline);
            }
            else{
                purline.setPurHeaderId(headerId);
                purLineRepository.insert(purline);
            }
        }

    }

    /**
     * 删除采购订单
     * @param orderDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePurOrder(OrderDTO orderDTO) {
        PurHeader purHeader = orderDTO.getPurHeader();
        //获取头id
        Long purHeaderId = purHeader.getPurHeaderId();
        purHeaderRepository.deleteByPrimaryKey(purHeader);
        //查询该头id下的行数据
        List<PurLine> purLineList = purLineRepository.select("purHeaderId", purHeaderId);
        //批量删除行数据
        purLineRepository.batchDelete(purLineList);
    }

    /**
     * 按主键查询头表信息并将行表数据一起查出
     * @param purHeaderId
     * @return
     */
    @Override
    public OrderDTO selectPurOrderByPrimaryKey(Long purHeaderId) {
        PurHeader purHeader = purHeaderRepository.selectByPrimaryKey(purHeaderId);
        List<PurLine> purLineList = purLineRepository.select("purHeaderId", purHeaderId);
        OrderDTO orderDTO =new OrderDTO();
        orderDTO.setPurHeader(purHeader);
        orderDTO.setPurLineList(purLineList);
        return orderDTO;
    }

    /**
     * 对采购订单进行模糊查询
     * @param purHeader
     * @return
     */
    @Override
    public Page<PurHeader> pageSelectLike(PageRequest pageRequest, PurHeader purHeader) {

        return PageHelper.doPage(pageRequest, () -> purHeaderMapper.selectLike(purHeader));
    }

    /**
     * 修改订单状态
     * @param purOrderHeaders
     * @param status
     */
    @Override
    public void submitPurOrder(List<PurHeader> purOrderHeaders, String status) {

        for (PurHeader purHeader : purOrderHeaders) {
            SecurityTokenHelper.validToken(purHeader);
            purHeader.setOrderStatus(status);

        }
        purHeaderRepository.batchUpdateOptional(purOrderHeaders,
                PurHeader.FIELD_ORDER_STATUS);
    }
}
