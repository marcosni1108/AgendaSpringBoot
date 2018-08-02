package com.springproject.error;

import lombok.Data;

@Data
class ErrorDetail {
    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String developerMessage;
}
