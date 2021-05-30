Feature: Order creation in Demo Web Shop

  @test
  Scenario: Navigate to URL and Validate Login page
    Given launch site using chrome
    When click on login button
    Then title should be "Welcome, Please Sign In!"
    Given login page is displayed
    When enter user id as "testdemowebshop@gmail.com" and  password as "Test123".
    And hit login button
    Then Account Id should be "testdemowebshop@gmail.com".
    When clear cart if items are available
    And choose books category
    And select a book from the list displayed
    And get the price details and enter the quantity as"3".
    And Add items to cart and validate the Sub-Total
    When click on check out button
    Then Address section will be displayed and select New Address
    And enter mandatory fields in Billing address and click on continue
    Then select the Shipping Address as same as Billing Address and click on continue
    When choose  Next Day Air as shipping method and click on continue
    Then Payment section will be dispayed choose COD  as payment and click on continue
    Then You will pay by COD message will be displayed and click on continue
    When click on Confirm Order
    Then Your order has been successfully processed message will be displayed
    And Print order number and click on continue
    When click on logout button and logout successful
