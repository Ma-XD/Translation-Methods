# Лабораторная работа по написанию генераторов парсеров

## Задание

Необходимо написать некоторый упрощенный аналог генератора трансляторов. Рекомендуется брать за основу синтаксис ANTLR или Bison. Рекомендуется для чтения входного файла с грамматикой сгенерировать разборщик с помощью ANTLR или Bison.

### Реализовать

* Поддержку LL(1)-грамматик
* Поддержку синтезируемых и наследуемых атрибутов

Для тестирования сгенерировать с помощью вашего генератора калькулятор

## Навигация по проекту

* [g4 файл](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/antlr) для парсинга входной грамматики
* сгенерированный с помощью antlr [код](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/java) для парсинга входной грамматики
* [классы](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/kotlin/grammar) для работы с входной грамматикой
* [генераторы](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/kotlin/codebuilders) парсера и лексера
* запуск генераторов по входной грамматике [main](https://github.com/Ma-XD/Translation-Methods/blob/main/TM-lab-4/src/main/kotlin/Main.kt)
* входная [грамматика](https://github.com/Ma-XD/Translation-Methods/blob/main/TM-lab-4/src/main/resources/calc.txt) для калькулятора
* сгенерированные [парсер и лексер](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/main/kotlin/parser) для калькулятора
* [дерево разбора](https://github.com/Ma-XD/Translation-Methods/blob/main/TM-lab-4/src/main/resources/calc_tree.svg), которое парсер построил для выражения `16 / (3 + 1) / 2`
* [тесты калькулятора](https://github.com/Ma-XD/Translation-Methods/tree/main/TM-lab-4/src/test/kotlin)
