package demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
  //  Wrappers w=new Wrappers(driver);


    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }
  @Test
    public void testCase01() {
        Wrappers w=new Wrappers(driver);
        System.out.println("Start Test case: Testcase01");
        w.openURL("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        System.out.println("Opened Google form");
        WebElement title = driver.findElement(By.xpath("//span[text()='QA Assignment - Automate Google Forms']"));
        title.click(); // Click on the form title
        System.out.println("Opened correct Form");
        WebElement name = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]"));
        w.waitForElementToBeClickable(name);
        name.click();
        w.sendKeys(name, "Crio Learner");
        try {
            String enteredText = driver.findElement(By.xpath("//input[@jsname='YPqjbf']")).getAttribute("data-initial-value");
            if (enteredText.equals("Crio Learner")) {
                System.out.println("Name Entered corectly");

            }
        } catch (Exception e) {
            System.out.println("Error while entering message");
        }
        //Validate label 'Why are you practicing Automation?'
        WebElement ptext = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='Why are you practicing Automation?']"));
        ptext.click();
        if (ptext.getText().contains("Why are you practicing Automation?")) {
            System.out.println("Practicing Automation label passed");
        } else {
            System.out.println("Practicing Automation label failed");
        }
        WebElement automation_txtBox = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        automation_txtBox.click();
        String s1 = "I want to be the best QA Engineer!";
        long x = System.currentTimeMillis() / 1000;
        String text = s1 + x;
        w.sendKeys(automation_txtBox, text);
        WebElement experience_txtBox = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
        experience_txtBox.click();
        System.out.println("selected radio button");
        WebElement ckkauto = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='Which of the following have you learned in Crio.Do for Automation Testing?']"));
        ckkauto.click();
        if (ckkauto.getText().contains("Which of the following have you learned in Crio.Do for Automation Testing?")) {
            System.out.println("Automation learning label passed");
        } else {
            System.out.println("Automation learning label failed");
        }

        try {
            List<WebElement> learned_txtBox = driver.findElements(By.xpath("//div[@class='eBFwI']//label"));
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
        } catch (Exception e) {
            System.out.println("Error in selecting checkboxes");
        }
        // Choose an option in 'How should you be addressed?'
        try {
            WebElement dd = driver.findElement(By.xpath("//div[@jsname='LgbsSe']//div/div[1]/span"));
            dd.click();
            Thread.sleep(2000);
            WebElement ms = driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']/div[4]/span"));
            ms.click();
        } catch (Exception e) {
            System.out.println("Error selecting dropdown options: " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

        WebElement dat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='M7eMe'][text()='What was the date 7 days ago?']")));
        w.waitForElementToBeClickable(dat);
        w.click(dat);
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
        w.sendKeys(dateInput, formattedDate);
        String enteredValue = dateInput.getAttribute("value");
        System.out.println("Entered date value: " + enteredValue);
        // Validate label 'What is the time right now?'
        try {
            Thread.sleep(3000);
            WebElement time = driver.findElement(By.xpath("//span[@class='M7eMe'][text()='What is the time right now?']"));
            w.click(time);
            if (time.getText().contains("What is the time right now?")) {
                System.out.println("Time label passed");
            } else {
                System.out.println("Time label failed");
            }
        } catch (Exception e) {
            System.out.println("Error selecting dropdown options: " + e.getMessage());
        }        // Enter hour and minute in 'What is the time right now?' input fields
        WebElement hourInput = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        w.sendKeys(hourInput, "7");
        WebElement minuteInput = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        w.sendKeys(minuteInput, "30");
        // Optionally, validate entered time values
        String enteredHour = hourInput.getAttribute("value");
        String enteredMinute = minuteInput.getAttribute("value");
        System.out.println("Entered time: " + enteredHour + ":" + enteredMinute);
        WebElement submit = driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac' and text()='Submit']"));
        w.click(submit);        // Print the text from result elements
        WebElement t1 = driver.findElement(By.xpath("//div[@class='pdLVYe LgNcQe']"));
        WebElement t2 = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println("Result 1: " + t1.getText());
        System.out.println("Result 2: " + t2.getText());
        System.out.println("End Test case");
    }
    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}