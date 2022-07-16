package com.shopper.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SignUpRequestBody {
  private String userName;
  private String password;
  private String emailId;
}
