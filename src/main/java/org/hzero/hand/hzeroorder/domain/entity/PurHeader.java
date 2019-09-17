package org.hzero.hand.hzeroorder.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import java.math.BigDecimal;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购订单头表
 *
 * @author gzm 2019-08-26 14:32:24
 */
@ApiModel("采购订单头表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_pur_header")
public class PurHeader extends AuditDomain {

    public static final String FIELD_PUR_HEADER_ID = "purHeaderId";
    public static final String FIELD_PUR_ORDER_NUMBER = "purOrderNumber";
	public static final String FIELD_ORDER_STATUS = "orderStatus";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_PUR_ORG_ID = "purOrgId";
    public static final String FIELD_PUR_AGENT_ID = "purAgentId";
    public static final String FIELD_ORDER_TYPE_ID = "orderTypeId";
    public static final String FIELD_SUPPLIER_ID = "supplierId";
    public static final String FIELD_SUPPLIER_ADDRESS = "supplierAddress";
    public static final String FIELD_TAX_EXCLUDED_TOTAL_AMOUNT = "taxExcludedTotalAmount";
    public static final String FIELD_ORDER_ABSTRACT = "orderAbstract";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID")
    @Id
    @GeneratedValue
    private Long purHeaderId;
    @ApiModelProperty(value = "采购订单编号")
    @NotBlank
    private String purOrderNumber;

	@ApiModelProperty(value="订单状态")
	@NotNull
    private String orderStatus;
    @ApiModelProperty(value = "公司")
    @NotNull
    private String companyId;
    @ApiModelProperty(value = "采购组织")
    @NotNull
    private String purOrgId;
    @ApiModelProperty(value = "采购员")
    @NotNull
    private String purAgentId;
    @ApiModelProperty(value = "订单类型")
    @NotNull
    private String orderTypeId;
    @ApiModelProperty(value = "供应商")
    @NotNull
    private String supplierId;
    @ApiModelProperty(value = "供应商地点")
    @NotBlank
    private String supplierAddress;
    @ApiModelProperty(value = "不含税总金额")
    @NotNull
    private BigDecimal taxExcludedTotalAmount;
    @ApiModelProperty(value = "订单摘要")
    @NotBlank
    private String orderAbstract;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID
     */
	public Long getPurHeaderId() {
		return purHeaderId;
	}

	public void setPurHeaderId(Long purHeaderId) {
		this.purHeaderId = purHeaderId;
	}
    /**
     * @return 采购订单编号
     */
	public String getPurOrderNumber() {
		return purOrderNumber;
	}

	public void setPurOrderNumber(String purOrderNumber) {
		this.purOrderNumber = purOrderNumber;
	}
    /**
     * @return 公司
     */
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
    /**
     * @return 采购组织
     */
	public String getPurOrgId() {
		return purOrgId;
	}

	public void setPurOrgId(String purOrgId) {
		this.purOrgId = purOrgId;
	}
    /**
     * @return 采购员
     */
	public String getPurAgentId() {
		return purAgentId;
	}

	public void setPurAgentId(String purAgentId) {
		this.purAgentId = purAgentId;
	}
    /**
     * @return 订单类型
     */
	public String getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(String orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
    /**
     * @return 供应商
     */
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
    /**
     * @return 供应商地点
     */
	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
    /**
     * @return 不含税总金额
     */
	public BigDecimal getTaxExcludedTotalAmount() {
		return taxExcludedTotalAmount;
	}

	public void setTaxExcludedTotalAmount(BigDecimal taxExcludedTotalAmount) {
		this.taxExcludedTotalAmount = taxExcludedTotalAmount;
	}
    /**
     * @return 订单摘要
     */
	public String getOrderAbstract() {
		return orderAbstract;
	}

	public void setOrderAbstract(String orderAbstract) {
		this.orderAbstract = orderAbstract;
	}

	/**
	 *
	 * @return 订单状态
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
