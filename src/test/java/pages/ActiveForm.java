package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;
import java.util.stream.Collectors;

public class ActiveForm extends HelpSteps {

    public ActiveForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindAll({@FindBy(how = How.XPATH, using = "//ul[@class='nav nav-tabs full']/li/a")})
    public List<WebElement> navigationItems;

    public List<String> getNavigationItems() {
        return navigationItems.stream().limit(13).
                map(WebElement::getText).collect(Collectors.toList());
    }

    @FindBy(how = How.XPATH, using = "//input[@name='accountNum']")
    public WebElement accountNumber;

    public void fillAccountNumber(String value) {
        isElementPresent(navigationItems, 30);
        accountNumber.click();
        accountNumber.clear();
        accountNumber.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceInitial']")
    public WebElement balanceInitial;

    public void fillBalanceInitial(String value) {
        balanceInitial.click();
        balanceInitial.clear();
        balanceInitial.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceRur']")
    public WebElement balanceRur;

    public void fillBalanceRur(String value) {
        balanceRur.click();
        balanceRur.clear();
        balanceRur.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceInitialCur']")
    public WebElement balanceInitialCur;

    public void fillBalanceInitialCur(String value) {
        balanceInitialCur.click();
        balanceInitialCur.clear();
        balanceInitialCur.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='balanceCur']")
    public WebElement balanceCur;

    public void fillBalanceCur(String value) {
        balanceCur.click();
        balanceCur.clear();
        balanceCur.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    public WebElement nameActive;

    public void fillNameActive(String value) {
        nameActive.click();
        nameActive.clear();
        nameActive.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='startDate']")
    public WebElement startDate;

    public void fillStartDate(String value) {
        isElementPresent(startDate, 30);
        startDate.click();
        startDate.clear();
        startDate.sendKeys(value);
        startDate.sendKeys(Keys.TAB);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='endDate']")
    public WebElement endDate;

    public void fillEndDate(String value) {
        isElementPresent(endDate, 30);
        endDate.click();
        endDate.clear();
        endDate.sendKeys(value);
        endDate.sendKeys(Keys.TAB);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='form-group']//button[text()='Сохранить']")
    public WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//*[@class='modal-content']//*[contains(text(), 'Обнаружены активы с таким же номером счёта ')]")
    public WebElement warningTheSameActive;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Обнаружены активы с таким же номером счёта ')]/./following-sibling::*//button[text()='Да']")
    public WebElement yesButton;

    public void pushSaveButton() {
        isElementPresent(saveButton, 30);
        saveButton.click();
        if (isElementPresent(warningTheSameActive, 30)){
            yesButton.click();

        }
    }
}
