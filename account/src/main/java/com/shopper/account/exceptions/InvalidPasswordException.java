package com.shopper.account.exceptions;

public class InvalidPasswordException extends AccountServiceException {

    public InvalidPasswordException() {
        super(Messages.INVALID_PASSWORD);
    }

    public ErrorDetail getErrorDetail() {
        return new ErrorDetail(Messages.code2, userMessage);
    }
}
