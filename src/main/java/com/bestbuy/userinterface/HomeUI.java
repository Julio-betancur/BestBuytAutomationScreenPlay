package com.bestbuy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public static final Target BTN_CERRAR_MODAL = Target.the("Boton para cerrar modal alerta").locatedBy("//button[@class='c-close-icon c-modal-close-icon']");
    public static final Target BTN_CERRAR_ENCUESTA = Target.the("Boton para cerrar encuesta").locatedBy("//button[@id='survey_invite_no']");

    public static final Target TXT_BARRA_BUSQUEDA = Target.the("Campo de texto para copiar producto").locatedBy("//input[@id='gh-search-input']");
    public static final Target BTN_BUSCAR_LUPA = Target.the("Boton para realizar busqueda").locatedBy("//button[@class='header-search-button']");

    public static final Target BTN_CATEGORIA_TABLETS= Target.the("Boton para entrar a la categoria tablets").locatedBy("(//a[@class='se-link-wrapper'])[7]");
}
