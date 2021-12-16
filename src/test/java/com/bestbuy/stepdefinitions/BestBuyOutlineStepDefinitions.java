package com.bestbuy.stepdefinitions;

import com.bestbuy.globalVar.Global;
import com.bestbuy.tasks.BuscarTablets;
import com.bestbuy.userinterface.ProductoUI;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;

public class BestBuyOutlineStepDefinitions {

    //Before cucumber: define las variables de usuario e instancia al actor
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^ella ingresa a la seccion de tablets y selecciona una (.*)$")
    public void ellaIngresaALaSeccionDeTabletsYSeleccionaUnaMicrosoft(String marca) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarTablets.on(marca));
    }


    @Then("^ella podra ver tablets de esa (.*)$")
    public void ellaPodraVerTabletsDeEsaMicrosoft(String marca) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(ProductoUI.LBL_PRODUCTO.of(marca)), WebElementStateMatchers.containsText(Global.randomModel)));
    }

}
