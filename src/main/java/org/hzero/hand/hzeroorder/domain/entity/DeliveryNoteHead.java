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
 * 送货单头表
 *
 * @author gzm 2019-08-27 20:47:28
 */
@ApiModel("送货单头表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "delivery_note_head")
public class DeliveryNoteHead extends AuditDomain {

    public static final String FIELD_HEAD_ID = "headId";
    public static final String FIELD_TENEMENT_ID = "tenementId";
    public static final String FIELD_DELIVERY_NUM = "deliveryNum";
    public static final String FIELD_DELIVERY_TYPE = "deliveryType";
    public static final String FIELD_SUPPLIER = "supplier";
    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_RECEIVING_ORGANIZATION = "receivingOrganization";
    public static final String FIELD_RECEIVING_ADDR = "receivingAddr";
    public static final String FIELD_DELIVER_DATE = "deliverDate";
    public static final String FIELD_ESTIMEATE_DATE = "estimeateDate";
    public static final String FIELD_SUPPLIER_ADDR = "supplierAddr";
    public static final String FIELD_REMARKS = "remarks";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_ORDER_SEQ = "orderSeq";
    public static final String FIELD_REMARK = "remark";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID")
    @Id
    @GeneratedValue
    private Long headId;
    @ApiModelProperty(value = "租户ID")

    private Long tenantId;
    @ApiModelProperty(value = "送货单编号")
    @NotBlank
    private String deliveryNum;
    @ApiModelProperty(value = "送货单类型")
    @NotBlank
    private String deliveryType;
    @ApiModelProperty(value = "供应商")
    @NotBlank
    private String supplier;
    @ApiModelProperty(value = "客户公司id")
    @NotNull
    private String customerId;
    @ApiModelProperty(value = "收货组织")
    @NotBlank
    private String receivingOrganization;
    @ApiModelProperty(value = "收货地点")
    @NotBlank
    private String receivingAddr;
    @ApiModelProperty(value = "发货日期")
    @NotNull
    private Date deliverDate;
    @ApiModelProperty(value = "预计到货日期")
    @NotNull
    private Date estimeateDate;
    @ApiModelProperty(value = "供应商地点")
    @NotBlank
    private String supplierAddr;
   @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "状态")
    @NotBlank
    private String status;
   @ApiModelProperty(value = "排序号")
    private Long orderSeq;
   @ApiModelProperty(value = "备注说明")
    private String remark;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------


	public DeliveryNoteHead() {
	}

	public DeliveryNoteHead(Long tenantId, @NotBlank String deliveryNum, @NotBlank String deliveryType, @NotBlank String supplier, @NotNull String customerId, @NotBlank String receivingOrganization, @NotBlank String receivingAddr, @NotNull Date deliverDate, @NotNull Date estimeateDate, @NotBlank String supplierAddr, String remarks, @NotBlank String status) {
		this.tenantId = tenantId;
		this.deliveryNum = deliveryNum;
		this.deliveryType = deliveryType;
		this.supplier = supplier;
		this.customerId = customerId;
		this.receivingOrganization = receivingOrganization;
		this.receivingAddr = receivingAddr;
		this.deliverDate = deliverDate;
		this.estimeateDate = estimeateDate;
		this.supplierAddr = supplierAddr;
		this.remarks = remarks;
		this.status = status;

	}

	/**
     * @return 表ID
     */
	public Long getHeadId() {
		return headId;
	}

	public void setHeadId(Long headId) {
		this.headId = headId;
	}
    /**
     * @return 租户ID
     */
	public Long getTenementId() {
		return tenantId;
	}

	public void setTenementId(Long tenantId) {
		this.tenantId = tenantId;
	}
    /**
     * @return 送货单编号
     */
	public String getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
    /**
     * @return 送货单类型
     */
	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
    /**
     * @return 供应商
     */
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
    /**
     * @return 客户公司id
     */
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    /**
     * @return 收货组织
     */
	public String getReceivingOrganization() {
		return receivingOrganization;
	}

	public void setReceivingOrganization(String receivingOrganization) {
		this.receivingOrganization = receivingOrganization;
	}
    /**
     * @return 收货地点
     */
	public String getReceivingAddr() {
		return receivingAddr;
	}

	public void setReceivingAddr(String receivingAddr) {
		this.receivingAddr = receivingAddr;
	}
    /**
     * @return 发货日期
     */
	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
    /**
     * @return 预计到货日期
     */
	public Date getEstimeateDate() {
		return estimeateDate;
	}

	public void setEstimeateDate(Date estimeateDate) {
		this.estimeateDate = estimeateDate;
	}
    /**
     * @return 供应商地点
     */
	public String getSupplierAddr() {
		return supplierAddr;
	}

	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}
    /**
     * @return 备注
     */
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    /**
     * @return 状态
     */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
