package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;


public class Sovtech_Namhla {
    public WebDriver buildingTestMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abosh\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //lAUNCH URL
       driver.get("https://www.sovtech.co.za/contact-us/");
       driver.manage().window().maximize();

       // MAXIMISE WINDOW
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//li[.//*[contains(@class,'menu-text') and text()='Contact Us']]")).click();

        return driver;
    }
}
