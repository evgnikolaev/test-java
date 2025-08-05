/*

Генерация исключений

        if (b == 0) throw new ArithmeticException();



Методы класса Throwable


        String getMessage()                         Возвращает описание исключения
        void printStackTrace()                      Выводит сообщение об ошибке и трассировку стека вызовов на консоль
        void printStackTrace(PrintStream поток)     Выводит трассировку стека вызовов в указанный поток
        String toString()                           Возвращает строку, содержащую полное описание исключения.
                                                    Неявно вызывается, если объект типа Throwable передается в метод println()


Можно создать свое исключение
                class StudentException extends Exception





Основные правила использования исключений:
https://stepik.org/lesson/1094582/step/15?unit=1105343

    1. Проверяемые исключения должны быть обработаны в методе, который может их генерировать,
    или включены в throws-список метода для дальнейшей обработки в вызывающих методах.

    2. Добавлять throws методу main()  считается  дурным тоном программирования.

    3. Следует класифицировать исключения

    4. Не оставлять пустыми блоки catch.

    5. По возможности не использовать одинаковую обработку различных исключений.

    6. Не создавать класс исключений, эквивалентный по смыслу уже существующему.

    7. Никогда самостоятельно не генерировать NullPointerException.
    Проверка значения ссылки на null позволяет обойтись без генерации исключения.

    8. Не следует в общем случае в секцию throws помещать unchecked-исключения (непроверяемые).

    9. Не рекомендуется вкладывать блоки try-catch друг в друга из-за ухудшения читаемости кода.

    10. При создании собственных исключений следует проводить наследование от класса Exception,
    либо от другого проверяемого класса исключений, а не от RuntimeException.

    11. Никогда не генерировать исключения в инструкции finally.


*/
package a2_OOP;

class a9_throw {
    public static void main(String[] args) {
        try {
            Studentic student1 = new Studentic("Иванов", 7.8, 22);
            System.out.println("Первый объект создан успешно");
            Studentic student2 = new Studentic("Петров", 8.9, -5);
            System.out.println("Второй объект создан успешно");
        } catch (StudentException ex) {
            System.out.println("Неверные данные студента! " + ex.getMessage());
        }
    }
}


class Studentic {
    private String surname;
    private double averageMark;
    private int age;

    // так как выбрасываем исключение в методе, то указываем throws StudentException
    public Studentic(String surname, double averageMark, int age) throws StudentException {
        this.surname = surname;
        this.averageMark = averageMark;
        if (age < 0) throw new StudentException("Неверный возраст"); // выбрасываем исключение
        this.age = age;
    }
}


// свое исключение
class StudentException extends Exception {
    public StudentException() {
    }

    // будет браться сообщение при вызове ex.getMessage()
    public StudentException(String message) {
        super(message);
    }

    // Throwable, что означает генерацию исключения на основе другого исключения
    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Throwable, что означает генерацию исключения на основе другого исключения
    public StudentException(Throwable cause) {
        super(cause);
    }

}








