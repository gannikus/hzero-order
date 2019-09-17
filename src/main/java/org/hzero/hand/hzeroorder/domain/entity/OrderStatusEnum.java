package org.hzero.hand.hzeroorder.domain.entity;

/**
 * description
 * 订单状态枚举类
 *
 * @author gzm 2019/08/27 18:52
 */
public enum OrderStatusEnum {
        /**
         * Created创建状态
         */
        CREATED,
        /**
         * 审批通过
         */
        APPROVED,
        /**
         *审批拒绝
         */
        PASS,
        /**
         *发布
         */
        RELEASE,
        /**
         *已确认
         */
        CONFIRMED,
        /**
         *交期审批拒绝
         */
        DELIVERY_DATE_PASS,
        /**
         *提交状态
         */
        SUBMITTED,
        /**
         *拒绝状态
         */
        REFUSED,
        /**
         *作废
         */
        CANCELLATION
}
