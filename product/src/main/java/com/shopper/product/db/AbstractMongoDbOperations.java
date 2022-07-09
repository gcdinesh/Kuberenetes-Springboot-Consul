package com.shopper.product.db;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneModel;
import com.shopper.product.exceptions.MongoInsertionException;
import com.shopper.product.model.DBDAO;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public abstract class AbstractMongoDbOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractMongoDbOperations.class);
    protected MongoDatabase mongoDatabase;

    AbstractMongoDbOperations() {
    }

    public <T extends DBDAO> void insert(T DAO, String collectionName) {
        try {
            String s = new ObjectMapper().convertValue(DAO, JsonNode.class).toString();
            List<InsertOneModel<Document>> insertModelList = Collections.singletonList(new InsertOneModel(Document.parse(s)));
            mongoDatabase.getCollection(collectionName).bulkWrite(insertModelList);

        } catch (MongoBulkWriteException e) {
            LOGGER.error("Exception while inserting record in mongodb", e);
            throw new MongoInsertionException();
        } catch (MongoException e) {
            LOGGER.error("Exception while contacting mongodb", e);
            throw new MongoInsertionException();
        }
    }

    public MongoCursor<Document> find(Bson filter, String collectionName) {
        FindIterable<Document> result = mongoDatabase.getCollection(collectionName)
                .find(filter, Document.class);
        return result.iterator();
    }

}
