package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ModalWindowSearchTable {

    public ModalWindowSearchTable(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//td/input[@role='textbox'][@class='input-elm']")
    public WebElement fieldInput;

    public void inputField(String value, WebDriver driver){
        fieldInput.clear();
        fieldInput.sendKeys(value);
    }
}
