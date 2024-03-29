package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
public class PatientController {
	static int i=0;
	static JTable jtable;
	private PatientView view;
	static Patient patient;
	static String path;
	static Map<String,Float> disease;
	private ArrayList<Patient> pModels;
	private ArrayList<Diagnosis> dModels;
	private ArrayList<Login> lModels;
	private File file;
	private int targetWidth=128;
	private int targetHeight=128;
	
	public PatientController(PatientView view) throws IOException {
		this.view = view;
		this.pModels = new ArrayList<Patient>();
		this.dModels = new ArrayList<Diagnosis>();
		this.lModels = new ArrayList<Login>();
	}

	/**
	 * Run once at startup. Retrieves all entries from the database.
	 */
	public void retrieveAllData()
	{
		DatabaseConnection.colDiagnosis.find().into(this.dModels);
		DatabaseConnection.colPatient.find().into(this.pModels);
		DatabaseConnection.colLogin.find().into(this.lModels);
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
	
	public void updateEntry(String firstName, String lastName, 
			int year, int month, int day, 
			String medicare, String address, String email
			)
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
		
		DatabaseConnection.updatePatient(medicare, firstName, lastName, day, month, year, address, email);
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
	// ----------------------------- GETTERS & SETTER -----------------------------------------

	public Boolean verifyLogin(String userName, String password)
	{
		return Login.correctLogin(userName, password, lModels);
	}
	

	public void initController() throws ClassNotFoundException {
		// #############################  WORK ON THIS ACTION LISTENERS   ################################################
        //handle language selection (EN/FR)
        view.getLanguageButton().addActionListener(e -> {
			if(view.getLanguageButton().getText().equals("French")){
				view.changeLanguage(new Locale("fr","FR"));
			}
			else{
				view.changeLanguage(new Locale("en","US"));
			}

		});

		//#######################################    EVERYTHING BELOW IS COMPLETED    ###############################################


		// COMPLETED
		view.getIndivUserButton().addActionListener(e -> {
			view.getMedicareTF().setEditable(true);
			view.individualUser();
			Clear(view.getIndivFrame());
		});

		// COMPLETED
		view.getviewWholeDBButton().addActionListener(e -> {
			i=0;
			view.getBundle().getString("Medicare");
			String[] columnNames={view.getBundle().getString("Medicare"),view.getBundle().getString("First Name"),view.getBundle().getString("Last Name"),view.getBundle().getString("DOB"),view.getBundle().getString("Address"),view.getBundle().getString("Email"),"G","C","H","M","D","N"};
			String[][] rowData=new String[pModels.size()][13];
			for (Patient y: pModels) {
				for (Diagnosis x : dModels){
				if (y.getMedicare().equals(x.getMedicare())){
						rowData[i][0] = y.getMedicare();
						rowData[i][1] = y.getFirstName();
						rowData[i][2] = y.getLastName();
						rowData[i][3] = y.getDobDay() + "/" + y.getDobMonth() + "/" + y.getDobYear();
						rowData[i][4] = y.getAddress();
						rowData[i][5] = y.getEmail();
						rowData[i][6] = String.valueOf(x.getDisease1());
						rowData[i][7] = String.valueOf(x.getDisease2());
						rowData[i][8] = String.valueOf(x.getDisease3());
						rowData[i][9] = String.valueOf(x.getDisease4());
						rowData[i][10] = String.valueOf(x.getDisease5());
						rowData[i][11] = String.valueOf(x.getDisease6());
						rowData[i][12] = String.valueOf(x.getDisease7());
						i++;
					}
				}
			}
			jtable=new JTable(rowData,columnNames);
			view.showDb(jtable);
			rowData=null;
		});

		// COMPLETED
		view.getClinicButton().addActionListener(e -> {
			view.showLoginFrame();
		});

		// COMPLETED
		view.getLoginButton().addActionListener(e -> {
			if(verifyLogin(view.getUserNameText(),view.getPasswordFiled()))
				view.showClinicFrame();
			else {
				if (view.getLocale() == new Locale("en", "US"))
					JOptionPane.showMessageDialog(null, "Incorrect password or username", "Info", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Mot de passe ou nom d'utilisateur incorrect", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});

        // COMPLETED
        view.getcreatePatientButton().addActionListener(e -> {
			view.showPatientFrame();
			Clear(view.getPatientFrame());
			view.getMedicareTF().setEditable(true);

 		});
        
        // COMPLETED
        view.getUpdatePatientButton().addActionListener(e -> {
			view.getMedicareTF().setEditable(true);
			view.getMedicareTF().setText(null);
			view.searchPatient();
 		});

		// COMPLETED
		view.getExport().addActionListener(e->{
			view.getExport().setEnabled(false);
			try {
				PDFMethods.createPDF(patient, disease, path);
				view.getExport().setEnabled(false);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		// COMPLETED
        view.getCreatePatient().addActionListener(e->{
			view.getCreatePatient().setEnabled(false);
			patient = new Patient(view.getfNameTF().getText(), view.getlNameTF().getText(),
					Integer.parseInt(view.getDobYearTF().getText()), Integer.parseInt(view.getDobMonthTF().getText()), Integer.parseInt(view.getDobDayTF().getText()),
			view.getMedicareTF().getText(), view.getAddressTF().getText(), view.getEmailAddressTF().getText());
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION)
			{
				this.file=fileChooser.getSelectedFile();
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
					newImg= ResizeImage.resizeImage(newImg, targetWidth, targetHeight);
					window.setSize(con.getIconWidth(),con.getIconHeight());
					window.getContentPane().add(label);
					disease = TrainedModel.getDiagnosis(newImg);
					DatabaseConnection.insertPatient(patient);
					view.getExport().setEnabled(true);

				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}

			}
		});

        // COMPLETED
        view.getCreateButton().addActionListener(e -> {
			view.getCreateButton().setEnabled(true);
			patient = new Patient(view.getfNameTF().getText(), view.getlNameTF().getText(),
					Integer.parseInt(view.getDobYearTF().getText()), Integer.parseInt(view.getDobMonthTF().getText()), Integer.parseInt(view.getDobDayTF().getText()),
					view.getMedicareTF().getText(), view.getAddressTF().getText(), view.getEmailAddressTF().getText());
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION)
			{
				this.file=fileChooser.getSelectedFile();
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
					newImg= ResizeImage.resizeImage(newImg, targetWidth, targetHeight);
					window.setSize(con.getIconWidth(),con.getIconHeight());
					window.getContentPane().add(label);
					disease = TrainedModel.getDiagnosis(newImg);
					Diagnosis diagnosis = new Diagnosis(patient.getMedicare(),disease.get("Macular-Degen"),disease.get("Glauc"),disease.get("Cats"),disease.get("Hyper"),disease.get("Myopia"),disease.get("Non-Prolif"),disease.get("Normal"));
					if(searchPatient(patient.getMedicare())== null)
						insertEntry(patient,diagnosis);
					view.getCreateButton().setEnabled(false);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}

 		});
        
       // COMPLETED
        view.getSearchButton().addActionListener(e -> {
         	Patient p1=searchPatient(view.getMedicareTF().getText());
			Diagnosis d1=searchDiagnosis(view.getMedicareTF().getText());

         	if(searchPatient(view.getMedicareTF().getText())!=null)
         	{
				view.updateDBFrame();
				view.getfNameTF().setText(p1.getFirstName());
				view.getlNameTF().setText(p1.getLastName());
				view.getDobYearTF().setText(String.valueOf(p1.getDobYear()));
				view.getDobDayTF().setText(String.valueOf(p1.getDobDay()));
				view.getDobMonthTF().setText(String.valueOf(p1.getDobMonth()));
				view.getAddressTF().setText(p1.getAddress());
				view.getEmailAddressTF().setText(p1.getEmail());
				view.getMedicareTF().setEditable(false);
         	}
         	else
         	{
				 if(view.getLocale()==new Locale("en","US"))
					view.displayResultMessage("user not found");
				 else
					 view.displayResultMessage("utilisateur non trouvé");
         	}

 		});

        // COMPLETED
        view.getUpdateDBButton().addActionListener(e -> {
			// UPDATING DB VALUES
        	if(disease==null)
        		updateEntry(view.getfNameTF().getText(),view.getlNameTF().getText(),Integer.parseInt(view.getDobYearTF().getText()),Integer.parseInt(view.getDobMonthTF().getText()),Integer.parseInt(view.getDobDayTF().getText()),view.getMedicareTF().getText(),
        				view.getAddressTF().getText(),view.getEmailAddressTF().getText());
        	else
        		updateEntry(view.getfNameTF().getText(),view.getlNameTF().getText(),Integer.parseInt(view.getDobYearTF().getText()),Integer.parseInt(view.getDobMonthTF().getText()),Integer.parseInt(view.getDobDayTF().getText()),view.getMedicareTF().getText(),
        				view.getAddressTF().getText(),view.getEmailAddressTF().getText(),disease.get("Macular-Degen"),disease.get("Glauc"),disease.get("Cats"),disease.get("Hyper"),disease.get("Myopia"),disease.get("Non-Prolif"),disease.get("Normal"));
			view.pressDBButton();

		});

    }


	public static void Clear(JFrame intFrame)
	{
		if (intFrame == null)
			return;
		Container con = intFrame.getContentPane();
		for (Component c : con.getComponents())
		{
			if (c instanceof JTextField)
			{
				JTextField j = (JTextField)c;
				j.setText("");
			}
		}
	}


}
