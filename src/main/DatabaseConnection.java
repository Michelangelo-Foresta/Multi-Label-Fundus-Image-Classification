package main;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
	private static CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
	private static CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
	private static String uri = "mongodb+srv://User1:YrqHUL2yh3xT7mLo@cluster0.woj8vsj.mongodb.net/?retryWrites=true&w=majority";
	private static MongoClient mongoClient = MongoClients.create(uri);
	private static MongoDatabase database = mongoClient.getDatabase("SystemDevDB")
			.withCodecRegistry(pojoCodecRegistry);
	/*
	 * TODO THese are test collections. Change them for final deployment
	 */
	public static MongoCollection<Patient> colPatient = database.getCollection("Test", Patient.class);
	public static MongoCollection<Diagnosis> colDiagnosis = database.getCollection("Test1", Diagnosis.class);
	
	public static void insertPatient(Patient patient)
	{
		colPatient.insertOne(patient);
	}
	
	public static void insertDiagnosis(Diagnosis diagnosis)
	{
		colDiagnosis.insertOne(diagnosis);
	}
	
	
	// Getters and setters
	public CodecProvider getPojoCodecProvider() {
		return pojoCodecProvider;
	}

	public void setPojoCodecProvider(CodecProvider pojoCodecProvider) {
		DatabaseConnection.pojoCodecProvider = pojoCodecProvider;
	}

	public CodecRegistry getPojoCodecRegistry() {
		return pojoCodecRegistry;
	}

	public void setPojoCodecRegistry(CodecRegistry pojoCodecRegistry) {
		DatabaseConnection.pojoCodecRegistry = pojoCodecRegistry;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		DatabaseConnection.uri = uri;
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		DatabaseConnection.mongoClient = mongoClient;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		DatabaseConnection.database = database;
	}

	public MongoCollection<Patient> getColPatient() {
		return colPatient;
	}

	public void setColPatient(MongoCollection<Patient> colPatient) {
		DatabaseConnection.colPatient = colPatient;
	}

	public MongoCollection<Diagnosis> getDiaPatient() {
		return colDiagnosis;
	}

	public void setDiaPatient(MongoCollection<Diagnosis> colDiagnosis) {
		DatabaseConnection.colDiagnosis = colDiagnosis;
	}

	
}