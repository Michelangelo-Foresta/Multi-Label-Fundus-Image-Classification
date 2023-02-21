package packages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PatientView {
		
	private JFrame mainFrame, loginFrame, clinicFrame, patientFrame, updateFrame;
	private JButton indivUserButton, clinicButton, languageButton, loginButton,inputImageButton, updateDBButton;
	private JButton viewDBButton, createPatientButton, updatePatientButton;
	private JLabel userNameLabel ,passwordLabel ;
	private JTextField userNameText ;
	private JPasswordField  passwordFiled;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Patient Frame
	private JLabel fNameLabel, lNameLabel, medicareLabel, ageLabel, genderLabel;
	private JLabel dobLabel, dobYearLabel, dobDayLabel, dobMonthLabel, d1Label, d2Label,d3Label,d4Label,d5Label,d6Label;
	
	private JTextField fNameTF, lNameTF, medicareTF, ageTF, genderTF;
	private JTextField dobYearTF, dobDayTF, dobMonthTF, d1TF, d2TF,d3TF,d4TF,d5TF,d6TF;
	
	private JButton createButton, searchButton;
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	//packages GUI dimensions
	private static int width = 460;
	private static int height = 400;
	public PatientView()
	{
		// default
	}
	public PatientView(String title) throws IOException {
		        
		mainFrame = new JFrame(title);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(width, height);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);   
	
		indivUserButton = new JButton("Individual User");
		indivUserButton.addMouseListener(mouseListener);
			
		clinicButton = new JButton("Clinic");
		clinicButton.addMouseListener(mouseListener);
			
		languageButton = new JButton("French");
		languageButton.addMouseListener(mouseListener);
		
		userNameLabel = new JLabel("User Name");
		passwordLabel = new JLabel("Password");
		
		userNameText = new JTextField();
		passwordFiled = new JPasswordField();
		loginButton = new JButton("Login");
		
		viewDBButton = new JButton("View whole DB");
		createPatientButton = new JButton("Create Patient");
		updatePatientButton = new JButton("Update Patient");
		
	    fNameLabel = new JLabel("First Name");
	    lNameLabel = new JLabel("Last Name");
	    medicareLabel = new JLabel("Medicate");
	    ageLabel = new JLabel("Age");
	    genderLabel = new JLabel("Gender");
	    dobLabel = new JLabel("Date of Birth:");
	    dobYearLabel = new JLabel("year");
	    dobDayLabel = new JLabel("day");
	    dobMonthLabel = new JLabel("month");
	    d1Label = new JLabel("Disease 1");
	    d2Label = new JLabel("Disease 2");
	    d3Label = new JLabel("Disease 3");
	    d4Label = new JLabel("Disease 4");
	    d5Label = new JLabel("Disease 5");
	    d6Label = new JLabel("Disease 6");
	
	    fNameTF = new JTextField();
	    lNameTF = new JTextField();
	    medicareTF = new JTextField();
	    ageTF = new JTextField();
	    genderTF = new JTextField();
	    dobYearTF = new JTextField();
	    dobDayTF= new JTextField();
	    dobMonthTF = new JTextField();
	    d1TF = new JTextField();
	    d2TF = new JTextField();
	    d3TF = new JTextField();
	    d4TF = new JTextField();
	    d5TF = new JTextField();
	    d6TF = new JTextField();
		createButton = new JButton("Create");
		searchButton = new JButton("Search");
	
		
		
		inputImageButton = new JButton("Input Image");
		updateDBButton = new JButton("Update DB");



		//mainFrame 
	    mainFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("purple.jpg")))));
	
			
	    // Add UI element to mainFrame
		GroupLayout layout = new GroupLayout(mainFrame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	
				        .addGroup(layout.createSequentialGroup()
				        		
					        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					            		.addComponent(indivUserButton,120,120,120))
					        	.addGap(30)
					            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					            		.addComponent(clinicButton,120,120,120))
					            .addGap(30)
				                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
			            		         .addComponent(languageButton,120,120,120)))));
	
		layout.setVerticalGroup(layout.createSequentialGroup()
				
				    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addGroup(layout.createSequentialGroup()
					        	.addGap(150)
					        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        			.addComponent(indivUserButton)
					        			.addComponent(clinicButton)
					            		.addComponent(languageButton))))
				        
				);
	
	        mainFrame.getContentPane().setLayout(layout);
	}
	
	MouseListener mouseListener = (MouseListener) new MouseAdapter() 
   	{
   	     
   		 JButton button;
   		 Color c;
   		 @Override 
   		 public void mouseEntered(MouseEvent e) {
   	    	  
   	    	  button = (JButton) e.getSource();
   	    	  c = button.getBackground();
   	    	  button.setBackground(Color.YELLOW);
   	      }
   	      
   	      @Override
   	      public void mouseExited(MouseEvent e) {
   	    	  button = (JButton) e.getSource();
   	    	  button.setBackground(c);
   	  	  }
   	      
   	 };
   	 
   	
	public JFrame getFrame() {
		return mainFrame;
    }
	
	public void setFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	    
    public JButton getIndivUserButton() {
        return indivUserButton;
    }
 
        
    public JButton getClinicButton() {
        return clinicButton;
    }
    
    public JButton getLanguageButton() {
        return languageButton;
    }
    
    public JButton getLoginButton() {
        return loginButton;
    }
    
    public JTextField getUserName() {
        return userNameText;
    }
    
    public JPasswordField getpasswordField() {
        return passwordFiled;
    }
	
	public JButton getviewWholeDBButton() {
        return viewDBButton;
    }
	
	public JButton getcreatePatientButton() {
        return createPatientButton;
    }
	
	public JButton getUpdatePatientButton() {
        return updatePatientButton;
    }
	
	public JButton getCreateButton() {
        return createButton;
    }
	
	public JButton getSearchButton() {
        return searchButton;
    }
	
	public JTextField getfNameTF() {
		return fNameTF;
	}

	public void setfNameTF(JTextField fNameTF) {
		this.fNameTF = fNameTF;
	}

	public JTextField getlNameTF() {
		return lNameTF;
	}

	public void setlNameTF(JTextField lNameTF) {
		this.lNameTF = lNameTF;
	}

	public JTextField getMedicareTF() {
		return medicareTF;
	}

	public void setMedicareTF(JTextField medicareTF) {
		this.medicareTF = medicareTF;
	}

	public JTextField getGenderTF() {
		return genderTF;
	}

	public void setGenderTF(JTextField genderTF) {
		this.genderTF = genderTF;
	}

	public JTextField getDobYearTF() {
		return dobYearTF;
	}

	public void setDobYearTF(JTextField dobYearTF) {
		this.dobYearTF = dobYearTF;
	}

	public JTextField getDobDayTF() {
		return dobDayTF;
	}

	public void setDobDayTF(JTextField dobDayTF) {
		this.dobDayTF = dobDayTF;
	}

	public JTextField getDobMonthTF() {
		return dobMonthTF;
	}

	public void setDobMonthTF(JTextField dobMonthTF) {
		this.dobMonthTF = dobMonthTF;
	}

	public JTextField getD1TF() {
		return d1TF;
	}

	public void setD1TF(JTextField d1tf) {
		d1TF = d1tf;
	}

	public JTextField getD2TF() {
		return d2TF;
	}

	public void setD2TF(JTextField d2tf) {
		d2TF = d2tf;
	}

	public JTextField getD3TF() {
		return d3TF;
	}

	public void setD3TF(JTextField d3tf) {
		d3TF = d3tf;
	}

	public JTextField getD4TF() {
		return d4TF;
	}

	public void setD4TF(JTextField d4tf) {
		d4TF = d4tf;
	}

	public JTextField getD5TF() {
		return d5TF;
	}

	public void setD5TF(JTextField d5tf) {
		d5TF = d5tf;
	}

	public JTextField getD6TF() {
		return d6TF;
	}

	public void setD6TF(JTextField d6tf) {
		d6TF = d6tf;
	}
	
	public JButton getInputImageButton()
	{
		return inputImageButton;
	}
	
	public JButton getUpdateDBButton()
	{
		return updateDBButton;
	}

	
	public void printPatient(Patient patient)
	{	
		System.out.println("Patient Information: ");
		System.out.println("First name: " + patient.getFirstName());
		System.out.println("Last Name: " + patient.getLastName());
		System.out.println("Date of Birth: Day:" + patient.getDobDay() + "/Month:" + patient.getDobMonth() +
				"/Year:" + patient.getDobYear());
		System.out.println("Medicare: " + patient.getMedicare());
		System.out.println("Address: " + patient.getAddress());
		System.out.println("E-mail: " + patient.getEmail() + "\n");
	}
	
	public void printAllPatients(ArrayList<Patient> models) 
	{
		for(Patient patient: models) 
		{
			printPatient(patient);
		}
	}
	
	public void printDiagnosis(Diagnosis diagnosis)
	{
		System.out.println("Diagnosis: ");
		System.out.println("Medicare: " + diagnosis.getMedicare());
		System.out.println("Disease 1: " + diagnosis.getDisease1());
		System.out.println("Disease 2: " + diagnosis.getDisease2());
		System.out.println("Disease 3: " + diagnosis.getDisease3());
		System.out.println("Disease 4: " + diagnosis.getDisease4());
		System.out.println("Disease 5: " + diagnosis.getDisease5());
		System.out.println("Disease 6: " + diagnosis.getDisease6());
		System.out.println("Disease 7: " + diagnosis.getDisease7() + "\n");
	}
	
	public void printAllDiagnosis(ArrayList<Diagnosis> models) 
	{
		for(Diagnosis diagnosis: models) 
		{
			printDiagnosis(diagnosis);
		}
	}

	public void displayResultMessage(String message)
    {
    	JOptionPane.showMessageDialog(null, message ,"Info", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public void showLoginFrame() {
    	
		loginFrame = new JFrame("Login");

    	loginFrame.getContentPane().setLayout(new BorderLayout());
    	loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	int width = 300;
    	int height = 200;
    	loginFrame.setSize(width, height);
    	loginFrame.setLocationRelativeTo(null);
    	loginFrame.setVisible(true); 
    	
    	loginButton.addMouseListener(mouseListener);
    		
    	    	  		
        // Add UI element to loginFrame
    	GroupLayout layout = new GroupLayout(loginFrame.getContentPane());
    	layout.setAutoCreateGaps(true);
    	layout.setAutoCreateContainerGaps(true);

    		
    	layout.setHorizontalGroup(layout.createSequentialGroup()
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			       		       		        			        
			        .addGroup(layout.createSequentialGroup()
				        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(userNameLabel,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(userNameText,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()
				        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(passwordLabel,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(passwordFiled,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()

				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(loginButton,120,120,120))))

			);

			layout.setVerticalGroup(layout.createSequentialGroup()
			    
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addGroup(layout.createSequentialGroup()

			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(userNameLabel)
			            		.addComponent(userNameText))
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(passwordLabel)
				                .addComponent(passwordFiled)
				                .addGap(40))

			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(loginButton)))));
			    

        loginFrame.getContentPane().setLayout(layout);
    }
	
	public void showClinicFrame() {
    	
		loginFrame.dispose();
		clinicFrame = new JFrame("ClinicFunctions");
    	clinicFrame.getContentPane().setLayout(new BorderLayout());
    	clinicFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	int width = 460;
    	int height = 160;
    	clinicFrame.setSize(width, height);
    	clinicFrame.setLocationRelativeTo(null);
    	clinicFrame.setVisible(true); 

    	viewDBButton.addMouseListener(mouseListener);
    	createPatientButton.addMouseListener(mouseListener);
    	updatePatientButton.addMouseListener(mouseListener);
    	
    	GroupLayout layout = new GroupLayout(clinicFrame.getContentPane());
    	layout.setAutoCreateGaps(true);
    	layout.setAutoCreateContainerGaps(true);

    		
    	layout.setHorizontalGroup(layout.createSequentialGroup()
 			   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

 			        .addGroup(layout.createSequentialGroup()
 				        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
 				            		.addComponent(viewDBButton,120,120,120))
 				        	.addGap(30)
 				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
 				            		.addComponent(createPatientButton,120,120,120))
 				            .addGap(30)
 			                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
 		            		         .addComponent(updatePatientButton,120,120,120)))));

 	     layout.setVerticalGroup(layout.createSequentialGroup()
 			
 			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
 				        .addGroup(layout.createSequentialGroup()
 				        		.addGap(40)
 				        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
 				        			.addComponent(viewDBButton)
 				        			.addComponent(createPatientButton)
 				            		.addComponent(updatePatientButton)))));
			    

        clinicFrame.getContentPane().setLayout(layout);
    }
	
	
	public void showPatientFrame() {
    	
		clinicFrame.dispose();
		patientFrame = new JFrame("Patient Information");
		patientFrame.getContentPane().setLayout(new BorderLayout());
		patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	int width = 600;
    	int height = 400;
    	patientFrame.setSize(width, height);
    	patientFrame.setLocationRelativeTo(null);
    	patientFrame.setVisible(true); 

    	createButton.addMouseListener(mouseListener);
    	searchButton.addMouseListener(mouseListener);

    	
    	GroupLayout layout = new GroupLayout(patientFrame.getContentPane());
    	layout.setAutoCreateGaps(true);
    	layout.setAutoCreateContainerGaps(true);
    	 		
    	layout.setHorizontalGroup(layout.createSequentialGroup()
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			       		       		        			        
			        .addGroup(layout.createSequentialGroup()
				        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(fNameLabel,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(fNameTF,120,120,120))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(lNameLabel,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(lNameTF,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(medicareLabel,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(medicareTF,120,120,120))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(ageLabel,40,40,40))
				            .addGap(0)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(ageTF,60,60,60))
				            .addGap(40)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(genderLabel,60,60,60))
				            .addGap(0)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(genderTF,60,60,60)))
			        
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(dobLabel,100,100,100))
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(dobYearLabel,30,30,30))
			        		.addGap(0)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(dobYearTF,40,40,40))
				            .addGap(20)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(dobDayLabel,30,30,30))
				            .addGap(0)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(dobDayTF,40,40,40))
				            .addGap(20)
			                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            		        .addComponent(dobMonthLabel,40,40,40))
			                .addGap(0)
			                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            		                 .addComponent(dobMonthTF,40,40,40)))
			        
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(d1Label,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(d1TF,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(d2Label,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(d2TF,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(d3Label,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(d3TF,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(d4Label,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(d4TF,120,120,120)))
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(d5Label,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(d5TF,120,120,120)))
			        .addGroup(layout.createSequentialGroup()
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(d6Label,80,80,80))
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(d6TF,120,120,120)))
			        
			        .addGroup(layout.createSequentialGroup()

				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(createButton,120,120,120))
				            .addGap(20)
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(searchButton,120,120,120))))

			);

			layout.setVerticalGroup(layout.createSequentialGroup()
			    
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addGroup(layout.createSequentialGroup()

			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(fNameLabel)
			            		.addComponent(fNameTF)
			            		.addComponent(lNameLabel)
			            		.addComponent(lNameTF))
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(medicareLabel)
				                .addComponent(medicareTF)
				                .addComponent(ageLabel)
				                .addComponent(ageTF)
				                .addComponent(genderLabel)
				                .addComponent(genderTF))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				                .addComponent(dobLabel)
				                .addComponent(dobYearLabel)
				                .addComponent(dobYearTF)
				                .addComponent(dobDayLabel)
				                .addComponent(dobDayTF)
				                .addComponent(dobMonthLabel)
				                .addComponent(dobMonthTF)
				                .addGap(40))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(d1Label)
				                .addComponent(d1TF))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(d2Label)
				                .addComponent(d2TF))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(d3Label)
				                .addComponent(d3TF))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(d4Label)
				                .addComponent(d4TF))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(d5Label)
				                .addComponent(d5TF))
			            
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(d6Label)
				                .addComponent(d6TF)
				                .addGap(40))
			            

			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(createButton)
			            		.addComponent(searchButton)))));
			    

			patientFrame.getContentPane().setLayout(layout);
    }


	public void updateDBFrame() {
		
		patientFrame.dispose();
		updateFrame = new JFrame("Input image and update DB");
		updateFrame.getContentPane().setLayout(new BorderLayout());
		updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = 300;
		int height = 160;
		updateFrame.setSize(width, height);
		updateFrame.setLocationRelativeTo(null);
		updateFrame.setVisible(true); 
	
		viewDBButton.addMouseListener(mouseListener);
		createPatientButton.addMouseListener(mouseListener);
		updatePatientButton.addMouseListener(mouseListener);
		
		GroupLayout layout = new GroupLayout(updateFrame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
	
			
		layout.setHorizontalGroup(layout.createSequentialGroup()
				   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	
				        .addGroup(layout.createSequentialGroup()
					        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					            		.addComponent(inputImageButton,120,120,120))
					        	.addGap(20)
					            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					            		.addComponent(updateDBButton,120,120,120)))));
	
		     layout.setVerticalGroup(layout.createSequentialGroup()
				
				    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addGroup(layout.createSequentialGroup()
					        		.addGap(40)
					        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        			.addComponent(inputImageButton)
					        			.addComponent(updateDBButton)))));
			    
	
		     updateFrame.getContentPane().setLayout(layout);
	}
}
