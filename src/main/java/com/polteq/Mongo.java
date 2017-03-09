package com.polteq;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Mongo {

	public MongoClient mongoclient;
	public MongoCollection<Document> collection;

	public Mongo() {
	}

	public void setupDBConnection() {
		mongoclient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoclient.getDatabase("TDDDB");
		collection = db.getCollection("orders");
	}

	public void addItemToOrder(String client, String item) {
		Document document = new Document();
		document.append("user", client).append("item", item);
		collection.insertOne(document);
	}

	public void listDBNames() {
		MongoIterable<String> dbs = mongoclient.listDatabaseNames();
		for (String string : dbs) {
			System.out.println(string);
		}
	}
}
