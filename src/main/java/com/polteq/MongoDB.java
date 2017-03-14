package com.polteq;

import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDB {

	public MongoClient mongoclient;
	public DBCollection collection;
	public DB database;

	public MongoDB() {
	}
	
	enum mongoCollections { PRODUCTS, ORDERS, CUSTOMERS}
	
	public DBCollection getCollection(){
		return collection;
	}

	public void connectToDB() {
		mongoclient = new MongoClient("localhost", 27017);
		database = mongoclient.getDB("TDDDB");
	}
	
	public void setCollection(mongoCollections mongoCollection){
		collection = database.getCollection(mongoCollection.toString().toLowerCase());
	}
	
	public void addDocumentToCollection(BasicDBObject document) {
		collection.insert(document);
	}
	
	public DBCursor queryDB(String key, String value){
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(key, value);
		DBCursor cursor = collection.find(searchQuery);
		return cursor;
	}
	
	public List<String> listDBNames() {
		List<String> DBnames = null;
		MongoIterable<String> dbs = mongoclient.listDatabaseNames();
		for (String string : dbs) {
			System.out.println(string);
			DBnames.add(string);
		}
		return DBnames;
	}

	public void closeDBConnection(){
		mongoclient.close();
	}
	
}
