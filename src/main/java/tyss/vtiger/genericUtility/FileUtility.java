package tyss.vtiger.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getPropertyvalue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return  p.getProperty(key);
	}
}
