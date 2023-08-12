package SawceDemo.Definitions;

import SawceDemo.Paginas.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import SawceDemo.Steps.*;
import java.io.IOException;



public class DefinitionsSteps {
	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private LogIn logIn;
	private Home home;
	private CheckOut checkOut;

	@Given("^usuario abre el navegador$")
	public void usuario_abre_el_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();
	}
	@When("^Usuario Diligencia credenciasles$")
	public void Usuario_diligencia_credenciasles() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.Credenciales();
	}

	@And("^usuario inicia sesion")
	public void usuario_iniciar_sesion() {
		this.logIn = new LogIn(driver);
		this.logIn.IniciarSesion();
	}
	@Then("^validar inicio de sesion correcto$")
	public void validar_inicio_de_sesion_correcto() throws IOException {
		this.logIn = new LogIn(driver);
		logIn.ValidarLogin();
	}

	@When("^Usuario resetea estado de la aplicacion$")
	public void usuario_resetea_estado_de_la_aplicacion() throws IOException {
		this.home = new Home(driver);
		this.home.ResetCar();
	}
	@When("^usuario agrega productos  producto al carrito$")
	public void usuario_agrega_productos_producto_al_carrito() throws InterruptedException {
		this.home = new Home(driver);
		this.home.Agregarjacket();
		this.home.Agregarbackpack();
	}
	@Then("validar cantidad de productos agregados")
	public void validarCantidadDeProductosAgregados() throws IOException {
		this.home = new Home(driver);
		this.home.ValidarNumeroproductos();
	}

	@Then("validar Productos agregados en el carrito")
	public void validarProductosAgregadosEnElCarrito() throws IOException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.ValidaCheckout();
	}

	@And("usuario diligencia formulario de checkout")
	public void usuarioDiligenciaFormularioDeCheckout() {
		this.checkOut = new CheckOut(driver);
		this.checkOut.DiligenciarFormulario();
	}

	@Then("validar formulario diligenciado")
	public void validarFormularioDiligenciado() throws IOException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.ValidForm();
	}

	@And("usuario finaliza compra")
	public void usuarioFinalizaCompra()  {
		this.checkOut = new CheckOut(driver);
		this.checkOut.FinishShopping();
	}

	@Then("Validar proceso de compras finalizado")
	public void validarProcesoDeComprasFinalizado() throws IOException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.validorder();
	}
}