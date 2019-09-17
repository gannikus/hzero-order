package org.hzero.hand.hzeroorder.infra.constant;

/**
 * 招标书模块常量类
 * @author xuan.zhang03@hand-china.com 2019/05/22 19:03
 */
public class PurConstants {

    /**
     * 招标书相关常量配置
     */
    public static final class BidHeader{
        /**
         * 资格审查方式
         */
        public final class QualificationType{

            /***
             * 无需资格审查
             */
            public static final String NONE = "NONE";
            /**
             * 资格预审
             */
            public static final String PRE = "PRE";
            /**
             * 资格后审
             */
            public static final String POST = "POST";
            /**
             * 预审并后审
             */
            public static final String PRE_POST = "PRE_POST";

        }

        public final class QuotationType{
            /**
             * 线下
             */
            public static final String LINE = "LINE";

            /**
             * 线上
             */
            public static final String ON_LINE = "ON_LINE";
            /**
             * 线上线下并存
             */
            public static final String ON_OFF = "ON_OFF";
        }

        /**
         * 寻源方式
         */
        public final class SourceMethod{
            /**
             * 邀请
             */
            public static final String INVITE = "INVITE";
            /**
             * 合作伙伴公开
             */
            public static final String OPEN = "OPEN";
            /**
             * 全平台公开
             */
            public static final String ALL_OPEN = "ALL_OPEN";

        }

        public final class BucketName{
            private BucketName(){}
            public static final String SSRC_BID_HEADER = "ssrc-bid-header";
            public static final String SSRC_RFX_PREQUAL = "ssrc-rfx-prequal";
        }

        /**
         * 标的规则
         */
        public final class SubjectMatterRule{
            public static final String PACK = "PACK";
            public static final String NONE = "NONE";
        }

        /**
         * 招标状态
         */
        public static class BidStatus{
            private BidStatus() {
            }

            public static final String NEW = "NEW";
            public static final String OPENED = "OPENED";
            public static final String RELEASE_APPROVING = "RELEASE_APPROVING";
            public static final String RELEASE_REJECTED = "RELEASE_REJECTED";
            public static final String NOT_START = "NOT_START";
            public static final String IN_PREQUAL = "IN_PREQUAL";
            public static final String PREQUAL_CUTOFF = "PREQUAL_CUTOFF";
            public static final String IN_BIDDING = "IN_BIDDING";
            public static final String OPEN_BID_PENDING = "OPEN_BID_PENDING";
            public static final String SCORING = "SCORING";
            public static final String BID_EVALUATION_PENDING = "BID_EVALUATION_PENDING";
            /**
             * 预定标
             */
            public static final String PRE_EVALUATION_PENDING = "PRE_EVALUATION_PENDING";
            public static final String CONFIRMED_PENDING = "CONFIRMED_PENDING";
            public static final String CHECK_PENDING = "CHECK_PENDING";
            public static final String CHECK_REJECTED = "CHECK_REJECTED";
            public static final String FINISHED = "FINISHED";
            public static final String CLOSED = "CLOSED";
            public static final String ROUNDED = "ROUNDED";
            public static final String IN_POSTQUAL = "IN_POSTQUAL";
            public static final String POSTQUAL_CUTOFF = "POSTQUAL_CUTOFF";
            public static final String PENDING_PREQUAL = "PENDING_PREQUAL";
        }

        /**
         * 招标角色
         */
        public static class RoleType{
            private RoleType(){}

            /**
             * SUPERVISE/监标员
             * PREQUAL/预审审查员
             * TENDER/招标员
             * OPENER/开标人
             */
            public static final String SUPERVISE= "SUPERVISE";
            public static final String PREQUAL= "PREQUAL";
            public static final String TENDER= "TENDER";
            public static final String OPENER= "OPENER";
        }
        /**
         *招标成员数量
         */
        public static class RoleNumber{
            private RoleNumber(){}
            public static final Integer FOUR= 4;
        }

        /**
         * 当前组别
         */
        public static class CurrentSequenceNum{
            public static final Integer FIRST = 1 ;
            public static final Integer SECOND = 2 ;
        }
    }

    /**
     * 供应商状态
     */
    public static class Supplier {
        /**
         * 供应商反馈状态-未反馈
         */
        public static final String FEEDBACK_STATUS_NEW = "NEW";
        /**
         * 供应商反馈状态-参与
         */
        public static final String FEEDBACK_STATUS_PARTICIPATED = "PARTICIPATED";
        /**
         * 供应商反馈状态-放弃
         */
        public static final String FEEDBACK_STATUS_ABANDONED = "ABANDONED";
        /**
         * 供应商未读标识
         */
        public static final Integer READ_FLAG_NO = 0;
        /**
         * 供应商已读标识
         */
        public static final Integer READ_FLAG_YES = 1;
    }

    public static class Nums{

        public static final int HUNDRED = 100;

    }
    /**
     * 招投标操作记录，操作字段
     */
    public static class BidActionOperation {
        private BidActionOperation() {
        }
        /**
         * 新建
         */
        public static final String CREATE = "CREATE";
        /**
         * 发布
         */
        public static final String ISSUE = "ISSUE";
        /**
         * 发布
         */
        public static final String OPEN = "OPEN";
        /**
         * 审批拒绝
         */
        public static final String REJECT = "REJECT";
        /**
         * 审批通过
         */
        public static final String APPROVE = "APPROVE";
        /**
         * 暂停
         */
        public static final String PAUSE = "PAUSE";
        /**
         * 启用
         */
        public static final String PAUSE_START = "PAUSE_START";
        /**
         * 关闭
         */
        public static final String CLOSE = "CLOSE";
        /**
         * 提交
         */
        public static final String SUBMIT = "SUBMIT";
        /**
         * 完成
         */
        public static final String FINISHED = "FINISHED";
        /**
         * 再次招标
         */
        public static final String ROUND = "ROUND";
        /**
         * 定标审批中
         */
        public static final String CHECK_APPROVING = "CHECK_APPROVING";
        /**
         * 定标审批通过
         */
        public static final String CHECK_APPROVED = "CHECK_APPROVED";
        /**
         * 定标审批拒绝
         */
        public static final String CHECK_REFUSE = "CHECK_REFUSE";
        /**
         * 专家评分提交
         */
        public static final String SUBMIT_SCORE = "SUBMIT_SCORE";
    }

    /**
     * 标书物料行常量
     */
    public static final class BidLineItem{
        /**
         * 标段标识
         */
        public static class SectionFlag{
            /**
             * 标段，可以有子行
             */
            public static final Integer ONE = 1;

            /**
             * 部分标段,不能有子行
             */
            public static final Integer ZERO = 0;
        }
    }

    /**
     * 供应商方相关常量
     */
    public static final class BidQuotation{
        private BidQuotation() {
        }
        public static final class FeedbackStatus{
            public static final String PARTICIPATED = "PARTICIPATED";
            public static final String ABANDONED = "ABANDONED";
            public static final String NEW = "NEW";
        }

        /**
         * 汇总状态
         */
        public final class SummaryStatus{

            /**
             * 新建
             */
            public static final String NEW = "NEW";

            /**
             * 新建
             */
            public static final String SAVED = "SAVED";

            /**
             * 已提交
             */
            public static final String SUBMITTED = "SUBMITTED";
        }
        public static final class QuotationStatus{
            /**
             * 新建
             */
            public static final String NEW = "NEW";
            /**
             * 已投标
             */
            public static final String QUOTED = "QUOTED";
            /**
             * 结束
             */
            public static final String FINISHED = "FINISHED";

            /**
             * 放弃
             */
            public static final String ABANDONED = "ABANDONED";

            /**
             * 尚未参与
             */
            public static final String UNPARTICIPATED = "UNPARTICIPATED";
            /**
             * 待资格预审
             */
            public static final String PREQUAL = "PREQUAL";
            /**
             * 资格预审中
             */
            public static final String IN_PREQUAL = "IN_PREQUAL";
            /**
             * 未入围
             */
            public static final String PRE_REFUSED = "PRE_REFUSED";
            /**
             * 已入围
             */
            public static final String BIDDING = "BIDDING";
            /**
             * 未开始
             */
            public static final String UNSTART = "UNSTART";

        }

        public static final class QuotationLineStatus{
            public static final String NEW = "NEW";
            public static final String SUBMITTED = "SUBMITTED";
            public static final String ABANDONED = "ABANDONED";
        }
    }

    /**
     * 编码规则
     */
    public static class CodeRule {
        private CodeRule() {
        }

        public static final String BID_NUM = "SSRC.BID_NUM";
        /**
         * 报价单编码规则
         */
        public static final String BID_QUOTATION_NUM = "SSRC.BID_QUOTATION_NUM";
    }
    /**
     * 业务异常
     */
    public static final class ErrorCode {

        public ErrorCode() {
        }

        /**
         * 招标事项不能为空
         */
        public static final String ERROR_BID_TITLE_CAN_NOT_BE_NULL = "error.bid_title_can_not_be_null";
        /**
         * 标的规则不能为空
         */
        public static final String ERROR_SUBJECT_MATTER_RULE_CAN_NOT_BE_NULL = "error.subject_matter_rule_can_not_be_null";
        /**
         * 投标开始时间不能为空
         */
        public static final String ERROR_QUOTATION_START_DATE_CAN_NOT_BE_NULL = "error.quotation_start_date_can_not_be_null";
        /**
         * 投标截止时间不能为空
         */
        public static final String ERROR_QUOTATION_END_DATE_CAN_NOT_BE_NULL = "error.quotation_end_date_can_not_be_null";
        /**
         * 开标时间不能为空
         */
        public static final String ERROR_BID_OPEN_DATE_CAN_NOT_BE_NULL = "error.bid_open_date_can_not_be_null";
        /**
         * 币种不能为空
         */
        public static final String ERROR_CURRENCY_CAN_NOT_BE_NULL = "error.currency_can_not_be_null";
        /**
         * 招标文件费不能为空
         */
        public static final String ERROR_BID_FILE_EXPENSE_CAN_NOT_BE_NULL = "error.bid_file_expense_can_not_be_null";
        /**
         * 招标文件不能为空
         */
        public static final String ERROR_BID_FILE_CAN_NOT_BE_NULL = "error.bid_file_can_not_be_null";
        /**
         * 招标文件不能为空
         */
        public static final String ERROR_PRE_BID_FILE_CAN_NOT_BE_NULL = "error.pre_bid_file_can_not_be_null";
        /**
         * 招标保证金不能为空
         */
        public static final String ERROR_BID_BOND_CAN_NOT_BE_NULL = "error.bid_bond_can_not_be_null";
        /**
         * 开标地点不能为空
         */
        public static final String ERROR_BID_OPEN_PLACE_CAN_NOT_BE_NULL = "error.bid_open_place_can_not_be_null";
        /**
         * 投标开始时间必须大于当前时间
         */
        public static final String ERROR_QUOTATION_START_DATE_MUST_GREATER_THAN_NOW = "error.quotation_start_date_must_greater_than_now";
        /**
         * 投标开始时间不能晚于投标截止时间
         */
        public static final String ERROR_QUOTATION_END_DATE_MUST_GREATER_THAN_QUOTATION_START_DATE = "error.quotation_end_date_must_greater_than_quotation_start_date";
        /**
         * 开标时间必须大于投标截止时间
         */
        public static final String ERROR_BID_OPEN_DATE_MUST_GREATER_THAN_QUOTATION_END_DATE = "error.bid_open_date_must_greater_than_quotation_end_date";

        /**
         * 寻源方式为邀请的报价方式不允许线下报价
         */
        public static final String ERROR_LINE_NOT_PERMITTED = "error.line_not_permitted";
        /**
         * 未找到投招标模板ID
         */
        public static final String ERROR_BID_TEMPLATE_ID_NOT_FOUND = "error.bid_template_id_not_found";
        /***
         * 处理状态有误
         */
        public static final String PROCESS_STATUS_ERROR = "process.status.error";
        /**
         * 招标单不存在
         */
        public static final String HEADER_NOT_PRESENCE = "bid_header.not.presence";
        /**
         * 定标时不分标段时中标数量小于物品需求数量
         */
        public static final String ERROR_BID_QUOTATION_LINE_ALLOTTED_QUANTITY_NONE = "error.bid_quotation_line_allotted_quantity_none";
        /**
         * 定标分标段时中标比例小于等于100
         */
        public static final String ERROR_BID_QUOTATION_LINE_ALLOTTED_QUANTITY_PACK = "error.bid_quotation_line_allotted_quantity_pack";
        /**
         * 分标段定标时中标比例不为空
         */
        public static final String ERROR_BID_QUOTATION_LINE_ALLOTTED_QUANTITY_IS_NOTNULL = "error.bid_quotation_line_allotted_quantity_pack_is_notnull";
        /***
         * 租户ID不能为空
         */
        public static final String TENANT_ID_ERROR = "TENANT_ID_ERROR";
        /**
         * 投标已截止，供应商不允许参与投标
         */
        public static final String ERROR_BID_DATE_END = "error.bid_date_end";
        /**
         * 资格预审已截止，供应商不允许参与投标
         */
        public static final String ERROR_PRE_TRIAL_DATE_END = "error.pre_trial_date_end";
        /**
         * 版本或轮次不是当前版本
         */
        public static final String VERSION_OR_ROTATION_ERROR = "error.version_or_rotation";
        /**
         * 当前状态不允许参与投标
         */
        public static final String CURRENT_STATUS_CAN_NOT_BID = "error.current_status_can_not_bid";
        /**
         * 已放弃或已参与不允许参与投标
         */
        public static final String PARTICIPATED_OR_ABANDONED_CAN_NOT_BID = "error.participated_or_abandoned_can_not_bid";
        /**
         * 仅能新增”监标人/开标人”两个角色的组员
         */
        public static final String ERROR_BID_MEMBERS_CAN_NOT_INSERT = "error.bid_members_can_not_insert";
        /**
         * 招标成员不能重复
         */
        public static final String ERROR_BID_MEMBERS_CAN_NOT_REPEAT = "error.bid_members_can_not_repeat";
        /**
         * 一个招标中必须存在四种角色
         */
        public static final String ERROR_BID_MEMBERS_NUMBERS = "error.bid_members_numbers";
        /**
         * 当前状态不能执行该操作
         */
        public static final String ERROR_OPERATE_STATUS = "error.operate_status";
        /**
         * 区分标段,中标数不能大于最大中标数
         */
        public static final String ERROR_QUOTATION_LINE_SUGGEST_BY_PICK = "error.quotation_line_suggest_by_pick";
        /**
         * 不区分标段,中标数不能大于最大中标数
         */
        public static final String ERROR_QUOTATION_LINE_SUGGEST_BY_NONE = "error.quotation_line_suggest_by_none";
        /**
         * 定标管理分标段提交时每个标段必须有中标供应商
         */
        public static final String ERROR_QUOTATION_LINE_SUGGEST_FLAG_PACK = "error.quotation_line_error_pack";
        /**
         * 定标管理不分标段时每个标段必须有中标供应商
         */
        public static final String ERROR_QUOTATION_LINE_SUGGEST_FLAG_NONE = "error.quotation_line_error_none";
        /**
         * 发布招标时状态错误
         */
        public static final String ERROR_RELEASE_STATUS = "error.release_status";
        /**
         * 发布时招标书的物料行至少存在一条数据
         */
        public static final String ERROR_BID_ITEMS_NOT_EXIST = "error.bid_items_not_exist";
        /**
         * 发布时招标书的供应商行至少存在一条数据
         */
        public static final String ERROR_BID_SUPPLIERS_NOT_EXIST = "error.bid_suppliers_not_exist";
        /**
         * 供应商数量错误
         */
        public static final String ERROR_BID_SUPPLIERS_NUMBERS="error.bid_suppliers_numbers";
        /**
         * 至少邀请供应商
         */
        public static final String ERROR_BID_SUPPLIERS_LEAST_NUMBERS="error.bid_suppliers_least_numbers";
        /**
         * 最多邀请供应商
         */
        public static final String ERROR_BID_SUPPLIERS_MOST_NUMBERS="error.bid_suppliers_most_numbers";
        /**
         *数据不存在
         */
        public static final String ERROR_DATA_NOT_EXISTS = "error.data_not_exists";
        /**
         * 当前状态不允许执行该操作
         */
        public static final String ERROR_STATUS_NOT_MATCH_OPERATE = "error.status_not_match_operate";
        /**
         * 投标时间已截止，不能投标
         */
        public static final String ERROR_END_DATE_IS_BEFORE_CURRENT_TIME = "error.end_date_is_before_current_time";
        /**
         * 投标未开始，不能投标
         */
        public static final String ERROR_START_DATE_IS_AFTER_CURRENT_TIME = "error.start_date_is_after_current_time";
        /**
         * 还有投标行未投标
         */
        public static final String ERROR_QUOTATION_LINE_ERROR = "error.quotation_line_not_tender";

        /**
         * 投标时间已截止
         */
        public static final String ERROR_QUOTATION_TIME_END_ERROR = "error.quotation_time_end";

        /**
         * 招标单不存在
         */
        public static final String ERROR_BID_HEADER_NONE = "error.bid_header_none";

        /**
         * 不可重复投标
         */
        public static final String ERROR_QUOTED_REPEAT= "error.quoted_repeat";

        /**
         * 不可重复提交
         */
        public static final String ERROR_QUOTED_SUBMITTED_REPEAT = "error.quoted_submitted_repeat";

        /**
         * 招标状态必须是投标中
         */
        public static final String ERROR_STATUS_NO_IN_QUOTATION  = "error.status_no_in_quotation";

        /**
         * 未入围
         */
        public static final String ERROR_STATUS_NO_BIDDING = "error.status_no_bidding";

        /**
         * 税率不能为空
         */
        public static final String ERROR_TAX_RATE_NULL = "tax_rate.null";

        /**
         * 供应商行重复
         */
        public static final String ERROR_SUPPLIER_REPEAT = "error.supplier_repeat";
    }

    public final class FieldReset{
        public static final String ROW_ABANDON = "rowAbandon";
    }
    /**
     * 消息模板参数定义
     */
    public final static class MessageConstants{
        private MessageConstants(){
        }

        public static final String COMPANY_NAME = "COMPANY_NAME";
        public static final String BID_NUMBER = "BID_NUMBER";
        public static final String BID_TITLE = "BID_TITLE";
        public static final String BID_DETAIL = "BID_DETAIL";
        public static final String BID_START_TIME = "BID_START_TIME";
        public static final String BID_OPEN_DATE = "BID_OPEN_DATE";
        public static final String OPEN_PASSWORD = "OPEN_PASSWORD";
        public static final String OPENER_NAME = "OPENER_NAME";
    }
}
