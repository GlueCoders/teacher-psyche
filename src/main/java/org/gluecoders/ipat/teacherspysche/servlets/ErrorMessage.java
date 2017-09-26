package org.gluecoders.ipat.teacherspysche.servlets;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class ErrorMessage {

    public enum ErrorCode{
        VALIDATION_FAILED,
        RESOURCE_ALREADY_EXISTS,
        GENERIC_ERROR
    }

    private ErrorCode code;

    public ErrorMessage(ErrorCode code) {
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}
