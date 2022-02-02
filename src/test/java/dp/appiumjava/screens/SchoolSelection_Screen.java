package dp.appiumjava.screens;

import dp.appiumjava.screens.base.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SchoolSelection_Screen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select the school you wish to view\")")
    private MobileElement lnk_SchoolSelection;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"schoolOption\")")
    private List<MobileElement> list_SchoolName;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"La Petite Academy of Victorville\")")
    private MobileElement lnk_SchoolName;


    public void click_Login() {
        this.lnk_SchoolSelection.click();
    }

    public List<MobileElement>  getListofSchools(){
        waitForVisibilityOfElement(this.lnk_SchoolSelection);
        return this.list_SchoolName;
    }

    public void  selectSchool(){
        this.lnk_SchoolName.click();
    }
}
