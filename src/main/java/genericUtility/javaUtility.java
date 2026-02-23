package genericUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	public int getRandom() {
		Random random=new Random();
		int randomcount= random.nextInt(1000);
		return randomcount;
		
	}
	
	public String getCurrentdate() {
		Date date= new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		String currentdate = sim.format(date);
		return currentdate;
		
	}
	
	public String togetExpectedDate(int day) {
		Date date= new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, 30);
		String expecteddate = sim.format(cal.getTime());
		return expecteddate;
		
		
	}

}
