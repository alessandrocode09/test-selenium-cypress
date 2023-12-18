package support;


import org.junit.Assert;

public class TestBase {

	/**
	 * Method to be reusable on the steps page, to provide a proper prompt message to the user
	 * @param condition receive the condition is true of false
	 * @param passMessage receive the Successful message when the tests pass
	 * @param failMessage receive the Fail message when the tests fails
	 */
	public void isTrue(boolean condition, String passMessage, String failMessage){
		try {
			Assert.assertTrue(passMessage,condition);
			if (condition == true) System.out.println(passMessage);
			else System.out.println(failMessage);
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
}
