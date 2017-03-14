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
		document.append("userName", username);
		
		if(!userExist(username))
			mongo.addDocumentToCollection(document);
		else{
			System.out.println("User already exists");
		}
	}
	
	public Boolean userExist(String username){
		mongo.setCollection(mongoCollections.CUSTOMERS);
		DBCursor queryresults = mongo.queryDB("userName", username);
		
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
	
	public void getCartProducts(String username)
	{
			mongo.setCollection(mongoCollections.ORDERS);
			DBCursor queryresults = mongo.queryDB("userName", username);
			while (queryresults.hasNext()) {
			    BasicDBObject obj = (BasicDBObject) queryresults.next();
			    System.out.println(obj.getString("productName") + " €" +(obj.getString("price")));
			}
	}
	
	public double getCartTotalPrice(String username)
	{
		double totalprice = 0;
		mongo.setCollection(mongoCollections.ORDERS);
		DBCursor queryresults = mongo.queryDB("userName", username);
		while (queryresults.hasNext()) {
		    BasicDBObject obj = (BasicDBObject) queryresults.next();
		    totalprice += obj.getDouble("price");
		}
		System.out.println("Total is €" + totalprice);
		return totalprice;
	}
	
	public double getProductPrice(String product)
	{
		mongo.setCollection(mongoCollections.PRODUCTS);
		DBCursor queryresults = mongo.queryDB("productName", product);
		BasicDBObject obj = (BasicDBObject) queryresults.one();
		mongo.setCollection(mongoCollections.ORDERS);
		return obj.getDouble("price");
		
	}
	
	public void addProductToCart(String username, String product)
	{
		mongo.setCollection(mongoCollections.ORDERS);
		if (userExist(username) && productExist(product)) {
			BasicDBObject document = new BasicDBObject();
			document.append("userName", username);
			document.append("productName", product);
			document.append("price", getProductPrice(product));
			
			mongo.addDocumentToCollection(document);
			System.out.println("Order succesfully placed");
		}
		else{
			System.out.println("Invalid input. Please make sure you have the right user and product");
		}
	}
}