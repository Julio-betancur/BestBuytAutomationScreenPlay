package com.bestbuy.tasks;

import com.bestbuy.globalVar.Global;
import com.bestbuy.interactions.ImplicitWait;
import com.bestbuy.userinterface.HomeUI;
import com.bestbuy.userinterface.ListadoTabletsUI;
import com.bestbuy.userinterface.PaisesUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.Keys;

public class BuscarTablets implements Task {

    private String marca;

    public BuscarTablets(String marca) {
        this.marca = marca;
    }

    public static Performable on(String marca){
        return Instrumented.instanceOf(BuscarTablets.class).withProperties(marca);
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
                Click.on(HomeUI.BTN_CATEGORIA_TABLETS),
                Enter.theValue(marca).into(ListadoTabletsUI.TXT_BUSQUEDA_MARCA),
                Click.on(ListadoTabletsUI.BTN_SELECCIONAR_MARCA)
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Global.randomModel = ListadoTabletsUI.BTN_PRIMERA_TABLET.resolveFor(actor).getText(); //Guardar titulo en variable global

        actor.attemptsTo(
                Click.on(ListadoTabletsUI.BTN_PRIMERA_TABLET)
        );
    }
}
