package com.bestbuy.tasks;

import com.bestbuy.userinterface.HomeUI;
import com.bestbuy.userinterface.PaisesUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class BuscarProducto implements Task {

    private String articulo;

    public BuscarProducto(String elemento) {
        this.articulo = elemento;
    }

    public static Performable on(String articulo) {
        return Instrumented.instanceOf(BuscarProducto.class).withProperties(articulo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaisesUI.BTN_SELECCION_PAIS),
                Enter.theValue(articulo).into(HomeUI.TXT_BARRA_BUSQUEDA),
                Click.on(HomeUI.BTN_BUSCAR_LUPA)
        );

    }
}
