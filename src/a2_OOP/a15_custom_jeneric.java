/*

Дженерики (обобщения или параметризованные типы)
https://stepik.org/lesson/1085541/step/6?unit=1095945

        Обобщения (дженерики) позволяют создавать классы, интерфейсы и методы, в которых тип данных указывается в виде параметра.
        Используя обобщения, можно создать единственный класс, который автоматически будет работать с различными типами данных.

                ArrayList<Student>
                можно помещать объекты класса Student (и наследников), но нельзя помещать объекты класса Dog или Purchase!



        Параметром типа для дженерика может быть только ссылочный тип, интерфейс или перечисление (enum)

                //ArrayList<int> list1 = new ArrayList<>();     //параметр Дженерика не может быть примитивного типа
                ArrayList<Integer> list2 = new ArrayList<>();
                ArrayList<int[]> list3 = new ArrayList<>();     //массив - это ссылочный тип в Java
                ArrayList<Integer[]> list4 = new ArrayList<>();




        Использование синтаксиса дженерика

                ArrayList<Student> list = new ArrayList<>();            //при описании типа переменных


                public static void print(ArrayList<Student> list) {     //при описании методов
                    for (Student item : list) {
                        System.out.println(item);
                    }
                }




        Описании коллекций с обобщениями (в документации или если Вы сами создаете коллекцию)

                 ArrayList<String> list = new ArrayList<String>();

                 описание  ArrayList в документации

                         public class ArrayList<E> extends AbstractList<E>...{
                             public boolean add (E o){
                             ...
                             }
                             //еще код
                         }

                 компилятором воспринимается как, вместо <E> подставляется нужный тип

                        public class ArrayList<String> extends AbstractList<String>...{
                             public boolean add (String o){
                             ...
                             }
                             //еще код
                         }



                При объявлении дженериков для идентификации типа можно использовать любую букву, но рекомендации Oracle следующие:
                        E — element, для элементов параметризованных коллекций;
                        K — key, для ключей map-структур;
                        V — value, для значений map-структур;
                        N — number, для чисел;
                        T — type, для обозначения типа параметра в произвольных классах;
                        S, U и так далее — применяются, когда в дженерик-классе несколько параметров.





                extends в дженериках
                    означает не только нассдеование, но и реализует интерфейс

                    public <T extends Student> void print(ArrayList<T> list){…}


*/
package a2_OOP;
import java.util.Scanner;


public class a15_custom_jeneric {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        while (!"end".equals(data)) {
            list.add(data);
            data = scan.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}



// пример своего дженерика, аналог ArrayList
class MyArrayList<E> {
    private E[] list;
    private int k; //индекс свободной ячейки

    public MyArrayList() {
        list = (E[]) new Object[10]; //массив из Object привожу к E
        k = 0;
    }

    public MyArrayList(int n) {
        list = (E[]) new Object[n];
        k = 0;
    }

    public void add(E elem) {
        if (k >= list.length) { //нет места
            E[] tmp = (E[]) new Object[list.length / 2 + list.length + 1]; //создаем новый массив и приводим к типу E[]
            for (int i = 0; i < list.length; i++) { //переписываем из исходного массива в новый
                tmp[i] = list[i];
            }
            list = tmp; //считаем новый массив текущим
        }
        list[k++] = elem; //записываем элемент и увеличиваем k в любом случае
    }

    public void add(int index, E elem) {
        if (k >= list.length) { //нет места
            E[] tmp = (E[]) new Object[list.length / 2 + list.length + 1]; //создаем новый массив и приводим к типу E[]
            for (int i = 0; i < list.length; i++) { //переписываем из исходного массива в новый
                tmp[i] = list[i];
            }
            list = tmp; //считаем новый массив текущим
        }
        if (index < 0 || index >= list.length) {
            throw new IndexOutOfBoundsException();
        }
        //подвигаем все правее вставляемого индекса
        for (int i = k - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = elem; //вставляем элемент
        k++; //индекс свободного места подвигаем

    }

    public E get(int index) {
        if (index < 0 || index >= list.length) { //можно и не проверять, это исключение автоматически возникнет
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public int indexOf(E elem) {
        int index = -1;
        for (int i = 0; i < k; i++) {
            if (list[i].equals(elem)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(E elem) {
        int index = -1;
        for (int i = k - 1; i >= 0; i--) {
            if (list[i].equals(elem)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public E remove(int index) {
        E tmp = list[index]; //здесь может возникнуть исключение
        for (int i = index; i < k - 1; i++) {
            list[i] = list[i + 1]; //подвигаем все элементы правее удаляемого
        }
        k--; //уменьшаем количество
        return tmp;
    }

    public E set(int index, E elem) {
        E tmp = list[index]; //сохраняем старое значение элемента
        list[index] = elem; //заменяем на новое
        return tmp; //возвращаем страрое
    }

    public int size() {
        return k;
    }

    public boolean isEmpty() {
        return k == 0;
    }
}

