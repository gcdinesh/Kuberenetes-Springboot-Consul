package com.shopper.account.exceptions;

import java.text.MessageFormat;

public class AccountServiceException extends RuntimeException {
    private static final long serialVersionUID = 7684248076818601417L;
    protected String userMessage;
    protected Object[] args;

    public AccountServiceException() {
    }

    public AccountServiceException(String userMessage, Object... args) {
        this.userMessage = MessageFormat.format(userMessage, args);
        this.args = args;
    }

    public ErrorDetail getErrorDetail() {
        return new ErrorDetail(Messages.code1, userMessage);
    }

}
