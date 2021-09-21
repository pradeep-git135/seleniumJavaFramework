package tyss.vtiger.genericUtility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandom() {
		Random r = new Random();
		return r.nextInt(1000);
	}

}
