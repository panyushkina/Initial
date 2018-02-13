package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static stepDefinition.InitialSteps.driver;
import static stepDefinition.InitialSteps.modalWindowSearchTable;
import static stepDefinition.InitialSteps.resultTable;

public class HelpSteps {

    //WebDriver driver = InitialSteps.getDriver();

    public void enterData(String id, String placeholder, String data) {
        WebElement element = driver.findElement(By.xpath("//input[@id='" + id + "'][@placeholder='" + placeholder + "']"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData(String nameField, String data) {
        WebElement element = driver.findElement(By.xpath("//input[@name='" + nameField + "']"));
        //    element.isEnabled();
        isElementPresent(element, 30);
        element.click();
        element.clear();
        element.sendKeys(data);
        element.sendKeys(Keys.TAB);
    }

    public void pushButton(String button) {
        WebElement element = driver.findElement(By.xpath("//self::node()[text()='" + button + "'][1]"));
        isElementPresent(element, 30);
        element.click();
    }

    public void checkElement(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        isElementPresent(el, 30);
        el.isDisplayed();
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    /*public void checkLogo(String logo){
       driver.findElement(By.xpath("//self::node()[@title='" + logo + "']")).isDisplayed();
    }*/

    public boolean isElementPresent(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(1200);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(List<WebElement> elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfAllElements(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void chooseOptionInModalWindow(String element, WebDriver driver) {
        WebElement el = driver.findElement(By.xpath("//option[contains(text(),'" + element + "')]"));
        isElementPresent(el, 30);
        el.click();
    }

    public boolean isElementEnabled(String xPath, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath(xPath));
        isElementPresent(element, 50);
        return element.isEnabled();
    }

    public boolean searchActiveInTable(String activeName) {
        resultTable.pushSearchButton();
        chooseOptionInModalWindow("Наименование", driver);
        chooseOptionInModalWindow("равно", driver);
        modalWindowSearchTable.inputField(activeName, driver);
        pushButton("Найти");
        return resultTable.checkItems(activeName);
    }

    public void checkEnabledElement(String name) {
        if (!isElementEnabled(name, driver)) {
            Assert.fail("Элемент недоступен!");
        }
    }

    public void checkDisabledElement(String name) {
        if (isElementEnabled(name, driver)) {
            Assert.fail("Элемент доступен!");
        }
    }

    public void fillField(String nameEl, String value){
        WebElement element = driver.findElement(By.xpath("//*[@" + nameEl + "]"));
        isElementPresent(element, 50);
        element.click();
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.TAB);
    }




}