@regression
Feature: Search functionality
  As a user I should be able to search cars

  Background:
    Given I am on homepage
    And I mouse hover on "buy + sell" tab

  @smoke
  Scenario Outline: Search the buy car with model
    When I click "Search Cars" link
    Then I navigate to "New & Used Car Search" page
    And I select make "<make>"
    And I select model "<model>"
    And I select location "<location>"
    And I select price "<price>"
    And I click on Find My Next Car tab
    Then I should see the make "<make>" in results
    Examples:
      | make       | model     | location            | price |
      | BMW        | X5        | NSW - Central Coast | 50000 |
      | Audi       | A5        | WA - Perth          | 50000 |
      | Hyundai    | Imax      | NSW - Sydney        | 40000 |
      | Mitsubishi | Outlander | SA - North          | 60000 |
      | Honda      | Odyssey   | VIC - All           | 50000 |

#  @sanity
  Scenario Outline: Search the used car with model
    When I click "Used" link
    Then I navigate to "Used Cars For Sale" page
    And I select make "<make>"
    And I select model "<model>"
    And I select location "<location>"
    And I select price "<price>"
    And I click on Find My Next Car tab
    Then I should see the make "<make>" in results
    Examples:
      | make   | model    | location       | price |
      | Holden | Trax     | SA - All       | 20000 |
      | Kia    | Cerato   | WA - All       | 30000 |
      | Fiat   | Freemont | WA - Perth     | 40000 |
      | Nissan | Navara   | QLD - Brisbane | 30000 |
      | Chery  | J11      | Any Location   | 25000 |


