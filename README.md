# Laborator5/6/7-Ungureanu
## Student
**Nume:** Ungureanu  
**Prenume:** Ana-Maria  


****Laborator 5 – Automatizare Google**
## Descriere proiect
Acest proiect este realizat pentru Laboratorul 5 la disciplina "Calitatea Produselor Program".  
Scopul proiectului este crearea unui script de automatizare folosind Python și Selenium WebDriver care:  

1. Deschide pagina [Google](https://www.google.com).  
2. Verifică dacă bara de căutare (antetul) Google este afișată.  
3. Efectuează o căutare pentru cuvântul „computer”.  

## Cerințe
- Python 3.x  
- Selenium WebDriver  
- ChromeDriver corespunzător versiunii Chrome instalate  

## Instrucțiuni de rulare
1. Instalează Selenium:  pip install selenium
2. Asigură-te că ai descărcat ChromeDriver și ai setat calea corectă în script (Lab5.py).
3. Rulează scriptul: python Lab5.py


# LL6_CPP – Proiect Automatizare Cucumber BDD

## Descriere
Acest proiect este dezvoltat pentru laboratorul de automatizare folosind **Cucumber BDD** și **Selenium WebDriver**. Scopul său este de a testa automat principalele funcționalități ale unei aplicații web e-commerce, incluzând:
- Căutarea produselor
- Filtrarea produselor
- Navigarea între categorii („Men’s wear”, „Clothing”, „Accessories”)
- Secțiunea Contact
- Adăugarea produselor în coș
- Vizualizarea rapidă a produselor (Quick View)
Proiectul este structurat conform principiilor **Page Object Model (POM)**, pentru a separa clar logica testelor de elementele paginilor web și a facilita mentenanța codului.
---
## Structura proiectului
LL6_CPP/
├─ src/
│ ├─ main/java/
│ ├─test/java/
│ │ └─ pages/ # Clase Page Object
│ │ └─ utils/ # Clase utilitare (DriverFactory)
│ │ └─ steps/ # Clase care implementează pașii scenariilor
│ │ └─ runners/ # Clase TestRunner pentru rularea testelor
│ └─ test/resources/features/ # Fișiere .feature Cucumber
│ ├─ AddToCart.feature
│ ├─ Contact.feature
│ ├─ Filter.feature
│ ├─ MensNavigation.feature
│ ├─ QuickView.feature
│ └─ Search.feature
├─ pom.xml # Fișier Maven cu dependențe și pluginuri

---
## Tehnologii și instrumente

- **Java 25**
- **Maven** – gestionare dependențe și rulare teste
- **Cucumber BDD 7.18.1** – definirea scenariilor în limbaj natural
- **Selenium WebDriver 4.18.0** – automatizarea browser-ului Chrome
- **WebDriverManager 5.8.0** – gestionarea automată a driverului Chrome
- **JUnit 4.13.2** – rularea testelor Cucumber
- **SLF4J Simple** – logare mesaje

---
## Clase principale
- **DriverFactory.java** – inițializează și gestionează driverul Selenium, cu URL de bază setat.
- **Hooks.java** – clasa Cucumber care inițializează driverul înainte de fiecare test.
- **TestRunner.java** – clasa care leagă fișierele `.feature` de pașii definiți în `steps/` și configurează rularea testelor.





