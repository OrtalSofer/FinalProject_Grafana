package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminMainPage {

    @FindBy(how = How.XPATH,using ="//table/tbody/tr")
    public List<WebElement> rows;
    @FindBy(how = How.XPATH,using ="//table/tbody/tr/td/a/img[@class='filter-table__avatar']")
    public List<WebElement> rows_to_click;
    @FindBy(how = How.XPATH,using ="//*[@class='css-1mhnkuh']")
    public WebElement btn_user;
    @FindBy(how = How.XPATH,using ="//input[@placeholder='Search user by login, email, or name.']")
    public WebElement txt_search;



}
