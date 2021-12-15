package com.bestbuy.tasks;


import com.bestbuy.interactions.ClickRandom;
import com.bestbuy.interactions.ImplicitWait;
import com.bestbuy.userinterface.HomeUI;
import com.bestbuy.userinterface.PaisesUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;

public class BuscarProductoAleatorio implements Task {

    private String producto;

    public BuscarProductoAleatorio(String producto) {
        this.producto = producto;
    }

    //Crea instancia de la clase para poder llamar mtodo perfomAs
    public static Performable on(String producto) {
        return Instrumented.instanceOf(BuscarProductoAleatorio.class).withProperties(producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PaisesUI.BTN_SELECCION_PAIS)
        );

        //Validamos si aparece el modal y lo cerramos
        if (Visibility.of(HomeUI.BTN_CERRAR_MODAL).viewedBy(actor).asBoolean())
            actor.attemptsTo(
                    Click.on(HomeUI.BTN_CERRAR_MODAL)
            );


        actor.attemptsTo(
                Enter.theValue(producto).into(HomeUI.TXT_BARRA_BUSQUEDA),
                Click.on(HomeUI.BTN_BUSCAR_LUPA),
                ClickRandom.on()
                );

    }
}
