package main;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class PatientController {
	private PatientView view;
	private ArrayList<Patient> model;
	private File file;

	
	public PatientController(PatientView view) {
		this.view = view;
		this.model = new ArrayList<Patient>();
	}
	
	public PatientView getView() {
		return this.view;
	}

	public void setView(PatientView view) {
		this.view = view;
	}
	
	public void initController() throws ClassNotFoundException {
		
		//handle Individual user button event from main frame
		view.getIndivUserButton().addActionListener(e -> {
			
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(null);
			System.out.println("result = "+ result);
			if (result == JFileChooser.APPROVE_OPTION) 
			{
				this.file = fileChooser.getSelectedFile();
				System.out.println("Selected file: " + this.file.getName());
				//TODO: the selected file will be used to output diagnosis and export as PDF
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
        	
        	System.out.println("userName = "+ userName + ", passord ="+ String.valueOf(password));
        	
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
         	
         	//System.out.println("userName = "+ userName + ", passord ="+ String.valueOf(password));
       	
            view.showPatientFrame();
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
						
			System.out.println("view whole DB = ");
			//TODO add view whole DB code
			
		});
        
    }
	

	public final File getFile() {
		return file;
	}


	public final void setFile(File file) {
		this.file = file;
	}
}
