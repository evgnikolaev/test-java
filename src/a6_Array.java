/*

МАССИВЫ


        массив - все элементы одного типа



                int a[]
                int[] a  - предпочтительно
                a = new int[5] - выделение памяти в куче
                все массивы динамические

                int[] a = new int[5]
                int[] a = new int[]{4,6,7,8}
                double[] c = {2, 4};





        Заполнение массива случайными числами

                Random rand = new Random(9);               //Создаем объект класса Random, начальное значение генератора 9 (случайное число на самом деле не случайно, вычисляется по рекрентной формуле)


                int[] a = new int[6];
                for(int i = 0; i < a.length; i++){
                    a[i] = rand.nextInt(6);                //0 включительно - 6 не включительно;   если нужен диапазон, то так    random.nextInt(max - min + 1) + min;
                    System.out.print(a[i] + " ");
                }
                System.out.println();



                double[] b = new double[10];
                for(int i = 0; i < b.length; i++){
                    b[i] = rand.nextDouble();               //0 включительно - 1 не включительно
                    System.out.printf("%.1f ",b[i]);
                }
                System.out.println();








Arrays

    Arrays.toString(mas);
    Arrays.sort(mas);
    Arrays.binarySearch(mas, 5);
    Arrays.fill(b, 2.5);
    Arrays.copyOf(mas, 5);
    Arrays.copyOfRange(mas, 4,8);




            1. String toString(Object[] a)    - массив в строку               Arrays.toString(mas);


            2. void sort(Object[] a)          - сортировка по возрастанию     Arrays.sort(mas);
                                    для чисел сортирвет только по возрастанию
                                    для строк можно задать обратную сортировку Collections.reverseOrder()

                                            String[] list = {"Даша", "Яна", "Ромка"};
                                            Arrays.sort(list, Collections.reverseOrder());     [Яна, Ромка, Даша]

                                            Arrays.sort(mas,3,7) - можно задать индексы, с каких сортировать



            3. int binarySearch(Object[] a, Object key)                         Arrays.binarySearch(mas, 5);
                    Находит в массиве a  индекс элемента key.  Массив a должен быть предварительно отсортирован!
                    Если в массиве таких элементов несколько, то находится индекс одного из них (какого именно - не гарантируется).
                    Если искомый элемент в массиве отсутствует, то метод вернет отрицательное число.

                                        int[] mas = {1, 2, -3, 4, 25, 6, 17, -1, 9, 6};
                                        Arrays.sort(mas);
                                        System.out.println(Arrays.toString(mas));
                                        int ind = Arrays.binarySearch(mas, 5);
                                        if(ind >= 0) {
                                             System.out.println("Индекс элемента = " + ind);
                                        }else{
                                             System.out.println("Элемент отсутствует");
                                        }




             4. void fill(Object[] a, Object val)                       Arrays.fill(b, 2.5);
                        Заполняет массив a одинаковыми значениями val.  Работает только с одномерными массивами.

                                        double[] b = new double[5];
                                        Arrays.fill(b, 2.5);


                                        Arrays.fill(b, 2 индекс начала, 4 индекс конца, 0.8) - можно задать индексы заполнения





            5. int[] copyOf(int[] original, int newLength длина нового массива)         Arrays.copyOf(mas, 5);
                        копирует массив

                                        int[] mas = {1, 2, -3, 4, 25, 6, 17, -1, 9, 6};
                                        int[] c = Arrays.copyOf(mas, 5);


            6. int[] copyOfRange(int[] original, int from включая, int to не включая)                Arrays.copyOfRange(mas, 4,8);
                        копирует массив по индексам

                                    int[] mas = {1, 2, -3, 4, 25, 6, 17, -1, 9, 6};
                                    int[] d = Arrays.copyOfRange(mas, 4,8);




ДВУМЕРНЫЕ МАССИВЫ

        int[][] a = new int[3][4];
        int[][] array = {{3,5},{6,7},{9,10}};
        int[][] ar = new int[][]{{1,2,3},{4,5,6},{7,8,9}};


        Отложенная инициализация

                int[][] b = new int[3][];                                   //создается массив из 3 х массивов
                b[0] = new int [2];                                         //первая строка из 2 х элементов
                b[1] = new int [4];                                         //вторая строка из 4 х элементов
                b[2] = new int [3];                                         //третья строка из 3 х элементов

                for (int i = 0; i < b.length; i++){ //b.length равно 3
                    for (int j = 0; j < b[i].length; j++) {                 //b[i].length - длина текущей строки
                          System.out.print(b[i][j] + "\t");
                    }
                    System.out.println();
                }

                    результат:
                            0    0
                            0    0    0    0
                            0    0    0




Массивы


        Массивы - ссылочный тип данных!!


                int[] a = new int[]{4,6,7,8};
                int[] b = a;
                a[1]=1000;
                System.out.println(Arrays.toString(a));  //[4, 1000, 7, 8]
                System.out.println(Arrays.toString(b));  //[4, 1000, 7, 8]



                public static void main(String[] args) {
                    int[] a = new int[7];
                    init(a);
                    print(a);
                }
                public static void init(int[] mas){       // меняем и массив a , так как массивы - это ссылочный тип данных
                    Random rand = new Random();
                    for(int i = 0; i < mas.length; i++){
                        mas[i] = rand.nextInt(11);
                    }
                }

 */


import java.util.Random;
import java.util.Scanner;

class   a6_Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] ar = new int[scan.nextInt()];
        long seed = scan.nextLong();
        init(ar, seed);
        print(ar);
        int[] b = reduceAfterMax(ar);
        print(b);
    }


    public static void init(int[] mas, long seed) {
        Random rand = new Random(seed);
        for (int i = 0; i < mas.length; i++) {
            //random.nextInt(max - min + 1) + min;
            mas[i] = rand.nextInt(5 + 3 + 1) - 3;
        }
    }

    public static void print(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    public static int findMax(int[] mas) {
        int max = mas[0];
        int k = 0;
        for (int i = 0; i < mas.length; i++) {
            if (max < mas[i]) {
                max = mas[i];
                k = i;
            }
        }
        return k+1;
    }


    public static int[] reduceAfterMax(int[] mas) {
        int k = findMax(mas);

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++){
            result[i] = mas[i];
        }
        return result;
    }
}



















