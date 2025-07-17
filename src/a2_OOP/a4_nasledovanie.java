/*

Наследование:

        Иерархия классов:
            - класс предок - суперкласс
            - потомок - подкласс
            - класс может иметь только одного предка и любое количество потомков



        Отношение наследования "is a":
            - Student is a Person       (ok - студент ЯВЛЯЕТСЯ человеком)
            - Computer has a Keyboard   (no - клавиатура ЧАСТЬ компьютера, компьютер ИМЕЕТ клавиатуру)



        Описание класса-наследника:
            - Конструкторы не наследуются, поэтому подкласс должен иметь собственные конструктры
            - Поля и методы суперкласса наследуются
            - private-элементы суперкласса в наследнике не доступны, исмользуем геттеры-сеттеры


                        [спецификаторы] class имя_класса extends имя_суперкласса {
                            //описание класса
                        }




        Описание конструктора подкласса:
            - первое действие - вызов конструктора суперкласса
            - если явный вызов конструктора суперкласса отстутствует, автоматически вызывается его конструктор без параметров
            - если конструктор суперклсаа требует указания параметров, он должен быть явным образом вызван в первой строчке
              конструктора подкласса с помощью ключевого слова super()

                    ключевое слово super():
                        - вызов конструктора суперкласса
                        - ссылка на любой член суперкласса:
                            super.toString() - обращение к методу toString(), который определен в родительском классе


                        public PayerStudent(String surname, double averageMark, int age, int cost) {
                            super(surname, averageMark, age);
                            this.cost = cost;
                        }



        Переопределение методов:
            - метод из подкласса переопределяет метод суперкласса, если в нем описать метод с той же сигнатурой (имя метода + набор параметров)
            - используем аннотацию @Override


        Отличие переопределения от перегрузки:
            - переопределение методов (override)  в подклассе выполняется, если сигнатуры одинаковы
            - перегрузка методов (overload) выполняется, если имена одинаковые, а сигнатруы разные





Одновременное использование объетков суперкласса и подкласса (Динамическая диспетчеризация методов)

        Иногда удобно оперировать объектами одной иерархии единообразно.
        Cсылочной переменной суперкласса можно присвоить объект подкласса. Но не наоборот!
        И мы можем вызывать методы, которые есть в родительском классе.


                PayerStudent person = new PayerStudent("Иванов", 8.4, 23, 3500);
                Student student = person;
                student.calculateScholarship();     //верно (при этом сработает метод подкласса)
                // student.payment();               //неверно!






Проверка принадлежности классу:

        person instanceof Student  - истинно, если объект person принадлежит классу Student или его наследнику
                                    (или реализует интерфейс Student – об интерфейсах будет в курсе дальше).


                         for (int i = 0; i < gruppa.length; i++) {
                            if (gruppa[i] instanceof PayerStudent) {
                                System.out.println(gruppa[i]);
                            }
                        }





        Нужно иметь ввиду, что проверка принадлежности классу-наследнику не дает автоматически возможности
        вызывать от имени этого объекта метод из подкласса (если ссылка осталась типа суперкласса).
        Чтобы вызывать специфические методы наследника, нужно сначала выполнить преобразование к его типу:

                        System.out.println("Оплата за обучение");
                        for (int i = 0; i < gruppa.length; i++) {
                            if (gruppa[i] instanceof PayerStudent) {
                                PayerStudent item = (PayerStudent) gruppa[i]; //преобразование к типу подкласса
                                System.out.println(item.getSurname() + ": " + item.payment());
                            }
                        }


        gruppa[i] instanceof PayerStudent item  - или преобразование можно сделать короче


                        System.out.println("Оплата за обучение");
                        for (int i = 0; i < gruppa.length; i++) {
                            if (gruppa[i] instanceof PayerStudent item) {
                                System.out.println(item.getSurname() + ": " + item.payment());
                            }
                        }


 */
package a2_OOP;

class a4_nasledovanie {
    public static void main(String[] args) {
        PayerStudent person = new PayerStudent("Иванов", 8.4, 23, 3500);

        // Cсылочной переменной суперкласса можно присвоить объект подкласса. Но не наоборот!
        // И мы можем вызывать методы, которые есть в родительском классе.
        Student student = person;
        student.calculateScholarship();     //верно (при этом сработает метод подкласса)
        // student.payment();               //неверно!


        Student[] gruppa = new Student[3];
        gruppa[0] = new Student("Смирнов", 6.5, 20);
        gruppa[1] = new PayerStudent("Петров", 9.4, 22, 4500); //студент-платник в массиве студентов
        gruppa[2] = new Student("Иволгина", 8.5, 28);
        for (int i = 0; i < gruppa.length; i++) {
            System.out.println(gruppa[i].getSurname() + " стипендия = " + gruppa[i].calculateScholarship());
        }


        /*
            Смирнов стипендия = 132
            Петров стипендия = 0
            Иволгина стипендия = 154
        */


        // Проверка принадлежности классу
        System.out.println("Оплата за обучение");
        for (int i = 0; i < gruppa.length; i++) {
            if (gruppa[i] instanceof PayerStudent item) {
                System.out.println(item.getSurname() + ": " + item.payment());
            }
        }
    }
}




class Student {
    private String surname;
    private double averageMark;
    private int age;
    private static int baseScholarship = 110;

    public Student(String surname, double averageMark, int age) {
        this.surname = surname;
        this.averageMark = averageMark;
        this.age = age;
    }

    public int calculateScholarship() {
        return (int) (baseScholarship * 1.4);
    }

    @Override
    public String toString() {
        return surname + ";" + averageMark + ";" + age;
    }

    public String getSurname() {
        return surname;
    }
}




class PayerStudent extends Student {
    private int cost;

    public PayerStudent(String surname, double averageMark, int age, int cost) {
        super(surname, averageMark, age);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int payment() { //расчет платежа с учетом успеваемости
        return (int) (cost * 0.85);
    }

    @Override
    public int calculateScholarship() { //переопределяем метод расчета стипендии
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + payment();
    }
}

