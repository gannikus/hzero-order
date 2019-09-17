package org.hzero.hand.hzeroorder.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.hand.hzeroorder.api.DTO.DeliveryNoteDTO;
import org.hzero.hand.hzeroorder.api.DTO.DlyNoteDisplayDTO;
import org.hzero.hand.hzeroorder.domain.entity.DeliveryNoteHead;
import org.hzero.hand.hzeroorder.domain.entity.PurHeader;

import java.util.List;

/**
 * 送货单头表应用服务
 *
 * @author gzm 2019-08-27 20:47:28
 */
public interface DeliveryNoteHeadService {

    /**
     * 送货单创建页面分页查询
     * @param pageRequest
     * @param dlyNoteDisplayDTO
     * @return
     */
    Page<DlyNoteDisplayDTO> deliveryList(PageRequest pageRequest, DlyNoteDisplayDTO dlyNoteDisplayDTO);

    /**
     * 创建送货单
     * @param dlyNoteDisplayDTO
     */
    DeliveryNoteDTO createDeliveryNote(List<DlyNoteDisplayDTO> dlyNoteDisplayDTO);

    /**
     * 修改送货单
     * @param deliveryNoteDTO
     */
    void saveDeliveryNote(DeliveryNoteDTO deliveryNoteDTO);

    /**
     * 删除送货单
     * @param deliveryNoteDTO
     */
    void deleteDeliveryNote(DeliveryNoteDTO deliveryNoteDTO);

    /**
     * 修改订单状态
     * @param deliveryNoteHeads
     * @param status
     */
    public void changeStatus(List<DeliveryNoteHead> deliveryNoteHeads, String status);

    /**
     * 头表模糊查询
     * @param deliveryNoteHead
     * @return
     */
    Page<DeliveryNoteHead> selectDeliLike(PageRequest pageRequest, DeliveryNoteHead deliveryNoteHead);
}
