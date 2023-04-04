package com.magentoapplication.utility;

import com.github.javafaker.Faker;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionClass {

    WebDriver driver;

    int timeout=Integer.parseInt(ApplicationConfig.readFromConfigProperties("config.properties","timeout"));

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

    public void waitUntilElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String generateFakeName(){
        String faker= Faker.instance().name().firstName();
        return faker;
    }

    public String generateFakeLastName(){
        String faker= Faker.instance().name().lastName();
        return faker;
    }

    public String generateFakeEmail(){
        String faker=Faker.instance().internet().emailAddress();
        return faker;
    }



}
