package hardcoding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {

	public static void main(String[] args) {
	Date d = new Date();
	System.out.println(d);
	SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
	String formatedDate = sim.format(d);
	System.out.println(formatedDate);
	Calendar calender = sim.getCalendar();
	calender.add(Calendar.DAY_OF_MONTH, 30);
	String requited = sim.format(calender.getTime());
	System.out.println(requited);

	}

}
