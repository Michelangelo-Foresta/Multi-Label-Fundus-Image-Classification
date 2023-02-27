package packages;

import com.sun.security.auth.module.JndiLoginModule;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PatientView {
	private JFrame mainFrame, loginFrame, clinicFrame, patientFrame, showDb,DbFrame;
	static JFrame showPatient,indivUserFram;
	private JButton indivUserButton, clinicButton, languageButton, loginButton,viewDBButton, createPatientButton, updateDBButton,updatePatientButton,CreatePatient,export;

	private JLabel userNameLabel ,passwordLabel ;
	private JTextField userNameText ;
	private JPasswordField  passwordFiled;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Patient Frame
	private JLabel fNameLabel, lNameLabel, medicareLabel,emailAddress,address;
	private JLabel dobLabel, dobYearLabel, dobDayLabel, dobMonthLabel;
	
	private JTextField fNameTF, lNameTF, medicareTF, emailAddressTF,addressTF;
	private JTextField dobYearTF, dobDayTF, dobMonthTF;
	
	private JButton createButton, searchButton;
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//packages GUI dimensions
	private static int width = 460;
	private static int height = 400;

	public PatientView(String title) throws IOException {

//		bundle=ResourceBundle.getBundle("packages.MessageBundle",new Locale("en","US"));
		mainFrame = new JFrame(title);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(width, height);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);   
	
		indivUserButton = new JButton("Individual");
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
		CreatePatient = new JButton("Input Image");
		export = new JButton("Export PDF");
		createPatientButton = new JButton("Create Patient");
		updatePatientButton = new JButton("Update Patient");
		
	    fNameLabel = new JLabel("First Name");
	    lNameLabel = new JLabel("Last Name");
	    medicareLabel = new JLabel("Medicare");
	    dobLabel = new JLabel("Date of Birth:");
	    dobYearLabel = new JLabel("year");
	    dobDayLabel = new JLabel("day");
	    dobMonthLabel = new JLabel("month");
		address = new JLabel("Address");
		emailAddress = new JLabel("Email");

	
	    fNameTF = new JTextField();
	    lNameTF = new JTextField();
	    medicareTF = new JTextField();
	    dobYearTF = new JTextField();
	    dobDayTF= new JTextField();
	    dobMonthTF = new JTextField();
		addressTF= new JTextField();
		emailAddressTF= new JTextField();
		createButton = new JButton("Input Image");
		searchButton = new JButton("Search");
		updateDBButton=new JButton("Update DB");

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

	public JFrame getIndivFrame(){return indivUserFram;}
	public void setFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	    
    public JButton getIndivUserButton() {
        return indivUserButton;
    }
    public JButton getClinicButton() {return clinicButton;}
    public JButton getLanguageButton() {
        return languageButton;
    }
    public JButton getLoginButton() {
        return loginButton;
    }
	public JButton getviewWholeDBButton() {
		return viewDBButton;
	}
	public JButton getcreatePatientButton() {
		return createPatientButton;
	}
	public JButton getCreatePatient() {
		return CreatePatient;
	}
	public JButton getExport() {
		return export;
	}
	public JButton getCreateButton() {
		return createButton;
	}
	public JButton getUpdatePatientButton() {
		return updatePatientButton;
	}
	public JButton getSearchButton() {
		return searchButton;
	}
	public JButton getUpdateDBButton(){return updateDBButton;}
	public String getUserNameText() {return userNameText.getText();}
	public String getPasswordFiled() {return passwordFiled.getText();}
	public void pressDBButton() {viewDBButton.doClick();}
	

	public JTextField getfNameTF() {
		return fNameTF;
	}
	public JTextField getlNameTF() {
		return lNameTF;
	}
	public JTextField getDobMonthTF() {
		return dobMonthTF;
	}
	public JTextField getMedicareTF() {
		return medicareTF;
	}
	public JTextField getAddressTF() {
		return addressTF;
	}
	public JTextField getEmailAddressTF() {
		return emailAddressTF;
	}
	public JTextField getDobYearTF() {
		return dobYearTF;
	}

	public JTextField getDobDayTF() {
		return dobDayTF;
	}

	public void setMedicareTF(JTextField medicareTF) {
		this.medicareTF = medicareTF;
	}
	public void setfNameTF(JTextField fNameTF) {
		this.fNameTF = fNameTF;
	}
	public void setlNameTF(JTextField lNameTF) {
		this.lNameTF = lNameTF;
	}
	public void setDobYearTF(JTextField dobYearTF) {
		this.dobYearTF = dobYearTF;
	}

	public void setDobDayTF(JTextField dobDayTF) {
		this.dobDayTF = dobDayTF;
	}


	public void setDobMonthTF(JTextField dobMonthTF) {
		this.dobMonthTF = dobMonthTF;
	}

	

	

	

	

	


	public void displayResultMessage(String message)
    {
    	JOptionPane.showMessageDialog(null, message ,"Info", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public void showLoginFrame() {
    	
		loginFrame = new JFrame("Login");
    	loginFrame.getContentPane().setLayout(new BorderLayout());
    	loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public void individualUser()  {

		indivUserFram = new JFrame("Patient Information");
		indivUserFram.getContentPane().setLayout(new BorderLayout());
		indivUserFram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = 600;
		int height = 400;
		indivUserFram.setSize(width, height);
		indivUserFram.setLocationRelativeTo(null);
		indivUserFram.setVisible(true);

    	export.addMouseListener(mouseListener);
		export.setEnabled(false);

	GroupLayout layout = new GroupLayout(indivUserFram.getContentPane());
    	layout.setAutoCreateGaps(true);
    	layout.setAutoCreateContainerGaps(true);

    	layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(medicareLabel,80,80,80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(medicareTF,120,120,120)))

			        .addGroup(layout.createSequentialGroup()
				        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(fNameLabel,80,80,80))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(fNameTF,120,120,120))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        			.addComponent(lNameLabel,80,80,80))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(lNameTF,120,120,120)))
							// ADDD EMAIL AND ADDRESS



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
            		                 .addComponent(dobMonthTF,40,40,40))
									.addGap(40))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(address,80,80,80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(addressTF,120,120,120))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(emailAddress,80,80,80))
								.addGap(0)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(emailAddressTF,120,120,120))
								.addGap(40))

			        .addGroup(layout.createSequentialGroup()
				            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            		.addComponent(CreatePatient,120,120,120)
									.addGap(20))
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addComponent(export,120,120,120))))

			);

			layout.setVerticalGroup(layout.createSequentialGroup()

					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addGroup(layout.createSequentialGroup()

							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(medicareLabel)
									.addComponent(medicareTF))
			            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(fNameLabel)
			            		.addComponent(fNameTF)
			            		.addComponent(lNameLabel)
			            		.addComponent(lNameTF))


			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				                .addComponent(dobLabel)
				                .addComponent(dobYearLabel)
				                .addComponent(dobYearTF)
				                .addComponent(dobDayLabel)
				                .addComponent(dobDayTF)
				                .addComponent(dobMonthLabel)
				                .addComponent(dobMonthTF))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(address)
									.addComponent(addressTF)
									.addComponent(emailAddress)
									.addComponent(emailAddressTF)
									.addGap(40))

			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(CreatePatient)
								.addComponent(export)))));


		indivUserFram.getContentPane().setLayout(layout);

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
	public static JFrame getPatientFrame(){
		return showPatient;
	}
	public void showPatientFrame() {
		showPatient = new JFrame("Create Patient");
		showPatient.getContentPane().setLayout(new BorderLayout());
		showPatient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = 600;
		int height = 400;
		showPatient.setSize(width, height);
		showPatient.setLocationRelativeTo(null);
		showPatient.setVisible(true);

		createButton.addMouseListener(mouseListener);
		searchButton.addMouseListener(mouseListener);
		export.setEnabled(false);

		GroupLayout layout = new GroupLayout(showPatient.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)


						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(medicareLabel,80,80,80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(medicareTF,120,120,120)))

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
										.addComponent(dobMonthTF,40,40,40))
								.addGap(40))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(address,80,80,80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(addressTF,120,120,120))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(emailAddress,40,40,40))
								.addGap(0)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(emailAddressTF,60,60,60))
								.addGap(40))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(createButton,120,120,120)
										.addGap(20))))

		);

		layout.setVerticalGroup(layout.createSequentialGroup()

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addGroup(layout.createSequentialGroup()


								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(medicareLabel)
										.addComponent(medicareTF))

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(fNameLabel)
										.addComponent(fNameTF)
										.addComponent(lNameLabel)
										.addComponent(lNameTF))


								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(dobLabel)
										.addComponent(dobYearLabel)
										.addComponent(dobYearTF)
										.addComponent(dobDayLabel)
										.addComponent(dobDayTF)
										.addComponent(dobMonthLabel)
										.addComponent(dobMonthTF))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(address)
										.addComponent(addressTF)
										.addComponent(emailAddress)
										.addComponent(emailAddressTF)
										.addGap(40))

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(createButton)))));


		showPatient.getContentPane().setLayout(layout);

	}
public void searchPatient(){
	patientFrame = new JFrame("Search Patient");
	patientFrame.getContentPane().setLayout(new BorderLayout());
	patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	patientFrame.setSize(width, height);
	patientFrame.setLocationRelativeTo(null);
	patientFrame.setVisible(true);

	searchButton.addMouseListener(mouseListener);

	GroupLayout layout = new GroupLayout(patientFrame.getContentPane());
	layout.setAutoCreateGaps(true);
	layout.setAutoCreateContainerGaps(true);

	layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					// ADDD EMAIL AND ADDRESS
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(medicareLabel,80,80,80))
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(medicareTF,120,120,120)))

					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(searchButton,120,120,120)
									.addGap(20))))

	);

	layout.setVerticalGroup(layout.createSequentialGroup()

			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(medicareLabel)
									.addComponent(medicareTF))

							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(searchButton)))));


	patientFrame.getContentPane().setLayout(layout);

}

	public void updateDBFrame() {
		patientFrame.dispose();
		DbFrame = new JFrame("Update Patient Information");
		DbFrame.getContentPane().setLayout(new BorderLayout());
		DbFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DbFrame.setSize(width, height);
		DbFrame.setLocationRelativeTo(null);
		DbFrame.setVisible(true);

		updateDBButton.addMouseListener(mouseListener);

		GroupLayout layout = new GroupLayout(DbFrame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(medicareLabel, 80, 80, 80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(medicareTF, 120, 120, 120)))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(fNameLabel, 80, 80, 80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(fNameTF, 120, 120, 120))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lNameLabel, 80, 80, 80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lNameTF, 120, 120, 120)))
						// ADDD EMAIL AND ADDRESS


						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobLabel, 100, 100, 100))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobYearLabel, 30, 30, 30))
								.addGap(0)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobYearTF, 40, 40, 40))
								.addGap(20)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobDayLabel, 30, 30, 30))
								.addGap(0)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobDayTF, 40, 40, 40))
								.addGap(20)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobMonthLabel, 40, 40, 40))
								.addGap(0)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(dobMonthTF, 40, 40, 40))
								.addGap(40))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(address, 80, 80, 80))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(addressTF, 120, 120, 120))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(emailAddress, 40, 40, 40))
								.addGap(0)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(emailAddressTF, 120, 120, 120))
								.addGap(40))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(CreatePatient,120,120,120)
										.addGap(20))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(updateDBButton,120,120,120))))

		);

		layout.setVerticalGroup(layout.createSequentialGroup()

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addGroup(layout.createSequentialGroup()

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(medicareLabel)
										.addComponent(medicareTF))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(fNameLabel)
										.addComponent(fNameTF)
										.addComponent(lNameLabel)
										.addComponent(lNameTF))

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(dobLabel)
										.addComponent(dobYearLabel)
										.addComponent(dobYearTF)
										.addComponent(dobDayLabel)
										.addComponent(dobDayTF)
										.addComponent(dobMonthLabel)
										.addComponent(dobMonthTF))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(address)
										.addComponent(addressTF)
										.addComponent(emailAddress)
										.addComponent(emailAddressTF)
										.addGap(40))

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(CreatePatient)
										.addComponent(updateDBButton)))));


		DbFrame.getContentPane().setLayout(layout);

	}
	public void showDb(JTable jtable) {

		showDb = new JFrame("Database");
		showDb.getContentPane().setLayout(new BorderLayout());
		showDb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		showDb.setSize(width, height);
		showDb.setLocationRelativeTo(null);
		showDb.setVisible(true);

		JTable table = jtable;

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		showDb.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
		showDb.getContentPane().add(table, BorderLayout.CENTER);
	}



}
