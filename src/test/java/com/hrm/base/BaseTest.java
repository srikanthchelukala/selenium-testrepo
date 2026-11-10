package com.hrm.base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void initDriver(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait =   new WebDriverWait(driver, Duration.ofSeconds(30));
         // 1. Wait for the page to load completely
        wait.until(webDriver ->((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
         // 2. Fetch it one more time to print the confirmed state
        String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
        System.out.println("Page load status: " + readyState); // Will print "complete"
    }
    @AfterSuite 
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
    
}
