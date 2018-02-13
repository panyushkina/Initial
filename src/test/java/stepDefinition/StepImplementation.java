package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.ru.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static stepDefinition.InitialSteps.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StepImplementation extends HelpSteps {

    /*@Когда("^пользователь заполняет поле \"Имя пользователя\" значением \"([^\"]*)\"$")
    public void setUsername(String username) throws Throwable {
        enterData("username", "Имя пользователя", username);
    }

    @Когда("^пользователь заполняет поле \"Пароль\" значением \"([^\"]*)\"$")
    public void setPassword(String password) throws Throwable {
        enterData("password", "Пароль", password);
    }*/

    @Когда("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void userFillsLoginForm(String fieldName, String value) throws Throwable {
        loginForm.enterDataLoginForm(fieldName, value);
    }


    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    @А("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"$")
    @И("^переходит на вкладку \"([^\"]*)\"$")
    public void clickButton(String element) throws Throwable {
        pushButton(element);
    }


    @И("^открывается модальное окно \"([^\"]*)\"$")
    @Когда("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    @Тогда("^открывается страница с сообщением \"([^\"]*)\"$")
    public void openPage(String element) throws Throwable {
        checkElement(element);
    }

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void открываетсяСтраницаСЛоготипомАгенствоПоСтрахованиюВкладов(String logo) throws Throwable {
        header.checkLogo(logo);
    }

    @Когда("^пользователь заполняет поля \"Имя пользователя\" и \"Пароль\" значениями$")
    public void пользователь_заполняет_поля_и_значениями(DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        enterData("username", "Имя пользователя", list.get(0));
        enterData("password", "Пароль", list.get(1));
    }

    @Когда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    @И("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню$")
    public void пользовательНажимаетКнопкуСВыпадающимСписком(String element) throws Throwable {
        header.clickOnNavigationItem(element);
        //Thread.sleep(1200);
        //driver.findElement(By.xpath("//li[@class='dropdown']//a[@class='dropdown-toggle'][contains(text(),'" + element + "')]")).click();
    }

    @И("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void пользовательВыбираетПункт(String element) throws Throwable {
        header.itemsDropDownList(element);
        //Thread.sleep(1200);
        //driver.findElement(By.xpath("//li/a[contains(@sua-access, '.list')][contains(text(),'" + element + "')]")).click();
    }

    @Тогда("^открывается экранная форма \"([^\"]*)\"$")
    public void открываетсяЭкраннаяФорма(String title) throws Throwable {
        resultTable.checkTitle(title);
    }


    @И("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void пользовательНажимаетКнопкуВВерхнейПанелиТаблицы(String arg0) throws Throwable {
        resultTable.pushSearchButton();
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"ID Плана Счетов\"$")
    @И("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"содержит\"$")
    @Тогда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Тип актива функциональный\"$")
    public void пользовательВыбираетПунктВВыпадающемСписке(String value) throws Throwable {
        chooseOptionInModalWindow(value, driver);
    }

    @И("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void пользовательЗаполняетПолеЗначением(String value) throws Throwable {
        modalWindowSearchTable.inputField(value, driver);
    }

    @Тогда("^отображается \"Номер счёта 2-го порядка\" содержащий \"([^\"]*)\"$")
    public void отображаетсяСодержащий(String element) throws Throwable {
        resultTable.checkItems(element);
    }

    @Ктомуже("^поле \"Наименование ФО\" недоступно для редактирования$")
    public void конкретноеполеНеоступноДляРедактирования() throws Throwable {
        if (isElementEnabled("orgName", driver)) {
            Assert.fail("Элемент доступен");
        }
    }

    @И("^поле \"([^\"]*)\" недоступно для редактирования$")
    public void полеНеоступноДляРедактирования(String nameField) throws Throwable {
        checkDisabledElement("//label[text()='" + nameField + "']/../following-sibling::*[1]/input");
    }

    @А("^поле \"Тип актива функциональный\" доступно для редактирования$")
    public void полеДоступноДляРедактирования() throws Throwable {
        if (!isElementEnabled("assetFunctionalType", driver)) {
            Assert.fail("Элемент недоступен");
        }
    }

    @И("^на форме присутствуют закладки$")
    public void наФормеПрисутствуютЗакладки(DataTable table) throws Throwable {
        List<String> tabs = table.asList(String.class);
        assertEquals(tabs, activeForm.getNavigationItems());
    }

    /*@Когда("^пользователь заполняет поле \"Номер счета\" значением \"([^\"]*)\" на вкладке Основная информация$")
    public void пользовательЗаполняетПолеНомерСчета(String value) throws Throwable {
        enterData("accountNum", value);
    }

    @Когда("^пользователь заполняет поле \"Начальная балансовая стоимость\" значением \"([^\"]*)\" на вкладке Основная информация$")
    public void пользовательЗаполняетПолеНачальнаяБалансоваяСтоимость(String value) throws Throwable {
        enterData("balanceInitial", value);
    }

    @Когда("^пользователь заполняет поле \"В валюте счета\" значением \"([^\"]*)\" на вкладке Основная информация$")
    public void пользовательЗаполняетПолеВвалютеСчета(String value) throws Throwable {
        enterData("balanceInitialCur", value);
    }

    @Когда("^пользователь заполняет поле \"Наименование актива\" значением \"([^\"]*)\" на вкладке Основная информация$")
    public void пользовательЗаполняетПолеНаименованиеАктива(String value) throws Throwable {
        enterData("name", value);
    }*/

    @Когда("^пользователь заполняет поля Номер счета, Начальная балансовая стоимость, В валюте счета, Наименование актива$")
    public void пользовательЗаполняетПолеНаименованиеАктива(DataTable table) throws Throwable {
        Iterator<String> iterator = table.asList(String.class).iterator();
        activeForm.fillAccountNumber(iterator.next());
        activeForm.fillBalanceInitial(iterator.next());
        activeForm.fillBalanceInitialCur(iterator.next());
        activeForm.fillNameActive(iterator.next());
    }

    @Когда("^пользователь заполняет поля Дата начала действия актива и Дата окончания действия актива$")
    public void пользовательЗаполняетПоляДатНаВкладкеПрием(DataTable table) throws Throwable {
        Iterator<String> iterator = table.asList(String.class).iterator();
        activeForm.fillStartDate(iterator.next());
        activeForm.fillEndDate(iterator.next());
    }


    @И("^пользователь нажимает кнопку \"Сохранить\" на форме создания актива$")
    public void пользовательНажимаетКнопкуНаФормеСозданияАктива() throws Throwable {
        activeForm.pushSaveButton();
    }

    @И("^в таблице активов есть актив с Наименованием \"([^\"]*)\"$")
    public void вТаблицеАктивовЕстьАктивСНаименованием(String activeName) throws Throwable {
        searchActiveInTable(activeName);
    }

    @Когда("^пользователь отмечает актив$")
    public void пользовательОтмечаетАктив() throws Throwable {
        documentsDLKO.checkActive();
    }

    @И("^пользователь нажимает кнопку \"([^\"]*)\" в заголовке таблицы$")
    public void пользовательНажимаетКнопкуСВыпадающимСпискомВЗаголовкеТаблицы(String nameButton) throws Throwable {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), '" + nameButton + "')]"));
        isElementPresent(button, 10);
        button.click();
    }

    @И("^пользователь переходит к пункту \"([^\"]*)\"$")
    public void пользовательПереходитКПункту(String nameOption) throws Throwable {
        WebElement option = driver.findElement(By.xpath("//*[@class='dropdown-submenu']//*[contains(text(), '" + nameOption + "')]"));
        Actions moveTo = new Actions(driver);
        moveTo.moveToElement(option).build().perform();
    }

    @И("^пользователь нажимает на пункт \"([^\"]*)\"$")
    public void пользовательНажимаетНаПункт(String nameOption) throws Throwable {
        WebElement button = driver.findElement(By.xpath("//*[@class='dropdown-menu']//*[text()='" + nameOption + "'][1]"));
        isElementPresent(button, 10);
        button.click();
    }

    @И("^на форме присутствуют поля$")
    public void наФормеПрисутствуютПоля(DataTable table) throws Throwable {
        //System.out.println(Arrays.toString(documentsDLKO.getNameOfElementsOnTab().toArray()));
        List<String> fields = table.asList(String.class);
        assertEquals(fields, documentsDLKO.getNameOfElementsOnTab());
    }

    @Тогда("^пользователь заполняет поля$")
    public void пользовательЗаполняетПоля(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        documentsDLKO.fillElementsOnTab(data);
    }

    @Тогда("^заполняем поле \"Банк\" значением \"([^\"]*)\"$")
    public void заполняем1Значением(String value) throws Throwable {
        fillField("name='bank'", value);
    }

    @Тогда("^заполняем поле \"Номер договора\" значением \"([^\"]*)\"$")
    public void заполняем2Значением(String value) throws Throwable {
        fillField("name='documentNumber'", value);
    }

    @Тогда("^заполняем поле \"Дата договора\" значением \"([^\"]*)\"$")
    public void заполняем3Значением(String value) throws Throwable {
        fillField("name='contractDate'", value);
    }

    @Тогда("^заполняем поле \"Срок договора\" значением \"([^\"]*)\"$")
    public void заполняем4Значением(String value) throws Throwable {
        fillField("name='endDate'", value);
    }

    @Тогда("^заполняем поле \"Место хранения\" значением \"([^\"]*)\"$")
    public void заполняем5Значением(String value) throws Throwable {
        fillField("id='storageLocation'", value);
    }

    @Тогда("^заполняем поле \"Комментарий\" значением \"([^\"]*)\"$")
    public void заполняем6Значением(String value) throws Throwable {
        fillField("name=\"comment\"", value);
    }

    @И("^пользователь нажимает кнопку \"([^\"]*)\" на форме создания документа$")
    public void пользовательНажимаетКнопкуНаФормеСозданияДокумента(String nameButton) throws Throwable {
        WebElement button = driver.findElement(By.xpath("//button[text()=" + nameButton + "]"));
        isElementPresent(button, 20);
        button.click();
    }

    @Когда("^пользователь нажимает на строку с активом$")
    public void пользовательНажимаетНаСтрокуСАктивом() throws Throwable {
        WebElement row = driver.findElement(By.xpath("//table[@id='dlko-docs-assets']//tr[2]"));
        isElementPresent(row, 20);
        row.click();
    }
}
