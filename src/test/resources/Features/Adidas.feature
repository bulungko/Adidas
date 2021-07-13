# new feature
# Tags: optional
    #Customer navigation through product categories: Phones, Laptops and Monitors
    #• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
    #• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    #• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
    #• Click on "Place order".
    #• Fill in all web form fields.
    #• Click on "Purchase"
    #• Capture and log purchase Id and Amount.
    #• Assert purchase amount equals expected.
    #• Click on "Ok"

Feature: Adidas search and cart functionality
  User Story:As a user, I should be able to add 2 Laptops and delete one in cart. And place order.

  @wip
  Scenario: Adidas search and cart functionality
    Given user is on the Demobraze home page
    When user search Laptop to add Sony vaio i5 to cart
    And user accept pop up confirmation
    And user search Laptop to add Dell i7 8gb to cart
    And user accept pop up confirmation
    And user navigate to cart
    And user should be able to delete Dell i7 8gb
    And user click on place order
    And user fill in all web form fields
    And user click on purchase
    Then user should see log purchase Id and Amount

