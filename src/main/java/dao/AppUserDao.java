package dao;

import java.text.SimpleDateFormat;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.google.gson.GsonBuilder;

import pojo.AppUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
			while (cursor.hasNext()) {
				String obj = cursor.next().toJson();
				System.out.println(obj);
				appUser = gson.fromJson(obj, AppUser.class);
			}
		} catch (JsonSyntaxException jse) {
			jse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();

		}
		return appUser;

	}

	public void searchAllField() {
		MongoDatabase db = getDB();
	}

	public List<AppUser> findMulitple(HashMap<String, Object> map) {
		List<AppUser> appUsers = new ArrayList<>();
		MongoDatabase db = getDB();
		BasicDBList query = new BasicDBList();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			query.add(new BasicDBObject(entry.getKey(), entry.getValue()));
		}
		System.out.println(new BasicDBObject("$or", query).toJson());
		FindIterable<Document> filter = db.getCollection("sampleCollection").find(new BasicDBObject("$or", query));
		MongoCursor<Document> cursor = filter.iterator();
		try {
			while (cursor.hasNext()) {
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

	public List<AppUser> sortMulitple(HashMap<String, Object> map) {
		List<AppUser> appUsers = new ArrayList<>();
		MongoDatabase db = getDB();
		BasicDBList query = new BasicDBList();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			query.add(new BasicDBObject(entry.getKey(), entry.getValue()));
		}
		System.out.println(new BasicDBObject("$or", query).toJson());

		List<Bson> sorts = map.keySet().stream().map(Sorts::descending).collect(Collectors.toList());

		FindIterable<Document> filter = db.getCollection("sampleCollection").find().sort(Sorts.orderBy(sorts));
		MongoCursor<Document> cursor = filter.iterator();
		try {
			while (cursor.hasNext()) {
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
	
	
	public void delete(String key, Object value) {
		MongoDatabase db = getDB();
		BasicDBObject query = new BasicDBObject();
		query.put(key, value);
		db.getCollection("sampleCollection").deleteOne(query);
		
	}
	
	
	public void deleteAll() {
		MongoDatabase db = getDB();
		BasicDBObject query = new BasicDBObject();
		db.getCollection("sampleCollection").deleteMany(query);
		
	}

}
