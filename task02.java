// Пусть дан произвольный список целых чисел, удалить из него четные числа

package DZ;

import java.util.*;

public class task02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        //вводим итератор для перебора коллекции
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            //проверяем на четность
            if (iter.next()%2==0) {
                iter.remove();               
            }
        }
        //результат
        System.out.println();
        for (int n = 0; n < list.size(); n++) {
            System.out.print(list.get(n) + " ");
        }

    }

}
