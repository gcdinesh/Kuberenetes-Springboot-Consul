package com.shopper.consul;

import com.ecwid.consul.transport.HttpResponse;
import com.ecwid.consul.v1.ConsulRawClient;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

@Component
public class ConsulPropertyUploader {
  private ConsulProperties consulProperties;

  @Autowired
  public ConsulPropertyUploader(ConsulProperties consulProperties) {
    this.consulProperties = consulProperties;
  }

  public boolean uploadFile(String appName) {
    try {
      System.out.println("Uploading properties file to consul...");
      ConsulRawClient consulClient =
          new ConsulRawClient("http://" + consulProperties.getConsulHost());
      File file = new File("/opt/application.yml");
      String str = Files.readString(file.toPath());
      HttpResponse httpResponse =
          consulClient.makePutRequest("/v1/kv/configuration/" + appName + "/data", str);
      return httpResponse.getStatusCode() == HttpStatus.SC_OK;
    } catch (Exception e) {
      System.out.printf(
          "Failed to upload file to consul: message:{}, cause:{}%n", e.getMessage(), e.getCause());
      throw new RuntimeException(e);
    }
  }
}
