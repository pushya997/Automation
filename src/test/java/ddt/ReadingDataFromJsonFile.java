package ddt;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingDataFromJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser=new JSONParser();
		FileReader reader=new FileReader("./src\\test\\resources\\commondata.json ");
		Object javaobj = jsonparser.parse(reader);
		JSONObject obj=(JSONObject)javaobj;
		String BROWSER = obj.get("browser").toString();
		System.out.println(BROWSER);
	}

}
