Feature: Ver detalles de reserva antes de finalizar la transacción

  Scenario: Verificar visualización de tarifa e impuestos de la reserva
    Given que soy un cliente que ha realizado una reserva
    When accedo a la sección de detalles de la reserva
    Then debería ver la tarifa de la reserva
    And debería ver los impuestos aplicados


  Scenario: Verificar visualización de detalles adicionales de la reserva
    Given que soy un cliente que ha realizado una reserva
    When accedo a la sección de detalles de la reserva
    Then debería ver los detalles adicionales de la reserva

  Scenario: Verificar opción de revisar y confirmar la información
    Given que soy un cliente que ha realizado una reserva
    When accedo a la sección de detalles de la reserva
    Then debería tener la opción de revisar y confirmar la información