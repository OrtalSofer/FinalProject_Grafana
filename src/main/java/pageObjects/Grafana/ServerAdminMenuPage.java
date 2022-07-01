package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ServerAdminMenuPage {
    @FindBy(how = How.XPATH,using ="//li[@data-key='global-users']/a/div/div/div/*[name()='svg']")
    public WebElement Link_Users;
    @FindBy(how = How.XPATH,using ="//ul/li/div/a[@href='/admin/users']")
    public WebElement users_Page;
    @FindBy(how = How.XPATH,using ="//a[@href='admin/users/create']")
    public WebElement btn_NewUser;

}
