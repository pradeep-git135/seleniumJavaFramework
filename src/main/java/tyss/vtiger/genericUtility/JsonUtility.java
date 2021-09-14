package tyss.vtiger.genericUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public static void main(String[] args) throws Throwable {
		getJsonData("fname");
		
	}

	public static Object getJsonData(String key) throws FileNotFoundException, IOException, ParseException {
		FileReader fis = new FileReader("F:\\seleniumJava\\practiceSelenium\\dataFile\\jsonfile.json");
		JSONParser jParse=new JSONParser();
		 HashMap job = (HashMap) jParse.parse(fis);//("fname"="pradeep",)
		return job.get(key);
	}
}
									