package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUserPage {
    @FindBy(how = How.CSS ,using ="button[class='css-14lhqbx-button']")
    public WebElement btn_deleteUser;
    @FindBy(how = How.CSS,using ="button[aria-label='Confirm Modal Danger Button']")
    public WebElement btn_confrimDeleteUser;
}
