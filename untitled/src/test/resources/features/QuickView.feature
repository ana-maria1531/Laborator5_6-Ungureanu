Feature: Quick View

  Scenario: Verificarea Quick View pentru doua produse
    Given utilizatorul este pe pagina mens pentru Quick View
    When utilizatorul deschide Quick View pentru primul produs
    And utilizatorul deschide Quick View pentru al doilea produs
    Then URL-urile paginilor de produs sunt diferite



