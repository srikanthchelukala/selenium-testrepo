package com.hrm;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import com.hrm.base.BaseTest;
import com.hrm.dataproviders.TestDataProviders;
import com.hrm.pages.LoginPage;
import com.hrm.utility.ExcelUtility;
import com.hrm.utility.PropertiesUtility;
import com.hrm.utility.SeleniumUtils;



//mvn test -Dtest=LoginTest
public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProviders.class)
    public  void loginWithValidCredentials(String username, String password) throws InvalidFormatException,IOException  {
        LoginPage loginPage = new LoginPage(driver);
        // loginPage.loginToApplication(ExcelUtility.getTestData1(1, 0), ExcelUtility.getTestData(1, 1));
        // loginPage.loginToApplication(PropertiesUtility.getData("username"), PropertiesUtility.getData("password"));
        loginPage.loginToApplication(username, password);
        WebElement clientBrandBanner = driver.findElement(By.xpath("//img[@alt='client brand banner']"));
        clientBrandBanner.isDisplayed();
        clientBrandBanner.getCssValue("display");clientBrandBanner.getAttribute("alt");
        clientBrandBanner.getTagName();clientBrandBanner.getLocation();clientBrandBanner.getSize();clientBrandBanner.getRect();clientBrandBanner.getAriaRole();
        String color=clientBrandBanner.getCssValue("color");
        String fontSize=clientBrandBanner.getCssValue("font-size");
        String textDecoration=clientBrandBanner.getCssValue("text-decoration");
        clientBrandBanner.getCssValue("background-color");clientBrandBanner.getCssValue("border");clientBrandBanner.getCssValue("margin");clientBrandBanner.getCssValue("padding");clientBrandBanner.getCssValue("width");clientBrandBanner.getCssValue("height");clientBrandBanner.getCssValue("max-width");clientBrandBanner.getCssValue("min-width");
        clientBrandBanner.getCssValue("max-height");clientBrandBanner.getCssValue("min-height");clientBrandBanner.getCssValue("opacity");clientBrandBanner.getCssValue("visibility");clientBrandBanner.getCssValue("z-index");clientBrandBanner.getCssValue("cursor");clientBrandBanner.getCssValue("overflow");
        clientBrandBanner.getCssValue("text-align");clientBrandBanner.getCssValue("line-height");clientBrandBanner.getCssValue("letter-spacing");clientBrandBanner.getCssValue("word-spacing");clientBrandBanner.getCssValue("text-transform");clientBrandBanner.getCssValue("white-space");clientBrandBanner.getCssValue("vertical-align");clientBrandBanner.getCssValue("text-overflow");clientBrandBanner.getCssValue("clip");clientBrandBanner.getCssValue("float");
        clientBrandBanner.getCssValue("clear");clientBrandBanner.getCssValue("position");clientBrandBanner.getCssValue("top");clientBrandBanner.getCssValue("right");clientBrandBanner.getCssValue("bottom");clientBrandBanner.getCssValue("left");clientBrandBanner.getCssValue("display");
        clientBrandBanner.getCssValue("visibility");clientBrandBanner.getCssValue("overflow");clientBrandBanner.getCssValue("clip");clientBrandBanner.getCssValue("content");
        System.out.println("-> Color (RGBA): " + color);
        System.out.println("-> Font Size: " + fontSize);
        System.out.println("-> Text Decoration: " + textDecoration);
        System.out.println("-------------------------------------");
    }

    @Test(dataProvider="usrData", dataProviderClass = TestDataProviders.class)
    public void sauceDemoLogin(Map<String, String> userData){
        // driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.saucedemo.com/");
         driver.navigate().refresh();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sauceDemoLogin(userData.get("username"), userData.get("password"));
    }


    @Test()
    public void dynamicDropDownTest(){
        driver.navigate().to("https://vinothqaacademy.com/drop-down/");
        //Way1
        // SeleniumUtils.waitForElementVisibility(driver, By.xpath("//span[@role='textbox' and @title='Choose A City']"), 1000);
           // driver.findElement(By.xpath("//span[@role='textbox' and @title='Choose A City']")).click();
        //Way2
        WebElement cityDropdown = SeleniumUtils.waitForElementClickable(driver, By.xpath("//span[@role='textbox' and @title='Choose A City']"), 5000);
        cityDropdown.click();
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("a");
        List<WebElement> options=driver.findElements(By.xpath("//li[@role='option']"));
        System.out.println("Options found: " + options.size());
        for(int i=0;i<options.size();i++){
            System.out.println("Option " + i + ": " + options.get(i).getText());
        }
        for(WebElement option : options){
            if(option.getText().equals("Los Angeles")){
                option.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;
            }
        }
    }

    @Test()
    public void gettingRequiredText(){
        String usernameValue = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']/descendant::p[1]")).getText();
        String[] actvalue=usernameValue.split(":");
        String actualValue = actvalue[1].trim();
        System.out.println("Actual value: " + actualValue);

         String pwdValue = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']/descendant::p[2]")).getText();
        String[] pwdActValue = pwdValue.split(":");
        String pwdActualValue = pwdActValue[1].trim();
        System.out.println("Password actual value: " + pwdActualValue);
    }

    @Test()
    public void relativeLocators(){
        driver.get("https://shelendrakumaracademy.com/web/relative-locators");
        driver.findElement(RelativeLocator.with(By.xpath("//input[@id='above-target']")).above(driver.findElement(By.id("login-button")))).sendKeys("testuser");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(RelativeLocator.with(By.xpath("//input[@id='left-target']")).toLeftOf(driver.findElement(By.xpath("//button[@id='submit-button']")))).sendKeys("csri");
    }

    @Test()
    public void webTable(){
        driver.get("https://shelendrakumaracademy.com/web/web-table");
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='table-container']/table[@id='employee-table']/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cells.size(); j++) {
                System.out.print(cells.get(j).getText() + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void anotherWebTest(){
        driver.get("https://shelendrakumaracademy.com/web/web-table");
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='table-container']/table[@id='employee-table']/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        for(WebElement row:rows){
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            String name = cells.get(1).getText();
            // int id=Integer.parseInt(cells.get(0).getText());
             String id=cells.get(0).getText();
            if (name.contains("Sara Lee")) {
            // if (id.contains("581")) {
                String city = cells.get(3).getText();
                System.out.println("City: " + city);
                break;
                }
        }
    }

    @Test 
    public void amzonTest(){
        driver.navigate().to("https://www.amazon.in/");
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File destination=new File("./screenshots/" + "Screenshot_"+System.currentTimeMillis() + ".png");//+ System.currentTimeMillis() + ".png"
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void navigateTest(){
        // driver.navigate().to("https://www.amazon.in/");
        driver.navigate().back();
        Object aftBck=driver.getCurrentUrl();
        System.out.println("Url before launch: " + aftBck);
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    
}
