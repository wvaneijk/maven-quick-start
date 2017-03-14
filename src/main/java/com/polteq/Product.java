package com.polteq;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.polteq.MongoDB.mongoCollections;

public class Product{ 
	
	MongoDB mongo = new MongoDB();

	public void listAllProducts(){
		mongo.setCollection(mongoCollections.PRODUCTS);
		DBCursor results = mongo.listAll();
		while (results.hasNext()) {
		    BasicDBObject obj = (BasicDBObject) results.next();
		    System.out.println(obj.getString("productName") + " €"+obj.getString("price"));
		}
	}
}
