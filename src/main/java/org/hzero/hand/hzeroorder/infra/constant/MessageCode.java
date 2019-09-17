package org.hzero.hand.hzeroorder.infra.constant;

/**
 * <p>
 * 消息模板code
 * </p>
 *
 * @author xuan.zhang03@hand-china.com 2019/07/08 13:36
 */
public enum MessageCode {

    /**
     * 招标发布通知-供应商
     */
    BID_RELEASE("SSRC.BID_RELEASE"),

    /**
     * 招标发布通知-组员
     */
    BID_RELEASE_MEMBER("SSRC.BID_RELEASE_MEMBER"),

    /**
     * 开标密码通知
     */
    BID_OPEN_PWD("SSRC.BID_OPEN_PWD"),
    /**
     * 专家评分通知
     */
    EVALUATE("SSRC.EVALUATE"),

    /**
     * 重新评分
     */
    EVALUATE_AGAIN("SSRC.EVALUATE_AGAIN"),

    /**
     * 确认汇总
     */
    EVALUATE_SUMMARY("SSRC.EVALUATE_SUMMARY"),

    /**
     * 确认候选人
     */
    PRE_EVALUATION("SSRC.PRE_EVALUATION"),

    /**
     * 评分负责人收到评审澄清回复通知
     */
    BID_CLARIFY_NOTIFY_LEADER("SSRC.BID_CLARIFY_NOTIFY_LEADER"),

    /**
     * 专家收到评审澄清回复通知
     */
    BID_CLARIFY_NOTIFY_EXPERT("SSRC.BID_CLARIFY_NOTIFY_EXPERT"),

    /**
     * 供应商收到评审澄清通知
     */
    BID_CLARIFY_NOTIFY_SUPPLIER("SSRC.BID_CLARIFY_NOTIFY_SUP"),

    /**
     * 收到供应商问题通知
     */
    BID_CLARIFY_PURCHASER("SSRC.BID_CLARIFY_PURCHASER"),

    /**
     * 收到澄清函通知
     */
    BID_CLARIFY_SUPPLIER("SSRC.BID_CLARIFY_SUPPLIER");

    private String messageCode;

    MessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageCode() {
        return messageCode;
    }
}
