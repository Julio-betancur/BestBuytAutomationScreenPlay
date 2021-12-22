package com.bestbuy.stepdefinitions;

import com.bestbuy.tasks.BuscarProducto;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.io.IOException;

public class BestBuyFailStepDefinitions {

    //Before cucumber: define las variables de usuario e instancia al actor
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^ella ingresa un (.*), da clic en la lupa$")
    public void ellaIngresaUnScooterDaClicEnLaLupa(String articulo) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProducto.on(articulo));
    }


    @Then("^ella podra ver el (.*) buscado$")
    public void ellaPodraVerElScooterBuscado(String articulo) {

    }

}
