package com.shen.sample.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回结果枚举
 *
 * @author zhangshichang
 * @date 2019-01-05 11:39
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 错误
     */
    ERROR(500, "服务器内部错误"),
    /**
     * 保存失败
     */
    SAVE_FAIL(400, "保存失败"),
    DEVICE_TYPE_NOT_EXIST(400, "设备类型不存在"),
    DEVICE_NO_EXIST(400, "设备编号已存在"),
    SYS_ROLE_FAIL(400, "系统角色不能修改，系统角色的版本更新由系统维护"),
    SYS_USER_FAIL(400, "系统用户不能修改，系统用户的版本更新由系统维护"),
    SYS_PERMISSION_FAIL(400, "系统资源不能修改，系统资源的版本更新由系统维护"),
    /**
     * 删除失败
     */
    DELETE_FAIL(400, "删除失败"),
    IS_SYS_FAIL(400, "系统资源，不可删除"),
    /**
     * 编辑失败
     */
    EDIT_FAIL(400, "编辑失败"),
    CODE_NOT_EXIST(400, "字典CODE不存在"),
    TENANT_ID_NOT_EXIST(400, "租户ID不存在"),
    RECORD_ID_NOT_EXIST(400, "备案号不存在"),
    RECORD_IS_CANCEL_EXIST(400, "该备案已经注销"),
    RECORD_IS_NOT_AUDIT(400, "该备案不是审核状态"),
    RECORD_IS_NOT_DONE(400, "登记状态不是已备案状态"),
    STAY_STATUS_EXIST(400, "已存在相同状态的滞留记录"),
    NOT_OVERDUE_EXIST(400, "该犬只尚未逾期，不可收容"),
    DEVICE_NOT_EXIST(400, "设备不存在"),
    DEVICE_IS_BINDING(400, "设备已绑定"),
    DEVICE_IS_BINDING_UPDATE(400, "设备已绑定,不可修改或删除"),
    /**
     * 犬只已注销
     */
    DOG_LOGGED_OUT_DESC(400, "该犬只已被注销"),
    /**
     * 免疫卡号已存在
     */
    IMMUNE_NUMBER_IS_USED(400, "该免疫卡号已用于备案或审批中"),
    IMMUNE_NUMBER_HAS_RECORD(400, "该免疫卡已有免疫记录"),
    IMMUNE_NUMBER_IS_EXIST(400, "免疫卡号已存在"),
    /**
     * 免疫卡号不存在
     */
    IMMUNE_NUMBER_NOT_EXIST(400, "免疫卡号不存在"),
    /**
     * 犬牌编号已发放给其他犬
     */
    DOG_TAG_NOT_PROVIDE(400, "犬牌编号已发放给其他犬"),
    /**
     * 犬牌编号已存在
     */
    TENANT_HOST_IS_EXIST(400, "租户主账号已存在"),
    DOG_TAG_IS_EXIST(400, "犬牌编号已存在"),
    DOG_ID_NOT_EXIST(400, "犬只编号不存在"),
    /**
     * 犬牌编号有误
     */
    DOG_TAG_IMMUNE_ERROR(400, "犬牌编号或免疫卡号不存在"),
    /**
     * 没有该犬牌编号
     */
    DOG_TAG_IMMUNE_NOT(400, "系统中没有该犬牌编号"),
    /**
     * 犬牌号不存在或已下发
     */
    DOG_TAG_IS_NOT_EXIST_OR_HAS_BEEN_ISSUED(400, "犬牌号不存在或该犬牌号已下发"),
    /**
     * 执法点名称已存在
     */
    ENFORCEMENT_POINT_NAME_IS_EXIST(400, "执法点名称已存在"),
    /**
     * 文件为空
     */
    FILE_ISNULL(400, "文件为空"),
    /**
     * 图片过大
     */
    FILE_MAX(400, "图片最大为2M"),
    /**
     * 不是图片文件
     */
    FILE_NOT_IMAGE(400, "不是图片文件"),
    /**
     * 图片解析失败
     */
    FILE_FAIL(400, "图片解析失败"),
    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),
    /**
     * 上传图片失败
     */
    UPLOAD_IMG_FAIL(400, "上传图片失败"),
    /**
     * 图片格式错误
     */
    UPLOAD_IMG_TYPE_FAIL(400, "图片格式错误"),
    /**
     * 图片大小限制为500KB
     */
    FILE_IMG_SIZE(400, "图片最大为500KB"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR(400, "密码错误"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(400, "用户不存在"),
    /**
     * 查询数据为空
     */
    QUERY_NULL(400, "查询数据为空"),
    /**
     * 查询失败
     */
    QUERY_ERROR(400, "查询失败"),
    /**
     * 数据已存在
     */
    NOT_NULL(400, "数据已存在"),
    /**
     * 验证码错误
     */
    VERIFICATION_CODE_ERROR(400, "验证码错误"),

    /**
     * 批量删除失败
     */
    BATCH_DELETION_FAIL(400, "批量删除失败"),
    /**
     * 数据已存在
     */
    DATA_ALREADY_EXISTS(400, "数据已存在"),
    /**
     * 数据不存在
     */
    DATA_DOES_NOT_EXIST(400, "数据不存在"),
    /**
     * 手机号不存在
     */
    PHONE_IS_NOT_EXIST(400, "该手机号不存在"),
    /**
     * 电话号码已经注册
     */
    PHONE_IS_EXIST(400, "电话号码已注册"),
    /**
     * 微信登录失败
     */
    WX_LOGIN_FAIL(400, "微信登录失败"),
    /**
     * 修改手机号码失败
     */
    MODIFY_MOBILE_NUMBER_FAIL(400, "修改手机号码失败"),
    /**
     * 图片类型不支持
     */
    IMAGE_TYPE_NOT_SUPPORT(400, "只支持gif、png、jpeg、jpg后缀的图片类型"),
    /**
     * 图片压缩失败
     */
    IMAGE_REDUCE_FILE(400, "图片压缩失败"),
    /**
     * 注册失败
     */
    REGISTER_FAIL(400, "注册失败"),
    /**
     * 用户已存在
     */
    USER_IS_EXISTS(400, "用户名已注册"),
    /**
     * 身份证号已被注册
     */
    ID_CARD_IS_EXISTS(400, "身份证号已被注册"),
    /**
     * 该账号没有此权限
     */
    NO_SUCH_PERMISSION(400, "该账号没有此权限"),
    /**
     * 密码不一致
     */
    INCONSISTENT_PASSWORD(400, "密码不一致"),

    FENCE_IS_EXIST_ONE(400, "您已设置了一个电子围栏（您只能设置至多一个电子围栏）");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 失败消息
     *
     * @see ResultEnum
     */
    private String message;

}
