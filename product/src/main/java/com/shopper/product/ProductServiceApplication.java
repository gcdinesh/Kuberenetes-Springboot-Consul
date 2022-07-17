package com.shopper.product;

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
public class ProductServiceApplication {
  @Autowired private ConsulPropertyUploader consulPropertyUploader;

  public static void main(String[] args) {
    SpringApplication.run(ProductServiceApplication.class, args);
  }

  @PostConstruct
  public void setup() {
    consulPropertyUploader.uploadFile("product");
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
