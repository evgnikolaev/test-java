/*

Пакеты:


Обращаться можно как:
        public class Runner {
            Example1.ClassA objA = new Example1.ClassA();
            Example2.ClassC objC = new Example2.ClassC();
        }


либо через импорты:
        //import Example1.ClassA;
        import Example1.*;
        import Example2.*;
        public class Runner {
            ClassA objA = new ClassA();
            ClassC objC = new ClassC();
        }



Существует четыре спецификатора доступа для членов класса:
    - public  - компонент доступен из любого класса любого пакета;
    - private – компонент доступен только в своем классе;
    - спецификатор по умолчанию (если отсутствует другой спецификатор) – компонент доступен для других классов этого же пакета;
    - protected – компонент доступен в своем пакете и подклассам в других пакетах.


 */
package a2_OOP;
class a55_pakets {
    public static void main(String[] args) {

    }
}

