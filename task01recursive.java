// Реализовать алгоритм сортировки слиянием
//все равно, пришлось подсматривать решения, раз уж подсмотрел, то решил найти и рекурсивное решение и итерационное

package DZ;

import java.util.Arrays;

public class task01recursive {
    public static void main(String[] args) {
        //вводим массив для сортировки
        int[] arrayToSort = { 5, 5, 0, -5, 6, 8, 3, -2, 1, 2, 9, -9 };
        System.out.println();
        //запускаем метод сортировки
        System.out.print(Arrays.toString(sortSl(arrayToSort)));

    }

    public static int[] sortSl(int[] arr) {
        //проверяем, что длина массива больше 1 (проверка выхода из рекурсии)
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        //делим массив на 2 части
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        //запускаем метод деления массива рекурсивно
        left = sortSl(left);
        right = sortSl(right);
        //возвращаем результат через метод слияния двух частей
        return leftPlusRight(left, right);

    }

    public static int[] leftPlusRight(int[] left, int[] right) {
        //вводим результирующий массив
        int[] res = new int[left.length + right.length];
        int posLeft = 0;
        int posRight = 0;
        int i = 0;
        //запускаем цикл слияния
        while (i < res.length) {
            //запускаем проверку, какой из элементов массивов меньше, пока не дошли до длины наименьшего из массивов
            if ((posLeft < left.length) && (posRight < right.length)) {
                if (left[posLeft] < right[posRight]) {
                    res[i] = left[posLeft];
                    // System.out.println("posLeft < left.lengt &&, res[i] =" + res[i] + " = left[" + posLeft + "]");
                    i++;
                    posLeft++;
                } else {
                    res[i] = right[posRight];
                    // System.out.println("posLeft < left.lengt &&, res[i] = " + res[i] + " = right[" + posRight + "]");
                    i++;
                    posRight++;
                }
            } else {
                //проверяем, если остались элементы в правом массиве, добавляем к результату
                if (posLeft >= left.length) {
                    while (posRight < right.length) {
                        res[i] = right[posRight];
                        // System.out.println("posLeft >= left.lenght, res[i] = " + res[i] + " = right[" + posRight + "]");
                        i++;
                        posRight++;
                    }
                }
                //проверяем, если остались элементы в левом массиве, добавляем к результату
                if (posRight >= right.length) {
                    while (posLeft < left.length) {
                        res[i] = left[posLeft];
                        // System.out.println("posLeft < left.lenght, res[i] = " + res[i] + " = left[" + posLeft + "]");
                        posLeft++;
                        i++;
                    }
                }
            }
        }
        return res;
    }
}