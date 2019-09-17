package org.hzero.hand.hzeroorder.api.controller.v1;

import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;


import org.hzero.hand.hzeroorder.config.SwaggerApiConfig;
import org.hzero.hand.hzeroorder.domain.entity.DeliveryNoteLine;
import org.hzero.hand.hzeroorder.domain.repository.DeliveryNoteLineRepository;
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

/**
 * 送货单行表 管理 API
 *
 * @author gzm 2019-08-27 20:47:28
 */
@RestController("deliveryNoteLineController.v1")
@RequestMapping("/v1/{organizationId}/delivery-note-lines")
@Api(tags = SwaggerApiConfig.DLYNOTELINE)
public class DeliveryNoteLineController extends BaseController {

    @Autowired
    private DeliveryNoteLineRepository deliveryNoteLineRepository;

    @ApiOperation(value = "送货单行表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<DeliveryNoteLine>> list(DeliveryNoteLine deliveryNoteLine, @ApiIgnore @SortDefault(value = DeliveryNoteLine.FIELD_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<DeliveryNoteLine> list = deliveryNoteLineRepository.pageAndSort(pageRequest, deliveryNoteLine);
        return Results.success(list);
    }

    @ApiOperation(value = "送货单行表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{lineId}")
    public ResponseEntity<DeliveryNoteLine> detail(@PathVariable Long lineId) {
        DeliveryNoteLine deliveryNoteLine = deliveryNoteLineRepository.selectByPrimaryKey(lineId);
        return Results.success(deliveryNoteLine);
    }

    @ApiOperation(value = "创建送货单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<DeliveryNoteLine> create(@RequestBody DeliveryNoteLine deliveryNoteLine) {
        validObject(deliveryNoteLine);
        deliveryNoteLineRepository.insertSelective(deliveryNoteLine);
        return Results.success(deliveryNoteLine);
    }

    @ApiOperation(value = "修改送货单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<DeliveryNoteLine> update(@RequestBody DeliveryNoteLine deliveryNoteLine) {
        SecurityTokenHelper.validToken(deliveryNoteLine);
        deliveryNoteLineRepository.updateByPrimaryKeySelective(deliveryNoteLine);
        return Results.success(deliveryNoteLine);
    }

    @ApiOperation(value = "删除送货单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody DeliveryNoteLine deliveryNoteLine) {
        SecurityTokenHelper.validToken(deliveryNoteLine);
        deliveryNoteLineRepository.deleteByPrimaryKey(deliveryNoteLine);
        return Results.success();
    }

}
