package io.pragra.learning.b25.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestADemoPage {

    WebDriver driver;

    @FindBy(css = "#support_contact>div.mini-layout-body>div.page-header>h2.fromNormal")
    WebElement pageHeading;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "first_name")
    WebElement first_name;

    // @Bhaumik to conplete


    public RequestADemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeadingText(){
        return this.pageHeading.getText();
    }

    public RequestADemoPage keyInEmail(String email){
        this.email.sendKeys(email);
        return this;
    }

    public RequestADemoPage keyCompany(String company){
        this.company.sendKeys(company);
        return this;
    }

    public RequestADemoPage and(){
        return this;
    }
}
