Feature: Pruebas Generales demo SawceDemo

	#  en la pagina https://www.saucedemo.com
	#  	Scenario: Inicio de sesion
	#	Scenario: Add productos al Carrito
	#	Scenario: Visualizar carrito de compras
	#	Scenario: Completar formulario de compras
	#	Scenario: Finalizar proceso de  compras


@tag1
Scenario: Inicio de sesion
	Given usuario abre el navegador
	When  Usuario Diligencia credenciasles
	And   usuario inicia sesion
	Then  validar inicio de sesion correcto

	@tag2
		Scenario: Add productos al Carrito
		Given usuario abre el navegador
		When  Usuario Diligencia credenciasles
		And   usuario inicia sesion
		And   Usuario resetea estado de la aplicacion
		And   usuario agrega productos  producto al carrito
		Then  validar cantidad de productos agregados

	@tag3
	Scenario: Visualizar carrito de compras
		Given usuario abre el navegador
		When  Usuario Diligencia credenciasles
		And   usuario inicia sesion
		And   Usuario resetea estado de la aplicacion
		And   usuario agrega productos  producto al carrito
		Then  validar Productos agregados en el carrito

	@tag4
	Scenario: Completar formulario de compras
		Given usuario abre el navegador
		When  Usuario Diligencia credenciasles
		And   usuario inicia sesion
		And   Usuario resetea estado de la aplicacion
		And   usuario agrega productos  producto al carrito
		And   usuario diligencia formulario de checkout
		Then  validar formulario diligenciado


	@tag5
	Scenario: Finalizar proceso de  compras
		Given usuario abre el navegador
		When  Usuario Diligencia credenciasles
		And   usuario inicia sesion
		And   Usuario resetea estado de la aplicacion
		And   usuario agrega productos  producto al carrito
		And   usuario diligencia formulario de checkout
		And   usuario finaliza compra
		Then  Validar proceso de compras finalizado