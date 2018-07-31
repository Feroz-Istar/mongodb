package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class BaseDatabaseDao {
	
	public MongoDatabase getDB() {
		MongoClient mongoclient = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("root", "feroz", "root".toCharArray());
		System.out.println("Connected to the database successfully");
		
		
		MongoDatabase database = mongoclient.getDatabase("feroz");
		return database;
	}

}
