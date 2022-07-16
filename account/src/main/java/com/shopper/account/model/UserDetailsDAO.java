package com.shopper.account.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDetailsDAO extends DBDAO {
  @Builder.Default private final long passwordExpiryDate = System.currentTimeMillis() + 777600000L;
  private String userName;
  private String password;
  private String emailId;
}
