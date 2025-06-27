# Project_1
# Easy console task menager

## Opis

Ten program to **konsolowy menedżer zadań**, pozwalający na zarządzanie listą zadań przechowywanych w pliku `tasks2.csv`. Umożliwia **dodawanie**, **usuwanie**, **przeglądanie** oraz **zapisywanie** zadań. Program obsługuje wejście użytkownika w języku angielskim oraz numeryczne.

## Funkcjonalności

- **Menu główne**  
  Po uruchomieniu programu wyświetlane jest menu z dostępnymi opcjami:
    - `add` – **dodaj nowe zadanie**
    - `remove` – **usuń wybrane zadanie**
    - `list` – **wyświetl wszystkie zadania**
    - `exit` – **zapisz zadania i zakończ program**

- **Dodawanie zadania**  
  Użytkownik wprowadza:
    - opis zadania,
    - datę wykonania (format: `YYYY-MM-DD`),
    - informację, czy zadanie jest ważne (`true/false`).

- **Możliwość powrotu do menu**
    - W każdej chwili podczas wyboru opcji możesz wrócić do menu głównego, wpisując 0 lub back.

- **Wyświetlanie zadań**  
  Program pokazuje listę wszystkich zadań wraz z numeracją.

- **Usuwanie zadania**  
  Użytkownik wybiera numer zadania do usunięcia. Program sprawdza poprawność numeru.

- **Zapis i odczyt z pliku**  
  Zadania są:
    - wczytywane z pliku `tasks2.csv` przy starcie programu,
    - zapisywane do niego przy wyjściu z programu.  
      Jeśli plik nie istnieje, zostaje automatycznie utworzony.
  

- **Walidacja danych**
  Program sprawdza poprawność wprowadzanych danych, takich jak numer zadania do usunięcia czy odpowiedzi podczas dodawania zadań. W przypadku błędnych danych prosi o ponowne wprowadzenie informacji.

- **Bezpieczeństwo**  
  Program obsługuje niepoprawne dane wejściowe oraz błędy podczas operacji na plikach.

## Struktura pliku zadań

Każda linia pliku `tasks2.csv` ma postać:
```
opis_zadania, data_wykonania, czy_ważne
```

Przykład:
```
Zrobić zakupy, 2024-06-04, true
Nauczyć się Javy, 2024-06-10, false
```

## Uruchomienie

1. Skompiluj program.
2. Upewnij się, że w katalogu programu znajduje się plik `tasks2.csv` (może być pusty).
3. Uruchom program z poziomu konsoli.
4. Postępuj zgodnie z poleceniami wyświetlanymi w menu.

