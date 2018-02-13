package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;

public class LoginForm extends HelpSteps{

    public LoginForm(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//input[@class='form-control']")
    public List<WebElement> fieldsLoginForm;

    public void enterDataLoginForm(String el, String value) {
        for (WebElement item : fieldsLoginForm){
            if (item.getAttribute("placeholder").equals(el)){
                item.sendKeys(value);
            }
        }
    }
}
