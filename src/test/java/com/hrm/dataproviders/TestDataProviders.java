package com.hrm.dataproviders;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.hrm.utility.ExcelUtility;

public class TestDataProviders {
    

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {
    return ExcelUtility.getAllTestData("src/test/resources/testdata/usersdata.xlsx", "Sheet1");
    }

    @DataProvider(name="usrData")
    public Object[][] usrDt(){
        return new Object[][]{{Map.of("username", "standard_user", "password", "secret_sauce")},{Map.of("username", "problem_user", "password", "secret_sauce")}};    
    }
}
