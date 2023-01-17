package main;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
	/*
	 * TODO
	 * Working on learning MongoDB, document based databasing.
	 * If not successful, will use SQL.
	 */
	private static String connection = "mongodb+srv://User1:YrqHUL2yh3xT7mLo"
			+ "@cluster0.woj8vsj.mongodb.net/?retryWrites=true&w=majority";
	private static MongoClient client = MongoClients.create(connection);
	private static MongoDatabase database = client.getDatabase("SystemDevDB");
	private static MongoCollection<Document> collection = database.getCollection("Test");
//	private static MongoCollection<Document> collection = database.getCollection("ApplicationDB");
	
	
	public static void viewAllDocuments()
	{
		MongoCursor<Document> cursor = collection.find().iterator();
		try 
		{
		    while (cursor.hasNext()) 
		    {
		        System.out.println(cursor.next().toJson());
		    }
		} 
		finally 
		{
		    cursor.close();
		}
	}
	
	public static void addEntry(Patient patient)
	{
		Document newEntry = new Document("medicare", patient.getMedicare())
				.append("fName", patient.getfName())
				.append("lName", patient.getlName())
				.append("age", patient.getAge())
				.append("gender", patient.getGender())
				.append("dobDay", patient.getDobDay())
				.append("dobMonth", patient.getDobMonth())
				.append("dobYear", patient.getDobYear())
				.append("disease1", patient.getDisease1())
				.append("disease2", patient.getDisease2())
				.append("disease3", patient.getDisease3())
				.append("disease4", patient.getDisease4())
				.append("disease5", patient.getDisease5())
				.append("disease6", patient.getDisease6());
				collection.insertOne(newEntry);
	}
//	
//	public static void addEntry(String name, String price, String format, String quantity, String store)
//	{	
//		Document newEntry = new Document("name", name)
//				.append("price", price)
//				.append("format", format)
//				.append("quantity", quantity)
//				.append("store", store);
//		collection.insertOne(newEntry);
//	}
	
	public static void deleteEntry(String medicare)
	{
		Document query = new Document("medicare", medicare);
		collection.deleteOne(query);
	}
	
	public static ArrayList<Patient> BSONtoObjects()
	{
		ArrayList<Patient> objectList = new ArrayList<Patient>();
		MongoCursor<Document> cursor = collection.find().iterator();
		try 
		{
		    Gson gson = new Gson();
		    while(cursor.hasNext())
		    {
		    	Document document = cursor.next();
		    	Patient model = gson.fromJson(document.toJson(), Patient.class);
			    objectList.add(model);
		    }
		} 	
		finally 
		{
		    cursor.close();
		}
		return objectList;
	}
}
