/* 
*Нестатический метод - вызов только c родительского.
*Статический метод - вызов с любого класса.
*Стасический метод не вызываються для объектов.
*Типы: 5 целых, 2 с плавающей точкой,1 символьный, 1 логический.
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

        System.out.println(Integer.MAX_VALUE);
    }
}

/*
* Static - не оперирует никакими обьектами.
* Пакет состоит их взаимосвязанных классов.
* int   4 бт    ...                 I
* long  8 бт    ...                 L
* short 2 бт    -32768 до 32767     -
* byte  1 бт    -128 до 127         -
*
* Integer.MIN_VALUE
* Integer.MAX_VALUE ...
*
* BigInteger>long
* 16x = 0x
* 2X  = 0b
* 8x  = 0 (не использовать)
* 0b1111_0100_0000_0101_0111
* Byte.toUnsignedInt(x) [0;255]
*
* float  4 бт
* double 8 бт (двойная точность - чаще использовать)
* Double.POSITIVE_INFINITY
* Double.NEGATIVE_INFINITY
* Double.NaN (не число)
* 
*/