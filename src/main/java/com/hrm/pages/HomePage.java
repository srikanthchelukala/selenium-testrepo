package com.hrm.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// import com.hrm.base.BaseTest;
public class HomePage {
    @FindBy(xpath="//span[text()='Admin']")
    WebElement adminlink;

    @FindBy(xpath="//img[@alt=\"profile picture\"]")
    WebElement profilePicture;

    @FindBy(linkText="Logout")
    WebElement logoutLink;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log=LogManager.getLogger(HomePage.class);
    public void clickOnAdminLink(){
        adminlink.click();
        log.info("Admin link is clicked");
    }
    // public void clickOnProfilePicture(){
    //     profilePicture.click();
    // }
    public void logoutFromApplication(){
        profilePicture.click();
        log.info("Profile picture button is clicked");
        logoutLink.click();
        log.info("Logout link is clicked");
    }
  
}
