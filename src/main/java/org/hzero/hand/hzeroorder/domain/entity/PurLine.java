package org.hzero.hand.hzeroorder.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import java.math.BigDecimal;
import java.util.Date;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购订单行表
 *
 * @author gzm 2019-08-26 14:32:24
 */
@ApiModel("采购订单行表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_pur_line")
public class PurLine extends AuditDomain {

    public static final String FIELD_PUR_LINE_ID = "purLineId";
    public static final String FIELD_PUR_HEADER_ID = "purHeaderId";
    public static final String FIELD_LINE_NUM = "lineNum";
    public static final String FIELD_SHIPMENT_NUM = "shipmentNum";
    public static final String FIELD_ITEM_CODE = "itemCode";
    public static final String FIELD_ITEM_NAME = "itemName";
    public static final String FIELD_QUANTITY = "quantity";
    public static final String FIELD_QUANTITY_UOM = "quantityUom";
    public static final String FIELD_TAX_EXCLUDED_PRICE = "taxExcludedPrice";
    public static final String FIELD_TAX_EXCLUDED_LINE_AMOUNT = "taxExcludedLineAmount";
    public static final String FIELD_TAX = "tax";
    public static final String FIELD_CURRENCY_CODE = "currencyCode";
    public static final String FIELD_DEMAND_DATE = "demandDate";
    public static final String FIELD_PROMISE_DATE = "promiseDate";
    public static final String FIELD_RECEIVED_ORG = "receivedOrg";
    public static final String FIELD_RECEIVED_WAREHOUSE = "receivedWarehouse";
    public static final String FIELD_RECEIVED_LOCATION = "receivedLocation";
    public static final String FIELD_BUYER_LINE_REMARK = "buyerLineRemark";
    public static final String FIELD_FEEDBACK_INFO = "feedbackInfo";
	public static final String FIELD_LINE_STATUAS = "lineStatus";


    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("行表ID")
    @Id
    @GeneratedValue
    private Long purLineId;
    @ApiModelProperty(value = "头id")
    @NotNull
    private Long purHeaderId;
    @ApiModelProperty(value = "行号")
    @NotNull
    private Long lineNum;
    @ApiModelProperty(value = "发运号")
    @NotNull
    private Long shipmentNum;
    @ApiModelProperty(value = "物料编码")
    @NotBlank
    private String itemCode;
    @ApiModelProperty(value = "物料名称")
    @NotBlank
    private String itemName;
    @ApiModelProperty(value = "数量")
    @NotNull
    private BigDecimal quantity;
    @ApiModelProperty(value = "单位")
    @NotBlank
    private String quantityUom;
    @ApiModelProperty(value = "不含税单价")
    @NotNull
    private BigDecimal taxExcludedPrice;
    @ApiModelProperty(value = "不含税行金额")
    @NotNull
    private BigDecimal taxExcludedLineAmount;
    @ApiModelProperty(value = "税率")
    @NotNull
    private BigDecimal tax;
    @ApiModelProperty(value = "币种")
    @NotBlank
    private String currencyCode;
    @ApiModelProperty(value = "需求日期")
    @NotNull
    private Date demandDate;
    @ApiModelProperty(value = "承诺交期")
    @NotNull
    private Date promiseDate;
    @ApiModelProperty(value = "收货组织")
    @NotBlank
    private String receivedOrg;
    @ApiModelProperty(value = "收货库房")
    @NotBlank
    private String receivedWarehouse;
    @ApiModelProperty(value = "收货库位")
    @NotBlank
    private String receivedLocation;

	@ApiModelProperty(value = "地址")
	@NotNull
    private String receivedAddr;
	@ApiModelProperty(value = "行状态")
	private String lineStatus;
    @ApiModelProperty(value = "购买方行备注")
    @NotBlank
    private String buyerLineRemark;
    @ApiModelProperty(value = "反馈信息")
    @NotBlank
    private String feedbackInfo;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 行表ID
     */
	public Long getPurLineId() {
		return purLineId;
	}

	public void setPurLineId(Long purLineId) {
		this.purLineId = purLineId;
	}
    /**
     * @return 头id
     */
	public Long getPurHeaderId() {
		return purHeaderId;
	}

	public void setPurHeaderId(Long purHeaderId) {
		this.purHeaderId = purHeaderId;
	}
    /**
     * @return 行号
     */
	public Long getLineNum() {
		return lineNum;
	}

	public void setLineNum(Long lineNum) {
		this.lineNum = lineNum;
	}
    /**
     * @return 发运号
     */
	public Long getShipmentNum() {
		return shipmentNum;
	}

	public void setShipmentNum(Long shipmentNum) {
		this.shipmentNum = shipmentNum;
	}
    /**
     * @return 物料编码
     */
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
    /**
     * @return 物料名称
     */
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    /**
     * @return 数量
     */
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
    /**
     * @return 单位
     */
	public String getQuantityUom() {
		return quantityUom;
	}

	public void setQuantityUom(String quantityUom) {
		this.quantityUom = quantityUom;
	}
    /**
     * @return 不含税单价
     */
	public BigDecimal getTaxExcludedPrice() {
		return taxExcludedPrice;
	}

	public void setTaxExcludedPrice(BigDecimal taxExcludedPrice) {
		this.taxExcludedPrice = taxExcludedPrice;
	}
    /**
     * @return 不含税行金额
     */
	public BigDecimal getTaxExcludedLineAmount() {
		return taxExcludedLineAmount;
	}

	public void setTaxExcludedLineAmount(BigDecimal taxExcludedLineAmount) {
		this.taxExcludedLineAmount = taxExcludedLineAmount;
	}
    /**
     * @return 税率
     */
	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
    /**
     * @return 币种
     */
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
    /**
     * @return 需求日期
     */
	public Date getDemandDate() {
		return demandDate;
	}

	public void setDemandDate(Date demandDate) {
		this.demandDate = demandDate;
	}
    /**
     * @return 承诺交期
     */
	public Date getPromiseDate() {
		return promiseDate;
	}

	public void setPromiseDate(Date promiseDate) {
		this.promiseDate = promiseDate;
	}
    /**
     * @return 收货组织
     */
	public String getReceivedOrg() {
		return receivedOrg;
	}

	public void setReceivedOrg(String receivedOrg) {
		this.receivedOrg = receivedOrg;
	}
    /**
     * @return
     */
	public String getReceivedWarehouse() {
		return receivedWarehouse;
	}

	public void setReceivedWarehouse(String receivedWarehouse) {
		this.receivedWarehouse = receivedWarehouse;
	}
    /**
     * @return
     */
	public String getReceivedLocation() {
		return receivedLocation;
	}

	public void setReceivedLocation(String receivedLocation) {
		this.receivedLocation = receivedLocation;
	}
    /**
     * @return
     */
	public String getBuyerLineRemark() {
		return buyerLineRemark;
	}

	public void setBuyerLineRemark(String buyerLineRemark) {
		this.buyerLineRemark = buyerLineRemark;
	}
    /**
     * @return
     */
	public String getFeedbackInfo() {
		return feedbackInfo;
	}

	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	public String getReceivedAddr() {
		return receivedAddr;
	}

	public void setReceivedAddr(String receivedAddr) {
		this.receivedAddr = receivedAddr;
	}

	public String getLineStatus() {
		return lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}
}
