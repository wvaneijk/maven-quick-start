package com.polteq;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.polteq.MongoDB.mongoCollections;

public class Customer {
	
	private MongoDB mongo = new MongoDB();
	
	public void createCustomer(String username)
	{
		mongo.setCollection(mongoCollections.CUSTOMERS);
		
		BasicDBObject document = new BasicDBObject();
		document.append("user", username);
		DBCursor queryresults = mongo.queryDB("user", username);
		
		if (queryresults.size() == 0) {
			mongo.addDocumentToCollection(document);
		}
		else{
			System.out.println("User already exists");
		}
	}
}