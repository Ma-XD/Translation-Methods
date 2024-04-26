# Лабораторная работа по написанию генераторов парсеров

Необходимо написать некоторый упрощенный аналог генератора трансляторов. Рекомендуется брать за основу синтаксис ANTLR или Bison. Рекомендуется для чтения входного файла с грамматикой сгенерировать разборщик с помощью ANTLR или Bison.

* LL(1)-грамматики, нисходящий разбор
* Поддержка синтезируемых и наследуемых атрибутов
* Для тестирования сгенерировать с помощью вашего генератора калькулятор

### Навигация по проекту

* [g4 файл для парсинга входной грамматики](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/antlr)
* [сгенерированный с помощью antlr код для парсинга входной грамматики](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/java)
* [классы для работы с входной грамматикой](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/kotlin/grammar)
* [генераторы парсера и лексера](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/kotlin/codebuilders)
* [сгенерированные парсер и лексер](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/kotlin/parser)
* [тесты калькулятора](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/test/kotlin)
