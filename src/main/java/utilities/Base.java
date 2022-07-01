package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.Grafana.AddNewUserPage;
import pageObjects.Grafana.EditUserPage;
import pageObjects.Grafana.ServerAdminMainPage;
import pageObjects.Grafana.ServerAdminMenuPage;

public class Base {
    protected static WebDriver driver;
    protected  static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected  static Screen screen;

    //pages objects
    protected static pageObjects.Grafana.LoginPage grafanaLogin;
    protected static pageObjects.Grafana.MainPage grafanaMain;
    protected static pageObjects.Grafana.LeftMenuPage grafanaLeftMenu;
    protected static ServerAdminMenuPage grafanaServerAdminPage;
    protected static ServerAdminMainPage grafanaServerAdminMainPage;
    protected static AddNewUserPage grafanaAddNewUserPage;
    protected static EditUserPage grafanaEditUserPage ;
}
