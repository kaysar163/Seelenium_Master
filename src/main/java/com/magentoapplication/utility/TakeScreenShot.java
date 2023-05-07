package com.magentoapplication.utility;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    public void takeScreenShot(String fileName, WebDriver driver){
        DateTime time=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyyMMddHHmm");
        String timeStamp=time.toString(formatter);
        fileName=fileName+"_"+timeStamp;
        File imageFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String folder="screenShot";
        try {
            FileUtils.copyFile(imageFile,new File(folder+File.separator+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
