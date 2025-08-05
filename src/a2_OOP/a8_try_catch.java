/*

Исключения:


    Throwable
        - Error                                                 - это критические ошибки.
                - StackOverflowError                            - переполнение стека вызовов
                - OutOfMemoryError                              - нехватка памяти для создания новых объектов

        -Exception                                              - менее серьезные ошибки
                 - непроверяемые (unchecked)                    - не обязан предусматривать обработку в программе (хотя может это сделать, если потребуется)
                         - ArrayIndexOutOfBoundsException       - выход за границы массива)
                         - ArithmeticException                  - арифметическая ошибка, например деление на ноль
                         - NumberFormatException                - неверное преобразование символьной строки в число  и т.д.



                - проверяемые (checked)                         - это такие исключения, на которые следует обязательно реагировать в программе
                         IOExeption                             - ошибка ввода-вывода
                         SQLException                           - ошибка при обращенио к базе данных и т.д.




синтаксис

            try {
                //блок кода, в котором должны отслеживаться ошибки
            } catch (типИсключения1 имяОбъектаИсключения1){
                //обработчик исключения типа 1
            } catch (типИсключения2 имяОбъектаИсключения2){
                //обработчик исключения типа 2
            } finally {
                //выполнится всегда
                //Блок finally будет вызван даже в том случае, если в блоке try/catch присутствует оператор return
                //для немедленного возврата из метода.
            }


        Можно группировать исключения.
                catch (ArithmeticException | ArrayIndexOutOfBoundsException exc)


        Можно вкладывать блоки try-catch друг в друга.
                Исключение, возникшее во внутреннем блоке try, и не перехваченное соответствующим  catch,
                распространяется далее во внешний блок try и обрабатывается связанным с ним блоком catch.





Методы класса Throwable

        String getMessage()                         Возвращает описание исключения
        void printStackTrace()                      Выводит сообщение об ошибке и трассировку стека вызовов на консоль
        void printStackTrace(PrintStream поток)     Выводит трассировку стека вызовов в указанный поток
        String toString()                           Возвращает строку, содержащую полное описание исключения.



*/
package a2_OOP;

class a8_try_catch {
    public static void main(String[] args) {
        int number[] = {4, 8, 16, 32, 64, 128, 256, 512};
        int denom[] = {2, 0, 4, 4, 0, 8};
        try {
            for (int i = 0; i < number.length; i++) {
                try {
                    int result = number[i] / denom[i];
                    System.out.println(number[i] + "/" + denom[i] + "=" + result);
                } catch (ArithmeticException ex) {
                    System.out.println("Деление на ноль");

                    //Методы класса Throwable
                    System.out.println("В блоке catch");
                    System.out.println("Описание исключения: " + ex.getMessage());
                    System.out.println("Стандартное сообщение:");
                    System.out.println(ex); //неявный вызов toString()
                    System.out.println("\nСтек вызовов:");
                    ex.printStackTrace();

                }
            }

            // Исключение, возникшее во внутреннем блоке try, и не перехваченное соответствующим  catch,
            // распространяется далее во внешний блок try и обрабатывается связанным с ним блоком catch.
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Выход за пределы массива");
        }catch (Exception exc) {
            System.out.println("общее исключение");
        }
        System.out.println("Продолжение программы...");
    }
}












