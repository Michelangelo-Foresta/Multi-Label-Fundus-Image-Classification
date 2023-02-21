package packages;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PatientController {
	private PatientView view;
	static Patient patient;
	static String path;
	static Map<String,Float> disease;
	private ArrayList<Patient> pModels;
	private ArrayList<Diagnosis> dModels;
	private File file;
	PDFMethods pdfMethods = new PDFMethods();
	private int targetWidth=128;
	private int targetHeight=128;
	
	public PatientController(PatientView view) throws IOException {
		this.view = view;
		this.pModels = new ArrayList<Patient>();
		this.dModels = new ArrayList<Diagnosis>();
	}
	

	public void consolePrintPatients()
	{
		this.view.printAllPatients(pModels);
	}
	
	public void consolePrintDiagnosis()
	{
		this.view.printAllDiagnosis(dModels);
	}
	
	/**
	 * Run once at startup. Retrieves all entries from the database.
	 */
	public void retrieveAllData()
	{
		DatabaseConnection.colDiagnosis.find().into(this.dModels);
		DatabaseConnection.colPatient.find().into(this.pModels);	
	}
	
	public void insertEntry(Patient patient, Diagnosis diagnosis)
	{
		this.pModels.add(patient);
		this.dModels.add(diagnosis);
		DatabaseConnection.insertPatient(patient);
		DatabaseConnection.insertDiagnosis(diagnosis);	
	}
	
	public void insertEntry(String firstName, String lastName, 
			int year, int month, int day, 
			String medicare, String address, String email,

			double disease1, double disease2, double disease3,
			double disease4, double disease5, double disease6,
			double disease7)
	{
		Patient patient = new Patient(firstName, lastName, year, month, day, medicare, address, email);
		Diagnosis diagnosis = new Diagnosis(medicare, disease1, disease2, disease3,
				 disease4, disease5, disease6, disease7);
		this.pModels.add(patient);
		this.dModels.add(diagnosis);
		DatabaseConnection.insertPatient(patient);
		DatabaseConnection.insertDiagnosis(diagnosis);	
	}
	
	public void deleteEntry(String medicare)
	{
		for(int i = 0; i < pModels.size(); i++)
		{
			if(pModels.get(i).getMedicare().equals(medicare))
			{
				pModels.remove(pModels.get(i));
				break;
			}
		}
		for(int i = 0; i < dModels.size(); i++)
		{
			if(dModels.get(i).getMedicare().equals(medicare))
			{
				dModels.remove(dModels.get(i));
				break;
			}
		}
		DatabaseConnection.deletePatient(medicare);
		DatabaseConnection.deleteDiagnosis(medicare);
	}
	
	public void updateEntry(String firstName, String lastName, 
			int year, int month, int day, 
			String medicare, String address, String email,

			double disease1, double disease2, double disease3,
			double disease4, double disease5, double disease6,
			double disease7)
	{
		for(int i = 0; i < pModels.size(); i++)
		{
			if(pModels.get(i).getMedicare().equals(medicare))
			{
				pModels.get(i).setFirstName(firstName);
				pModels.get(i).setLastName(lastName);
				pModels.get(i).setDobDay(day);
				pModels.get(i).setDobMonth(month);
				pModels.get(i).setDobYear(year);
				pModels.get(i).setAddress(address);
				pModels.get(i).setEmail(email);
			}
		}
		for(int i = 0; i < dModels.size(); i++)
		{
			if(dModels.get(i).getMedicare().equals(medicare))
			{
				dModels.get(i).setDisease1(disease1);
				dModels.get(i).setDisease2(disease2);
				dModels.get(i).setDisease3(disease3);
				dModels.get(i).setDisease4(disease4);
				dModels.get(i).setDisease5(disease5);
				dModels.get(i).setDisease6(disease6);

				dModels.get(i).setDisease6(disease7);
			}
		}
		DatabaseConnection.updatePatient(medicare, firstName, lastName, day, month, year, address, email);
		DatabaseConnection.updateDiagnosis(medicare, disease1, disease2, disease3, disease4, disease5, disease6,disease7);

	}
	
	public Patient searchPatient(String medicare)
	{
		for(int i = 0; i < pModels.size(); i++)
		{
			if(pModels.get(i).getMedicare().equals(medicare))
			{
				return pModels.get(i);
			}
		}
		return null;
	}
	
	public Diagnosis searchDiagnosis(String medicare)
	{
		for(int i = 0; i < dModels.size(); i++)
		{
			if(dModels.get(i).getMedicare().equals(medicare))
			{
				return dModels.get(i);
			}
		}
		return null;
	}

	
	public void initController() throws ClassNotFoundException {
		
		//handle Individual user button event from packages frame
		view.getIndivUserButton().addActionListener(e -> {
			try {
				view.individualUser();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});
		
		//handle the clinic user by loading the login page
        view.getClinicButton().addActionListener(e -> {
			
            view.showLoginFrame();
		});
        
        //handle login input event and open clinic frame if successful
        view.getLoginButton().addActionListener(e -> {
        	
        	String userName = view.getUserName().getText();
        	char[] password = view.getpasswordField().getPassword();
        	
        	System.out.println("userName = "+ userName + ", password ="+ String.valueOf(password));
        	
            //TODO: verify user name and password and if valid then open clinic frame		
            view.showClinicFrame();
		});
       
        //handle language selection (EN/FR)
        view.getLanguageButton().addActionListener(e -> {
        	//TODO: apply locale and properties files for EN/FR			
            System.out.println("locale not implemented yet");
		});
         
        //handle create patient event from clinic frame 
        view.getcreatePatientButton().addActionListener(e -> {
         	
         	//String userName = view.getUserName().getText();
         	
         	//System.out.println("userName = "+ userName + ", passord ="+ String.valueOf(password));
         	
             //TODO: verify user name and password and if valid then open clinic frame		
             view.showPatientFrame();
 		});
        
        //handle update patient event from clinic frame
        view.getUpdatePatientButton().addActionListener(e -> {
         	
            //String userName = view.getUserName().getText();
         	
         	//System.out.println("userName = "+ userName + ", password ="+ String.valueOf(password));
       	
            view.showPatientFrame();
 		});
		view.getExport().addActionListener(e->{
			try {
				PDFMethods.createPDF(patient, disease, path);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
        view.getCreatePatient().addActionListener(e->{
			patient = new Patient(view.getfNameTF().getText(), view.getlNameTF().getText(),
					Integer.parseInt(view.getDobYearTF().getText()), Integer.parseInt(view.getDobMonthTF().getText()), Integer.parseInt(view.getDobDayTF().getText()),
			view.getMedicareTF().getText(), view.getAddressTF().getText(), view.getEmailAddressTF().getText());
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

			int result = fileChooser.showOpenDialog(null);
			System.out.println("result = "+ result);
			if (result == JFileChooser.APPROVE_OPTION)
			{
				this.file=fileChooser.getSelectedFile();
				System.out.println("Selected file: " + this.file.getName());
				try {

					JFrame window= new JFrame();
					path = this.file.getParent();
					ImageIcon con= new ImageIcon(this.file.toURL());
					window.setVisible(true);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JLabel label=new JLabel();
					label.setIcon(con);
					BufferedImage in = ImageIO.read(this.file);
					BufferedImage newImg= new BufferedImage(in.getWidth(),in.getHeight(),BufferedImage.TYPE_INT_ARGB);
					newImg=ResizeImage.resizeImage(newImg, targetWidth, targetHeight);
					window.setSize(con.getIconWidth(),con.getIconHeight());
					window.getContentPane().add(label);
					disease =TrainedModel.getDiagnosis(newImg);
					view.getExport().setEnabled(true);
				//	PDFMethods.exportPdfClient(disease,patient);// ADD PDF METHOD
					System.out.println(disease +"\n"+patient);

				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}

			}
		});
        //handle the create patient having the patient info and opening update DB frame
        view.getCreateButton().addActionListener(e -> {

         	String firstName = view.getfNameTF().getText();
         	String lastName = view.getlNameTF().getText();
         	
         	System.out.println("First Name = "+ firstName + ", Last Name ="+ lastName);
         	
            //TODO: add patien""t	
         	view.updateDBFrame();
 		});
        
       //handle search patient event and if patient found open the update DB frame to get input and update DB
        view.getSearchButton().addActionListener(e -> {
         	
         	String firstName = view.getfNameTF().getText();
         	String lastName = view.getlNameTF().getText();
         	
         	System.out.println("First Name = "+ firstName + ", Last Name ="+ lastName);
         	
            //TODO: after finding patient, get the input file and update database
         	//replace the following code, this is just for testing very simple case
         	if(firstName.equals(""))
         	{
         		view.displayResultMessage("user not found");
         	}
         	else
         	{
             	view.updateDBFrame();
         	}
 		});
        
        //handle input file in update DB frame
        view.getInputImageButton().addActionListener(e -> {
			
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(null);
			System.out.println("result = "+ result);
			if (result == JFileChooser.APPROVE_OPTION) 
			{
				this.file = fileChooser.getSelectedFile();
				System.out.println("Selected file: " + this.file.getName());
				//TODO: the selected file will be used to update the DB after clicking the updateDB button
				
			}
		});
        
        //handle update DB event in update DB frame
        view.getUpdateDBButton().addActionListener(e -> {
			
			
			System.out.println("update DB with file = "+ this.file.getName() );
			//TODO add update DB code
			
		});
        
        //handle view whole DB event
        view.getviewWholeDBButton().addActionListener(e -> {
			consolePrintPatients();
			System.out.println("view whole DB = ");
			//TODO add view whole DB code
			
		});
        
    }
	
	// Getters and setters

	public PatientView getView() {
		return this.view;
	}

	public void setView(PatientView view) {
		this.view = view;
	}

	public ArrayList<Patient> getpModels() {
		return pModels;
	}

	public void setpModels(ArrayList<Patient> pModels) {
		this.pModels = pModels;
	}

	public ArrayList<Diagnosis> getdModels() {
		return dModels;
	}

	public void setdModels(ArrayList<Diagnosis> dModels) {
		this.dModels = dModels;
	}

	public final File getFile() {
		return file;
	}

	public final void setFile(File file) {
		this.file = file;
	}

	public static void convert() {


	}
}
