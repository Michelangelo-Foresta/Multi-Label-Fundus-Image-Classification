package main;
import java.time.LocalDate;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LocalDate d1 = LocalDate.of(1988, 6, 13);
//		System.out.println(d1);
		
		Patient p1 = new Patient("NGXT1111222", "Thomas", "Ng", 34, 'M', 
				1988, 6, 13, 1, 2, 3, 4, 5, 6);
		System.out.println(p1.getDateOfBirth());
		System.out.println(p1);
	}

}
