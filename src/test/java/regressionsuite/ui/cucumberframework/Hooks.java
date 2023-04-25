package regressionsuite.ui.cucumberframework;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;


import java.io.FileWriter;
import java.io.IOException;


public class Hooks {
    private Logger logger;
    private FileWriter logFile;

    @Before
    public void setup(Scenario scenario) {
        DOMConfigurator.configure("log4j.xml"); // configure Log4j using an XML file
        logger = Logger.getLogger(Hooks.class); // initialize logger
        logger.info("Starting Scenario: " + scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        // Get log information from logger
        String logInfo = logger.getName(); // retrieve logs from logger

        // Write log information to log file
        try {
            logFile = new FileWriter("test_logs.log", true); // append to existing log file
            logFile.write("Scenario: " + scenario.getName() + "\n");
            String writerName = getScenarioWriterName(scenario); // retrieve scenario writer name
            logFile.write("Scenario Writer: " + writerName + "\n"); // write scenario writer name
            logFile.write("Status: " + (scenario.isFailed() ? "Failed" : "Passed") + "\n");
            logFile.write("Log information: " + scenario.getName() + " " + (scenario.isFailed() ? "Failed" : "Passed") + "\n"); // write dynamic log information
            logFile.write("\n");
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Clear logs in logger for next scenario
        logger.removeAllAppenders();

        logger.info("Ending Scenario: " + scenario.getName());
    }

    private String getScenarioWriterName(Scenario scenario) {
        String writerName = "Unknown"; // default value for scenario writer name
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@writer:")) { // assuming scenario writer is tagged with @writer:<writer_name>
                writerName = tag.substring(8); // extract writer name from the tag
                break;
            }
        }
        return writerName;
    }
}

