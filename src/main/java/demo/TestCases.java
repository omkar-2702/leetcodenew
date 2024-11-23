package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public boolean testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("leetcode")) {
            System.out.println("TestCase01 is passed sucessfully");
            System.out.println("end Test case: testCase01");
            return true;
        }
        System.out.println("end Test case: testCase02");
        return false;
    }

    public boolean testCase02() {
        System.out.println("Start Test case: testCase01");
        driver.findElement(By.xpath(" //p[contains(text(),'Questions')]")).click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("problemset")) {
            System.out.println("url contains problemset");
        }
        try {
            Thread.sleep(5000); // Wait for the page to load
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
        List<WebElement> list = driver
                .findElements(By.xpath(" //a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
        int inputCount = 6;
        for (int i = 0; i < inputCount; i++) {
            System.out.println(list.get(i).getText());
        }

        System.out.println("end Test case: testCase02");

        // a[text()='Two Sum']

        // span[text()='Submissions']
        // a[text()='Register or Sign In']

        return true;
    }

    public boolean testCase03() {
        System.out.println("Start Test case: testCase03");
        try {
            Thread.sleep(5000); // Wait for the page to load
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
        driver.findElement(By.xpath("//a[text()='Two Sum']")).click();
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("two-sum")) {
            System.out.println("url contains two-sum");
        }
        System.out.println("end Test case: testCase03");

        return true;
    }

    public boolean testCase04() {
        System.out.println("Start Test case: testCase04");

        WebElement submissionTab = driver.findElement(By.id("submissions_tab"));
        submissionTab.click();

        try {
            Thread.sleep(10000); // Wait for the page to load
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
        System.out.println("end Test case: testCase04");

        String res = driver.findElement(By.xpath("//a[text()='Register or Sign In']")).getText();
        if (res.contains("Register or Sign In")) {
            return true;
        }
        return false;
    }

}