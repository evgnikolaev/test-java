/*

Объекты как параметры методов


        Параметрами методов могут быть не только примитивные типы данных, но и объектные ссылки.
        Например, очень часто объявляются конструкторы, которые  создают один объект на основании другого (клонируют объект).




        Mетод hashCode()
            - если в классе переопределяется метод equals(), то обязательно нужно переопределять и метод hashCode()
            - объекты, которые сыитаются равными, должны иметь одинаковый hashCode()
            - на основании содержимого полей объекта генерируется целое число
            - используются когда  ооъекты класса помещаются в hash таблиуцу  (например HashSet или HashMap)


            Алгоритм создания hashCode():

                    - Объявите переменную типа int с именем result и инициализируйте ее хеш-кодом с для первого значащего поля вашего объекта.
                    - Для каждого из остальных значащих полей выполняйте следующее.
                            Вычислите хеш-код для этого поля и запишите в переменную c.
                            Объедините этот хеш-код с result следующим образом:  result = 31 * result + с;
                    - Верните result.


                                @Override
                                public int hashCode() {
                                    int result = surname.hashCode(); //хеш-код для фамилии
                                    int c = Integer.hashCode(age); //хеш-код для возраста
                                    return 31*result+c; //равные студенты должны иметь одинаковые хеш-коды
                                }


                    можно автоматически генерить equals() и hashCode() в idea




Пример


        class Main {
            public static void main(String[] args) {
                Student student1 = new Student("Иванов", 8.3, 18);
                Student student2 = new Student(student1);

                if (student1 == student2) {
                    System.out.println("Студенты равны");
                } else {
                    System.out.println("Студенты не равны");   // не равны, разные объектные ссылки
                }

                //Переопределили метод equals
                if (student1.equals(student2)) {
                    System.out.println("Студенты равны!"); //выводит эту надпись
                } else {
                    System.out.println("Студенты не равны!");
                }


                //Пример с изменением внутренности объекта, так как объекты - это ссылочный тип данных
                Student student3 = new Student();
                student1.setEqual(student3);

                System.out.println(student1);
                System.out.println(student3);
            }
        }



        class Student {
            private String surname;
            private double averageMark;
            private int age;

            public Student() {
            }

            public Student(String surname, double averageMark, int age) {
                this.surname = surname;
                this.averageMark = averageMark;
                this.age = age;
            }


            // Параметрами методов могут быть не только примитивные типы данных, но и объектные ссылки.
            // Например, очень часто объявляются конструкторы, которые  создают один объект на основании другого (клонируют объект).
            public Student(Student student) {
                this.surname = student.surname;
                this.averageMark = student.averageMark;
                this.age = student.age;
            }


            // Переопределение методов
            // Например, сравним содержимое объектов Student, будем считать, что два студента равны, если у них одинаковая фамилия и возраст
            @Override
            public boolean equals(Object obj) {
                Student another = (Student) obj; //преобразование полученного объекта в студента
                if (!this.surname.equals(another.surname)) return false;
                return this.age == another.age;
            }



            @Override
            public int hashCode() {
                int result = surname.hashCode(); //хеш-код для фамилии
                int c = Integer.hashCode(age); //хеш-код для возраста
                return 31*result+c; //равные студенты должны иметь одинаковые хеш-коды
            }


            // Объекты - это ссылочный тип данных, изменяется внтуренность объекта, который передали
            public void setEqual(Student studentForChange) {
                studentForChange.surname = this.surname;
                studentForChange.averageMark = this.averageMark;
                studentForChange.age = this.age;
            }


            // переопределение toString()
            @Override
            public String toString() {
                return "Student{" +
                        "surname='" + surname + '\'' +
                        ", averageMark=" + averageMark +
                        ", age=" + age +
                        '}';
            }
        }





 */
package a2_OOP;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrLength = scanner.nextInt();

        if (arrLength < 0) {
            System.out.println("ERROR");
            return;
        }


        String name;
        int transportnue;
        int kolvoDney;
        BusinessTrip[] businessTrip = new BusinessTrip[arrLength];
        for (int i = 0; i < arrLength - 1; i++) {
            //scanner.skip("\n");
            name = scanner.next();
            transportnue = scanner.nextInt();
            kolvoDney = scanner.nextInt();
            businessTrip[i] = new BusinessTrip(name, transportnue, kolvoDney);
        }

        businessTrip[businessTrip.length - 1] = new BusinessTrip();
        businessTrip[0].setEqual(businessTrip[businessTrip.length - 1]);
        businessTrip[0].setName(scanner.next());

        for (BusinessTrip el : businessTrip) {
            System.out.println(el);
        }
        System.out.println();


        int index = scanner.nextInt();
        for (int i = 0; i < arrLength; i++) {
            if (businessTrip[i].equals(businessTrip[index])) {
                System.out.println(businessTrip[i]);
            }
        }
    }
}

class BusinessTrip {
    private static final int sutochnue = 25;
    private String name;
    private int transportnue;
    private int kolvoDney;

    public BusinessTrip() {
    }

    public BusinessTrip(String name) {
        this.name = name;
    }

    public BusinessTrip(String name, int kolvoDney, int transportnue) {
        this.name = name;
        this.kolvoDney = kolvoDney;
        this.transportnue = transportnue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolvoDney() {
        return kolvoDney;
    }

    public void setKolvoDney(int kolvoDney) {
        this.kolvoDney = kolvoDney;
    }

    public int getTransportnue() {
        return transportnue;
    }

    public void setTransportnue(int transportnue) {
        this.transportnue = transportnue;
    }


    @Override
    public String toString() {
        return name + ";" + kolvoDney + ";" + transportnue + ";"  + getTotal();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BusinessTrip that)) return false;
        return this.getTotal() == that.getTotal();
        //return transportnue == that.transportnue && kolvoDney == that.kolvoDney && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = this.getTotal(); //хеш-код для фамилии
        int c = Integer.hashCode(result); //хеш-код для возраста
        return 31 * result; //равные студенты должны иметь одинаковые хеш-коды
        //return 31*result+c; //равные студенты должны иметь одинаковые хеш-коды
        //return Objects.hash(name, transportnue, kolvoDney);
    }

    public void setEqual(BusinessTrip businessTripChange) {
        businessTripChange.name = this.name;
        businessTripChange.transportnue = this.transportnue;
        businessTripChange.kolvoDney = this.kolvoDney;
    }

    public int getTotal() {
        return (int) (this.transportnue + this.kolvoDney * sutochnue);
    }

    public void show() {
        System.out.println("Суточные = " + sutochnue + "\n" +
                "Фамилия Имя = " + this.name + "\n" +
                "Транспортные расходы = " + this.transportnue + "\n" +
                "Количество дней = " + this.kolvoDney + "\n" +
                "Итого расходы = " + this.getTotal());

    }
}
















