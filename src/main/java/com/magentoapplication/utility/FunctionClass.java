package com.magentoapplication.utility;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FunctionClass {

    WebDriver driver;

    public FunctionClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String currentDate(){
        DateTime time=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH");
        String timeStamp=time.toString(formatter);
        return timeStamp;
    }

}
