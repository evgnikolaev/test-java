/*


Паттерны проектирования

    UML -диаграммы
    https://stepik.org/lesson/1110876/step/2?unit=1122258


    Межклассовые отношения:

        1. ассоциация (аналог использует) - классы имеют связь, может указываться кратность (один к одному, и т.д.)
                                            Например, Студент - преподаватель

        2. Наследование (генерализация)

        3. Реализация - интерфейс и реализация класса

        4. Зависимость - объект одного класса использует объект другого в своем методе
                         объект не храниться в отдельном поле класса.

        5. агрегация (в переводе "Помещение") - один класс является частью другого, но также может существовать отдельно
                                                (игрок - команда, или рабочее место)


        6. композиция (часть чего-то) - один класс не может существовать без другого
                                        (тело - конечности)






    Паттерн Singleton (Одиночка)

        Существует много объектов, которые нужны нам в одном экземпляре: пулы программных потоков,
        кэши, диалоговые окна, объекты драйверов устройств и т.п. Попытка создания более одного
        экземпляра такого класса приведет к всевозможным проблемам.



    Идея паттерна Singleton

        1. Сделаем конструктор приватным
        2. Для создания объекта будем использовать статический метод getInstance()
        3. Код класса  должен включать статическую переменную для хранения ссылки
           на единственный экземпляр класса
        4. При первом обращении к методу getInstance() экземпляр создается, а ссылка на него
           присваивается этой статической переменной.
        5. При всех последующих обращениях к getInstance() возвращается ссылка на уже существующий объект.



    При многопотточном программирование есть подводные камни.
    Рассмотрим 3 способа решения.

        1) Объявить метод getInstance() синхронизированным (ключевое слово synchronized).
           Тогда два потока не могут войти в этот метод одновременно.
           Но это замедляет работу, каждый раз будет синхронизация при вызове метода.


                        class Singleton {
                            private static Singleton uniqueInstance;

                            private Singleton() {
                            }

                            public static synchronized Singleton getInstance() {     // !!synchronized
                                if (uniqueInstance == null) {
                                    uniqueInstance = new Singleton();
                                }
                                return uniqueInstance;
                            }
                        }





        2) Можно создать экземпляр синглетного класса заранее
           Недостаток такого подхода в том, что мы создаем экземпляр Singleton
           в самом начале работы приложения, а не тогда, когда это действительно необходимо.


                        public class Singleton {
                            private static Singleton uniqueInstance = new Singleton(); //заранее создаем объект

                            private Singleton() { //приватный конструктор недоступен в других классах
                            }

                            public static Singleton getInstance() {
                                return uniqueInstance; //возвращаем ссылку на единственный объект
                            }
                        }




        3) Можно воспользоваться “условной блокировкой”: сначала проверить, создается ли новый экземпляр.
        Если да – тогда синхронизировать фрагмент кода создания экземпляра.
        Синхронизация будет производится только при первом вызове.

        volatile - гарантирует, что данная переменная не будет помещаться в кэш-память программного потока
                    (то есть все потоки будут обращаться к одной и той же переменной)



                        public class Singleton {
                            private static volatile Singleton uniqueInstance;   //volatile

                            private Singleton() {
                            }

                            public static Singleton getInstance() {
                                if (uniqueInstance == null) {                   //первый вызов
                                    synchronized (Singleton.class) {            //синхронизируем блок
                                        if (uniqueInstance == null) {           //после синхронизации повторить проверку
                                            uniqueInstance = new Singleton();
                                        }
                                    }

                                }
                                return uniqueInstance; //возвращаем ссылку на единственный объект
                            }

                        }







*/
package a2_OOP;

public class a19_singleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2); // получим один и тот же объект
    }
}


class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}