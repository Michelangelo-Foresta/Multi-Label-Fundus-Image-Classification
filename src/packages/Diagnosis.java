package packages;

import org.bson.types.ObjectId;

public class Diagnosis {
	
	private ObjectId id;
	private String medicare;
	private double disease1;
	private double disease2;
	private double disease3;
	private double disease4;
	private double disease5;
	private double disease6;
	private double disease7;
	
	public Diagnosis()
	{
		// default
	}
	
	public Diagnosis(String medicare, 
			double disease1, double disease2, 
			double disease3, double disease4,
			double disease5, double disease6,
			double disease7) 
	{
		super();
		this.medicare = medicare;
		this.disease1 = disease1;
		this.disease2 = disease2;
		this.disease3 = disease3;
		this.disease4 = disease4;
		this.disease5 = disease5;
		this.disease6 = disease6;
		this.disease7 = disease7;
	}


	public String getMedicare() {
		return medicare;
	}
	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}
	public double getDisease1() {
		return disease1;
	}
	public void setDisease1(double disease1) {
		this.disease1 = disease1;
	}
	public double getDisease2() {
		return disease2;
	}
	public void setDisease2(double disease2) {
		this.disease2 = disease2;
	}
	public double getDisease3() {
		return disease3;
	}
	public void setDisease3(double disease3) {
		this.disease3 = disease3;
	}
	public double getDisease4() {
		return disease4;
	}
	public void setDisease4(double disease4) {
		this.disease4 = disease4;
	}
	public double getDisease5() {
		return disease5;
	}
	public void setDisease5(double disease5) {
		this.disease5 = disease5;
	}
	public double getDisease6() {
		return disease6;
	}
	public void setDisease6(double disease6) {
		this.disease6 = disease6;
	}
	public double getDisease7() {
		return disease7;
	}
	public void setDisease7(double disease7) {
		this.disease7 = disease7;
	}
	@Override
	public String toString() {
		return "Diagnosis [medicare=" + medicare + ", disease1=" + disease1 + ", disease2=" + disease2 + ", disease3="
				+ disease3 + ", disease4=" + disease4 + ", disease5=" + disease5 + ", disease6=" + disease6 + "]";
	}
}