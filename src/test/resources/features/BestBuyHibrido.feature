#language: en
Feature: Busqueda de tablets
  Yo como usuario quiero buscar tablets marca microsoft para poder comprarlas

  Background:
    Given que Maria esta en la pagina principal de bestbuy https://www.bestbuy.com/

  Scenario Outline: <Escenario>
    When ella ingresa a la seccion de tablets y selecciona una marca
      | marca     |
      | Microsoft |
    Then ella podra ver tablets de esa marca

    Examples:
      | Escenario                | url                      |
      | Buscar tablets por marca | https://www.bestbuy.com/ |