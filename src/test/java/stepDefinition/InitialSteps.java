package stepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

public class InitialSteps extends HelpSteps{

    public static WebDriver driver;
    public static LoginForm loginForm;
    public static Header header;
    public static ResultTable resultTable;
    public static ModalWindowSearchTable modalWindowSearchTable;
    public static ActiveForm activeForm;
    public static DocumentsDLKO documentsDLKO;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.drive", "chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(capabilities);
            loginForm = new LoginForm(driver);
            header = new Header(driver);
            resultTable = new ResultTable(driver);
            modalWindowSearchTable = new ModalWindowSearchTable(driver);
            activeForm = new ActiveForm(driver);
            documentsDLKO = new DocumentsDLKO(driver);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");

    }

    @И("^открывается страница с формой \"([^\"]*)\"$")
    public void openPage(String window) throws Throwable {
        Thread.sleep(1000);
        checkElement(window);
    }

    @Тогда("^браузер закрыт$")
    public void браузерЗакрыт() throws Throwable {
        driver.quit();
        driver = null;
    }
}
