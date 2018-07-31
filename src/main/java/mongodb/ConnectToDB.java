package mongodb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class ConnectToDB {
 public static void main(String args[]) throws IOException {
		// Creating a Mongo client
		MongoClient mongoclient = new MongoClient("localhost", 27017);
		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("root", "feroz", "root".toCharArray());
		System.out.println("Connected to the database successfully");
		
		
		DB database = mongoclient.getDB("feroz");
		DBCollection col = database.getCollection("sampleCollection");

		
		
     
     
     
 }
}
