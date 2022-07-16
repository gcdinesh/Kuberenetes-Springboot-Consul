package com.shopper.product.service;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.shopper.product.Validator;
import com.shopper.product.db.LoginDB;
import com.shopper.product.exceptions.InvalidPasswordException;
import com.shopper.product.exceptions.Messages;
import com.shopper.product.exceptions.UserNotFoundException;
import com.shopper.product.model.CheckRequestBody;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

  private final Validator validator;
  private final LoginDB loginDB;

  @Autowired
  ProductService(Validator validator, LoginDB loginDB) {
    this.validator = validator;
    this.loginDB = loginDB;
  }

  public String checkIfExist(final CheckRequestBody checkRequestBody) {
    System.out.println("asdfasdfasdf");
    MongoCursor<Document> documentCursor = getUserDetails(checkRequestBody.getUserName());

    if (!documentCursor.hasNext()) {
      throw new UserNotFoundException(Messages.USER_NOT_FOUND, checkRequestBody.getUserName());
    }

    Document userDetail = documentCursor.next();
    if (checkRequestBody.getPassword().equals(userDetail.get("password"))) {
      return "Login Successful";
    }

    throw new InvalidPasswordException();
  }

  private MongoCursor<Document> getUserDetails(final String userName) {
    Bson filter = Filters.eq("userName", userName);
    return loginDB.find(filter);
  }
}
