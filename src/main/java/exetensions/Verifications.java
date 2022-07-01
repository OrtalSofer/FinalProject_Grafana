package exetensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {
    @Step("Verify Text INElement")
    public static void verifyTextINElement(WebElement elem,String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expected) ;

    }
    @Step( "verify numer Of Elements")
    public static void numerOfElements (List<WebElement>elems, int expected)
    { wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expected) ;

    }
@Step ("verify Visibility Of Elem  ")
    public static void visibilityOfElem(List<WebElement>elems)
    {
        for (WebElement elem:elems) {
          softAssert.assertTrue(elem.isDisplayed(),"Sory"+elem.getText()+"is not Displayed");
        }
       softAssert.assertAll("some elements where not displayed ");
    }

    @Step("verify image file")
    public  static void visualElement(String ExpectedImageName)
    {
        try {
            screen.find(getData("ImageRepo")+ExpectedImageName+".png");
        } catch (FindFailed FindFailed) {
            System.out.println("error comparing image file"+FindFailed);
            fail("error comparing image file"+FindFailed);
        }
    }
    @Step("verify element displayed")
    public static void existenceOfElement(List<WebElement> elements)
    { assertTrue(elements.size()>0);
    }
    @Step("verify element is not displayed")
    public static void nonexistenceOfElement(List<WebElement> elements)
    { assertFalse(elements.size()>0);
    }
}
