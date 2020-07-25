package io.pragra.learning.b25.framework.utils;

import io.pragra.learning.b25.framework.config.Config;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Utils class will have helped methods to
 * ease our works.
 *
 * @nav, @meh, @bmk please add logger
 */
public class Utils {

    private static String generateTimeStamp(){
        SimpleDateFormat format = new SimpleDateFormat(Config.getInstance().getProperty("timestamp"));
        return format.format(new Date());
    }
    //create Screenshots dir
    private static void createDirs(String dirName) {
        Path path = Paths.get(dirName);
        if(Files.exists(path)) {
            System.out.println("Dir already exists");
            return;
        }
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String captureScreenShot(WebDriver driver, String testCaseName, boolean pass) throws IOException {
        String fileName = testCaseName+"_" + generateTimeStamp() +".png";
        createDirs(Config.getInstance().getProperty("screenshot.pass.dir"));
        createDirs(Config.getInstance().getProperty("screenshot.fail.dir"));
        if(pass) {
            Path fullName  = Paths.get(Config.getInstance().getProperty("screenshot.pass.dir"),fileName);
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenShot.toPath(), fullName);
            return fileName;
        }else {
            Path fullName  = Paths.get(Config.getInstance().getProperty("screenshot.fail.dir"),fileName);
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenShot.toPath(), fullName);
            return fileName;
        }

    }
}
