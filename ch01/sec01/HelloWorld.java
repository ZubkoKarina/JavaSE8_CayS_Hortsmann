package ch01.sec01;
import java.math.BigInteger;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Console;

public class HelloWorld{
    public static final int DAYS_PER_WEEK = 7;
    public static void main(String[] args){
        System.out.println("Hello World!");
        Random gen = new Random();
        System.out.println(gen.nextInt());
        System.out.println(gen.nextInt());
        System.out.println(gen.nextInt());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(DAYS_PER_WEEK);
        BigInteger n = BigInteger.valueOf(37562763528364586L);
        BigInteger k = new BigInteger("37562763528364586");
        BigInteger r = BigInteger.valueOf(5).multiply(n.add(k));
        System.out.println(n);
        System.out.println(k);
        System.out.println(r);
        StringBuilder builder = new StringBuilder();
        while(builder.length()<20){
            builder.append("IjmfmlkmsDNLD");
        }
        String result = builder.toString();
        String[] arr = result.substring(1, 10).split("m");
        System.out.println(Arrays.toString(arr)); 
        String str = "Karina Zubko";
        int[] codePoints = str.codePoints().toArray();
        System.out.println(Arrays.toString(codePoints));
        Console terminal = System.console();
        String username = terminal.readLine("User name: ");
        char[] passwd = terminal.readPassword("Password: ");
        ArrayList<String> names = new ArrayList<>();
        names.add("Karina");
        names.add("Tim");
        names.remove(0);
        String first = names.get(0);
        names.set(0, "Mary");
        for (String name : names) {
            System.out.println(name);
        }
    }
}

/*
* Нестатический метод - вызов только c родительского.
* Статический метод - вызов с любого класса.
* Стасический метод не вызываються для объектов.
* Типы: 5 целых, 2 с плавающей точкой,1 символьный, 1 логический.
* String = кодовые точки Юникод в UTF-16.

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
* Double.POSITIVE_INFINITY          1.0/0.0     isInfinite()
* Double.NEGATIVE_INFINITY          0.0/0.0     isFinite()
* Double.NaN (не число)             sqrt(-n)    if(Double.isNaN(x))
* 
* при System.out.println(2.0-1.1) вывод 0,89999999999999999 а не 0,9
* потому что числа с пл.точкой представлены в 2х системе счисления
* точные расчеты -> BigDecimal
* 
* char 'J' = 74 = (16x)4A = "U004A LatinCaption Letter J"
* 'J' == '\u004A' 
* 
* variable  => xXxx
* class     => Xxxx
* constant  => XXXX
*
* Обьявление переменной как можно позже! Прям перед использованием!
* final int DAYS_PER_WEEK = 7;                      константа
* public static final int DAYS_PER_WEEK = 7;        константа вне тела метода
* в System есть "public static final PrintStream out" == "System.out"
*
* public static final int MONDAY  = 0;
* public static final int TUESDAY = 1; =>
* enum Weekday{MON, TUE, WED, THU, FRI, SAT, SUN}; 
* состоит из Weekday.MON и тд.
* Weekday startDay = Weekday.MON;
* 
* лево  ассоциативность - 3-4-5   -> (3-4)-5
* право ассоциативность - i-=j-=k -> i-=(j-=k)
* 
* [].()                                         л
* !~++--+-()new                                 п
* * / %                                         л
* +-                                            л
* <<>> >>>                                      л
* <><=>=instanceof                              л
* == !=                                         л
* &                                             л
* ^                                             л
* |                                             л
* &&                                            л
* ||                                            л
* ?:                                            л
* = += -= *= /= %= <<= >>= >>>= &= ^= |=        п
*
* Math.floorMod(position+adjustment, 12)        всегда значения [0;11]
* n++   инкремент
* n--   декремент
*
* (1000000000*3)                        = -1294967296 превышает int
* Math.multiplyExact(1000000000, 3)     = исключение
* Math.addExact() Math.subtractExact() Math.incrementExact() Math.decrementExact() Math.nagateExact()
*
* преоразование тепов если есть double -> double,float ->, long -> long иначе int.
* Math.toIntExact() возращяет исключение если приведение типов прошло некорректно
*
* тернарный if - (time<12)?"am":"pm"
*
* BigInteger и BigDecimal из java.math
* valurOf() вернет long типу BigInteger
*
* соединение строк с розделителем String names = String.join(",", "Peter", "Paul", "Mary");
* или StringBuilder
*
* разделение строк - substring()
* стравнние строк  - equals() или equalsIgnoreCase()
*
* не использовать Scanner для пароля(видно в терминале) использовать Console
*
* java mypackage.MainClass<input.txt>output.txt 
* данные читаються в поток System.in из файла imput.txt в output.txt из потока System.out
*
* форматирование вывода
* d                     10х
* x X                   16х
* o                     8х
* f F                   пл. точка фикс. точность
* e E                   пл. точка в экс. форме
* g G                   пл. точка в общей форме
* a A                   пл. точка 16х
* s S                   строка
* c C                   символ
* b B                   лог. значение
* h H                   хеш-код
* t T                   дата и время
* %                     знак процента
* n                     разделитель строк
*
* break outer - выход из вложеного цикла
* а желательно не использовать break и continue 
* ArrayList динамичесикий массив
* дефолтные значения для заполнения массивов: числовые = 0, логические = false, обьекты = null
* primes = new int[] {1, 5, 3, 2, 6, 4, 3}; иниц. массива с указанием имени 
* int[] primes = {1, 4, 5, 6, 3, 5}; 
*
* int[0] или int[]{} массивы нулевой длинны a.length() => 0
* int[] = {null}                            a.length() => NullPointerException
* Списочные массивы:
* ArrayList<String> friends = new ArrayList<>(); тоже самое 
* ArrayList<String> friends = new ArrayList<String>();
* friends.add("Peter");
* friends.remove(a);
* String first = friends.get(0);            получение элемента
* friends.set(1, "Mary");                   замена элемента другим
* недопустимо использовать примитивные типы для обобщенных классов
* для этого используеться класс оболочка: Integer, Byte, Short, Long, Character, Float, Double, Boolean
*
* в операциях == и != сравниваються ссылки а не содержание !
* 
* копирование массива: 
* int[] copiedPrimes = Array.copyOf(primes, primes.length);
* ArrayList<String> copiedFriends = new ArrayList<>(friends);
* обычный массив в списочный: 
* String[] names = ...;
* ArrayList<String> friends = new ArrayList<>(Arrays.asList(names));
* спис. массив в обычный:
* String[] names = friends.toArray(new String[0]);
* 
* заполнение массивов из классов Array и Collections: 
* Arrays.fill(numbers, 0);                  обычный массив   int[]
* Collections.fill(friends, "")             списочный массив ArrayList<String>
*
* сортировка массивов из классов Array и Collections: 
* Array.sort(names);
* Collections.sort(friends);
* 
* Collections.reverse(names);       -
* Collections.shuffle(names);       перетаскивание в производном порядке
*
* Аргументы командной строки: 
* если вызвать програму по команде: java Greting -g cruel world
* где элемент args[0] = "-g"
*             args[1] = "cruel"
*             args[2] = "world"
*
* многомерный обход об. массив: 
* int[][]square = new int[4][4];
* обход многомерного массива:
* for(int[] row: triangle){
*    for(int element : row){
*       System.out.printf("%4d", element);
*    }
*    System.out.printin();
* }
* для выводу списка элементов 2-мерного массива:
* System.out.println(Arrays.deepToString(triangle));
* многомерные списочные масивы - не предусмотрены:
* ArrayList<ArrayList<Integer>> и тд.
*
*
*
*
*
*
*
*
*
*
*
*
чем отличаеться массив с 0 длиной и масив с елементами null стр 59 по книжке?
ArrayList<>(); что будет если во вторих ромбах укажу другой тип
почему нельзядля обобщенных класов использовать примитивные типы 
*
*
*
*/