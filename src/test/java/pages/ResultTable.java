package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTable extends HelpSteps{

    public ResultTable(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//form/ol//*")
    public List<WebElement> tableTitle;

    public void checkTitle(String element){
        for (WebElement elem : tableTitle){
            if (elem.getText().equals(element)){
                isElementPresent(elem, 30);
                assertEquals(elem.getText(), element);
                //return true;
            }
        }
        //return false;
    }

    @FindBy(how = How.XPATH, using = "(//span[@class='ui-icon fa fa-search fa-fw'])[1]")
    public WebElement buttonSearch;

    public void pushSearchButton(){
        isElementPresent(buttonSearch, 30);
        buttonSearch.click();
    }

    @FindBy(how = How.XPATH, using = "//td[contains(text(), '')]")
    public List<WebElement> items;

    public boolean checkItems(String el){
        for (WebElement elem : items){
            if (elem.getText().equals(el)){
                if (items.size()>=1){
                    return true;
                }
            }
            return true;
        }
        return false;
    }

}
