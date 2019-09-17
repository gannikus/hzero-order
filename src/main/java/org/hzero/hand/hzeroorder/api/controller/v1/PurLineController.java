package org.hzero.hand.hzeroorder.api.controller.v1;

import io.choerodon.swagger.SwaggerConfig;
import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.hand.hzeroorder.config.SwaggerApiConfig;
import org.hzero.hand.hzeroorder.domain.entity.PurLine;
import org.hzero.hand.hzeroorder.domain.repository.PurLineRepository;
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
 * 采购订单行表 管理 API
 *
 * @author gzm 2019-08-26 14:32:24
 */

@RestController("purLineController.v1")
@RequestMapping("/v1/{organizationId}/pur-lines")
@Api(tags = SwaggerApiConfig.PURLINE)
public class PurLineController extends BaseController {

    @Autowired
    private PurLineRepository purLineRepository;

    @ApiOperation(value = "采购订单行表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<PurLine>> list(PurLine purLine, @ApiIgnore @SortDefault(value = PurLine.FIELD_PUR_LINE_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<PurLine> list = purLineRepository.pageAndSort(pageRequest, purLine);
        return Results.success(list);
    }

    @ApiOperation(value = "采购订单行表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{purLineId}")
    public ResponseEntity<PurLine> detail(@PathVariable Long purLineId) {
        PurLine purLine = purLineRepository.selectByPrimaryKey(purLineId);
        return Results.success(purLine);
    }

    @ApiOperation(value = "创建采购订单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<PurLine> create(@RequestBody PurLine purLine) {
        validObject(purLine);
        purLineRepository.insertSelective(purLine);
        return Results.success(purLine);
    }

    @ApiOperation(value = "修改采购订单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<PurLine> update(@RequestBody PurLine purLine) {
        SecurityTokenHelper.validToken(purLine);
        purLineRepository.updateByPrimaryKeySelective(purLine);
        return Results.success(purLine);
    }

    @ApiOperation(value = "删除采购订单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<PurLine> remove(@RequestBody PurLine purLine) {
        SecurityTokenHelper.validToken(purLine);
        purLineRepository.deleteByPrimaryKey(purLine);
        return Results.success();
    }

}
