package dao;

import java.text.SimpleDateFormat;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.google.gson.GsonBuilder;

import pojo.AppUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppUserDao extends BaseDatabaseDao {
	public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public void insertAppUser(AppUser appUser) {
		MongoDatabase db = getDB();
		Document doc = Document.parse(gson.toJson(appUser));
		db.getCollection("sampleCollection").insertOne(doc);
	}

	public AppUser find(String key, Object value) {
		AppUser appUser = new AppUser();
		MongoDatabase db = getDB();
		BasicDBObject query = new BasicDBObject();
		query.put(key, value);
		FindIterable<Document> filter = db.getCollection("sampleCollection").find(query);
		MongoCursor<Document> cursor = filter.iterator();
		try {
			String obj = cursor.next().toJson();
			System.out.println(obj);
			appUser = gson.fromJson(obj, AppUser.class);
		} catch (JsonSyntaxException jse) {
			jse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();

		}
		return appUser;

	}

	public List<AppUser> findMulitple(HashMap<String, Object> map) {
		List<AppUser> appUsers = new ArrayList<>();

		MongoDatabase db = getDB();
		BasicDBObject query = new BasicDBObject();
		for (String key : map.keySet()) {
			query.append(key, map.get(key));
		}

		FindIterable<Document> filter = db.getCollection("sampleCollection").find(query);
		MongoCursor<Document> cursor = filter.iterator();
		try {
			String obj = cursor.next().toJson();
			System.out.println(obj);
			AppUser appUser = gson.fromJson(obj, AppUser.class);
			appUsers.add(appUser);
		} catch (JsonSyntaxException jse) {
			jse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();
		}
		return appUsers;
	}

	public List<AppUser> findAll() {
		List<AppUser> appUsers = new ArrayList<>();
		MongoDatabase db = getDB();
		MongoCollection<Document> mongo_collection = db.getCollection("sampleCollection");
		FindIterable<Document> filter = mongo_collection.find();
		MongoCursor<Document> cursor = filter.iterator();

		try {
			while (cursor.hasNext()) {
				// System.out.println(cursor.next().toJson());
				String obj = cursor.next().toJson();
				System.out.println(obj);
				AppUser appUser = gson.fromJson(obj, AppUser.class);
				appUsers.add(appUser);

			}
		} catch (JsonSyntaxException jse) {
			jse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();

		}
		return appUsers;
	}

	public List<AppUser> sortBy(String key) {
		List<AppUser> appUsers = new ArrayList<>();
		MongoDatabase db = getDB();
		MongoCollection<Document> mongo_collection = db.getCollection("sampleCollection");
		FindIterable<Document> filter = mongo_collection.find().sort(new BasicDBObject(key, 1));
		MongoCursor<Document> cursor = filter.iterator();

		try {
			while (cursor.hasNext()) {
				// System.out.println(cursor.next().toJson());
				String obj = cursor.next().toJson();
				System.out.println(obj);
				AppUser appUser = gson.fromJson(obj, AppUser.class);
				appUsers.add(appUser);

			}
		} catch (JsonSyntaxException jse) {
			jse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();

		}
		return appUsers;
	}

}
