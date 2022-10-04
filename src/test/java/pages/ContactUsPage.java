package pages;

import framework.pages.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ContactUsPage  extends BaseSeleniumPage{

    @FindBy(xpath = "//li[.//*[contains(@class,'menu-text') and text()='Contact Us']]")
    public WebElement contactUs;

    @FindBy(css = "#sticky-wrapper > header > div > div.col-xl-5.col-lg-4.col-md-6.col-10 > div.header-contact.nice-select-two > ul > li:nth-child(1) > div")
    public WebElement countryDropDown;

    @FindBy(css = "#sticky-wrapper > header > div > div.col-xl-5.col-lg-4.col-md-6.col-10 > div.header-contact.nice-select-two > ul > li:nth-child(1) > div > ul > li.option.selected.focus")
    public WebElement rsa;

    @FindBy(css = "#sticky-wrapper > header > div > div.col-xl-5.col-lg-4.col-md-6.col-10 > div.header-contact.nice-select-two > ul > li:nth-child(1) > div > ul > li:nth-child(2)")
    public WebElement uk;

    @FindBy(name = "your_name")
    public WebElement name;

    @FindBy(css = "[name$='mobilephone']")
    public WebElement contactNumber;

    @FindBy(css = "[id$='what_kind_of_problem_is_your_business_currently_facing_-c2e387f9-4bd8-496f-ab2a-81fbbc31712a'] select")
    public WebElement whatServicesLookingFor;

    @FindBy(css = "[name$='message']")
    public WebElement howCanWeHelpYou;

    @FindBy(css = "[name$='email']")
    public WebElement workEmail;

    @FindBy(css = "[id$='numemployees-c2e387f9-4bd8-496f-ab2a-81fbbc31712a'] select")
    public WebElement companySize;

    @FindBy(css = "[name$='LEGAL_CONSENT.subscription_type_10841063']")
    public WebElement agreeCheckbox;

    @FindBy(xpath = "//div[contains(@class,'hs_submit hs-submit')]//input")
    public WebElement submit;

    @FindBy(id = "hs-form-iframe-0")
    WebElement iframe;

    public ContactUsPage (WebDriver driver) {
        super(driver);
    }

    public List<String> getValidations(){
        return driver.findElements(By.cssSelector(".hs-error-msg")).stream().map(WebElement::getText).collect(Collectors.toList());

    }

    public ContactUsPage switchToIframe() {
        driver.switchTo().frame(iframe);
        return this;
    }
}
