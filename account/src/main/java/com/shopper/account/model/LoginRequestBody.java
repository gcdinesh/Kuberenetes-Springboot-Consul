package com.shopper.account.model;

import com.shopper.account.exceptions.InvalidUserDetailsException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Setter
@Getter
@NoArgsConstructor
public class LoginRequestBody {
    private String userName;
    private String password;

    private void setUserName(final String userName) {
        if (StringUtils.isEmpty(userName.trim())) {
            throw new InvalidUserDetailsException(userName);
        }
        this.userName = userName;
    }
}
