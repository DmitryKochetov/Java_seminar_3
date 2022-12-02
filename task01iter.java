// Реализовать алгоритм сортировки слиянием
//все равно, пришлось подсматривать решения, раз уж подсмотрел, то решил найти и рекурсивное решение и итерационное

package DZ;

import java.util.Arrays;

public class task01iter {
    public static void main(String[] args) {
        int[] arrayToSort = { 5, 5, 0, -5, 6, 8, 3, -2, 1, 2, 9, -9 };
        System.out.println(Arrays.toString(arrayToSort));
        // запускаем метод сортировки
        System.out.println(Arrays.toString(sortSlNonRecursive(arrayToSort)));

    }

    public static int[] sortSlNonRecursive(int[] array) {
        int[] temp;
        int[] currentArray = array;
        int[] newArray = new int[array.length];

        int count = 1;
        while (count < array.length) {
            //запускаем цикл в пределах длины полученного массива и добавляем в новый массив отсортированные подмассивы со сдвигом на count
            for (int i = 0; i < array.length; i += 2 * count) {
                leftPlusRight(currentArray, i, currentArray, i + count, newArray, i, count);
            }
            temp = currentArray;
            currentArray = newArray;
            newArray = temp;
            count = count * 2;
        }
        return currentArray;
    }

    private static void leftPlusRight(int[] left, int leftStart, int[] right, int rightStart, int[] dest,
        int destStart, int count) {
        int index1 = leftStart;
        int index2 = rightStart;

        //присваиваем конечной точке минимальное из двух значений (для двух частей подмассива)
        int leftEnd = Math.min(leftStart + count, left.length);
        int rightEnd = Math.min(rightStart + count, right.length);

        if (leftStart + count > left.length) {
            for (int i = leftStart; i < leftEnd; i++) {
                dest[i] = left[i];
            }
            return;
        }

        int iterationCount = leftEnd - leftStart + rightEnd - rightStart;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < leftEnd && (index2 >= rightEnd || left[index1] < right[index2])) {
                dest[i] = left[index1];
                index1++;
            } else {
                dest[i] = right[index2];
                index2++;
            }
        }
    }
}
