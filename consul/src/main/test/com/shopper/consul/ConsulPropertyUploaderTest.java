package com.shopper.consul;

import org.junit.Test;

import java.io.IOException;

public class ConsulPropertyUploaderTest {

  @Test
  public void uploadFile() throws IOException {
    (new ConsulPropertyUploader(new ConsulProperties())).uploadFile("account");
  }
}
