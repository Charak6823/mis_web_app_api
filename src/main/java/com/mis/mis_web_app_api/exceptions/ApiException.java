package com.mis.mis_web_app_api.exceptions;

import lombok.*;


/**
 *  Custom exception class for API-related errors.
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends Throwable{

    private String code;
    private String messageKh;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, String messageKh, String code) {
        super(message);
        this.messageKh = messageKh;
        this.code = code;
    }
}
