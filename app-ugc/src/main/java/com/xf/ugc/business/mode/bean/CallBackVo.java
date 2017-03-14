package com.xf.ugc.business.mode.bean;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-13:09
 * @describe  * 说明：统一回调实体
 * ｛"resCode":"200","resMsg":"请求成功","resObj":obj｝
 */
public class CallBackVo {
    String error_code;
    String reason;
    Object result;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
