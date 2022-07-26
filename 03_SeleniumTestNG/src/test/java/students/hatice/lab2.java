package students.hatice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab2 {
    public static void main(String[] args) throws InterruptedException {


        //TC #1: Facebook title verification
//Task - 1
//Open Chrome Browser
//Go to https://www.facebook.com
//Verify title: Expected: "Facebook - Log In or Sign Up"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Facebook title verification has passed");
        } else {
            System.out.println("Facebook title verification has failed");
        }
        System.out.println("actual title is=" + actualTitle);
        driver.close();
        //Task - 2
//Open Chrome Browser
//Go to google
//Navigate back
//Navigate forward
//Navigate to https://www.amazon.com
//Verify title contains : Smile
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.google.com");
        driver1.navigate().back();
        driver1.navigate().forward();
        driver1.get("https://www.amazon.com");

        WebElement SearchBox = driver1.findElement(By.id("twotabsearchtextbox"));
        SearchBox.sendKeys("Smile");
        WebElement searchButton = driver1.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        Thread.sleep(200);
        driver1.navigate().back();
        driver1.navigate().back();
        //Second Task:
        // Go to https://www.etsy.com/
        // Maximize window
        // Verify title doesnt contains "Smile"
        // Verify Current Url
        // Go to https://www.amazon.com/
        // Verify title
        // Verify Current Url
        // Navigate Back
        // Refresh
        // Quit browser
        driver1.get("https://www.etsy.com/");
        driver1.manage().window().maximize();
        String expectedTitle1 = "etsy";
        String actualTitle1 = driver1.getTitle();

        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println("title does not contains 'Smile' and test past");
        } else {
            System.out.println("title  contains 'Smile' and test failed");
        }
        System.out.println("The actual Title is" + actualTitle);

        // Verify Current Url
        if (driver1.getCurrentUrl().equals("https://www.etsy.com/")) {
            System.out.println("Current Url has past");
        } else
            System.out.println("Current Url has failed");

        driver1.navigate().back();
        driver1.get("https://www.amazon.com/");
        String expectedTitle2 = "amazon";
        String actualTitle2 = driver1.getTitle();
        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println("The title is 'amazon' and test past");
        } else
            System.out.println("The title is not 'amazon' and test past");

        // Verify Current Url
        if(driver1.getCurrentUrl().equals("https://www.amazon.com/")){
            System.out.println("URL has past");
        }else{
            System.out.println("URL has failed");
        }
            driver1.navigate().back();
            driver1.navigate().refresh();
            driver1.quit();

    }

}

