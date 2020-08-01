package io.pragra.learning.b25.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class ContactSales {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "employee_count")
    WebElement empCountSelect;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "country")
    WebElement countrySelect;

    @FindBy(id = "state")
    WebElement stateSelect;

    @FindBy(id = "city")
    WebElement zip;

    @FindBy(id = "description")
    WebElement additionalInfo;

    public ContactSales(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ContactSales enterEmail(String email){
        this.email.sendKeys(email);
        return this;
    }

    public ContactSales company(String company){
        this.company.sendKeys(company);
        this.company.sendKeys(Keys.ESCAPE);
        return this;
    }

    public ContactSales selectEmpCountByValue(String value){
        Select select = new Select(empCountSelect);
        select.selectByValue(value);
        return this;
    }

    public ContactSales selectEmpCountByIndex(int index){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        empCountSelect = wait.until(ExpectedConditions.elementToBeClickable(empCountSelect));
        Select select = new Select(empCountSelect);
            select.selectByIndex(index);
        return this;
    }
}
