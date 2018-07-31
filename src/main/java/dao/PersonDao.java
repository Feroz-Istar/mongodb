package dao;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import pojo.AppUser;
import pojo.Person;

public class PersonDao extends BaseDatabaseDao {
	private static final Gson gson = new Gson();
	public void insertPerson(Person person) {
		MongoDatabase db = getDB();
		Document doc = Document.parse(gson.toJson(person));
		db.getCollection("personCollection").insertOne(doc);
	}
	
	public void findAll() {
		MongoDatabase db = getDB();
		MongoCollection<Document> mongo_collection = db.getCollection("personCollection");
		FindIterable<Document> filter = mongo_collection.find();
		MongoCursor<Document> cursor = filter.iterator();

		try {
			while (cursor.hasNext()) {
				//System.out.println(cursor.next().toJson());
				String obj = cursor.next().toJson();
				System.out.println(obj);
				Person person = gson.fromJson(obj, Person.class);
				System.out.println(person.get_id().get$oid());
				
			}
		}catch(JsonSyntaxException jse) {
			jse.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			cursor.close();

		}
	}
}
