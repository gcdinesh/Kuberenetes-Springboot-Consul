package com.shopper.product.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongoConfigurations {

  @Autowired private MongoProperties mongoProperties;

  @Bean
  public MongoDatabase mongoDatabase() {
    MongoClient mongoClient = MongoClients.create(mongoProperties.getUri());
    System.out.println(mongoProperties.getUri());
    return mongoClient.getDatabase("shopper");
  }
}
