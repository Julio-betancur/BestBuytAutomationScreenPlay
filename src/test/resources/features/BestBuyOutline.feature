#language: en
Feature: Busqueda de tablets
  Yo como usuario quiero buscar tablets marca microsoft para poder comprarlas

  Scenario Outline: <Escenario><marca>
    Given que Maria esta en la pagina principal de bestbuy <url>
    When ella ingresa a la seccion de tablets y selecciona una <marca>
    Then ella podra ver tablets de esa <marca>

    Examples:
      | Escenario                | marca     | url                      |
      | Buscar tablets por marca | Microsoft | https://www.bestbuy.com/ |
      | Buscar tablets por marca | UAG | https://www.bestbuy.com/ |
