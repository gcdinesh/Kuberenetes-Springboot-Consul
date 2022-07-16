package com.shopper.consul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConsulProperties {

  @Value("${spring.cloud.consul.host}")
  private String consulHost;

  public String getConsulHost() {
    return consulHost;
  }
}
