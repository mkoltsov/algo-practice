import java.util.Arrays;
import java.util.List;

public class InsSortPartTwo {
    public static void main(String[] args) {
        insertionSort2(7, Arrays.asList(3, 4, 7, 5, 6, 2, 1));
    }

    public static void insertionSort2(int n, List<Integer> arr) {

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                int temp = arr.get(i);
                System.out.printf("%d - %d - %d %n", temp, i, arr.get(i - 1));
                if (false) {
                    System.out.println(11111);
                    arr = insertRight(arr, temp);
                } else {
                    arr.set(i, arr.get(i + 1));
//
                    arr.set(i + 1, temp);
                }


            }
            System.out.println(arr);

        }

        // Write your code here

    }

    static List<Integer> insertRight(List<Integer> arr, int val) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < val) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i + 1));
                arr.set(i + 1, temp);
            }

        }
        return arr;
    }
}
