package com.bestbuy.tasks;

import com.bestbuy.globalVar.Global;
import com.bestbuy.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Screenshots;

public class GuardarProducto implements Task {

    private String busqueda;

    public GuardarProducto(String busqueda) {
        this.busqueda = busqueda;
    }

    public static Performable on(String busqueda) {
        return Instrumented.instanceOf(GuardarProducto.class).withProperties(busqueda);
    }

    @Screenshots(onlyOnFailures=true)
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
                Enter.theValue(busqueda).into(HomeUI.TXT_BARRA_BUSQUEDA),
                Click.on(HomeUI.BTN_BUSCAR_LUPA)
        );

        Global.randomModel = ListaProductosUI.BTN_PRODUCTO1.resolveFor(actor).getText(); //Guardar titulo en variable global

        actor.attemptsTo(
                Click.on(ListaProductosUI.BTN_PRODUCTO1),
                Click.on(ProductoUI.BTN_GUARDAR_PRODUCTO),
                Click.on(ProductoUI.BTN_VER_PRODUCTOS_GUARDADOS),

                //Espera explicita hasta que el elemento este disponible
                Wait.until(
                        WebElementQuestion.the(ListaGuardadosUI.LBL_PRODUCTO_GUARDADO) , WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds()

        );

    }
}
