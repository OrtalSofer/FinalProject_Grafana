package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {
    @FindBy(how = How.ID,using =" react-aria9038735958-13" )
    public WebElement btn_Alerting;

    @FindBy(how = How.ID,using =" react-aria9038735958-16" )
    public WebElement btn_Configuration;

    @FindBy(how = How.XPATH,using ="//ul/li/div/a[@href='/admin/users']" )
    public WebElement btn_server;


}
