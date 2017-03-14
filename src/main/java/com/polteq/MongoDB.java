package com.polteq;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoIterable;
import com.polteq.MongoDB.mongoCollections;

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

	public void setCollection(mongoCollections mongoCollections){
		mongoclient = new MongoClient("localhost", 27017);
		database = mongoclient.getDB("TDDDB");
		collection = database.getCollectionFromString(mongoCollections.toString().toLowerCase());
	}
	
	public DBCursor listAll(){
		DBCursor cursor = collection.find();
		return cursor;
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
