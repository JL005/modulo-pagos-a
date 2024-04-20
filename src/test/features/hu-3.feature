Feature: Ingresar datos del método de pago

  Scenario: Verificar formulario de ingreso de datos del método de pago
    Given que soy un cliente que está realizando un pago
    When llego al paso de ingresar los datos del método de pago
    Then debería ver un formulario para ingresar los datos del método de pago

  Scenario: Ingresar datos válidos del método de pago
    Given que soy un cliente que está realizando un pago
    And he llegado al paso de ingresar los datos del método de pago
    When ingreso datos válidos del método de pago
    Then debería ver la confirmación de los datos ingresados

  Scenario: Cancelar ingreso de datos del método de pago
    Given que soy un cliente que está realizando un pago
    And he llegado al paso de ingresar los datos del método de pago
    When decido cancelar el ingreso de datos
    Then debería regresar al paso anterior en el cual elijo el método de pago