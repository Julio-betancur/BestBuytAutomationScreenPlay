package com.bestbuy.stepdefinitions;


import com.bestbuy.globalVar.Global;
import com.bestbuy.models.Modelos2;
import com.bestbuy.tasks.BuscarTablets;
import com.bestbuy.tasks.GuardarProducto;
import com.bestbuy.userinterface.ListaGuardadosUI;
import com.bestbuy.userinterface.ListadoTabletsUI;
import com.bestbuy.userinterface.ProductoUI;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;


import javax.swing.text.GapContent;
import java.io.IOException;
import java.util.List;

public class BestBuyHibridoStepDefinitions {

    //Before cucumber: define las variables de usuario e instancia al actor
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }


    @When("^ella ingresa a la seccion de tablets y selecciona una marca$")
    public void ella_ingresa_a_la_seccion_de_tablets_y_selecciona_una_Microsoft(List<Modelos2> mod2) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarTablets.on(mod2.get(0).getMarca()));
    }

    @Then("^ella podra ver tablets de esa marca$")
    public void ella_podra_ver_tablets_de_esa_Microsoft() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(ProductoUI.LBL_PRODUCTO.of()), WebElementStateMatchers.containsText(Global.randomModel)));
    }

}
