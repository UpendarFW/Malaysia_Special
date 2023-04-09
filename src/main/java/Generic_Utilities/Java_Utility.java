package Generic_Utilities;

import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Replace;

public class Java_Utility {

	public int getRandomNumber() {
		Random r=new Random();
		int rand=r.nextInt(10000);
		return rand;
	}
	
	public String getSystemDate() {
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	
	public String getSystemdateInFormat() {
		Date d=new Date();
		String[] dArray=d.toString().split(" ");
		String Day=dArray[0];
		String Date=dArray[2];
		String Month=dArray[1];
		String Year=dArray[5];
		String time=dArray[3].replace(":","-");
		
		String DateFormat=Day+"-"+Date+"-"+Month+"-"+"-"+Year+"-"+time;
		return DateFormat;
	}

	

}
