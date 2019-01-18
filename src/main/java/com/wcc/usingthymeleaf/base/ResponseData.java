package com.wcc.usingthymeleaf.base;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name ResponseData
 * @description 封装返回信息{status,message,data}
 * @date 19-1-14 下午3:29
 */
public class ResponseData implements Serializable {
    private static final long serialVersionUID = -1919560630109993566L;

    public static final String STATUS = "status";
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_ERROR = "error";
    public static final String MESSAGE = "message";

    private String status;
    private String message;
    private List<BaseEntity> data;

    private ResponseData(String status) {
        this.status = status;
    }

    private ResponseData(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseData newSuccess() {
        return new ResponseData(STATUS_SUCCESS);
    }

    public static ResponseData newError() {
        return new ResponseData(STATUS_ERROR);
    }

    public static ResponseData newError(String message) {
        return new ResponseData(STATUS_ERROR, message);
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BaseEntity> getData() {
        return data;
    }

    public void setData(List<BaseEntity> data) {
        this.data = data;
    }
}
