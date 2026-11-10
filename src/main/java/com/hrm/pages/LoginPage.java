package com.hrm.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// import com.hrm.base.BaseTest;
public class LoginPage  {

    @FindBy(name="username")
    WebElement userNamTextBox;

    @FindBy(name="password")
    WebElement passwordTextBox;

    @FindBy(css="button[type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    Logger log=LogManager.getLogger(LoginPage.class);
    public void loginToApplication(String userName, String password){
        userNamTextBox.sendKeys(userName);
        log.info("Username is entered in username text box");
        passwordTextBox.sendKeys(password);
        log.info("Password is entered in Password text box");
        loginButton.click();
        log.info("Login button is clicked");
    }

    @FindBy(id="user-name")
    WebElement sauceuserNameTextBox;

    @FindBy(id="password")
    WebElement saucepasswordTextBox;

    @FindBy (id="login-button")
    WebElement sauceloginButton;

    public void sauceDemoLogin(String userName, String password){
        sauceuserNameTextBox.sendKeys(userName);
        log.info("Username is entered in username text box", userName);
        saucepasswordTextBox.sendKeys(password);
        log.info("Password is entered in Password text box", password);
        sauceloginButton.click();
        log.info("Login button is clicked");
    }


    
}
