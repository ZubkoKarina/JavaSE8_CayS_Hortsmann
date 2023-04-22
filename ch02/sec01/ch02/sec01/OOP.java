package ch02.sec01;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class OOP{
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2023, 5, 18);
        System.out.println(date);
        System.out.println(date.plusDays(1));
        Employee kotlimDev = new Employee("Tim", 5000);
        System.out.println(kotlimDev.getName());
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Karina", 10000));
    }
    public static class Employee{
        private final String name;
        private double salary = 500.0;
        //блок инициализации(обычно не используются)
        {
            Random generator = new Random();
            salary = 1+generator.nextInt(1_000_000);
        }
        public Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }
        public Employee(double salary){
            // this.name = "";
            // this.salary = salary;
            this("", salary);
        }
        public Employee(String name){
            // для обьектов будет вызывать исключение в getName()
            // salary = 0;
            this.name = name;
        }
        public void raiseSalary(double byPercent){
            double raise = salary * byPercent/100;
            salary += raise;
        }
        public String getName(){
            return name;
        }
        /* as a method!
        public void Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }*/
    }/* 
    public class Network{
        public class Member{
            private String name;
            private ArrayList<Member> friends;
            public Mamber(String name){
                this.name = name;
                this.friends = new ArrayList<>();
                //...
            }
        }
        private ArrayList<Member> members;
        //...
    }*/
}

/*
* утилита javadoc обрабатывает исходный код в HTML-файлы 
* класс LocalDate date = LocalDate.of(year, month, 1);
*
* Если случайно обьявить void public void Employee(...)- не конструктор, а метод!
*
* Переменная экземпляра класса final - обязана быть инициализирована к концу определения каждого конструктора
* но private fienl ArrayList<Person> friends = new ArrayList<>() - неизменяема только ссылка, а изменять 
* обьект можно(можно изменять содержимое массива, но они не могут заменить ссылку)
*
* Static поле  - единственное в классе, принадлежит только классу а не экземпляру обьекта
* Static final - например double Pi = ...;
* Static {}      как блок инициализации
* Чаще всего статические методы употребляться как факюичные, как методы возащяющие новые экземпляры класса
* Стас. методы исп. когда не требуеться создание обьекта
*
* В одном пакете - связанные между собой классы
* В java вложенность пакетов не предусмотрено
* Пакет по умолчанию - при не указания пакета(не рекомендуется)
* javac -d ... - файлы классов формируються в отдельном каталоге
*
* JAR: jar cvf library.jar com/mycompany/*.class 
* jar cvfe program.jar com.mycompany.MainClass com/mycompany/*.class
* и тогда выполнение: java -jar program.jar
*
* утилиты javac и java имеют параметр -classpath(-cp)
* тек.каталог(.) и два jar-файла в каталоге ../libs
* java -classpath .:../libs/lib1.jar:../libs/lib2.jar com.mycompany.MainClass
* в windows: java -classpath .;../libs/lib1.jar;../libs/lib2.jar com.mycompany.MainClass
* если есть много jar-файлов - разместить в одном каталоге:
* java -classpath .:../libs/\* com.mycompany.MainClass
* установка пути: export CLASSPASH=.:/home/username/project/libs/\*
* в windows: SET SLASSPATH=.;C:\Users\(тут пусто, комментарии слетают)username\progect\libs\*
* область видимости пакета:
* private        - только в том классе, в котором обьявлен
* public         - в любом классе
* не указано     - только в одном пакете 
* ClassLoader - изоляция классов которые неизменны в java
* если необходима защита своих пакетов ->  размещение в геометричном архивном JAR-файле,
* и предоставить манифест - текстовый файл с таких содержанием как : 
* Name: com/mycompany/util/
* Seales: true
* ...
* затем выполнить: jar cvfm library.jar manifest.txt com/mycompany/*(тут ничего, просто коментарии слетают)/*.class
* 
* import java.* - импорт всех классов но не всех пакетов
* оператор import в java не приводик к компиляции этих классы(как в C++), а лишь сокращает имена классов
*
* Статический импорт: import static java.lang.Math.*; 
* и далее доступно использование стас. методов таким образом:pow(y,2) а не Math.pow()
*
* Не стат. внутренний класс и стат. вложенный класс
* Не стат. внутренние классы не имеют доступа к членам внешнего класса!
* Они нужны когда нужно логически связать 2 класса, но они не зависят друг от друга
* 
* outer - скрытая ссылка на обьемлеющий класс, дает ссылку только для внутренних классов
* в стас. класс отсуцтвует outer и this ссылки
*
* Правила специального синтаксиса для внутренних классов:
* внешнийКласс.this. ... и так далее
* public class Network{
*    public class Member{
*        //...
*        public boolean belongdTo(Network n){
*           return Network.this == n;
*       }
*    }
* }
* Member newMember = new Member(name); тоже самое:
* Member newMember = this.new Member(name);
* Network.Member wilma = myFace.new Member("Karina") вызов конструктора внутреннего класса
*
* Утилита Javadoc - авто. составление HTML документации из исходных файлов
*  /** ... *(тут пусто, слетают комментарии)/ - специальные коментарии для Javadoc
* 
* @param - описание параметра метода;
* @return - описание возвращаемого значения метода;
* @throws - описание выбрасываемого исключения методом;
* @see - связывание текущего элемента с другим элементом;
* @since - указание версии Java, в которой был введен текущий элемент;
* @deprecated - помечает метод, который устарел и рекомендуется использовать другой метод вместо него;
* @version - указание версии текущего элемента;
* @author - указание автора;
* @link - создание ссылки на другой элемент;
* @code - отображение кода внутри Javadoc комментария;
* @literal - вставка символьных литералов, которые могут быть искажены стандартным форматированием Javadoc;
* @inheritDoc - использование документации родительского класса или интерфейса.
*/


