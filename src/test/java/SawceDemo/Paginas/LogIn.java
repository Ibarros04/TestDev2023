package SawceDemo.Paginas;

import SawceDemo.Steps.Botones;
import SawceDemo.Steps.Questions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogIn {
    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;


    public LogIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions(driver);

    }

    @Step
    public void Credenciales () throws IOException {
       this.botones.credenciales();
    }
    @Step

    public void IniciarSesion()  {
        this.botones.Login();
    }

    @Step
    public void ValidarLogin () throws IOException {
      this.questions.AssertLogin(driver);
    }
}
