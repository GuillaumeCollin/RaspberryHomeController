package com.homeController.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * Spring MongoDB configuration file
 *
 */

@Configuration
public class MongoGridFsTemplate extends AbstractMongoConfiguration {

    @Value("${raspberry.mongo.address}")
    private String mongoAddress;

    @Value("${raspberry.mongo.database}")
    private String mongoDatabase;

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return mongoDatabase;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoAddress);
    }
}
