package main;

import org.bson.Document;

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
	
//	ConnectionString connectionString = new ConnectionString("mongodb+srv://User1:<password>@cluster0.woj8vsj.mongodb.net/?retryWrites=true&w=majority");
//	MongoClientSettings settings = MongoClientSettings.builder()
//	        .applyConnectionString(connectionString)
//	        .serverApi(ServerApi.builder()
//	            .version(ServerApiVersion.V1)
//	            .build())
//	        .build();
//	MongoClient mongoClient = MongoClients.create(settings);
//	MongoDatabase database = mongoClient.getDatabase("test");
	
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
}
