Feature: Magento Test

  @TestCase02
  Scenario: 03. Place an order
    Given user on listing product page
    When user add 3 jackets into cart
    * user processed checkout
    * user fill out address
    * user placed order
    Then order should be successfully created