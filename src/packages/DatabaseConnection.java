package packages;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

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
	
	public static void deletePatient(String medicare)
	{
		Bson filter = Filters.eq("medicare", medicare);
		colPatient.deleteOne(filter);
	}
	
	public static void deleteDiagnosis(String medicare)
	{
		Bson filter = Filters.eq("medicare", medicare);
		colDiagnosis.deleteOne(filter);
	}
	
	public static void updatePatient(String medicare, String firstName, String lastName, 
			int day, int month, int year, String address, String email)
	{
		Bson filter = Filters.eq("medicare", medicare);
		Bson updateFName = Updates.set("firstName", firstName);
		Bson updateLName = Updates.set("lastName", lastName);
		Bson updateDay = Updates.set("dobDay", day);
		Bson updateMonth = Updates.set("dobMonth", month);
		Bson updateYear = Updates.set("dobYear", year);
		Bson updateAddress = Updates.set("address", address);
		Bson updateEmail = Updates.set("email", email);
		colPatient.updateOne(filter, updateFName);
		colPatient.updateOne(filter, updateLName);
		colPatient.updateOne(filter, updateDay);
		colPatient.updateOne(filter, updateMonth);
		colPatient.updateOne(filter, updateYear);
		colPatient.updateOne(filter, updateAddress);
		colPatient.updateOne(filter, updateEmail);
	}
	
	public static void updateDiagnosis(String medicare, double disease1, double disease2, double disease3,
									   double disease4, double disease5, double disease6, double disease7)
	{
		Bson filter = Filters.eq("medicare", medicare);
		Bson updateD1 = Updates.set("disease1", disease1);
		Bson updateD2 = Updates.set("disease2", disease2);
		Bson updateD3 = Updates.set("disease3", disease3);
		Bson updateD4 = Updates.set("disease4", disease4);
		Bson updateD5 = Updates.set("disease5", disease5);
		Bson updateD6 = Updates.set("disease6", disease6);
		Bson updateD7 = Updates.set("disease7", disease7);
		colDiagnosis.updateOne(filter, updateD1);
		colDiagnosis.updateOne(filter, updateD2);
		colDiagnosis.updateOne(filter, updateD3);
		colDiagnosis.updateOne(filter, updateD4);
		colDiagnosis.updateOne(filter, updateD5);
		colDiagnosis.updateOne(filter, updateD6);
		colDiagnosis.updateOne(filter, updateD7);
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