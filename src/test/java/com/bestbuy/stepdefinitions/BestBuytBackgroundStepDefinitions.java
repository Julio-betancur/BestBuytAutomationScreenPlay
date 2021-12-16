package com.bestbuy.stepdefinitions;

import com.bestbuy.globalVar.Global;
import com.bestbuy.models.Modelos;
import com.bestbuy.tasks.GuardarProducto;
import com.bestbuy.userinterface.ListaGuardadosUI;
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
import java.util.List;

public class BestBuytBackgroundStepDefinitions {

    //Before cucumber: define las variables de usuario e instancia al actor
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^ella busca un producto y lo guarda$")
    public void ellaBuscaUnProductoYLoGuarda(List<Modelos> mod) {
        OnStage.theActorInTheSpotlight().attemptsTo(GuardarProducto.on(mod.get(0).getBusqueda()));
    }


    @Then("^ella podra ver el producto guardado$")
    public void ellaPodraVerElProductoGuardado() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(ListaGuardadosUI.LBL_PRODUCTO_GUARDADO.of()), WebElementStateMatchers.containsText(Global.randomModel)));
    }
}
