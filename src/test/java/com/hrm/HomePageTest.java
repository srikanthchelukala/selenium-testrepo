package com.hrm;

import org.testng.annotations.Test;
import com.hrm.pages.HomePage;
import com.hrm.pages.LoginPage;
import com.hrm.base.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void logout(){
       HomePage homePage = new HomePage(driver);
        homePage.logoutFromApplication();
    }
    
}
