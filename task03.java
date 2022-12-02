// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
// поскольку точно не указано, какое именно среднее значение нужно, то ищем наиболее приближенное к среднему арифметическому


package DZ;

import java.util.*;

public class task03 {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4,5 ,100, 1000);

        int min = list.get(0);
        int max = list.get(0);
        int mid = 0;

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
            if (list.get(i) > max) {
                max = list.get(i);
            }
            sum = sum + list.get(i);
        }
        System.out.println(sum);
        int isk = sum / list.size();
        System.out.println(isk);
        int minAbs = Math.abs(list.get(0) - isk);
        for (int i = 0; i < list.size(); i++) {
            if ((Math.abs((list.get(i) - isk))) < minAbs) {
                minAbs = Math.abs(list.get(i) - isk);
                mid = list.get(i);
            }

        }

        System.out.println("минимальное = " + min + ", максимальное = " + max + ", самое близкое к среднему арифметическому = " + mid);
    }
}
