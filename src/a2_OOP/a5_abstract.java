/*

Абстрактные классы:

        Абстрактный метод:
            - метод, для которого отстутствует реализация в суперклассе
            - нельзя объявлять абстрактные конструкторы и абстрактные статические методы


        Абстрактынй класс:
            - нельзя создавать объекты
            - может быть использован для создания ссылок (например в массиве)
                        Figure dd = new Triangle(2, 2);




         Ключевое слово final:
             - предотвращение наследования
             - создание константы
                        final double PI =3.1415;

             - предотвращение переопределения методов

                            public boolean isCorrect(final int age) {
                                //age++; запрещено, т.к. параметр только для чтения
                                if (age > 0 && age < 150) {
                                    return true;
                                }
                                return false;
                            }





            Класс Object

                Класс Object  - это общий предок всех классов Java.
                Методы getClass(), notify(), notifyAll() и wait() объявлены как final. Остальные методы можно переопределять.


                        Метод                               Назначение

                        Object clone()                      Создает новый объект, являющийся копией клонируемого
                        Boolean equals(Object object)       Определяет, равен ли один объект другому
                        void finalize()                     Вызывается перед удалением не используемого объекта
                        Class<?> getClass()                 Получает класс объекта во время выполнения
                        int hashCode()                      Возвращает хеш-код, связанный с вызывающим  объектом
                        String toString()                   Возвращает символьную строку, описывающую объект



                объект типа Class
                    Student person = new Student(20, "Иванов");
                    Class my = person.getClass();
                    my.getPackageName()     //имя пакета
                    my.getName()            //имя
                    my.getSimpleName()      //имя класса



*/
package a2_OOP;

class a5_abstract {
    public static void main(String[] args) {
        Figure dd = new Triangle(2, 2);
        Figure[] figures = new Figure[4]; //массив фигур
        figures[0] = new Triangle(2, 2);
        figures[1] = new Rectangle(2, 2);
        figures[2] = new Triangle(1, 2);
        figures[3] = new Rectangle(1, 2);
        for (int i = 0; i < figures.length; i++) {
            System.out.println(figures[i] + " area = " + figures[i].area());
        }
    }
}


abstract class Figure {             //абстрактный класс
    public double dim1;
    public double dim2;

    public Figure(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double area();         //абстрактный метод вычисления площади
}



class Rectangle extends Figure {

    public Rectangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        return dim1 * dim2;
    }

    @Override
    public String toString() {
        return "Rectangle{" + dim1 + ", " + dim1 + "}";
    }
}



class Triangle extends Figure {

    public Triangle(double dim1, double dim2) {
        super(dim1, dim2);
    }


    @Override
    double area() {
        return 0.5 * dim1 * dim2;
    }

    @Override
    public String toString() {
        return "Triangle{" + dim1 + ", " + dim2 + "}";
    }
}