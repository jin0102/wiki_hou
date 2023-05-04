package com.frank.wiki.resp;

public class CommonResp<T> {
    /**
     * 返回一个状态，业务的成功或失败
     */
    private boolean success = true;

    /**
     * 返回描述信息，对本次业务的响应做解释
     */
    private String message;

    /**
     * 返回响应结果
     */
    private T content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonResp{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
