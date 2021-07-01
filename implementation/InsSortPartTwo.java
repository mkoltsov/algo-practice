import java.util.Arrays;
import java.util.List;

public class InsSortPartTwo {
    public static void main(String[] args) {
        insertionSort2(7, Arrays.asList(1, 4, 3, 5, 6, 2));
    }

    public static void insertionSort2(int n, List<Integer> arr) {

        for (int i = 1; i < arr.size(); i++) {
            int j = i;
            int value = arr.get(i);
            while (j >= 1 && arr.get(j-1) > value) {
                arr.set(j, arr.get(j-1));// array[j] = array[j-1];
                j--;
            }
            arr.set(j, value);
//            array[j] = value;
//            printArray(array);
//            System.out.println(arr);
            arr.forEach(x-> System.out.print(x+" "));
            System.out.println();


        }

//        for (int i = 1; i < arr.size(); i++) {
//            if (arr.get(i) > arr.get(i + 1)) {
//                int temp = arr.get(i);
////                System.out.printf("%d - %d - %d %n", temp, i, arr.get(i - 1));
////                if (false) {
////                    System.out.println(11111);
////                    arr = insertRight(arr, temp);
////                } else {
////                if (i>0){
//                    for (int j=i;j!=0;j--){
//                        System.out.printf("%d - %d - %d %n",arr.get(i), arr.get(j-1), i );
//                        if (arr.get(i)>arr.get(j)){
//                            System.out.printf("%d - %d - %d %n",arr.get(i), arr.get(j), i );
//                        }
//                    }
//                }
//                    arr.set(i, arr.get(i + 1));
////
//                    arr.set(i + 1, temp);
//                }


//            }
//            System.out.println(arr);

        }



        // Write your code here

    }

//    static List<Integer> insertRight(List<Integer> arr, int val) {
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i) < val) {
//                int temp = arr.get(i);
//                arr.set(i, arr.get(i + 1));
//                arr.set(i + 1, temp);
//            }
//
//        }
//        return arr;
//    }
//}
