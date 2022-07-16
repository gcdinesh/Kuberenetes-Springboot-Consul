package com.shopper.product.db;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.shopper.product.model.DBDAO;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDB extends AbstractMongoDbOperations {
  public static final String USER_DETAILS_COLLECTION = "userDetails";

  @Autowired
  public LoginDB(MongoDatabase mongoDatabase) {
    this.mongoDatabase = mongoDatabase;
  }

  public <T extends DBDAO> void insert(T DAO) {
    insert(DAO, USER_DETAILS_COLLECTION);
  }

  public MongoCursor<Document> find(Bson filter) {
    return find(filter, USER_DETAILS_COLLECTION);
  }
}
