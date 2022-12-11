# SocketExercise. Zadanie Rekrutacyjne.

W resources/sql/database.sql umieściłem sql, którymi utworzyłem bazę danych oraz tabele.

Dodatkowe pytania:
1. Co można poprawić w strukturze bazy?

W tabeli users dobrym rozwiązaniem byłaby zmiana loginu użytkownika na unikatowy (tak zrobiłem).

2. Jak po stronie serwera można zweryfikować czy nadawca komunikatu rzeczywiście jest
właścicielem danego konta w tabeli users?

Poprzez weryfikację polegajającą na wpisaniu hasła, jeśli użytkownik poda nieprawidłowe to nie będzie miał dostępu do danych (tak zrobiłem).

3. Czy zaproponowane przez Ciebie rozwiązanie można zoptymalizować, aby pozwalało
obsłużyć jednocześnie komunikaty od kilku klientów?

Można wykorzystać wielowątkowość i dzięki temu obsługiwać więcej klientów (tak zrobiłem).
