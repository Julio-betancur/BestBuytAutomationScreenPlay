package com.bestbuy.stepdefinitions;

import com.bestbuy.driver.SeleniumWebDriver;
import com.bestbuy.globalVar.Global;
import com.bestbuy.tasks.BuscarProductoAleatorio;
import com.bestbuy.userinterface.ProductoUI;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;

public class BestBuytRandomStepDefinitions {

    //Before cucumber: define las variables de usuario e instancia al actor
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que Maria esta en la pagina principal de bestbuy (.*)$")
    public void queMariaEstaEnLaPaginaPrincipalDeBestbuy(String arg) {
        OnStage.theActorCalled("Maria").can(BrowseTheWeb.with(SeleniumWebDriver.ChromeWebDriver().on(arg)));
    }


    @When("^ella ingresa el nombre de un (.*), da clic en la lupa y selecciona aleatoriamente una opcion$")
    public void ellaIngresaElNombreDeUnPcGamerDaClicEnLaLupaYSeleccionaAleatoriamenteUnaOpcion(String modelo) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoAleatorio.on(modelo));
    }

    @Then("^ella podra ver el (.*) seleccionado$")
    public void ellaPodraVerElPcGamerSeleccionado(String modelo) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(ProductoUI.LBL_PRODUCTO.of(modelo)), WebElementStateMatchers.containsText(Global.randomModel)));
    }


}
