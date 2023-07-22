Feature: SauceDemo

  Scenario: Login with valid account
    Given open web and navigate URL
    And login with <username> as username and <password> as password
    And click button login
    Then verify the titile of page is "Products" and the itemlist is displayed
    And sort the products by "Price (high to low)"
    Then verify the product list is sorted
    And open the highest product
    Then verify is "Sauce Labs Fleece Jacket" is the highest product with price "49.99"
		And add product to cart
		Then verify that the product "Sauce Labs Fleece Jacket" with price "49.99" is the product that appears in the cart
		And click checkout button
		Then verfify "Checkout" page
		And fill the required text field
		And click continue button
		Then verify that the product "Sauce Labs Fleece Jacket" with price "49.99" is the product that appears on "Overview"
		And click finish button
		Then verify order status and capture screen then rename it with <username>
		    
    Examples: 
    | username  								| password 				|
    | "standard_user" 					| "secret_sauce"	|
    | "performance_glitch_user"	|	"secret_sauce"	|
    
  Scenario: Login with locked out account
    Given open web and navigate URL
    And login with <username> as username and <password> as password
    And click button login
    Then appear error message
    
    Examples: 
    | username  								| password 				|
    | "locked_out_user" 				| "secret_sauce"	|
    
  Scenario: Login with problem account
    Given open web and navigate URL
    And login with <username> as username and <password> as password
    And click button login
    Then verify the titile of page is "Products" and the itemlist is displayed
    And sort the products by "Price (high to low)"
    Then product list not sorted
    
    Examples: 
    | username  						| password 				|
    | "problem_user" 				| "secret_sauce"	|