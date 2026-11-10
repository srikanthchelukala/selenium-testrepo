package com.hrm.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Waits {
    private Logger logger = LogManager.getLogger(Waits.class);
    public void setImpicitWait(WebDriver driver,int time){
        try{
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(time));
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Error setting implicit wait,"+ e.getMessage());
        }
    }

    public void waitForElementToBePresent(WebDriver driver,By locator,int time){
        try{
        WebDriverWait wait =new WebDriverWait(driver,java.time.Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Waiting for element to be present: " + locator.toString());
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Error waiting for element to be present,"+ e.getMessage());
        }
    }

    public void waitForElementToBeClickable(WebDriver driver,By locator,int time){
        try{
        WebDriverWait wait =new WebDriverWait(driver,java.time.Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        logger.info("Waiting for element to be clickable: " + locator.toString());
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Error waiting for element to be clickable,"+ e.getMessage());
        }
    }
    
}
