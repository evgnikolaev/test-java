/*

OOP

        Обычно в классе присутствуют различные компоненты:
        - Поля (обычно приватные)
        - Методы (обычно публичные)
        - Конструкторы
        - Геттеры/Сеттеры (доступы к приватным полям)
        - Переопределенные методы класса Object (toString(), equals()  и др.)
        - блоки кода



Модификаторы

        static - единственное для всех объектов класса
             - static может быть вызван до создания каких либо объектов класса
             - имеет доступ только к статическим полям
             - обычно вызывается от имени класса



        final - константа
            - final поле нельзя изменять после инициализации
            - final параметры метода - значения нельзя изменять в пределах метода
            - final локальная переменная - значение можно присвоить один раз
            - final метод - запрещение переопределения метода
            - final класс - запрещение наследования от него


        модификаторы доступа:
            private - члены класса доступны только внутри данного класса (обычно это поля, реже методы)
            по умолчанию(package-private) - члены класса доступны классам в том же пакете
            public - члены класса доступны для всех классов в этом и дргуих пакетах
            protected - члены класса доступны классам, находящимся в том же пакете, и подклассам (наследников) - в других пакетах




      Существует четыре спецификатора доступа для членов класса:
                - public  - компонент доступен из любого класса любого пакета;
                - private – компонент доступен только в своем классе;
                - спецификатор по умолчанию (если отсутствует другой спецификатор) – компонент доступен для других классов этого же пакета;
                - protected – компонент доступен в своем пакете и подклассам в других пакетах.




Конструктор

    - конструктор вызывается при создании объекта new
    - имя конструктора совпадает с именем класса
    - конструктор не возвращает ничего, даже void
    - в классе может быть несколько конструкторов

            Cmd + N (на macOS) или Alt+Insert (на Windows/Linux).







Удаление объектов

    - система периодически выполняет сборку мусора
    - "мусором" считается объект, если на него нет ни одной ссылки из программы
    - finalize - метод автоматически вызывается при удаление объекта

                @Override
                protected void finalize() throws Throwable {
                   //здесь должен следовать код полного завершения
                }

                только непонятно когда объект будет удаляться. Нормальная работа программы не должна зависеть от метода finalize()!
                finalize() имеет статус "deprecated"


Геттеры и сеттеры

    Поля класса обычно помечаются модификатором private, что соответствует принципу инкапсуляции  и должно уберечь данные класса от случайной или злонамеренной порчи.
    Смысл геттеров и сеттеров как раз в том, чтобы сделать дополнительный "слой" перед использованием переменных. Например, проследить, чтобы некорректное значение на попало в поле класса.


    Не всегда в классе должны присутствовать геттеры и сеттеры! Если например нельзя менять поля по-отдельности, а значит - у нас не будет сеттеров. (пример железо с плотностью)





Пример класса


            import java.util.Scanner;

            class Main {
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);

                    Student[] gruppa = new Student[4];
                    gruppa[0] = new Student();                                      //используем конструктор без параметров
                    gruppa[0].setSurname("Сидоров");                                //использование сеттеров

                    gruppa[1] = new Student("Иванов", 8.3, 20);                     //конструктор с тремя параметрами
                    gruppa[2] = new Student("Петров", 22);                          //конструктор с двумя параметрами

                    Student.setBaseScholarship(120);                                //использование сеттеров для статического поля

                    for (int i = 0; i < gruppa.length; i++) {
                        if (gruppa[i] != null) {
                            //использование геттера
                            System.out.println(gruppa[i].getSurname() + " : " + gruppa[i].calculateScholarship());              //вывод стипендии каждого студента
                        }
                    }
                }
            }






            class Student {
            private String surname;                                                 //у каждого студента свое значение
                private double averageMark;                                         //у каждого студента свое значение
                private int age;                                                    //у каждого студента свое значение
                private static int baseScholarship = 110;                           //одно значение у всех студентов

                public Student() {                                                  //конструктор без параметров - дефолтные значения полей
                }

                public Student(String surname, double averageMark, int age) {           //конструктор заполняет все поля
                    this.surname = surname;
                    this.averageMark = averageMark;
                    if (age > 0) {
                        this.age = age;
                    } else {
                        this.age = 18;
                    }
                }

                public Student(String surname, int age) {                           //конструктор заполняет два поля
                    this.surname = surname;
                    if (age > 0) {
                        this.age = age;
                    } else {
                        this.age = 18;
                    }
                }

                int calculateScholarship(){
                    if(averageMark >= 9){
                        return (int)(baseScholarship * 1.6);
                    }else if(averageMark >= 8){
                        return (int)(baseScholarship * 1.4);
                    }else if(averageMark >= 6){
                        return (int)(baseScholarship * 1.2);
                    }else if(averageMark >= 5){
                        return baseScholarship;
                    }else{
                        return 0;
                    }
                }


                                                                                // геттер сеттер для поля - surname
                public String getSurname() {
                    return surname;
                }

                public void setSurname(String surname) {
                    this.surname = surname;
                }


                                                                                // геттер сеттер для статического поля
                public static int getBaseScolarship() {
                    return baseScholarship;
                }

                public static void setBaseScholarship(int baseScholarship) {
                    Student.baseScholarship = baseScholarship;
                }
            }





 */

package a2_OOP;

import java.util.Locale;
import java.util.Scanner;

class a1_OOP {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double newObiem =  scanner.nextDouble();

        Material material1 = new Material("steel", 7850);
        Thing thing1 = new Thing("wire", material1,0.03);
        thing1.show();

        Material material2 = new Material("copper", 8500);
        thing1.setMaterial(material2);
        thing1.setObiem(newObiem);
        thing1.show();
    }
}



class Material {
    private String name;
    private int plotnost;

    public Material(String name, int plotnost) {
        this.name = name;
        this.plotnost = plotnost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlotnost() {
        return plotnost;
    }

    public void setPlotnost(int plotnost) {
        this.plotnost = plotnost;
    }
}




class Thing {
    private String name;
    private Material material;
    private double obiem;

    public Thing() {
    }

    public Thing(String name, Material material, double obiem) {
        this.name = name;
        this.material = material;
        this.obiem = obiem;
    }

    public double getObiem() {
        return obiem;
    }

    public void setObiem(double obiem) {
        this.obiem = obiem;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getMass() {
        return this.material.getPlotnost() * this.obiem;
    }


    public void show() {
        System.out.print(this.name);
        System.out.print(";");
        System.out.print(this.material.getName());
        System.out.print(";");
        System.out.print(this.material.getPlotnost());
        System.out.print(";");
        System.out.print(this.obiem);
        System.out.print(";");
        System.out.print(this.getMass());
        System.out.println();
    }
}

















