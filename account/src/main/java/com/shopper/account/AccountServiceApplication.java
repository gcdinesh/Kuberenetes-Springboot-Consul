package com.shopper.account;

import com.shopper.consul.ConsulPropertyUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.shopper.consul", "com.shopper"})
public class AccountServiceApplication {
  @Autowired private ConsulPropertyUploader consulPropertyUploader;

  @PostConstruct
  public void setup() {
    consulPropertyUploader.uploadFile("account");
  }

  public static void main(String[] args) {
    SpringApplication.run(AccountServiceApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
