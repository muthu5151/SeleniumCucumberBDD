@DemoShop
Feature: Addding product to my cart/wishlist in Demoshop application

  @TC001
  Scenario Outline: verify_the_selected_items_in_my_wishlist_<TC_ID>
    Given I add "<item_count>" different product to my wish list
    When I view my wishlist table
    Then I find total "<item_count>" selected items in my Wishlist

    Examples: 
      | TC_ID | item_count |
      |   001 |          4 |

  @TC002
  Scenario Outline: verify_the_<rate>_price_item_in_my_cart_<TC_ID>
    Given I search for "<rate>" price product
    When I am able to add the "<rate>" price item to my cart
    Then I am able to verify the item in my cart

    Examples: 
      | TC_ID | rate   |
      |   002 | lowest |
