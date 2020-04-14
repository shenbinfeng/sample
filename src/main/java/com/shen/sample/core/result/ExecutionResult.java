package com.shen.sample.core.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Binfeng Shen
 * @Date: 2019/3/14 15:55
 */
@Data
public class ExecutionResult<T> {
    /**
     * 状态码<br/>
     * 200-请求成功<br/>
     * 400-请求失败<br/>
     * 500-服务器内部错误<br/>
     */
    @ApiModelProperty("code: 200->请求成功, 400->请求失败:一般为参数格式错误, 500->服务器错误")
    private Integer code;
    //返回消息
    private String msg;
    //数据集
    private T data;

    public ExecutionResult() {
    }

    /**
     * 有结果数据返回
     *
     * @param code 状态码
     * @param msg  消息
     * @param data JSON数据
     */
    public ExecutionResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无数据返回
     *
     * @param code 状态码
     * @param msg  消息
     */
    public ExecutionResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}