package com.shopper.account.exceptions;

public class InvalidUserDetailsException extends AccountServiceException {

  public InvalidUserDetailsException(String message, Object... args) {
    super(message, args);
  }

  public ErrorDetail getErrorDetail() {
    return new ErrorDetail(Messages.code3, userMessage);
  }
}
