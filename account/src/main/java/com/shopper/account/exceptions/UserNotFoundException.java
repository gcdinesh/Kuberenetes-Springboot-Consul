package com.shopper.account.exceptions;

import lombok.Getter;

@Getter
public class UserNotFoundException extends AccountServiceException {
  private static final long serialVersionUID = 7684248076818601410L;

  public UserNotFoundException(String userMessage, Object... args) {
    super(userMessage, args);
  }

  public ErrorDetail getErrorDetail() {
    return new ErrorDetail(Messages.code4, userMessage);
  }
}
