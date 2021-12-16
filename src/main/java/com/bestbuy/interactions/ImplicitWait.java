package com.bestbuy.interactions;

import com.bestbuy.driver.SeleniumWebDriver;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.concurrent.TimeUnit;

public class ImplicitWait  implements Interaction {
    private int segundos;

    public ImplicitWait(int segundos){
        this.segundos = segundos;
    }


    //Serenity y selenium son frameworks para automatizar
    //Cucumber es una herramienta para crear casos de prueba usando lenguage gherkin - traduce gherkin en metodos de java
    //POM Y screenplay son patrones de diseño
    @Override
    public <T extends Actor> void performAs(T actor) {
        SeleniumWebDriver.driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    public static Performable tiempo(int segundos){
        return Instrumented.instanceOf(ImplicitWait.class).withProperties(segundos);
    }
}
