package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {
   @FindBy(how = How.NAME,using ="user" )
   public WebElement txt_username;


    @FindBy(how = How.NAME,using ="password" )
    public WebElement txt_password;

    @FindBy(how = How.CSS,using ="button[class='css-1s5ybvs-button']" )
    public WebElement txt_btn_login;

    @FindBy(how = How.CSS,using ="button[class='css-15h6w-button']" )
    public WebElement txt_btn_skip;



}
