package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.Grafana.ServerAdminMenuPage;

public class MangePages extends  Base {
    public static void  initGrafana()
    { grafanaLogin= PageFactory.initElements(driver,pageObjects.Grafana.LoginPage.class);
      grafanaMain= PageFactory.initElements(driver,pageObjects.Grafana.MainPage.class);
      grafanaLeftMenu=PageFactory.initElements(driver,pageObjects.Grafana.LeftMenuPage.class);
      grafanaServerAdminPage=PageFactory.initElements(driver, ServerAdminMenuPage.class);
      grafanaServerAdminMainPage=PageFactory.initElements(driver,pageObjects.Grafana.ServerAdminMainPage.class);
      grafanaAddNewUserPage=PageFactory.initElements(driver,pageObjects.Grafana.AddNewUserPage.class);
      grafanaEditUserPage=PageFactory.initElements(driver,pageObjects.Grafana.EditUserPage.class);
    }
}
