package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProvide;
import io.restassured.response.Response;

public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProvide.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String userEmail,
			String password, String ph) {

		User userpayload = new User();

		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(userEmail);
		userpayload.setPassword(password);
		userpayload.setPhone(ph);

		Response response = UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProvide.class)
	public void testDeleteByUsername(String userName) {

		Response response = UserEndPoints.deleteUser(userName);

		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
