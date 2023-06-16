package uy.edu.fing.tse.CargaUY.response;

import java.io.Serializable;

public class RestResponse implements Serializable {
    private static final Long serialVersionUID = 1L;
    private int status;
    private String msg;

    public RestResponse() {
    }

    public RestResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
