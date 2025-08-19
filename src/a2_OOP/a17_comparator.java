/*


Стандартные интерфейсы


    В пакете java.lang
        - CharSequence — интерфейс последовательности символов (его реализует String, StringBuilder).

        - Cloneable — маркирующий интерфейс, указывающий, что для объектов класса можно строить копии.
                      Сам по себе он не требует реализации каких-либо методов.
                      Однако для построения копий нужно переопределить метод clone() класса Object.
                      Интерфейс Clonable лишь "разрешает" использовать функциональность этого метода.

        - Iterable<T> — интерфейс итерируемых коллекций. Классы, которые реализуют этот интерфейс,
                        могут использоваться в инструкции цикла foreach (аналогично массивам).

        - Сomparable<T> — интерфейс, позволяющий сравнивать любые два объекта класса по отношению "больше/меньше".
                          Если класс реализует этот интерфейс, то можно применять метод sort() к массивам или коллекциям,
                          содержащим объекты данного  класса.




    В пакете java.util находятся:

        - Iterator<T> - интерфейс, реализующий  обход коллекции. Для того, чтобы использовать цикл foreach
                        по компонентам объекта класса, необходимо реализовать оба интерфейса:  Iterable и Iterator.

        - Comparator<T> - это также интерфейс, который служит для сравнения объектов. Используется в том случае,
                          если в классе, объекты которого нужно сортировать, не реализован интерфейс
                          Comparable (или реализован не тем способом, который нужен).








    Интерфейс Comparable<T>

        - int compareTo(T item)

        - сравнивает текущий объект с объектом, переданным в качестве параметра.

                 - Возвращает отрицательное число, то текущий объект «меньше» того,
                   который передается через параметр (т.е. при сортировке будет располагаться перед ним).
                 - Если метод вернет положительное число, то, наоборот, текущий объект «больше» переданного через параметр.
                 - Если метод возвратит ноль, значит, оба объекта равны.






    Интерфейс Comparator<T>

        Если мы используем готовый класс, в котором автор этого класса не реализовал интерфейс Comparable,
        то означает ли это, что мы никогда не сможем воспользоваться методом sort()?
        Либо он реализован, но нас эта реализация не устраивает.
        Например, сравнение организовано по среднему баллу, а нам нужно – по фамилии?
        Для решения этой проблемы существует интерфейс Comparator<T>


        - int compare(T a, T b)       - возвращает 0, 1, -1, аналогично методы выше






    Пример с коллекцией

        В массивах используем Arrays.sort, в коллекциях Collections.sort



                    import java.util.ArrayList;
                    import java.util.Comparator;
                    import static java.util.Collections.sort;


                    public class Runner {
                        public static void main(String[] args) {
                            ArrayList<Student> gruppa = new ArrayList<Student>();
                            gruppa.add(new Student("Смирнов", 5.3, 18));
                            gruppa.add(new Student("Андреев", 7.5, 20));
                            gruppa.add(new Student("Мешков", 9.2, 17));
                            sort(gruppa, new Comparator<Student>() {
                                @Override
                                public int compare(Student o1, Student o2) {
                                    return o1.getAge() - o2.getAge();
                                }
                            });
                            for (Student man : gruppa) {
                                System.out.println(man);
                            }
                        }
                    }


 */
package a2_OOP;

import java.util.Comparator;

import static java.util.Arrays.sort;

public class a17_comparator {
    public static void main(String[] args) {
        Studentc[] gruppa = {new Studentc("Иванов", 7.8, 21),
                new Studentc("Петров", 5.4, 18),
                new Studentc("Кириллов", 9.2, 20)};

        System.out.println("Сортировка по среднему баллу:");
        //sort(gruppa);                             // прямая сортировка
        sort(gruppa, Comparator.reverseOrder());    // реверсивная сортировка
        for (Studentc man : gruppa) {
            System.out.println(man);
        }


        System.out.println("Сортировка по фамилии:");

        // реализация Comparator<>, своей сортировки
        // создается объект безымянного класса, который реализует интерфейс Comparator
        sort(gruppa, new Comparator<Studentc>() {
            @Override
            public int compare(Studentc o1, Studentc o2) {
                String s1 = o1.surname;
                String s2 = o2.surname;
                return s1.compareTo(s2);
            }
        });
        for (Studentc man : gruppa) {
            System.out.println(man);
        }
    }
}



// в исходном классе используем интерфейс Comparable<Studentc>
// сортируем по среднему баллу
class Studentc implements Comparable<Studentc> {
    public String surname;
    public double averageMark;
    private int age;

    public Studentc(String surname, double averageMark, int age) {
        this.surname = surname;
        this.averageMark = averageMark;
        this.age = age;
    }

    @Override
    public String toString() {
        return surname + ";" + averageMark + ";" + age;
    }

    @Override
    public int compareTo(Studentc o) {
        if (averageMark - o.averageMark > 0) return 1;
        if (averageMark - o.averageMark < 0) return -1;
        return 0;
    }
}