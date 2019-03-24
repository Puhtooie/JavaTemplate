//package com.mongodb;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.DBCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class MongoMain {


    private DBCollection col;
    private String collect;

    public MongoMain(){}

    public MongoMain(String collect)
    {
        this.collect = collect; //This is so that more than one Collection can be instantiated and querried.
    }


    public void getDb(String userName, String dataBase,
                      String password)
    {
        this.col = new Collection(userName,dataBase,
                password).getCollection(collect); //init the DBCollection
    }


    public ArrayList QueryBuild(Date startDate, Date endDate, ArrayList params)
    {
        DBObject query = new QueryBuilder().start(startDate)
                .lessThan(endDate).and(new QueryBuilder()
                        .or(Arrays.asList(params)))//Params is an ArrayList of QueryBuilder() Objects
                .get();

        return col.find(query);
    }

}
