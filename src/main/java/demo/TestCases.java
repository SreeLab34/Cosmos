package demo;

import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCases {

    ChromeDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

   public void testCase01() throws InterruptedException{

        System.out.println("Start Test case: testCase01");
        
        // Open Google Form URL
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(3000);

        // Locate and interact with form elements
        WebElement title = driver.findElement(By.xpath("//span[text()='QA Assignment - Automate Google Forms']"));
        title.click(); // Click on the form title
        System.out.println("Opened Form");

        // Enter text into the 'Name' input field
        WebElement name = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys("Crio Learner");
        System.out.println("Entered text");

        // Validate entered text
        Thread.sleep(3000);
        String enteredText = driver.findElement(By.xpath("//input[@jsname='YPqjbf']")).getAttribute("data-initial-value");
        if (enteredText.equals("Crio Learner")) {
            System.out.println("Name Entered.");
        } else {
            System.out.println("Error in name.");
        }

        // Validate label 'Why are you practicing Automation?'
        WebElement ptext = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='Why are you practicing Automation?']"));
        ptext.click();
        if (ptext.getText().contains("Why are you practicing Automation?")) {
            System.out.println("Practicing Automation label passed");
        } else {
            System.out.println("Practicing Automation label failed");
        }

        // Enter text in 'How much experience do you have in Automation Testing?' textarea
        Thread.sleep(3000);
        WebElement pauto = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        pauto.sendKeys("I want to be the best QA Engineer");
        String enteredText1 = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']")).getAttribute("data-initial-value");
        if (enteredText1.contains("I want to be the best QA Engineer")) {
            System.out.println("Practicing Automation Text passed");
        } else {
            System.out.println("Practicing Automation Text failed");
        }

        // Validate label 'How much experience do you have in Automation Testing?'
        Thread.sleep(3000);
        WebElement atext = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='How much experience do you have in Automation Testing?']"));
        atext.click();
        if (atext.getText().contains("How much experience do you have in Automation Testing?")) {
            System.out.println("Automation Testing label passed");
        } else {
            System.out.println("Automation Testing label failed");
        }

        // Choose an option in 'How much experience do you have in Automation Testing?'
        WebElement aauto = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
        aauto.click();

        // Validate label 'Which of the following have you learned in Crio.Do for Automation Testing?'
        Thread.sleep(3000);
        WebElement ckkauto = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='Which of the following have you learned in Crio.Do for Automation Testing?']"));
        ckkauto.click();
        if (ckkauto.getText().contains("Which of the following have you learned in Crio.Do for Automation Testing?")) {
            System.out.println("Automation learning label passed");
        } else {
            System.out.println("Automation learning label failed");
        }

        // Select options in 'Which of the following have you learned in Crio.Do for Automation Testing?'
        WebElement java = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        java.click();
        WebElement se = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        se.click();
        WebElement ng = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
        ng.click();

        // Validate label 'How should you be addressed?'
        Thread.sleep(3000);
        WebElement add = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='How should you be addressed?']"));
        add.click();
        if (add.getText().contains("How should you be addressed?")) {
            System.out.println("Addressed label passed");
        } else {
            System.out.println("Addressed label failed");
        }

        // Choose an option in 'How should you be addressed?'
        WebElement dd = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"));
        dd.click();
        WebElement ms = driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'][text()='Ms'])[2]"));
        ms.click();

        // Validate label 'What was the date 7 days ago?'
        Thread.sleep(3000);
        WebElement dat = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='What was the date 7 days ago?']"));
        dat.click();
        if (dat.getText().contains("What was the date 7 days ago?")) {
            System.out.println("Dates label passed");
        } else {
            System.out.println("Dates label failed");
        }
        
        // Enter date in 'What was the date 7 days ago?' input field
        LocalDate currentDate = LocalDate.now();
        LocalDate dateMinus7Days = currentDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = dateMinus7Days.format(formatter);
        WebElement dateInput = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[2]"));
        dateInput.sendKeys(formattedDate);
        String enteredValue = dateInput.getAttribute("value");
        System.out.println("Entered date value: " + enteredValue);

        // Validate label 'What is the time right now?'
        Thread.sleep(3000);
        WebElement time = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='What is the time right now?']"));
        time.click();
        if (time.getText().contains("What is the time right now?")) {
            System.out.println("Time label passed");
        } else {
            System.out.println("Time label failed");
        }

        // Enter hour and minute in 'What is the time right now?' input fields
        WebElement hourInput = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        hourInput.sendKeys("7");
        WebElement minuteInput = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        minuteInput.sendKeys("30");

        // Optionally, validate entered time values
        String enteredHour = hourInput.getAttribute("value");
        String enteredMinute = minuteInput.getAttribute("value");
        System.out.println("Entered time: " + enteredHour + ":" + enteredMinute);

        // Click on the Submit button
        WebElement submit = driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac' and text()='Submit']"));
        submit.click();
        Thread.sleep(5000);

        // Print the text from result elements
        WebElement t1 = driver.findElement(By.xpath("//div[@class='pdLVYe LgNcQe']"));
        WebElement t2 = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println("Result 1: " + t1.getText());
        System.out.println("Result 2: " + t2.getText());

        // Note: Uncomment if you want to print the text of the link as well
        // WebElement t3 = driver.findElement(By.xpath("//a[@href='https://docs.google.com/forms/u/0/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?usp=form_confirm']/text()"));
        // System.out.println("Link Text: " + t3.getText());

        System.out.println("End Test case: testCase01");
    }
}