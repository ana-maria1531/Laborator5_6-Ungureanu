Feature: Căutare produse

  Scenario: Căutare produs existent
    Given utilizatorul este pe pagina principală pentru căutare
    When utilizatorul caută produsul "Analog Watch"
    Then produsul "Analog Watch" a fost găsit
