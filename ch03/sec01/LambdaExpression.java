package ch03.sec01;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExpression{
    public interface IntSequence{
        boolean hasNext();
        //если int next() не имеет реализации - есть абстракным
        //если класс реализует только некоторые из методов инерфейса, он должен быть abstract
        int next();
    }
    public static double average(IntSequence seq, int n){
        int count = 0;
        double sum = 0;
        while(seq.hasNext()&&count<n){
            count ++;
            sum+=seq.next();
        }
        return count == 0?0:sum/count;
    }
    public class SquareSequence implements IntSequence{
        private int i;
        public boolean hasNext(){
            return true;
        }
        public int next(){
            i++;
            return i*i;
        }
    }
    public interface IntConsumer{
        void accept(int value);
    }
    public static void repeat(int n, IntConsumer action){
        for(int i = 0; i < n; i++) action.accept(i);
    }
    public static void main(String[] args){
        String str = "Hello, world!";
        // создаем ссылку на метод length() класса String
        Function<String, Integer> strLengthFunction = String::length;
        // вызываем метод length() через ссылку
        int strLength = strLengthFunction.apply(str); 
        // Пример ссылки на конструктор
        // создаем ссылку на конструктор класса String
        Supplier<String> stringSupplier = String::new;
        // вызываем конструктор через ссылку
        LambdaExpression obj = new LambdaExpression();
        IntSequence squares = obj.new SquareSequence();
        double avg = average(squares, 100);
        System.out.println(avg);
        repeat(100, i -> System.out.println("Hello, World!" + (9-i)));
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
* Проверка, относиться ли обьекст к нужному типу - обьект instanceof Тип -> true если обьект есть экземпляром класса, у которого Тип в качестве супертипа
* Один интерфейс может розширять другой интерфейс:
* public interface Closeable{
*     void close();
* }
* public interface Channek extends Closeable{
*    boolean isOpen();
* }
* Класс может реализовать несколько интерфейсов: 
* public class FileSequence implenets IntSequence, Closeable{
*     //...
* } 
* Любая переменная в интерфейсе автоматически обьявляеться как public static final
* Интерфейс определяет поведение, а не состояние обьекта
* В интефейсе допускаются два вида методов: статические и по умолчанию(default)
*
* Разрешение конфликтов с методами по умолчанию с идентичными названиями методов:
* public class Employee implements Person, Identified{
*     public int getiId{return Identified.super.getId();}
* }
* super - позволяет вызвать метод супертипа
*
* Инерфейтс Comparable:
* public interface Comporable<T>{
*     int compareTo(T other);
* }
* Класс String реализует интерфейс Comparable<String>
* чтобы compareTo() имел следующую сигнатуру: int compareTo(String other)
* если возращает любое положительно число: x > y, если любое отрицательно: y > x, если 0: x==y
* Упорядочивание роботников по заплатам:
* public class Employee implements comparable<Employee>{
*     //...
*     public int compareTo(Employee other){
*         return Double.compare(selary, other.salary);
*     }
* }
* 
* Интерфейс Comparator:
* компаратор - экземпляр класса, реализующего интерфейс Comparator:
* public interface comporator<T>{
*     int compare(T first, T second);
* }
* Что бы сравнить  символьние строки по длине: 
* class LenghtComparator implements Comparator<String>{
*     public int compare(String first, String second){
*         return first.length() - second.length();
*     }
* }
* а далее: 
* Comparator<String> comp = new LengthComparator();
* if(comp.compare(words[1], words[j])>0)//...
*
* Интерфейс Runnable:
* class HelloTask implements Runnable{
*     public void run(){
*         for(int i = 0, i < 1000, i++){
*             System.out.println("Hello, World!");
*         }
*    }
* }
* теперь run() выполняеться в другом потоке:
* Runnable task = new HelloTask();
* Thread thrad = new Thread(task);
* thread.start();
*
* Обратные вызовы в ГПИ:
* Интерфейс из бибилиотеки JavaFX для извещения об событиях, наступающих в ГПИ:
* public interface EventHansle<T>{
*     void handle(T event);
* }
* Это очень обобщеный интерфейс. Чтобы указать действие, нужно реализовать интерфейс следующим образом:
* class CancelAction implements EventHandler<ActionEvent>{
*     public void handle(ActionEvent event){
*         System.out.println("Oh, noes!");
*     } 
* }
* а далее создать обьект и вывести таким образом:
* Button cancelButton = new Button("Cancel");
* cancelButtin.setOnAction(new CancelAction());
* 
* Лямбда-выражения - блок кода, который предается для последующего выполненеия один или несколько раз.
* first.length - second.length() по сути:
* (String first, String second) -> first.length() - second.length()
* Если должны быть выполнены вычисления более одного выражения, 
* можно использовать {} и явно указать return:
* (String first, String second) -> {
*     int diff = first.length() - second.length();
*     if(diff < 0) return -1;
*     else if(diff > o) return 1;
*     else return 0;
* }
* Если в лямбда-выражении отсутствуют параментры, следует указать ():
* Runnable task = () -> {for(int i = 0; i < 1000, i++) doWork();}
* Усли же параметры могут быть выведены, их можно отпустить:
* Comparator<String> comp = 
*   (first, second) -> first.length() - second.length();
* то же, что и: (String first, String second)
* Если же параметр единсвенный, то можно опустить даже круглые скобки:
* EventHandler<ActionEvent> listener = event -> 
*   System.out.println("Oh, noes!");
*       //вместо выражения (event)-> или (ActionEvent event)-> 
* 
* Функциональные интерфейсы: 
* Лямбда-выражения можно предоставить всякий раз, когда ожидается обьект класса, реализующего нтерфейс с единсвенным абстракным методом.
* Такой интерфейс называется функциональным.
* Arrays.sort(words,
*       (first, second) -> first.length() - second.length());
* С лямбда-выражениями можно делать лишь одно: присваивать его переменной, 
* типом который являеться функциональный интерфейс чтобы преобразовать его в экземпляр данного интерфейса.
* 
* Ссылка на методы:
* например сортирование строк независсимо от регистра букв:
* Array.sort(string, (x, y)->x.compareToIgnoreCase(y)); но можно так:
* Array.sort(String, String::compareToIgnoreCase); - это ссылка на метод 
* А тут из списка удаляются все пустые значения:
* list.removeIf(Objects::isNull);
* Еще примеры:
* list.forEach(x->System.out.println(x)); это тоже самое что и: 
* list.forEach(System.out::println);
*
* Операция :: отделяет имя метода от имени класса или обьекта:
*   Класс  :: МетодЭкземпляра               пример: String::compareToIgnoreCase
*   Класс  :: СтатическийМетод              пример: Objects::isNull
*   Обьект :: МетодЭкземпляра               пример: System.out::println
*
* Ссылка на конструкторы:
* Employee::new     - ссылка на конструктор Employee
*
* List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
* List<Integer> lengths = names.stream()
*                               .map(String::length)
*                               .collect(Collectors.toList());
* System.out.println(lengths);                                  // Выведет [5, 3, 7]
* 
* Stream<Employee> stream = names.stream().map(Employee::new);
* Массив работников:
* List<String> names = Arrays.asList("John", "Jane", "Bob");
* Stream<Employee> stream = names.stream().map(Employee::new);
* Employee[] buttons = stream.toArray(Employee[]::new);
*
* Реализация отложенного выполнения: 
* Лямбда-выражения применяются для отложенного выполнения
* Причины:
* - выполнение кода в отдельном потоке
* - неоднократное выподненеие кода
* - выполнения кода в нужный момент
* - выполнения кода при наступлении события
* - выполнения кода только по мере надобности
*
* Вызов функционального интерфейса:
* номинальная питизация - система типо, с совместимостью имен типов,  ане на структуре и их свойствах.
* Наиболее употребляемые функциональные интерфейсы:
* ФИ                    Параметры       Возвращаемое значение    Имя абстрактного метода    Описание                                Другие методы
* Runnable              Нет             void                     run()                      Выполняет дейсвие без аргументов        Нет
* Supplier<T>           Нет             T                        get()                      Возвращает значение типа T              Нет
* Consumer<T>           T               void                     accept(T)                  Выполняет действие с аргументом T       andThen(Consumer<? super T> after)
* BiConsumer<T, U>      T, U            void                     accept(T, U)               Выполняет действие с аргументами T и U  andThen(BiConsumer<? super T, ? super U> after)
* Function<T, R>        T               R                        apply(T)                   Функция с аргументом T                  andThen(Function<? super R, ? extends V> after)
*                                                                                                                                   compose(Function<? super V, ? extends T> before)        
*                                                                                                                                   identity()
* BiFunction<T, U, R>   T, U           R                         apply(T, U)                Функция с аргументами T и U             andThen(Function<? super R, ? extends V> after)
* UnaryOperator<T>      T              T                         apply(T)                   Унарная операция над T                  identity()
*                                                                                                                                   andThen(UnaryOperator<T> after) 
*                                                                                                                                   compose(UnaryOperator<T> before)
* BinaryOperator<T>     T, T           T                         apply(T, T)                Бинарная операция над T                 maxBy(Comparator<? super T> comparator)
*                                                                                                                                   minBy(Comparator<? super T> comparator)
*                                                                                                                                   andThen(BinaryOperator<T> after)
* Predicate<T>          T              boolean                   test(T)                    Проверяет свойство T                    isEqual(Object targetRef), end(), or(), negate(), test(Object t)
* BiPredicate<T, U>     T, U           boolean                   test(T, U)                 Проверяет свойство T и U                and(BiPredicate<? super T, ? super U> other), negate(), or()                           
*
* Реализация собсвенных функциональных интерфейсов:
* BiFunction< Integer, Integer, Color> - подрозумевает автоупаковку
* Целесообразно определить новый интерфейс:
* @FunctionalInterface
* public interface PixelFunction {
*     Color apply(int x, int y);
* }
* и реализация: 
* BufferedImage createImage(int width, int height, PixelFunction f) {
*     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
*     for (int x = 0; x < width; x++) {
*         for (int y = 0; y < height; y++) {
*             Color color = f.apply(x, y);
*             image.setRGB(x, y, color.getRGB());
*         }
*     }
*     return image;
* }
* вызов: BufferedImage frenchFlag = createImage(150, 100, (x, y) -> x < 50 ? Color.BLUE : x < 100 ? Color.WHITE : Color.RED);
* замыкание - формальный блок кода вместе со значениями свободных переменных
* Лямбда-выражения могут ссылаться на свободные переменные, но только на те, которые не изменяются
* Лямбда-выражения захватывают значения, а не переменные
* Дейсвительно конечная переменная - это переменная, которая не изменяется после инициализации
* 
* 
*/