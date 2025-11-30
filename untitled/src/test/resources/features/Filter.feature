Feature: Filtrarea produselor pe pagina Mens

  Scenario: Verificarea filtrării produselor de pe pagina mens
    Given utilizatorul este pe pagina mens pentru filtrare
    When utilizatorul selectează filtrul după preț mic spre mare
    Then produsele ar trebui să fie afișate în ordinea corectă după preț
