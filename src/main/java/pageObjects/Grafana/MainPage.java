package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH,using ="//div[@class='css-1m290ug']/h1" )
    public WebElement Head;

    @FindBy(how = How.XPATH,using ="//div[@class='css-piff9g']" )
    public List<WebElement> listProgressTest;
}
