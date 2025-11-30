Feature: Verificarea funcționalității secțiunii Contact

  Scenario: Navigarea către pagina Contact
    Given utilizatorul este pe pagina principală pentru contactare
    When utilizatorul accesează secțiunea Contact
    Then pagina Contact se deschide corect
