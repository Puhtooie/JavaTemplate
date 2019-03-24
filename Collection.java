//package com.mongodb;


import java.util.Arrays;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class Collection{
    private String userName, dataBase, password;

    public Collection(){}

    public Collection(String userName, String dataBase,
                    String password)
    {
        this.userName = userName;
        this.dataBase = dataBase;
        this.password = password;
    }

    public DB getDb()
    {
        MongoCredential credential = MongoCredential.createCredential(userName,
                dataBase, password);

        return new MongoClient(new ServerAddress("localhost", 27017),
                Arrays.asList(credential))
                .getDB(dataBase);
    }
}
