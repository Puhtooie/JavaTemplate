//package com.mongodb;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.DBCollection;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class MongoMain {


    private DBCollection col;
    private String collect;

    public MongoMain(){}

    public MongoMain(String collect){this.collect = collect;}


    public void getDb(String userName, String dataBase,
                        String password)
    {
        this.col = new Collection(userName,dataBase,
                password).getCollection(collect);
    }


    public ArrayList Query(Date startDate, Date endDate, ArrayList params)
    {
        DBObject query = new QueryBuilder().start(startDate)
                .lessThan(endDate).and(new QueryBuilder()
                        .or(Arrays.asList(params)))
                .get();

        return col.find(query);
    }

    public query(Date startDate, Date endDate, ArrayList params)
    {

        //for Aggregation.
    }

}

