package org.hzero.hand.hzeroorder.api.DTO;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import javax.persistence.Id;

/**
 * 送货单显示dto
 *
 * @author gzm 2019/08/28 10:34
 */

@Getter
@Setter
public class DlyNoteDisplayDTO {

    @ApiModelProperty(value = "客户物料编码")
    private String itemCode;
    @ApiModelProperty(value = "客户物料名称")
    private String itemName;
    @ApiModelProperty(value = "订单号")
    @Id
    private String orderNum;
    @ApiModelProperty(value = "订单行号")
    private Long orderLineNum;
    @ApiModelProperty(value = "发运号")
    private Long shipmentNum;
    @ApiModelProperty(value = "版本号")
    private Long objectVersionNumber;
    @ApiModelProperty(value = "订单数量")
    private Long orderQuantity;
    @ApiModelProperty(value = "可发货数量")
    private Long eliverableQuantity;
    @ApiModelProperty(value = "单位")
    private String quantityUom;
    @ApiModelProperty(value = "需求日期")
    private Date demandDate;
    @ApiModelProperty(value = "承诺日期")
    private Date promiseDate;
    @ApiModelProperty(value = "客户")
    private String customer;
    @ApiModelProperty(value = "收获组织")
    private String receivedOrg;
    @ApiModelProperty(value = "收货库房")
    private String receivedWarehouse;
    @ApiModelProperty(value = "收货库位")
    private String receivedLocation;
    @ApiModelProperty(value = "收货地址")
    private String receivedAddr;
    @ApiModelProperty(value = "采购员")
    private String purAgent;
    @ApiModelProperty(value = "采购方行备注")
    private String buyerLineRemark;
    @ApiModelProperty(value = "供应商")
    private String supplier;
    @ApiModelProperty(value = "供应商地址")
    private String supplierAddress;
    @ApiModelProperty(value = "行状态")
    private String lineStatus;
    @ApiModelProperty(value = "行id")
    private Long purLineId;


}
