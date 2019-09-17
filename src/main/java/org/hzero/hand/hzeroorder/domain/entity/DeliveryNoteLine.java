package org.hzero.hand.hzeroorder.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 送货单行表
 *
 * @author gzm 2019-08-27 20:47:28
 */
@ApiModel("送货单行表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "delivery_note_line")
public class DeliveryNoteLine extends AuditDomain {

    public static final String FIELD_LINE_ID = "lineId";
    public static final String FIELD_HEAD_ID = "headId";
    public static final String FIELD_LINE_NUMBER = "lineNumber";
    public static final String FIELD_CUSTOMER_ITEM_NUM = "customerItemNum";
    public static final String FIELD_CUSTOMER_NAME = "customerName";
    public static final String FIELD_ORDER_QUANTITY = "orderQuantity";
    public static final String FIELD_MAY_DELIVER_GOODS = "mayDeliverGoods";
    public static final String FIELD_UNIT = "unit";
    public static final String FIELD_THIS_DELIVER_GOODS = "thisDeliverGoods";
    public static final String FIELD_SUPPLIER_REMAARKS = "supplierRemaarks";
    public static final String FIELD_ORDER_NUM = "orderNum";
    public static final String FIELD_ORDER_LINE_NUMBER = "orderLineNumber";
    public static final String FIELD_SHIPPING_NUMBER = "shippingNumber";
    public static final String FIELD_VERSION = "version";
    public static final String FIELD_NEED_DATE = "needDate";
    public static final String FIELD_PROMISE_DATE = "promiseDate";
    public static final String FIELD_CONTACTS_INFORMATION = "contactsInformation";
    public static final String FIELD_PURCHASER_REMARKS = "purchaserRemarks";
    public static final String FIELD_ORDER_SEQ = "orderSeq";
    public static final String FIELD_REMARK = "remark";
	public static final String FIELD_LINE_STATUS = "line_status";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


	public DeliveryNoteLine() {
	}

	public DeliveryNoteLine(@NotNull Long  purLineId, @NotNull Long headId, @NotNull Long lineNumber, @NotNull String customerItemCode, @NotBlank String customerItemName, @NotNull Long orderQuantity, @NotNull Long mayDeliverGoods, @NotBlank String unit, @NotBlank Long thisDeliverGoods, String supplierRemarks, @NotNull String orderNum, @NotNull Long orderLineNumber, @NotBlank Long shippingNumber, @NotBlank Long version, @NotNull Date needDate, @NotNull Date promiseDate, String contactsInformation, String purchaserRemarks,  String lineStatus) {
		this.purLineId=purLineId;
		this.headId = headId;
		this.lineNumber = lineNumber;
		this.customerItemCode = customerItemCode;
		this.customerItemName = customerItemName;
		this.orderQuantity = orderQuantity;
		this.mayDeliverGoods = mayDeliverGoods;
		this.unit = unit;
		this.thisDeliverGoods = thisDeliverGoods;
		this.supplierRemarks = supplierRemarks;
		this.orderNum = orderNum;
		this.orderLineNumber = orderLineNumber;
		this.shippingNumber = shippingNumber;
		this.version = version;
		this.needDate = needDate;
		this.promiseDate = promiseDate;
		this.contactsInformation = contactsInformation;
		this.purchaserRemarks = purchaserRemarks;
		this.lineStatus = lineStatus;
	}

	@ApiModelProperty("表ID")
    @Id
    @GeneratedValue
    private Long lineId;
    @ApiModelProperty(value = "送货单头id")
    @NotNull
    private Long headId;
    @ApiModelProperty(value = "行号")
    @NotNull
    private Long lineNumber;
    @ApiModelProperty(value = "客户物料编码")
    @NotNull
    private String customerItemCode;
    @ApiModelProperty(value = "客户物料名称")
    @NotBlank
    private String customerItemName;
    @ApiModelProperty(value = "订单数量")
    @NotNull
    private Long orderQuantity;
    @ApiModelProperty(value = "可发货数量")
    @NotNull
    private Long mayDeliverGoods;
    @ApiModelProperty(value = "单位")
    @NotBlank
    private String unit;
    @ApiModelProperty(value = "本次发货")
    @NotBlank
    private Long thisDeliverGoods;
   @ApiModelProperty(value = "供应商备注")
    private String supplierRemarks;
    @ApiModelProperty(value = "订单号")
    @NotNull
    private String orderNum;
    @ApiModelProperty(value = "订单行号")
    @NotNull
    private Long orderLineNumber;
    @ApiModelProperty(value = "发运号")
    @NotBlank
    private Long shippingNumber;
    @ApiModelProperty(value = "版本号")
    @NotBlank
    private Long version;
    @ApiModelProperty(value = "需求日期")
    @NotNull
    private Date needDate;
    @ApiModelProperty(value = "承诺日期")
    @NotNull
    private Date promiseDate;
   @ApiModelProperty(value = "联系人信息")
    private String contactsInformation;
   @ApiModelProperty(value = "采购方备注")
    private String purchaserRemarks;
   @ApiModelProperty(value = "排序号")
    private Long orderSeq;
   @ApiModelProperty(value = "备注说明")
    private String remark;
   @ApiModelProperty(value = "行状态")
   private  String lineStatus;
	@ApiModelProperty(value = "采购订单行id")
   private  Long purLineId;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

	public Long getPurLineId() {
		return purLineId;
	}

	public void setPurLineId(Long purLineId) {
		this.purLineId = purLineId;
	}

	/**
     * @return 表ID
     */
	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
    /**
     * @return 送货单头id
     */
	public Long getHeadId() {
		return headId;
	}

	public void setHeadId(Long headId) {
		this.headId = headId;
	}
    /**
     * @return 行号
     */
	public Long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getCustomerItemCode() {
		return customerItemCode;
	}

	public void setCustomerItemCode(String customerItemCode) {
		this.customerItemCode = customerItemCode;
	}

	public String getCustomerItemName() {
		return customerItemName;
	}

	public void setCustomerItemName(String customerItemName) {
		this.customerItemName = customerItemName;
	}

	public String getSupplierRemarks() {
		return supplierRemarks;
	}

	public void setSupplierRemarks(String supplierRemarks) {
		this.supplierRemarks = supplierRemarks;
	}

	/**
     * @return 订单数量
     */
	public Long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
    /**
     * @return 可发货数量
     */
	public Long getMayDeliverGoods() {
		return mayDeliverGoods;
	}

	public void setMayDeliverGoods(Long mayDeliverGoods) {
		this.mayDeliverGoods = mayDeliverGoods;
	}
    /**
     * @return 单位
     */
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
    /**
     * @return 本次发货
     */
	public Long getThisDeliverGoods() {
		return thisDeliverGoods;
	}

	public void setThisDeliverGoods(Long thisDeliverGoods) {
		this.thisDeliverGoods = thisDeliverGoods;
	}

    /**
     * @return 订单号
     */
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
    /**
     * @return 订单行号
     */
	public Long getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Long orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
    /**
     * @return 发运号
     */
	public Long getShippingNumber() {
		return shippingNumber;
	}

	public void setShippingNumber(Long shippingNumber) {
		this.shippingNumber = shippingNumber;
	}
    /**
     * @return 版本号
     */
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
    /**
     * @return 需求日期
     */
	public Date getNeedDate() {
		return needDate;
	}

	public void setNeedDate(Date needDate) {
		this.needDate = needDate;
	}
    /**
     * @return 承诺日期
     */
	public Date getPromiseDate() {
		return promiseDate;
	}

	public void setPromiseDate(Date promiseDate) {
		this.promiseDate = promiseDate;
	}
    /**
     * @return 联系人信息
     */
	public String getContactsInformation() {
		return contactsInformation;
	}

	public void setContactsInformation(String contactsInformation) {
		this.contactsInformation = contactsInformation;
	}
    /**
     * @return 采购方备注
     */
	public String getPurchaserRemarks() {
		return purchaserRemarks;
	}

	public void setPurchaserRemarks(String purchaserRemarks) {
		this.purchaserRemarks = purchaserRemarks;
	}
    /**
     * @return 排序号
     */
	public Long getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(Long orderSeq) {
		this.orderSeq = orderSeq;
	}
    /**
     * @return 备注说明
     */
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLineStatus() {
		return lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}
}
