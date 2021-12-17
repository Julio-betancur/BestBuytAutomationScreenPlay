#language: en
Feature: Busqueda de productos
  Como usuario quiero buscar articulos para poder comprarlos

  Scenario Outline: <Escenario><articulo>
    Given que Maria esta en la pagina principal de bestbuy <url>
    When ella ingresa un <articulo>, da clic en la lupa
    Then ella podra ver el <articulo> buscado

    Examples:
      | Escenario                   | articulo | url                      |
      | Realizar busqueda productos | scooter  | https://www.bestbuy.com/ |
