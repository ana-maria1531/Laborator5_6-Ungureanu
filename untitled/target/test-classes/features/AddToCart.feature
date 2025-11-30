Feature: Verificarea funcționalității de adăugare a unui produs în coș

  Scenario: Adăugarea primului produs în coș și verificarea subtotalului
    Given utilizatorul este pe pagina mens
    When utilizatorul adaugă primul produs în coș
    Then subtotalul coșului este corect
