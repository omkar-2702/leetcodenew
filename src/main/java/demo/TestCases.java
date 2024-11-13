package demo;

import java.time.Duration;
import java.util.List;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        boolean status = false;

        // Navigate to Leetcode homepage
        driver.get("https://leetcode.com/");

        // Verify that the URL contains "leetcode"
        String url = driver.getCurrentUrl();
        if (url.contains("leetcode")) {
            status = true;
            System.out.println("URL contains 'leetcode': Test Passed");
        } else {
            System.out.println("URL does not contain 'leetcode': Test Failed");
        }

        System.out.println("End Test case: testCase01");
    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02");
        boolean status = false;

        // Click on the "Questions" link to navigate to the problem set page
        WebElement questionsLink = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questionsLink.click();

        // Verify that the URL contains "problemset"
        String url = driver.getCurrentUrl();
        if (url.contains("https://leetcode.com/problemset/")) {
            status = true;
            System.out.println("URL contains 'problemset': Test Passed");
        } else {
            System.out.println("URL does not contain 'problemset': Test Failed");
        }

        // Retrieve and print details of the first 5 questions
        List<WebElement> questions = driver.findElements(By.xpath("//a[text()='Two Sum']"));
        for (int i = 0; i < 5 && i < questions.size(); i++) {
            String questionTitle = questions.get(i).getText();
            System.out.println("Question " + (i + 1) + ": " + questionTitle);

            // Verify the title of each question
            questions.get(i).click();
            String titleOnPage = driver.getTitle();
            if (titleOnPage.contains(questionTitle)) {
                System.out.println("Title matches for question: " + questionTitle);
                driver.navigate().back();
            } else {
                System.out.println("Title does not match for question: " + questionTitle);
            }
        }

        System.out.println("End Test case: testCase02");
    }

    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        boolean status = false;

        // Open the Two Sum problem
        driver.get("https://leetcode.com/problems/two-sum/description/");

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Verify that the URL contains "two-sum"
        if (currentUrl.contains("https://leetcode.com/problems/two-sum/description/")) {
            status = true;
            System.out.println("URL contains 'two-sum': Test Passed");
        } else {
            System.out.println("URL does not contain 'two-sum': Test Failed");
        }

        System.out.println("End Test case: testCase03");
    }

    public void testCase04() {
        System.out.println("Start Test case: testCase04");
        boolean status = false;

        // Open the Two Sum problem page first
        driver.get("https://leetcode.com/problems/two-sum/");

        // Click on the Submissions tab
        WebElement submissionsTab = driver.findElement(By.xpath("//span[text()='Submit']"));
        submissionsTab.click();

        // Verify if the "Register or Sign In" message is displayed
        WebElement messageElement = driver.findElement(By.xpath("//a[text()='Login / Sign up']"));
        if (messageElement.isDisplayed()) {
            status = true;
            System.out.println("'Register or Sign In' is displayed: Test Passed");
        } else {
            System.out.println("'Register or Sign In' is not displayed: Test Failed");
        }

        System.out.println("End Test case: testCase04");
    }
}