package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUsPage;
import pages.Sovtech_Namhla;

import java.util.Arrays;
import java.util.List;

public class Test_Contact_us_Page  {

    @Test
    public void Test_Contact_us_Page() {
        Sovtech_Namhla sovtech_namhla = new Sovtech_Namhla();
        SoftAssert softAssert = new SoftAssert();
        ContactUsPage contactUsPage = new ContactUsPage(sovtech_namhla.buildingTestMethod());
        contactUsPage.contactUs.click();
        contactUsPage.switchToIframe();
        contactUsPage.submit.click();

        List<String> messeges = contactUsPage.getValidations();
        List<String> expectedValidation = Arrays.asList(
                "Please complete this required field.",
                "Please complete this required field.",
                "Please select an option from the dropdown menu."
        );
        softAssert.assertEquals(messeges, expectedValidation);
        contactUsPage.name.sendKeys("sonwabile");
        contactUsPage.contactNumber.sendKeys("0734567892");
        contactUsPage.workEmail.sendKeys("funeka@gmail.com");

        Select companySize = new Select(contactUsPage.driver.findElement(By.id("numemployees-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")));
        companySize.selectByVisibleText("25-50");

        Select whatKindOfProblem = new Select(contactUsPage.driver.findElement(By.id("what_kind_of_problem_is_your_business_currently_facing_-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")));
        whatKindOfProblem.selectByVisibleText("Design and prototype a new idea");
        contactUsPage.howCanWeHelpYou.sendKeys("Testing");
        contactUsPage.agreeCheckbox.click();
        contactUsPage.workEmail.clear();
        contactUsPage.workEmail.sendKeys("funekagmail.com");

        //Email field
        List<String> workEmail = contactUsPage.getValidations();
        List<String> expectedEmailValidation = Arrays.asList(
                "Email must be formatted correctly."
        );
        softAssert.assertEquals(workEmail, expectedEmailValidation);

        contactUsPage.workEmail.clear();
        contactUsPage.workEmail.sendKeys("funeka@gmailcom");

        List<String> workEmail1 = contactUsPage.getValidations();
        List<String> expectedEmailValidation1 = Arrays.asList(
                "Email must be formatted correctly."
        );
        softAssert.assertEquals(workEmail1, expectedEmailValidation1);
        contactUsPage.workEmail.clear();
        contactUsPage.workEmail.sendKeys("funeka@gmail.com");

        // Contact number validations
        contactUsPage.contactNumber.clear();
        contactUsPage.contactNumber.sendKeys("wqeet6547");

        List<String> contactNumber = contactUsPage.getValidations();
        List<String> contactNumberValidation1 = Arrays.asList(
                "Must contain only numbers, +()-. and x."
        );
        softAssert.assertEquals(contactNumber, contactNumberValidation1);
        contactUsPage.contactNumber.clear();
        contactUsPage.contactNumber.sendKeys("0734567892");
        contactUsPage.submit.click();
        softAssert.assertAll();
    }
}
