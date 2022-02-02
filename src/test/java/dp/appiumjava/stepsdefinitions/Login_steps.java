package dp.appiumjava.stepsdefinitions;

import cucumber.api.java.en.*;
import dp.appiumjava.screens.ActivityFeed_Screen;
import dp.appiumjava.screens.Login_Screen;
import dp.appiumjava.screens.SchoolSelection_Screen;


public class Login_steps {

	Login_Screen login;
	SchoolSelection_Screen schoolScreen;
	ActivityFeed_Screen afScreen;

    public Login_steps() {

		login = new Login_Screen();
    }

	@Given("^I Am on the Login Page$")
	public void fillIn_LoginDtls() throws Throwable {
		this.login.click_Login();
		this.login.click_Continue_Email();
		this.login.setCreds_And_SignIn();
	}

	@When("^Click on Submit button$")
	public void submit() throws Throwable {
		this.login.click_Submit();
	}

	@Then("^School Selection Container should be displayed$")
	public void schoolSelection() throws Throwable {
		schoolScreen=new SchoolSelection_Screen();
		System.out.println("**************");
		System.out.println(schoolScreen.getListofSchools().size());
		schoolScreen.selectSchool();
		Thread.sleep(10000);
	}
	@Then("^On Selection School the Activity feed should be displayed$")
	public void waitForAF() throws Throwable {
		afScreen=new ActivityFeed_Screen();
		afScreen.waitForActivityFeed();
	}

}
