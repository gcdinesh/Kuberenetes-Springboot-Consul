package com.shopper.account.controller;

import com.shopper.account.model.LoginRequestBody;
import com.shopper.account.model.SignUpRequestBody;
import com.shopper.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping(value = "/login")
  protected String login(@RequestBody final LoginRequestBody loginRequestBody) {
    return accountService.login(loginRequestBody);
  }

  @PostMapping(value = "/signup")
  protected String signUp(@RequestBody final SignUpRequestBody signUpRequestBody) {
    return accountService.signUp(signUpRequestBody);
  }
}
