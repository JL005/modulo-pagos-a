Feature: Selección de múltiples métodos de pago

  Scenario: Verificar disponibilidad de múltiples métodos de pago
    Given que soy un cliente que está realizando una transacción
    When llego al paso de selección de método de pago
    Then debería ver al menos dos opciones de métodos de pago disponibles

  Scenario: Seleccionar un método de pago
    Given que soy un cliente que está realizando una transacción
    And tengo al menos dos opciones de métodos de pago disponibles
    When selecciono un método de pago
    Then debería ver la confirmación de mi selección
