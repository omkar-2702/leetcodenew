package demo;

import java.net.MalformedURLException;

public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {

        // This is to remove unnecessary warnings from your console
        System.setProperty("java.util.logging.config.file", "logging.properties");

        TestCases tests = new TestCases(); // Initialize your test class

        // TODO: call your test case functions one after other here
        int count = 0;

        if (tests.testCase01()) {
            count++;
        }
        if (tests.testCase02()) {
            count++;
        }
        if (tests.testCase03()) {
            count++;
        }
        if (tests.testCase04()) {
            count++;
        }
        System.out.println("Total no of testcases " + count);
        // END Tests
        tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}

// package demo;

// import java.net.MalformedURLException;

// public class App {
// public void getGreeting() throws InterruptedException, MalformedURLException
// {

// // This is to remove unnecessary warnings from your console
// System.setProperty("java.util.logging.config.file", "logging.properties");

// TestCases tests = new TestCases(); // Initialize your test class

// // TODO: call your test case functions one after other here

// tests.testCase01();
// tests.testCase02();
// tests.testCase03();
// tests.testCase04();

// // END Tests

// tests.endTest(); // End your test by clearning connections and closing
// browser
// }

// public static void main(String[] args) throws InterruptedException,
// MalformedURLException {
// new App().getGreeting();
// }
// }

// // omkarbhagwatwar-ME_QA_XLEETCODE1
