package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.swing.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType) {
     if (browserType.equalsIgnoreCase("chrome"))
     driver= initChromeDriver();
      else  if (browserType.equalsIgnoreCase("firefox"))
         driver=initFirefoxDriver();
    else  if (browserType.equalsIgnoreCase("ie"))
     driver= initIEDriver();
    else
        throw new RuntimeException("Invalid browse name");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    wait= new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
    driver.get(getData("url"));
    MangePages.initGrafana();
      action= new Actions(driver) ;



    }
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=  new ChromeDriver();
        return driver;

    }
    public static WebDriver initFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=  new FirefoxDriver();
        return driver;

    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver=  new InternetExplorerDriver();
        return driver;

    }



    @BeforeClass
    public void startSession()
    {

        if (getData("platfrom").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
    //  else    if (getData("platfrom").equalsIgnoreCase("mobile"))
      //   initMobile();
        else
            throw new RuntimeException("Invalid platfrom name");
        softAssert = new SoftAssert();
        screen= new Screen();
    }

    @AfterClass
    public void closeSession()
    {
        //driver.quit();
    }
    @AfterMethod
    public void aftermethod()
    {
        driver.get(getData("url"));
    }
    @BeforeMethod
    public void beforeMethod(Method method)
    {
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
