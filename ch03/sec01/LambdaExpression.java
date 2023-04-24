package ch03.sec01;

import java.util.function.Function;

public class LambdaExoression{
    public static void main(String[] args){
        String str = "Hello, world!";
        // создаем ссылку на метод length() класса String
        Function<String, Integer> strLenghFunction = String::length;
        // вызываем метод length() через ссылку
        int strLength = strLengthFunc.apply(str); 
        // Пример ссылки на конструктор
        // создаем ссылку на конструктор класса String
        Supplier<String> stringSupplier = String::new;
        // вызываем конструктор через ссылку
        String newString = stringSupplier.get(); 
    }
}

/*
* в Lisp - функциональный язык 
* Функциональное программирование для параллельного и событийно-ориентиванного програмиирования (реактивного)
* Интерефейс - подтип класса. 
* Все переменные интерфейса - статические и конечные(неизменяемые)
* Интерфейсы Comparable Comparator - для сравнения обьектов
* Лямбда-выражение - блок кода, который может быть выполнен в последующий момент времени 
* По ссылкам на методы и конструкторы происходит обращение к им без их вызова
* Лямбда-выражения и локальные внутренне классы имеют доступ к конечным(final) переменным из обьемляющей оласти действия
*
*
*
*
*/