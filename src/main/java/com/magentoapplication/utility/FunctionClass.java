package com.magentoapplication.utility;

import com.github.javafaker.Faker;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionClass {

    WebDriver driver;

    int timeout = Integer.parseInt(ApplicationConfig.readFromConfigProperties("config.properties", "timeout"));

    public FunctionClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String currentDate() {
        DateTime time = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH");
        String timeStamp = time.toString(formatter);
        return timeStamp;
    }

    public void waitUntilElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String generateFakeName() {
        String faker = Faker.instance().name().firstName();
        return faker;
    }

    public String generateFakeLastName() {
        String faker = Faker.instance().name().lastName();
        return faker;
    }

    public String generateFakeEmail() {
        String faker = Faker.instance().internet().emailAddress();
        return faker;
    }


    public String generateCityName() {
        String cityName = Faker.instance().address().city();
        return cityName;
    }

    public String generateStreetName() {
        String streetName = Faker.instance().address().streetName();
        return streetName;
    }


    public String generateZipCode() {
        String zipCode = Faker.instance().address().zipCode();
        return zipCode;
    }

    public String generateCountryName() {
        String countryName = Faker.instance().address().country();
        return countryName;
    }

    public String generateTelephoneNumber() {
        String telephoneNumber = Faker.instance().phoneNumber().cellPhone();
        return telephoneNumber;
    }


    public String generateMiddleName() {
        Faker faker = new Faker();
        String middleName = Faker.instance().name().username();
        return middleName;
    }

    public String generateFakePassword(){
        Faker faker=new Faker();
        String  password=Faker.instance().internet().password();
        return password;

    }

    public String generateProductName(){
        Faker faker=new Faker();
        String productName=Faker.instance().name().name();
        return productName;
    }

    public String generateProductDescription(){
        Faker faker=new Faker();
        String productDescription=Faker.instance().book().author();
        return productDescription;
    }

    public String generateProductShortDescription(){
        Faker faker=new Faker();
        String productShortDescription=Faker.instance().book().publisher();
        return productShortDescription;
    }

    public String generateProductSku(){
        Faker faker=new Faker();
        String productSku=Faker.instance().code().asin();
        return productSku;
    }
    public String generateProductWeight(){
        Faker faker=new Faker();
        int productWeight=Faker.instance().number().numberBetween(150,500);
        return String.valueOf(productWeight);
    }

    public String generateProductPrice() {
        Faker faker = new Faker();
        int productPrice = Faker.instance().number().randomDigitNotZero();
        return String.valueOf(productPrice);
    }

    public String generateWebsiteName(){
        Faker faker=new Faker();
        String websiteName=Faker.instance().name().name();
        return websiteName;
    }
    public String generateWebsiteCode() {
        Faker faker = new Faker();
        String websiteCode = faker.bothify("??-###-??");
        return websiteCode;
    }

    public String generateSortOrder() {
        Faker faker = new Faker();
        int sortOrder = Faker.instance().number().randomDigitNotZero();
        return String.valueOf(sortOrder);
    }

    public void waitForAlertPresent(){
        WebDriverWait wai=new WebDriverWait(driver,timeout);
        wai.until(ExpectedConditions.alertIsPresent());
    }

    //alertAccept
    public void alertAccept(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public String generateFakeRedirectURL() {
        return "https://www.fakeurl.com/path?param=value";


    }
}
