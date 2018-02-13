package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.ArrayList;
import java.util.List;

public class DocumentsDLKO extends HelpSteps {

    public DocumentsDLKO(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//table[@id='dlko-docs-assets']")
    public WebElement tableAssets;

    @FindBy(how = How.ID, using = "dlko-docs-docs")
    public WebElement tableDocs;

    @FindAll({@FindBy(how = How.XPATH, using = "//td//input[@type='checkbox']")})
    public List<WebElement> checkboxes;

    public void checkActive() {
        isElementPresent(checkboxes, 10);
        checkboxes.get(0).click();

    }

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@id='basic']//label/../following-sibling::*[1]//input"),
            @FindBy(how = How.XPATH, using = "//*[@id='basic']//label/../following-sibling::*[1]//textarea")})
    public List<WebElement> inputFieldsOnTabBasicForStorageContract;

    //@FindAll({@FindBy(how = How.XPATH, using = "//*[@id=\"basic\"]//label//input")})
    //public List<WebElement> checkboxesOnTabBasicForStorageContract;

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@id='basic']//label")})
    public List<WebElement> elementsOnTab;

    public List<String> getNameOfElementsOnTab() {
        List<String> names = new ArrayList<>();
        if (isElementPresent(elementsOnTab, 10)) {
            for (WebElement element : elementsOnTab) {
                names.add(element.getText());
            }
        }
        return names;
    }

    public void fillElementsOnTab(List<List<String>> data){
        if (isElementPresent(inputFieldsOnTabBasicForStorageContract, 10)) {
            for (List<String> row : data) {
                for (WebElement element : elementsOnTab) {
                    if(row.get(0).equals(element.getText())){
                        WebElement el = element.findElement(By.xpath("./../following-sibling::*[1]/*[1]"));
                        el.click();
                        el.sendKeys(row.get(1));
                    }
                }
            }
        }
    }



}
