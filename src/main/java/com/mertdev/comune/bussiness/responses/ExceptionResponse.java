package com.mertdev.comune.bussiness.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionResponse {
    private String httpStatus;
    private String errorLocation;
    private String message;

}
