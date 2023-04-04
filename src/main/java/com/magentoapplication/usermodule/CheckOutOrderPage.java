package com.magentoapplication.usermodule;


import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOrderPage {
   WebDriver driver;
   FunctionClass functionClass;
   FrontEndDashboardPage frontEndDashboardPage;
   public CheckOutOrderPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
       
   }
}
