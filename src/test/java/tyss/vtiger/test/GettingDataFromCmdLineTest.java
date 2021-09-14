package tyss.vtiger.test;

import org.testng.annotations.Test;

public class GettingDataFromCmdLineTest {
	@Test
	public void method1() {
		String username = System.getProperty("username");
		String password = System.getProperty("password");

		System.out.println(username);
		System.out.println(username);

	}

}
