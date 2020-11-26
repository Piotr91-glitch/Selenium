Feature:Buy a jumper Hummingbird
 Scenario: buy jumper with  rabat and find medium size
    Given setup
    Then check rabat for jumper
    And choose medium size,choose five art and add to shopping cart
    Then move to options "checkout"
    And confirm address
    Then Will choose pick up
    And Select payment options
    Then click on the order with an obligation to pay
    And make screenshot with confirm order and price

