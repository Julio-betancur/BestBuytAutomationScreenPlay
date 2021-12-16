package com.bestbuy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ListaProductosUI {
    public static final Target BTN_PRODUCTO_ALEATORIO = Target.the("Boton para dar clic a un producto aleatorio").locatedBy("//h4[@class='sku-header']/a");
    public static final Target BTN_PRODUCTO1 = Target.the("Boton para dar clic a el primer producto de la lista").locatedBy("(//h4[@class='sku-header'])[1]/a");

}
