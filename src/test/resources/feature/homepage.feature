Feature: E-Commerce flow
@wip
  Scenario: Complete end-to-end checkout with Stripe
    Given the user is on the product detail page for "swing"
    When user clears popup
    And the user adds the product to the cart
    And the user clicks on cart Icon
    And the user applies coupon "EVERYDAY"
    And user click on apply
    And the user click on checkout
    And the user fills in shipping details with name  "Aarav Sharma",email  "aarav@email.com",address "123 Tech Park Road", city "Hyderabad" and postal code "500081"
    And the user continues to payment
    And the user selects payment method "paylater"
    And the user selects pay later with mobile number "7569478359"
    And the user reviews and confirms the order
    Then an order confirmation message "Thanks for shopping." should be displayed

  Scenario Outline: Complete checkout across different payment providers
    Given the user is on the product detail page for "<product>"
    When user clears popup
    And the user adds the product to the cart
    And the user clicks on cart Icon
    And the user applies coupon "<couponCode>"
    And user click on apply
    And the user click on checkout
    And the user fills in shipping details with "<name>","<email>","<address>","<city>","<postalCode>"
    And the user continues to payment
    And the user selects pay later with mobile number "<number>"
    And the user reviews and confirms the order
    Then an order confirmation message "<expectedMessage>" should be displayed

    Examples:
    |product  | name         | email             | address            | city      | postalCode | number     | expectedMessage      |
    |pot      | Aarav Sharma | aarav@gmail.com   | 123 Tech Park Road | Hyderabad | 500081     | 9876543210 | Thanks for shopping. |
    |plant    | Keerthi Rao  | keerthi@gmail.com | 45 Jubilee Hills   | Hyderabad | 500033     | 7578388857 | Thanks for shopping. |



