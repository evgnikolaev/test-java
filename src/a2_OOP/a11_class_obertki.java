/*

Классы-обертки (wrapper classes)

    Для всех примитивных типов в Java существуют соответствующие классы-обертки.

            byte	    Byte        (наследник Number)
            char	    Character
            short	    Short       (наследник Number)
            int	        Integer     (наследник Number)
            long	    Long        (наследник Number)
            float	    Float
            double	    Double
            boolean	    Boolean



Статические методы классов-оберток

        valueOf()
            Integer i4 = Integer.valueOf("5");
            Integer i5 = Integer.valueOf(7);
            Float f1 = Float.valueOf(1.3f);


        parseXXX()
            int m = Integer.parseInt("123");
            boolean b1 = Boolean.parseBoolean("TRUE");


        toBinaryString()
            String binaryString = Integer.toBinaryString(21);   // 10101 - в двоичный формат


        toHexString()
            String hexString = Integer.toHexString(255);        // ff - в шестнадц. формат
            String hexString2 = Double.toHexString(3.14);


        Класс-обертка  Character
            boolean isDigit1 = Character.isDigit('3');          // является ли символ цифрой?
            boolean isUpper = Character.isUpperCase('b');       // в верхнем регистре?







Автоматическая упаковка и распаковка



        Раньше для получения примитивного значения из объекта-обертки  использовали:
        intValue(), doubleValue(), charValue() ...

                Integer example = Integer.valueOf("5");
                int value = example.intValue();



        Автоматическая упаковка (autoboxing)
        - это механизм неявного создания (без использования оператора new) объекта класса-обертки.

                Integer i = 5;      //числовой литерал автоматически преобразуется в объект
                Boolean b = true;   //булевский литерал неявно преобразуется в объект


        Автоматическая распаковка (unboxing)
        - это механизм неявного преобразования объекта типа-обертки в примитивный тип.

                Integer n = new Integer(5);
                int num = n;                            //автоматическая распаковка



        Автоматическая упаковка и распаковка может происходить в операторе присваивания, при передаче в метод, а также в выражениях.

                Double x = Double.valueOf(3.14);
                System.out.println(Math.sin(x));        //передали в метода класс-обертку


        Автоматической распаковки в выражении:

                Integer i1 = Integer.valueOf("15");
                int m = 25 + i1;                        //распаковка


                Integer k1 = 34;                        //автоматическая упаковка
                Integer k2 = 18;
                System.out.println(k1 > k2);            //автоматическая распаковка



Автоматическая упаковка и распаковка упрощают код, но могут привести к ряду ошибок

                Integer number = null;
                int j = number;                         // возникнет исключение NullPointerException


            Проверка на равенство, неравенство не подразумевает распаковки!

                Integer num1 = new Integer(123);
                Integer num2 = new Integer(123);
                System.out.println(num2 == num1);       //false, сравниваются ссылки


                Integer num3 = 123;
                Integer num4 = 123;
                System.out.println(num3 == num4);       // true, тут тоже происходи кеширование
                                                        // аналогично примеру ниже

                Integer num5 = Integer.valueOf(123);    // valueOf() кеширует значение от -128 до 127
                Integer num6 = Integer.valueOf(123);    // (верхнюю границу можно изменять, но по умолчанию она такая).
                System.out.println(num5 == num6);       // true, то есть num6 - закешируется.
                                                        // если передать например 150, то уже результат будет false



            Автоупаковка не работает для массивов

                public static void print(int[] array) {
                    for (int item : array) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                }

                Integer[] mas = {3, 6, 8};
                print(mas);                             // ошибка!
                                                        // Массив Integer[] не преобразуется в массив int[]




Применение автоупаковки и автораспаковки
        Например, в колллекции (списки, множества и т.п.) мы можем помещать только объекты классов,
        а примитивные переменные не можем. Поэтому, если нужно, например, создать список из целых чисел,
        то мы объявляем список из Integer:

        ArrayList<Integer> list = new ArrayList<>();
        А при добавлении числа происходит автоматическая упаковка int в Integer:
        list.add(2);


*/
package a2_OOP;


class a11_class_obertki {
    public static void main(String[] args) {


    }
}
