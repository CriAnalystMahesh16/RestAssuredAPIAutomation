package com.theRohitKingKohali.ddt;

import com.theRohitKingKohali.utils.UtilsExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class vmoLoginAPITC {
    @Test(dataProvider="getData",dataProviderClass = UtilsExcel.class)
    public void testVMOLogin(String email, String password){
        System.out.println("--Login API Testing");
        System.out.println(email);
        System.out.println(password);
    }
}
