package co.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

public class Day1 {
    WebDriver driver;
    JavascriptExecutor js;

    public void invokeBrowser() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/salmassari/Documents/Selenium/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model

            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            // to give your browser time to load images and contents so we need to prevent the next step from failure.
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.get("http://www.amazon.com");
            Thread.sleep(1000);
            search();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void search()  {
        // To find one of the 8 elements
        //id , classname , name, tagname, cssSelector, lonkText, partialLinkText, XPath
        try {

            driver.findElement(new By.ById("twotabsearchtextbox")).sendKeys("Coffee beans");
            driver.findElement(new By.ById("nav-search-submit-button")).click();
            js = (JavascriptExecutor) driver;
            Thread.sleep(1000);
            js.executeScript("scroll(0,500)");
            driver.findElement(new By.ByXPath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/span/a/div")).click();
            driver.findElement(new By.ByXPath("/html/body/div[2]/div[3]/div[8]/div[4]/div[4]/div[30]/div[1]/div/form/div[1]/ul/li[2]/span/div/span/span/span/button/div/div[1]/p")).click();

//            js.executeScript("arguments[0].scrollIntoView();", Element);


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Day1 run = new Day1();
        run.invokeBrowser();

    }
}
