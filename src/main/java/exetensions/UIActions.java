package exetensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {
    @Step("click on element")
    public static void click(WebElement elem)
    {    wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("update text")
    public static void UpdateText(WebElement elem, String text)
    { wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("update text Human")
    public static void UpdateTextHuman(WebElement elem, String text)
    { wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch:text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch+"");
        }

    }
    @Step ("update Drop Down element")
    public static void UpdateDropDown(WebElement elem, String text)
    { wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropdown=new Select(elem);
        dropdown.selectByVisibleText(text);

    }
    @Step("Mouse Hover element")
    public static void MouseHover(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).perform();
        action.moveToElement(elem2).click().perform();
    }

}
