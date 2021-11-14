package com.vue.result.error;

public enum ExceptionInfoEnum {

    OTHER_ERROR(1999, ""),

    SYSTEM_BIZ_ERROR(1000, "系统业务异常"),

    PARAM_ERROR_EXCEPTION(1001, "参数错误"),

    RESULT_EMPTY_EXCEPTION(1002, "没有更多数据了哦~"),

    INSERT_ERROR_EXCEPTION(1003, "数据插入失败"),

    QUERY_ERROR_EXCEPTION(1004, "查询失败"),

    RESULT_NOTEXIST_EXCEPTION(1005, "当前条件查询结果不存在"),

    UPDATE_ERROR_EXCEPTION(1006, "数据更新失败"),

    PROJ_DETAIL_NAME_IS_EXIT(1007, "当前子项名称重复"),

    PROJ_CASE_NAME_IS_EXIT(1008, "当前用例名称重复"),

    PROJ_CASE_REQ_COUNT_IS_EXIT(1009, "当前用例请求顺序重复"),

    PROJ_MOCK_PROJECT_IS_NOT_EXIT(1010, "未找到Mock对象"),

    PROJ_MOCK_DEMAND_IS_NOT_EXIT(1011, "未找到Mock需求对象"),

    URL_NOT_PATTERN(1012, "请求url不合法"),

    CASE_REQ_NOT_EXIT(1013, "未找到当前用例请求"),

    CASE_HAS_NO_REQ(1014, "当前case下没有可执行的Request"),

    CASE_NOT_EXIT(1015, "当前id未查询到Case"),

    CASE_RUN_ERROR(1016, "case执行失败"),

    CASE_TASK_EXIT(1017, "当前已存在该任务"),

    URI_NOT_PATTERN(1020, "URI不合法"),

    RESULT_NOT_PATTERN(1021, "请检查返回值是否为json结构"),

    RESULT_EMPTY(1022, "返回值为空"),

    SYNC_ENV_IS_START(1023, "环境正在运行中,请等待."),

    PWD_ERROR(1024, "账号或密码错误"),

    LOGOUT_ERROR(1025, "退出失败!"),

    SSH_CONNECT_ERROR(1026, "SSH连接失败"),

    USER_IS_NOT_EXIT(1027, "用户不存在"),

    NOT_FOUND_ENUM(1028, "未找到数据类型"),

    MOCK_IS_NOT_OPEN(1029, "MOCK开关没有打开"),

    RECOMMEND_REQ_ERROR(1030, "推荐手机号接口请求失败"),

    REIM_APPLY_FORBIDDEN(1031, "您是审核大佬.暂未开通大佬报销制度"),

    REIM_APPLY_CHECKER_NOT_EXIST(1032, "审核人不存在,请重新选择"),

    BIZ_CONTENT_PARAM_ERROR(1033, "biz_content参数错误"),

    BALANCE_NOT_ENOUGH(1034, "余额不足"),

    UN_LOGIN_ERROR(1035, "请登录"),

    DEFAULT_ACCOUNT_EMPTY(1036, "默认账户为空"),

    ORDER_EXISTED(1037, "订单已存在"),

    RSAKEY_ERROR(1038, "ras_key为空"),

    DATA_EMPTY(1039, "data为空"),

    CUR_USER_EMPTY(1040, "当前用户为空"),

    ORDER_NUM_ERROR(1041, "请检查传入的单号是否正确"),

    PAY_INTER_RES_ERROR(1042, "支付接口返回数据格式不正确"),

    INTER_QUERY_FAIL(1043, "接口查询失败"),

    REIM_ORDER_ERROR(1044, "请检查报销单号是否相同"),

    ORDER_UN_PAY(1045, "该笔订单未支付"),

    REDIS_TIME_OUT(1046, "Redis超时"),

    ID_CAN_NOT_NULL(1047, "id不能为空"),

    TASKID_CAN_NOT_NULL(1048, "task任务id为空"),

    TESTTASKID_CAN_NOT_NULL(1049, "testTask任务id为空"),

    BUG_TYPE_EMPTY(1050, "bug类型为空"),

    PROJ_ID_NULL(1051, "projectId为空"),

    PAY_FAIL(1052, "支付失败"),

    REQ_FAIL_RES_NULL(1053, "请求失败,返回数据为空"),

    GET_COOKIE_FAIL(1054 ,"cookie获取失败,请检查wptId与环境"),

    XMIND_CONTENT_EMPTY(1055, "xmind内容为空"),

    SAVE_ERROR(1056, "保存失败"),

    ENV_NOT_FOUND(1057, "环境未找到"),

    FILE_EMPTY(1058, "文件为空"),

    IMAGE_UPLOAD_FAIL(1059, "图片上传失败"),

    OBJ_NAME_IS_EXIST(1060, "当前项目名称已存在"),

    OBJ_NAME_IS_NOT_EXIST(1061, "当前项目名称不存在"),

    ROLE_IS_NOT_EXIST(1062, "该用户角色不存在"),

    DEPT_IS_NOT_EXIST(1063, "部门类型不存在"),

    DEL_ERROR(1064, "删除失败"),

    DATA_TYPE_IS_NOT_EXIT(1065, "未找到埋点类型"),

    DATA_POINT_IS_NOT_EXIT(1066, "埋点信息未找到"),

    WEB_TYPE_IS_NOT_EXIT(1067, "WebType未找到"),

    RELATION_ROLE_ERROR(1068, "角色菜单关联失败"),

    TKE_SERVER_LOGIN_ERROR(1069, "TKE环境管理登录失败"),

    TKE_SERVER_GET_LIST_ERROR(1070, "获取TKE服务列表失败"),

    REPORT_NOT_INFO(1071, "请填写埋点配置和埋点信息"),

    EXEC_ERROR(1072, "执行脚本失败"),

    GET_TOKEN_FAILED(1073, "Token获取失败"),

    INSIDE_ERROR(1074,"内部接口请求返回异常"),

    CANCEL_DEPLOY_SERVER_ERROR(1075,"取消部署服务失败"),

    NOT_FOUND_STATUS(1076,"未定义状态"),

    ENV_IS_EMPLOY(1078,"当前环境已被暂用,请稍候再申请"),

    EMPLOY_TIME_ERROR(1079,"结束占用时间不能小于当前时间"),

    DEPLOY_STATUS_404_ERROR(1080,"请求部署状态404ERROR"),

    USER_NONE_ERROR(1081,"用户不存在"),

    NONE_SUPPORT_ERROR(1082,"暂时不支持查询"),

    ENV_IS_EXIT(1083,"环境已经存在"),

    SECTION_NAME_IS_EXIT(1084, "统一分组下，分组名不可重复"),

    SECTION_LEVEL_IS_DEPP(1085, "分组层级过深"),

    EXECUTION_PLAN_IS_UNCLOSED(1086, "存在未执行的用例"),

    ETCD_SETTING_ERROR(1087, "配置内容不符合要求"),

    USER_IS_NOT_LOGIN(401, "用户未登陆"),

    EMPLOY_ENV_IS_EXIT(1088, "环境已存在"),

    EMPLOY_SERVER_IS_EXIT(1089, "服务已存在"),

    EMPLOY_SHELL_IS_EXIT(1090, "脚本已存在"),

    NOT_RESET_SHELL(1091, "不存在恢复时间脚本"),

    FILE_UPLOAD_FAIL(1092, "文件上传失败"),

    EMPLOY_TIME_LONG_ERROR(1093,"占用时间最多目前支持4小时"),

    ACCOUNT_IS_EXIT(1094,"该帐号已存在"),

    BIND_MOBILE_TWO(1095,"绑定不能超过两个虚拟号"),

    SERVER_NOT_FOUND(1096,"服务未找到"),

    PHONE_IS_ERROR(1097,"手机号格式错误"),

    PHONE_IS_EXIT(1097,"手机号已存在"),

    TEMPLATE_IS_NOT_EXIT(1098, "模版环境不存在"),

    TARGET_IS_NOT_EXIT(1099, "目标环境不存在"),

    URL_IS_ERROR(1100, "URL格式错误"),

    RUN_ERROR(1101, "执行任务失败"),

    PERMISSION_ERROR(1102, "没有操作权限"),

    REPORT_ERROR(1103, "上报服务错误"),
    LOGIN_PASSWORD_ERROR(1104, "密码错误"),
    LOGIN_USERNAME_ERROR(1105, "用户名错误"),
    NO_REGISTER(1106, "当前用户不存在，请先注册"),
    NO_DATA(1107, "数据为空"),


    /*******************以下为Call_Graph*****************/
    BATCH_INSERT_TIME_OUT(7001, "调用栈插入数据库失败");




    public final Integer code;
    private String message;


    ExceptionInfoEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionInfoEnum setMessage(String message) {
        this.message = message;
        return this;
    }

}
