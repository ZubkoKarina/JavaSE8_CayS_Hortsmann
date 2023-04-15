/* 
*Нестатический метод - вызов только c родительского.
*Статический метод - вызов с любого класса.
*Стасический метод не вызываються для объектов.
*Типы: 5 целых, 2 с плавающей точкой, 1 логический.
*String = кодовые точки Юникод в UTF-16.
*/
package ch01.sec01;
import java.util.Random;

public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World!");

        Random gen = new Random();
        System.out.println(gen.nextInt());
        System.out.println(gen.nextInt());
        System.out.println(gen.nextInt());
    }
}

/*
* Static - не оперирует никакими обьектами.
* Пакет состоит их взаимосвязанных классов.
*   
*/