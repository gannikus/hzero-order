package org.hzero.hand.hzeroorder.api.controller.v1;

import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;

import org.hzero.hand.hzeroorder.api.DTO.DeliveryNoteDTO;
import org.hzero.hand.hzeroorder.api.DTO.DlyNoteDisplayDTO;
import org.hzero.hand.hzeroorder.app.service.DeliveryNoteHeadService;
import org.hzero.hand.hzeroorder.config.SwaggerApiConfig;
import org.hzero.hand.hzeroorder.domain.entity.DeliveryNoteHead;
import org.hzero.hand.hzeroorder.domain.entity.OrderStatusEnum;
import org.hzero.hand.hzeroorder.domain.repository.DeliveryNoteHeadRepository;
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
 * 送货单头表 管理 API
 *
 * @author gzm 2019-08-27 20:47:28
 */
@RestController("deliveryNoteHeadController.v1")
@RequestMapping("/v1/{organizationId}/delivery-note-heads")
@Api(tags = SwaggerApiConfig.DLYNOTEHEAD)
public class DeliveryNoteHeadController extends BaseController {

    @Autowired
    private DeliveryNoteHeadRepository deliveryNoteHeadRepository;
    @Autowired
    private DeliveryNoteHeadService deliveryNoteHeadService;

    @ApiOperation(value = "送货单头表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<DeliveryNoteHead>> list(DeliveryNoteHead deliveryNoteHead, @ApiIgnore @SortDefault(value = DeliveryNoteHead.FIELD_HEAD_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<DeliveryNoteHead> list = deliveryNoteHeadRepository.pageAndSort(pageRequest, deliveryNoteHead);
        return Results.success(list);
    }

    @ApiOperation(value = "送货单头表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{headId}")
    public ResponseEntity<DeliveryNoteHead> detail(@PathVariable Long headId) {
        DeliveryNoteHead deliveryNoteHead = deliveryNoteHeadRepository.selectByPrimaryKey(headId);
        return Results.success(deliveryNoteHead);
    }

    @ApiOperation(value = "创建送货单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<DeliveryNoteHead> create(@RequestBody DeliveryNoteHead deliveryNoteHead) {
        validObject(deliveryNoteHead);
        deliveryNoteHeadRepository.insertSelective(deliveryNoteHead);
        return Results.success(deliveryNoteHead);
    }

    @ApiOperation(value = "修改送货单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<DeliveryNoteHead> update(@RequestBody DeliveryNoteHead deliveryNoteHead) {
        SecurityTokenHelper.validToken(deliveryNoteHead);
        deliveryNoteHeadRepository.updateByPrimaryKeySelective(deliveryNoteHead);
        return Results.success(deliveryNoteHead);
    }

    @ApiOperation(value = "删除送货单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody DeliveryNoteHead deliveryNoteHead) {
        SecurityTokenHelper.validToken(deliveryNoteHead);
        deliveryNoteHeadRepository.deleteByPrimaryKey(deliveryNoteHead);
        return Results.success();
    }

    @ApiOperation(value = "送货单创建页面分页查询")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/delivery-note")
    public ResponseEntity<Page<DlyNoteDisplayDTO>> deliveryList(DlyNoteDisplayDTO dlyNoteDisplayDTO, PageRequest pageRequest) {
        Page<DlyNoteDisplayDTO> list =deliveryNoteHeadService.deliveryList(pageRequest,dlyNoteDisplayDTO);
        return Results.success(list);
    }

    @ApiOperation(value = "创建送货单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/create")
    public ResponseEntity<DeliveryNoteDTO> createPurOrder(@RequestBody List<DlyNoteDisplayDTO> dlyList) {
        DeliveryNoteDTO deliveryNoteDTO = deliveryNoteHeadService.createDeliveryNote(dlyList);
        return Results.success(deliveryNoteDTO);
    }

    @ApiOperation(value = "修改保存送货单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/delivery-note")
    public ResponseEntity<DeliveryNoteDTO> update(@RequestBody DeliveryNoteDTO deliveryNoteDTO) {
        SecurityTokenHelper.validToken(deliveryNoteDTO.getDeliveryNoteHead());
        deliveryNoteHeadService.saveDeliveryNote(deliveryNoteDTO);
        return Results.success(deliveryNoteDTO);
    }

    @ApiOperation(value = "删除送货单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/delivery-note")
    public ResponseEntity<DeliveryNoteDTO> remove(@RequestBody DeliveryNoteDTO deliveryNoteDTO) {
        SecurityTokenHelper.validToken(deliveryNoteDTO.getDeliveryNoteHead());
        deliveryNoteHeadService.deleteDeliveryNote(deliveryNoteDTO);
        return Results.success();
    }

    @ApiOperation(value = "送货单提交")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/delivery-note/submitted")
    public ResponseEntity<?> updateDeliSubmitted(@RequestBody List<DeliveryNoteHead> deliveryNoteHeadList) {

        deliveryNoteHeadService.changeStatus(deliveryNoteHeadList, OrderStatusEnum.SUBMITTED.toString());
        return Results.success();
    }

    @ApiOperation(value = "送货单审批通过")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/delivery-note/approved")
    public ResponseEntity<?> updateDeliApproved(@RequestBody List<DeliveryNoteHead> deliveryNoteHeadList) {

        deliveryNoteHeadService.changeStatus(deliveryNoteHeadList, OrderStatusEnum.APPROVED.toString());
        return Results.success();
    }

    @ApiOperation(value = "送货单审批拒绝")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/delivery-note/refused")
    public ResponseEntity<?> updateDeliRefused(@RequestBody List<DeliveryNoteHead> deliveryNoteHeadList) {

        deliveryNoteHeadService.changeStatus(deliveryNoteHeadList, OrderStatusEnum.REFUSED.toString());
        return Results.success();
    }

    @ApiOperation(value = "送货单作废")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/delivery-note/cancellation")
    public ResponseEntity<?> updateDeliCancellation(@RequestBody List<DeliveryNoteHead> deliveryNoteHeadList) {

        deliveryNoteHeadService.changeStatus(deliveryNoteHeadList, OrderStatusEnum.CANCELLATION.toString());
        return Results.success();
    }

    @ApiOperation(value = "送货单模糊查询")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/delivery-note/like")
    public ResponseEntity<Page<DeliveryNoteHead>> deliSelectLike(DeliveryNoteHead deliveryNoteHead,  PageRequest pageRequest) {
        Page<DeliveryNoteHead> list = deliveryNoteHeadService.selectDeliLike(pageRequest,deliveryNoteHead);
        return Results.success(list);
    }

}
