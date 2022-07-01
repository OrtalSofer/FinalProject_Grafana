package sanitiy;

import com.google.common.util.concurrent.Uninterruptibles;
import exetensions.UIActions;
import exetensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;
@Listeners(utilities.Listeners.class)
public class GrafaneWeb extends CommonOps {
    @Test(description ="Test01-verify Header" )
    @Description ("This test login and verifies the main Header ")
    public void test01_verifyHeader() {
        WebFlows.login("admin", "admin");
        Verifications.verifyTextINElement(grafanaMain.Head, "Welcome to Grafana");
    }

    @Test(description ="Test02-verify defult users" )
    @Description ("This test login and verifies the defult users ")
    public void test02_verifyDefultUsers() {
        UIActions.MouseHover(grafanaLeftMenu.btn_server, grafanaServerAdminPage.Link_Users);
        Verifications.numerOfElements(grafanaServerAdminMainPage.rows, 1);
    }

    @Test(description = "Test03-verify new user" )
    @Description ("This test login and verifies the new user")
    public void test03_verifyNewUser() {
        WebFlows.CreateNewUser("ortal", "ortal@gmail.com", "ortals", "12345");

        Verifications.numerOfElements(grafanaServerAdminMainPage.rows, 2);
    }

    @Test(description = "Test04-verify user deletion" )
    @Description ("This test login and verifies the user deletion")
 public void test04_verifyUserDeletion() {
     UIActions.MouseHover(grafanaLeftMenu.btn_server,   grafanaServerAdminPage.Link_Users);
   WebFlows.DeleteLastUser();
   Verifications.numerOfElements(grafanaServerAdminMainPage.rows, 1);
  }
    @Test(description = "Test05-verify progress steps" )
    @Description ("This test login and verifies the default progress steps are displayed (using soft assertion)")
    public void test05_verifyProgressSteps() {
        Verifications.visibilityOfElem(grafanaMain.listProgressTest);

    }
   @Test(description = "Test06-verify Avatar Icon" )
   @Description ("This test  verifies the Avatar image using sikuli tools ")
   public void test06_verifyAvatarIcon() {
        Verifications.visualElement("grafanaavatar");

    }

 @Test(description = "Test07-search users" )
  @Description ("This test  search users in a table using DDT")
    public void test07_verifyAvatarIcon() {
        UIActions.MouseHover(grafanaLeftMenu.btn_server,   grafanaServerAdminPage.Link_Users);
        WebFlows.SearchAndVerifyUser("Ortal","not-exists");

   }
}
