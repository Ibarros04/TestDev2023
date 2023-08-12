package SawceDemo.Paginas;
import SawceDemo.Steps.Questions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CheckOut {

    private WebDriver driver;

    private Questions questions;

    String FirstNameP ="iskian";
    String LastNameP  ="barros";
    String PostalCodeP  ="1234567";


    public CheckOut(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.questions= new Questions(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement carrito;


    ///////////Elementos formulario
    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement shopping_cart;
    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkout;
    @FindBy(how = How.ID, using = "first-name")
    private WebElement FirstName;
    @FindBy(how = How.ID, using = "last-name")
    private WebElement LastName;
    @FindBy(how = How.ID, using = "postal-code")
    private WebElement pcode;
    @FindBy(how = How.ID, using = "continue")
    private WebElement Continue;
    @FindBy(how = How.ID, using = "finish")
    private WebElement finish;


    public void ValidaCheckout () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(carrito));
        carrito.click();
        this.questions.AssertCheckOut();
    }

    public void DiligenciarFormulario ()   {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(shopping_cart));
        shopping_cart.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();
        wait.until(ExpectedConditions.elementToBeClickable(FirstName));
        FirstName.clear();
        FirstName.sendKeys(FirstNameP);
        wait.until(ExpectedConditions.elementToBeClickable(LastName));
        LastName.clear();
        LastName.sendKeys(LastNameP);
        wait.until(ExpectedConditions.elementToBeClickable(pcode));
        pcode.clear();
        pcode.sendKeys(PostalCodeP);
    }



    public void ValidForm () throws  IOException {
        this.questions.AssertForm();
    }


    public void FinishShopping ()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Continue));
        Continue.click();
        wait.until(ExpectedConditions.elementToBeClickable(finish));
        finish.click();
    }


    public void validorder () throws IOException {
        this.questions.Assertorder();

    }

}
