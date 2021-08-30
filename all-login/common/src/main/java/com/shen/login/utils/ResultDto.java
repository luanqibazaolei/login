package com.shen.login.utils;

import lombok.Data;

import java.util.List;

@Data
public class ResultDto<T> {
    private static final String TOTAL_FIELD = "total";

    /**
     * 返回代码
     */
    private int code;

    /**
     * 总条数
     */
    private long total;

    private String message;

    private String level;

    private T data;

    /**
     * 国际化返回
     */
    private T i18nData;

    public ResultDto() {
    }

    public ResultDto(T data) {
        this.data = data;
    }

    public ResultDto(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultDto(int code, long total, String message, T data) {
        this.code = code;
        this.total = total;
        this.message = message;
        this.data = data;
    }

    public ResultDto(int code, long total, String message, String level, T data, T i18nData) {
        this.code = code;
        this.total = total;
        this.message = message;
        this.level = level;
        this.data = data;
        this.i18nData = i18nData;
    }

    public static final <T> ResultDto<T> createSuccess(T data) {
        return new ResultDto(data);
    }

    public static final <T> ResultDto<T> createSuccess(String message){
        return new ResultDto(200,message,(String) null);
    }

}
