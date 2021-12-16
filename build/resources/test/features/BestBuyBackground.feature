#language en
Feature: Buscar un producto y guardarlo
  como usuario quiero buscar una scooter y guardarla para poder comprarla en el futuro

  Background:
    Given que Maria esta en la pagina principal de bestbuy https://www.bestbuy.com/

  Scenario: Buscar producto y guardarlo
    When ella busca un producto y lo guarda
      | busqueda |
      | scooter  |
    Then ella podra ver el producto guardado
