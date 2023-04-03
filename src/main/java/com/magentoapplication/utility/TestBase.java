package com.magentoapplication.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    WebDriver driver;

    final static String configName="config.properties";
    String frondEndUrl=ApplicationConfig.readFromConfigProperties(configName,"MagentoFrontEndURL");

    String backEndUrl=ApplicationConfig.readFromConfigProperties(configName,"MagentoBackEndURL");

    public void setupBrowserFrondEnd(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(frondEndUrl);
    }

    public void setupBrowserBackEnd(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(backEndUrl);
    }

}
