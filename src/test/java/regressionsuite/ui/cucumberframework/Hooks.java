package regressionsuite.ui.cucumberframework;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Hooks {
    private Logger logger;
    private FileWriter logFile;

    @Before
    public void setup(Scenario scenario) {
        // Setup log configurations
        // e.g., initializing log objects, setting up log formats, etc.
        DOMConfigurator.configure("log4j.xml"); // configure Log4j using an XML file
        logger = Logger.getLogger(Hooks.class); // initialize logger
        logger.info("Starting Scenario: " + scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        // Capture test results
        // e.g., logging test results, capturing screenshots, etc.

        // Get log information from logger
        String logInfo = logger.getName(); // retrieve logs from logger

        // Write log information to log file
        try {
            logFile = new FileWriter("test_logs.log", true); // append to existing log file
            logFile.write("Scenario: " + scenario.getName() + "\n");
            logFile.write("Status: " + (scenario.isFailed() ? "Failed" : "Passed") + "\n");
            logFile.write("Log information: " + scenario.getName() + " " + (scenario.isFailed() ? "Failed" : "Passed") +"\n"); // write dynamic log information
            logFile.write("\n");
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Clear logs in logger for next scenario
        logger.removeAllAppenders();

        logger.info("Ending Scenario: " + scenario.getName());
    }
//    private FileWriter logFile;
//private static final Logger logger = Logger.getLogger(Hooks.class);
//    private FileAppender fileAppender;
//
//    @Before
//    public void setup(Scenario scenario) {
//        // Setup log configurations
//        // e.g., initializing log objects, setting up log formats, etc.
//        logger.info("Starting Scenario: " + scenario.getName());
//    }
//
//    @After
//    public void teardown(Scenario scenario) {
//        // Capture test results
//        // e.g., logging test results, capturing screenshots, etc.
//
//        // Get log information from test execution context
//        String logInfo = "Scenario: " + scenario.getName() + "\n"
//                + "Status: " + (scenario.isFailed() ? "\033[31mFailed\033[0m" : "\033[32mPassed\033[0m") + "\n";
//
//        // Write log information to log file
//        try {
//            if (fileAppender == null) {
//                fileAppender = (FileAppender) logger.getAppender("fileAppender");
//                if (fileAppender != null) {
//                    // Set layout for file appender
//                    fileAppender.setLayout(new PatternLayout("[%d{yyyy-MM-dd HH:mm:ss}] %p %C{1}: %m%n"));
//                    // Activate options for file appender
//                    fileAppender.activateOptions();
//                } else {
//                    logger.error("Failed to retrieve file appender");
//                }
//            }
//            if (fileAppender != null) {
//                fileAppender.setAppend(true);
//                FileOutputStream fos = new FileOutputStream(fileAppender.getFile());
//                OutputStreamWriter osw = new OutputStreamWriter(fos, fileAppender.getEncoding());
//                osw.write(logInfo);
//                osw.flush();
//                osw.close();
//                fileAppender.setAppend(false);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        logger.info("Ending Scenario: " + scenario.getName());
//    }

}

