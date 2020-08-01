package io.pragra.learning.b25.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationBar {

    private WebDriver driver;

    /*
        //div[@id='black-topbar']//ul[@role='menubar']/li[1]
     */
    @FindBy(css = "#black-topbar ul[role=menubar]>li:nth-child(1)")
    private WebElement requestADemo;
    @FindBy(css = "#black-topbar ul[role=menubar]>li:nth-child(2)")
    private WebElement one888Link;
    @FindBy(css = "#black-topbar ul[role=menubar]>li:nth-child(3)")
    private WebElement resources;
    @FindBy(css = "#black-topbar ul[role=menubar]>li:nth-child(4)")
    private WebElement support;

    /* Menu Under Resources **/

    @FindBy(css = "#resourcesDropdown>li:nth-child(1)")
    private WebElement downLoadZoom;
    private WebElement videoTuts;
    private WebElement liveTraining;
    private WebElement webinar;
    //@Nav to compete


    public TopNavigationBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public RequestADemoPage clickOnRequestDemo(){
        this.requestADemo.click();
        return new RequestADemoPage(driver);
    }

    public void clickOnDownloadZoom() {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(resources)
                .pause(1000)
                .moveToElement(downLoadZoom)
                .click()
                .build()
                .perform();

    }
}
