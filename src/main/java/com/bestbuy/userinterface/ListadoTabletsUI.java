package com.bestbuy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ListadoTabletsUI {
    public static Target TXT_BUSQUEDA_MARCA = Target.the("Campo de texto para copiar la marca").locatedBy("//input[@class='tb-input search-bar-control form-control']");
    public static Target BTN_PRIMERA_TABLET = Target.the("Boton para dar clic a la primera tablet de la lista").locatedBy("(//h4[@class='sku-header'])[1]/a");
    public static Target BTN_SELECCIONAR_MARCA = Target.the("Boton seleccionar la marca").locatedBy("//button[@class='c-button-link button']");


}
