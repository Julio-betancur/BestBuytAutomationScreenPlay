package com.bestbuy.interactions;

import com.bestbuy.globalVar.Global;
import com.bestbuy.userinterface.ListaProductosUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

public class ClickRandom implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(5000);
        }catch (Exception ex){

        }

        Random random = new Random();
        //Creamos dos listas con WebElements
        List<WebElementFacade> listaBtnVideos = ListaProductosUI.BTN_PRODUCTO_ALEATORIO.resolveAllFor(actor);
        List<WebElementFacade> listaLblVideos = ListaProductosUI.BTN_PRODUCTO_ALEATORIO.resolveAllFor(actor);

        int randomNumber = random.nextInt(listaBtnVideos.size()); //Generamos numero al azar
        Global.randomModel = listaLblVideos.get(randomNumber).getText();
        listaBtnVideos.get(randomNumber).click();

        try {
            Thread.sleep(5000);
        }catch (Exception ex){

        }
    }

    //Metodo  que reemplaza el instanciamiento de la clase
    public static Performable on(){
        return Instrumented.instanceOf(ClickRandom.class).withProperties();
    }
}
