package com.shopper.account.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Getter
@Configuration
@RefreshScope
public class AccountProperties {

  @Value("${testkey}")
  private String testKey;

  /** To validate that the properties are set correctly. */
  @PostConstruct
  public void postConstruct() {
    System.out.println("** testkey: " + testKey);
  }
}
