package com.shen.sample.core.result;

import org.springframework.http.HttpStatus;

/**
 * @description: 返回JSON数据封装工具类
 * @author: Shenbinfeng
 * @create: 2020/2/14 10:34
 **/
public class ResultBuilder {
    /**
     * 成功并且有数据返回调用
     *
     * @param t 返回JSON对象
     * @return ExecutionResult
     */
    public static <T> ExecutionResult<T> success(T t) {
        return new ExecutionResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), t);
    }

    /**
     * 成功并且没有数据返回调用,
     * 用于新增、删除、编辑
     *
     * @return ExecutionResult
     */
    public static ExecutionResult success() {
        return new ExecutionResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

    /**
     * 失败返回 返回消息为枚举类中的信息
     *
     * @param resultEnum 枚举结果
     * @return ExecutionResult
     * @see ResultEnum
     */
    public static <T> ExecutionResult<T> fail(ResultEnum resultEnum) {
        ExecutionResult<T> results = new ExecutionResult<>();
        results.setCode(resultEnum.getCode());
        results.setMsg(resultEnum.getMessage());
        return results;
    }

    /**
     * 参数错误
     *
     * @param msg 参数错误返回的信息
     * @return ExecutionResult
     * @author zhangshichang
     * @date 19-2-28 下午2:27
     * @see HttpStatus#BAD_REQUEST
     */
    public static ExecutionResult parameterError(String msg) {
        ExecutionResult results = new ExecutionResult();
        results.setCode(HttpStatus.BAD_REQUEST.value());
        results.setMsg(msg);
        return results;
    }

    /**
     * 请求接口失败
     *
     * @param msg 参数错误返回的信息
     * @return ExecutionResult
     * @author zhangshichang
     * @date 19-2-28 下午2:27
     * @see HttpStatus#BAD_REQUEST
     */
    public static ExecutionResult requestFail(String msg) {
        ExecutionResult results = new ExecutionResult();
        results.setCode(HttpStatus.BAD_REQUEST.value());
        results.setMsg(msg);
        return results;
    }


    /**
     * 全局异常拦截 返回的错误消息
     *
     * @param msg 错误消息
     * @return ExecutionResult
     * @see ResultEnum
     * @see HttpStatus
     */
    public static ExecutionResult<Object> serverError(String msg) {
        ExecutionResult<Object> results = new ExecutionResult<>();
        results.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        results.setMsg(msg);
        results.setData("错误信息请看msg");
        return results;
    }

    /**
     * 未授权时调用--403
     *
     * @param message 消息
     * @return ExecutionResult
     * @author zhangshichang
     * @date 19-4-18 下午2:31
     */
    public static ExecutionResult<Object> forbidden(String message) {
        ExecutionResult<Object> results = new ExecutionResult<>();
        results.setCode(HttpStatus.FORBIDDEN.value());
        results.setMsg(message);
        results.setData("没有相关权限");
        return results;
    }

    /**
     * 未登录时调用--401
     *
     * @param message 消息
     * @return ExecutionResult
     * @author zhangshichang
     * @date 19-4-18 下午2:31
     */
    public static ExecutionResult<Object> unauthorized(String message) {
        ExecutionResult<Object> results = new ExecutionResult<>();
        results.setCode(HttpStatus.UNAUTHORIZED.value());
        results.setMsg(message);
        results.setData("暂未登录或token已经过期");
        return results;
    }

    /**
     * 密码验证不通过时调用
     *
     * @param message 消息
     * @return ExecutionResult
     * @author zhangshichang
     * @date 19-4-20 上午10:50
     */
    public static ExecutionResult badCredentials(String message) {
        ExecutionResult<Object> results = new ExecutionResult<>();
        results.setCode(HttpStatus.BAD_REQUEST.value());
        results.setMsg(message);
        results.setData(null);
        return results;
    }
}
