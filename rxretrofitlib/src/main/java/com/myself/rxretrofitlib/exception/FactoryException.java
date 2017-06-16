package com.myself.rxretrofitlib.exception;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Administrator on 2017/6/16 0016.
 */

public class FactoryException {
    private static final String HttpException_MSG = "网络错误";
    private static final String ConnectException_MSG = "连接失败";
    private static final String JSONException_MSG = "fastjson解析失败";
    private static final String UnknownHostException_MSG = "无法解析该域名";

    public static ApiException analysisException(Throwable e){
        ApiException apiException = new ApiException(e);
        if (e instanceof HttpException){
            apiException.setCode(CodeException.HTTP_ERROR);
            apiException.setDisplayMessage(HttpException_MSG);
        }else if (e instanceof HttpTimeException){
            HttpTimeException exception = (HttpTimeException) e;
            apiException.setCode(  CodeException.RUNTIME_ERROR);
            apiException.setDisplayMessage(exception.getMessage());
        }else if (e instanceof ConnectException || e instanceof SocketTimeoutException){
            apiException.setCode(CodeException.HTTP_ERROR);
            apiException.setDisplayMessage(ConnectException_MSG);
        }else if (e instanceof JSONException || e instanceof ParseException){
            apiException.setCode(CodeException.JSON_ERROR);
            apiException.setDisplayMessage(JSONException_MSG);
        }else if (e instanceof UnknownHostException){
            apiException.setCode(CodeException.UNKOWNHOST_ERROR);
            apiException.setDisplayMessage(UnknownHostException_MSG);
        }else{
            apiException.setCode(CodeException.UNKNOWN_ERROR);
            apiException.setDisplayMessage(e.getMessage());
        }

        return apiException;
    }
}