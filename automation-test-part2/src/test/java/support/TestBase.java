package support;

import org.testng.Assert;

public class TestBase {

	public void isTrue(boolean condition, String passMessage, String failMessage){
		try {
			Assert.assertTrue(condition,failMessage);
			System.out.println(passMessage);
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
}
