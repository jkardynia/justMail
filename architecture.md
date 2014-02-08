Architektura
===================
System sk�ada si� z trzech g�ownych pakiet�w:

config
=========
Tutaj powinny znaje�� si� definicje klas zawieraj�cych metody fabrykuj�ce tworz�ce serwisy, kt�re mog� by� wykorzystane np. w DI.

web
========
Miejsce na elementy systemu dedykowane dla aplikacji webowej (kontrolery, widoki i model maj�cy zastosowanie
jedynie w aplikacji webowej (np. koszyk))

core
=======
Logika boznesowa systemu. Tutaj znajduje si� g��wny model, kt�ry powinien by� odseparowany od innych modeli (Bounded Context).
Sk�ada si� on z kilku podpakiet�w:

domain
=====
Stanowi serce systemu. Powinien zawiera� Agregaty, Policy itp.. Mo�na tutaj tak�e wydzieli� serwisy domenowe (DAO itp), jednak�e wi�kszo�� system�w raczej nie b�dzie
na tyle du�a by by�o to konieczne.

persistence
=====
Encje anemiczne dla ORM.

service
=====
Serwisy aplikacyjne. Za ich po�rednictwem powinna nast�powa� komunikacja z modelem zawartym w tym Bounded Contexcie.

dto
=====
Serwisy aplikacyjne powinny si� komunkowa� ze �wiatem za pomoc� DTO (Request/Response, kt�ry przyjmuj�/zwracaj�), poza model nie powinny by� zwraca encje, kt�re mog� pracowa� bezpo�rednio na danych.
Zapewne w wi�kszo�ci niedu�ych aplikacji narzut zwi�zany z przepisywaniem danych z encji na DTO b�dzie zbyt du�y by je stosowa�.