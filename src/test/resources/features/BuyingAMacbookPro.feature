Feature: Buying a MacBook Pro on the website
As an online customer
I want to choose a MacBook with accessories on the website
So so that I can buy it online


Scenario: A MacBook 15” with accessories can be ordered on the website
Given I navigate to Apple website
And I choose to browse Mac
And I select MacBookPro
And I initiate buying a MacBookPro
And I select screen size color and processor options as below to navigate to customize page
  | Option          | Specification           |
  | Screen          |              15-inch    |
  | Processor       |              2.9GHz    |
  | Colour          |              Silver     |
  | Model           |         MacBook Pro     |

And I select additional software as below and add to bag to navigate to accessories page
  | Option          | Specification        |
  | Software        |          Logic Pro X |
And I add accessories as below
  | Option          | Specification        |
  | DisplayAdapter  | USB-C to USB Adapter  |
Then I navigate to review bag page to place the order and verify order
And I validate the total price and VAT of the items in my bag
  | PriceItem       | Value                 |
  | TotalPrice      | £2,917.99             |
  | VAT             | £486.34               |



