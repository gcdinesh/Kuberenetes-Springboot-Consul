package com.shopper.product.exceptions;

public class InvalidPasswordException extends ProductServiceException {

    public InvalidPasswordException() {
        super(Messages.INVALID_PASSWORD);
    }

    public ErrorDetail getErrorDetail() {
        return new ErrorDetail(Messages.code2, userMessage);
    }
}
