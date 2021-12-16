package com.bestbuy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductoUI {
    public static final Target LBL_PRODUCTO = Target.the("Titulo del producto seleccionado").locatedBy("//h1[@class='heading-5 v-fw-regular']");
    public static final Target BTN_GUARDAR_PRODUCTO = Target.the("Boton para guardar el producto").locatedBy("//button[@class='save-for-later-save']");
    public static final Target BTN_VER_PRODUCTOS_GUARDADOS = Target.the("Boton para ver los productos guardados").locatedBy("//button[@class='c-button-unstyled plButton savedItems-button']");
}
