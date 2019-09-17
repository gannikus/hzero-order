package org.hzero.hand.hzeroorder.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.service.BaseService;
import org.hzero.hand.hzeroorder.api.DTO.OrderDTO;
import org.hzero.hand.hzeroorder.domain.entity.PurHeader;

import java.util.List;

/**
 * 采购订单头表应用服务
 *
 * @author gzm 2019-08-26 14:32:24
 */
public interface PurHeaderService {
    /**
     * 创建采购订单
     * @param orderDTO
     */
     void createPurOrder(OrderDTO orderDTO);

    /**
     * 修改采购订单
     * @param orderDTO
     */
     void updatePurOrder(OrderDTO orderDTO);

    /**
     * 删除采购订单
     * @param orderDTO
     */
     void deletePurOrder(OrderDTO orderDTO);

    /**
     * 查询采购订单
     * @param purHeaderId
     * @return
     */
     OrderDTO selectPurOrderByPrimaryKey(Long purHeaderId);

    /**
     * 模糊查询
     * @param pageRequest
     * @param purHeader
     * @return
     */
    Page<PurHeader> pageSelectLike(PageRequest pageRequest, PurHeader purHeader);

    /**
     * 修改订单状态
     * @param purOrderHeaders
     * @param status
     */
    void submitPurOrder(List<PurHeader> purOrderHeaders, String status);
}
