/*

Вложенные классы
https://stepik.org/lesson/1080721/step/1?unit=1090980


        Существует четыре базовых типа вложенных классов в Java:
            1. Nested Inner classes (вложенные внутренние классы)
            2. Static Nested classes  (статические вложенные классы)
            3. Method -local Inner classes (локальные вложенные классы)
            4. Anonymous Inner classes (анонимные классы)



        1. Nested Inner classes (вложенные внутренние классы)
            - всегда неявно связан с объектом своего внешнего класса
            - может получить доступ к любому приватному полю или методу экземпляра внешнего класса
            - не мог содержать в себе статических методов или статических полей
            - может иметь любой модификатор доступа
            - также вложенными могут быть интерфейсы



                        public class Student {
                            private String name;

                            public Student(String name) {
                                this.name = name;
                            }

                            public class Account { //nested inner class
                                private String login;
                                private String password;

                                public Account(String login, String password) {
                                    this.login = login;
                                    this.password = password;
                                }

                                public void show() {
                                    System.out.println("Студент: " + name); //доступ к приватному полю внешнего класса
                                    System.out.println("Логин: " + login);
                                    System.out.println("Пароль: " + password);
                                }
                            }
                        }



                        public class Main {
                            public static void main(String[] args) {
                                Student person = new Student("Иванов");  //создаем объект внешнего класса

                                //объект внутреннего класса создается от имени объекта  внешнего класса
                                Student.Account account = person.new Account("ivanov", "123");
                                account.show();
                            }
                        }








       2. Static Nested classes
            - имеют доступ к статическим полям внешнего класса (в том числе приватным)
            - не имеют доступа к полям экземпляра



                        public class Student {
                            private String name;
                            private static int baseScolarship = 200;

                            public Student(String name) {
                                this.name = name;
                            }

                            public static class Scolarship {
                                public void increaseBaseScolarship(int procent) {
                                    baseScolarship += baseScolarship * procent / 100; //доступ к статическому полю
                                    //System.out.println(name); //нет доступа к полю экземпляра
                                }
                            }
                        }



                        public class Main {
                            public static void main(String[] args) {
                                Student.Scolarship money = new Student.Scolarship(); //не нужен объект внешнего класса
                                money.increaseBaseScolarship(20);
                            }
                        }









        3. Method Local Inner classes
            - имеет доступ к переменным внешнего класса (как к статическим, так и переменным экземпляра)
            - меет доступ и к локальным переменным этого метода, если они фактически являются константами




                        public class Student {
                            private String name;

                            public Student(String name) {
                                this.name = name;
                            }

                            public void createAccount(String login, String password) {

                                class Account {             //класс внутри метода
                                    private String log;     //имя должно отличаться от локальной переменной
                                    private String passw;

                                    public Account() {
                                        //login = "petrov";  //локальную переменную в методе не менять
                                        this.log = login;    //доступ к локальным переменным метода
                                        this.passw = password;
                                    }

                                    public void show() {
                                        System.out.println("name = " + name); //доступ к полю экземпляра внешнего класса
                                        System.out.println("login = " + log);
                                        System.out.println("password = " + passw);
                                    }
                                }

                                //операторы метода
                                Account account = new Account();
                                account.show();
                            }

                        }



                        public class Main {
                            public static void main(String[] args) {
                                Student person = new Student("Иванов");
                                person.createAccount("ivanov", "123");
                            }
                        }




         4. Anonymous Inner classes (анонимные классы)
            - объявляются без указания имени класса
            - могут быть созданы двумя путями:
                    - как наследник определённого класса
                    - как реализация какого-то интерфейса
            - может либо реализовать интерфейс (только один!), либо расширить класс (но не одновременно)



                        //пример - как наследника класса
                        public class Demo {
                            public void show() {
                                System.out.println("Метод суперкласса");
                            }
                        }

                        public class Main {
                            public static void main(String[] args) {
                                Demo obj = new Demo() {
                                    @Override
                                    public void show() {
                                        System.out.println("Метод анонимного класса");
                                    }
                                };
                                obj.show();
                            }
                        }





                        //пример - как реализация интерфейса
                        public interface DemoInterf {
                            void show();
                        }

                        public class Main {
                            public static void main(String[] args) {
                                DemoInterf item = new DemoInterf() {
                                    @Override
                                    public void show() {
                                        System.out.println("Метод анонимного класса");
                                    }
                                };
                                item.show();
                            }
                        }






Назначение вложенных классов

Для улучшения инкапсуляции.
Т.е. если один класс полезен только для одного другого класса, то логично сделать его вложенным и хранить эти классы вместе.
Что касается статических вложенных классов, то они вводятся в основном для группировки данных внутри другого класса.




*/
package a2_OOP;

import java.util.Locale;
import java.util.Scanner;

class a12_vlozhennie_classes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        scanner.useLocale(Locale.US);

        String klichka1 = scanner.next();
        String poroda1 = scanner.next();
        String color1 = scanner.next();
        Double razmer1 = scanner.nextDouble();
        Dog dog1 = new Dog(klichka1, poroda1, color1, razmer1);

        String klichka2 = scanner.next();
        String poroda2 = scanner.next();
        String color2 = scanner.next();
        Double razmer2 = scanner.nextDouble();
        Dog dog2 = new Dog(klichka2, poroda2, color2, razmer2);
        switch (dog1.compareTo(dog2)) {
            case -1:
                System.out.println("Вторая собака больше");
                break;
            case 0:
                System.out.println("Собаки одинакового размера");
                break;
            case 1:
                System.out.println("Первая собака больше");
                break;
        }
    }
}


class Dog {
    private String klichka;
    private String poroda;
    private Collar collar;

    public Dog(String klichka, String poroda, String color, double razmer) {
        this.klichka = klichka;
        this.poroda = poroda;
        this.collar = new Collar(color, razmer);
    }


    public int compareTo(Dog two) {
        if (collar.razmer > two.collar.razmer) {
            return 1;
        } else if (collar.razmer < two.collar.razmer) {
            return -1;
        } else {
            return 0;
        }
    }

    class Collar {
        private String color;
        private double razmer;

        public Collar(String color, double razmer) {
            this.color = color;
            this.razmer = razmer;
        }

        public double getRazmer() {
            return razmer;
        }
    }
}














