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
		
		if(!userExist(username))
			mongo.addDocumentToCollection(document);
		else{
			System.out.println("User already exists");
		}
	}
	
	public Boolean userExist(String username){
		mongo.setCollection(mongoCollections.CUSTOMERS);
		DBCursor queryresults = mongo.queryDB("user", username);
		
		if (queryresults.size() == 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public Boolean productExist(String product){
		mongo.setCollection(mongoCollections.PRODUCTS);
		DBCursor queryresults = mongo.queryDB("productName", product);
		
		if (queryresults.size() == 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	public void addProductToCart(String username, String product)
	{
		if (userExist(username) && productExist(product)) {
			mongo.setCollection(mongoCollections.ORDERS);
			BasicDBObject document = new BasicDBObject();
			document.append("user", username);
			document.append("product", product);
			mongo.addDocumentToCollection(document);
			System.out.println("Order succesfully placed");
		}
		else{
			System.out.println("Invalid input. Please make sure you have the right user and product");
		}
	}
}