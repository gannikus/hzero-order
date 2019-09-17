package org.hzero.hand.hzeroorder.api.controller.v1;

import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.hand.hzeroorder.api.DTO.OrderDTO;
import org.hzero.hand.hzeroorder.app.service.PurHeaderService;
import org.hzero.hand.hzeroorder.config.SwaggerApiConfig;
import org.hzero.hand.hzeroorder.domain.entity.OrderStatusEnum;
import org.hzero.hand.hzeroorder.domain.entity.PurHeader;
import org.hzero.hand.hzeroorder.domain.repository.PurHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 采购订单头表 管理 API
 *
 * @author gzm 2019-08-26 14:32:24
 */

@RestController("purHeaderController.v1")
@RequestMapping("/v1/{organizationId}/pur-headers")
@Api(tags = SwaggerApiConfig.PURHEADER)
public class PurHeaderController extends BaseController {

    @Autowired
    private PurHeaderRepository purHeaderRepository;

    @Autowired
    private PurHeaderService purHeaderService;

    @ApiOperation(value = "采购订单头表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<PurHeader>> list(PurHeader purHeader, @ApiIgnore @SortDefault(value = PurHeader.FIELD_PUR_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<PurHeader> list = purHeaderRepository.pageAndSort(pageRequest, purHeader);

        return Results.success(list);
    }

    @ApiOperation(value = "采购订单头表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{purHeaderId}")
    public ResponseEntity<PurHeader> detail(@PathVariable Long purHeaderId) {
        PurHeader purHeader = purHeaderRepository.selectByPrimaryKey(purHeaderId);
        return Results.success(purHeader);
    }

    @ApiOperation(value = "创建采购订单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<PurHeader> create(@RequestBody PurHeader purHeader) {
        validObject(purHeader);
        purHeaderRepository.insertSelective(purHeader);
        return Results.success(purHeader);
    }

    @ApiOperation(value = "修改采购订单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<PurHeader> update(@RequestBody PurHeader purHeader) {
        SecurityTokenHelper.validToken(purHeader);
        purHeaderRepository.updateByPrimaryKeySelective(purHeader);
        return Results.success(purHeader);
    }

    @ApiOperation(value = "删除采购订单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<PurHeader> remove(@RequestBody PurHeader purHeader) {
        SecurityTokenHelper.validToken(purHeader);
        purHeaderRepository.deleteByPrimaryKey(purHeader);
        return Results.success();
    }


    @ApiOperation(value = "创建采购订单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/pur-order")
    public ResponseEntity<OrderDTO> createPurOrder(@RequestBody OrderDTO orderDTO) {
        validObject(orderDTO);
        purHeaderService.createPurOrder(orderDTO);
        return Results.success(orderDTO);
    }

    @ApiOperation(value = "修改采购订单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order")
    public ResponseEntity<OrderDTO> updatePurOrder(@RequestBody OrderDTO orderDTO) {
        //修改需要对头的_token进行验证
        SecurityTokenHelper.validToken(orderDTO.getPurHeader());
        purHeaderService.updatePurOrder(orderDTO);
        return Results.success(orderDTO);
    }

    @ApiOperation(value = "删除采购订单")
        @Permission(level = ResourceLevel.ORGANIZATION)
        @DeleteMapping("/pur-order")
        public ResponseEntity<OrderDTO> removePurOrder(@RequestBody OrderDTO orderDTO) {
            SecurityTokenHelper.validToken(orderDTO.getPurHeader());
            purHeaderService.deletePurOrder(orderDTO);
            return Results.success();
    }

    @ApiOperation(value = "采购订单头行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/pur-order/{purHeaderId}")
    public ResponseEntity<OrderDTO> purOrderDetail(@PathVariable Long purHeaderId) {
        OrderDTO orderDTO = purHeaderService.selectPurOrderByPrimaryKey(purHeaderId);
        return Results.success(orderDTO);
    }

    @ApiOperation(value = "采购订单头模糊查询")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/pur-order")
    public ResponseEntity<Page<PurHeader>> sleectPurOrderLike(PageRequest pageRequest,PurHeader purHeader) {

        return Results.success(purHeaderService.pageSelectLike(pageRequest,purHeader));
    }

    @ApiOperation(value = "订单已提交")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order/submitted")
    public ResponseEntity<?> updatePurOrderSubmitted(@RequestBody List<PurHeader> purHeaderList) {

        purHeaderService.submitPurOrder(purHeaderList, OrderStatusEnum.SUBMITTED.toString());
        return Results.success();
    }
    @ApiOperation(value = "审批通过")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order/approved")
    public ResponseEntity<?> updatePurOrderApproved(@RequestBody List<PurHeader> purHeaderList) {

        purHeaderService.submitPurOrder(purHeaderList, OrderStatusEnum.APPROVED.toString());
        return Results.success();
    }

    @ApiOperation(value = "审批拒绝")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order/pass")
    public ResponseEntity<?> updatePurOrderPass(@RequestBody List<PurHeader> purHeaderList) {

        purHeaderService.submitPurOrder(purHeaderList, OrderStatusEnum.PASS.toString());
        return Results.success();
    }

    @ApiOperation(value = "订单已发布")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order/release")
    public ResponseEntity<?> updatePurOrderRelease(@RequestBody List<PurHeader> purHeaderList) {

        purHeaderService.submitPurOrder(purHeaderList, OrderStatusEnum.RELEASE.toString());
        return Results.success();
    }

    @ApiOperation(value = "订单已确认")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order/deli-date-agreed")
    public ResponseEntity<?> updatePurOrderDelDateAgreed(@RequestBody List<PurHeader> purHeaderList) {

        purHeaderService.submitPurOrder(purHeaderList, OrderStatusEnum.CONFIRMED.toString());
        return Results.success();
    }

    @ApiOperation(value = "交期审核拒绝")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pur-order/deli-date-pass")
    public ResponseEntity<?> updatePurOrderDelDatePass(@RequestBody List<PurHeader> purHeaderList) {

        purHeaderService.submitPurOrder(purHeaderList, OrderStatusEnum.DELIVERY_DATE_PASS.toString());
        return Results.success();
    }
}
