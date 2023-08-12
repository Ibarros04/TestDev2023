package SawceDemo.Steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class Botones {

    private WebDriver driver;


    public Botones(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //////////// LOGIN
    String userName ="locked_out_user";
    String Password  ="secret_sauce";
    @FindBy(how = How.ID, using = "user-name")
    private WebElement User;
    @FindBy(how = How.ID, using = "password")
    private WebElement pass;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement login;

    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement carrito;

    ////////////////RESET APP STATUS
    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']")
    private WebElement OpenMenu;

    @FindBy(how = How.XPATH, using = "//a[@id='reset_sidebar_link']")
    private WebElement reset;

    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-cross-btn']")
    private WebElement CloseMenu;

    @Step //ingreso de credenciales al portal
    public void credenciales() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(User));
        User.clear();
        User.sendKeys(Utility.locatorValues("userName"));
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.clear();
        pass.sendKeys(Password);
        wait.until(ExpectedConditions.elementToBeClickable(login));
    }


    @Step
    public void Login ()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
    }

    @Step // resetear estado de app
    public void ResetStatusApp ( )  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(OpenMenu));
        OpenMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(reset));
        reset.click();
        wait.until(ExpectedConditions.elementToBeClickable(CloseMenu));
        CloseMenu.click();
    }





}