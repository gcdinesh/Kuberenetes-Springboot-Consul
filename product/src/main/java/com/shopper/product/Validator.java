package com.shopper.product;

import com.shopper.product.exceptions.InvalidUserDetailsException;
import com.shopper.product.exceptions.Messages;
import com.shopper.product.model.SignUpRequestBody;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Validator {
  private final EmailValidator emailValidator = EmailValidator.getInstance();

  public void validateUserDetails(SignUpRequestBody signUpRequestBody) {
    if (isValidUserName(signUpRequestBody.getUserName())) {
      throw new InvalidUserDetailsException(Messages.INVALID_USER_NAME);
    }
    if (!isValidPassword(signUpRequestBody.getPassword())) {
      throw new InvalidUserDetailsException(Messages.INVALID_PASSWORD_CREATION);
    }
    if (!isValidEmailId(signUpRequestBody.getEmailId())) {
      throw new InvalidUserDetailsException(Messages.INVALID_EMAIL_ID);
    }
  }

  private boolean isValidUserName(final String userName) {
    return StringUtils.isBlank(userName);
  }

  private boolean isValidPassword(final String password) {
    if (StringUtils.isBlank(password) || password.length() < 8) {
      return false;
    }

    boolean hasCapital = false, hasLower = false, hasDigit = false, hasSpecialChar = false;

    for (char c : password.toCharArray()) {
      if (Character.isUpperCase(c)) {
        hasCapital = true;
      } else if (Character.isLowerCase(c)) {
        hasLower = true;
      } else if (Character.isDigit(c)) {
        hasDigit = true;
      } else if (Arrays.asList('.', '$', '/', '!', '@', '#', '^', '&', '*', '-', '_', ',')
          .contains(c)) {
        hasSpecialChar = true;
      }
    }

    return hasCapital && hasLower && hasDigit && hasSpecialChar;
  }

  private boolean isValidEmailId(String emailId) {
    if (StringUtils.isBlank(emailId)) {
      return true;
    }

    return emailValidator.isValid(emailId);
  }
}
