Feature: Navigarea între paginile de produse pentru Men's wear

  Scenario: Navigarea la Accessories
    Given utilizatorul este pe pagina principală
    When utilizatorul navighează la categoria Accessories din Men's wear
    Then produsele pentru categoria Accessories sunt afișate

  Scenario: Navigarea la Clothing
    Given utilizatorul este pe pagina principală
    When utilizatorul navighează la categoria Clothing din Men's wear
    Then produsele pentru categoria Clothing sunt afișate
