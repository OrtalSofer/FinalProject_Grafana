package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import exetensions.UIActions;
import exetensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps {
   @Step ("Business Flow: Login")
    public static void login(String user, String pass)
    {
        UIActions.UpdateText(grafanaLogin.txt_username,user);
        UIActions.UpdateText(grafanaLogin.txt_password,pass);
        UIActions.click(grafanaLogin.txt_btn_login);

        UIActions.click(grafanaLogin.txt_btn_skip);
    }
    @Step("Business Flow: Create New User")
    public static void CreateNewUser(String name, String email,String username,String pass)
    {    UIActions.click(grafanaServerAdminPage.users_Page);
        UIActions.click(grafanaServerAdminPage.btn_NewUser);
      UIActions.UpdateText(grafanaAddNewUserPage.txt_name,name);
        UIActions.UpdateText(grafanaAddNewUserPage.txt_email,email);
        UIActions.UpdateText(grafanaAddNewUserPage.txt_username,username);
        UIActions.UpdateText(grafanaAddNewUserPage.txt_password,pass);
        UIActions.click(grafanaAddNewUserPage.btn_create);
    }
    @Step("Business Flow:Delete Last User ")
    public static void DeleteLastUser()
    { UIActions.click(grafanaServerAdminMainPage.rows_to_click.get(grafanaServerAdminMainPage.rows.size()-1));
      UIActions.click(grafanaEditUserPage.btn_deleteUser);
        UIActions.click(grafanaEditUserPage.btn_confrimDeleteUser);

    }

    @Step("Business Flow:Search and verify User ")
    public static void SearchAndVerifyUser(String user, String shouldExists)
    { UIActions.UpdateTextHuman(grafanaServerAdminMainPage.txt_search,user);
        if (shouldExists.equalsIgnoreCase("exists"))
            Verifications.existenceOfElement(grafanaServerAdminMainPage.rows);
        else if (shouldExists.equalsIgnoreCase("not-exists"))
            Verifications.nonexistenceOfElement(grafanaServerAdminMainPage.rows);
        else
        throw new RuntimeException("Invalid expected output option in data driven testing, should be exists or not-exists") ;


    }

}
