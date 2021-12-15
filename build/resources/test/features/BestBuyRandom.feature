#language: en
Feature: Busqueda de productos
  Como usuario quiero buscar productos para poder comprarlos

  Scenario Outline: <Escenario><producto>
    Given que Maria esta en la pagina principal de bestbuy <url>
    When ella ingresa el nombre de un <producto>, da clic en la lupa y selecciona aleatoriamente una opcion
    Then ella podra ver el <producto> seleccionado

    Examples:
      | Escenario                   | producto | url                      |
      | Realizar busqueda productos | pc gamer | https://www.bestbuy.com/ |
      | Realizar busqueda productos | ps4      | https://www.bestbuy.com/ |