package com.shopper.account.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetail {
    private String errorCode;
    private String errorMessage;
}
