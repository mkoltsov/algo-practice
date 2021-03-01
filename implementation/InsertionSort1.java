import java.util.Arrays;

public class InsertionSort1 {

    public static void main(String[] args) {
//        insertionSort1(5, new int[]{1, 2, 4, 5, 3});
//        insertionSort1(5, new int[]{2, 4, 6, 8, 3});
        insertionSort1(5, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1});
    }

    static void insertionSort1(int n, int[] arr) {
        int curr = arr[arr.length - 1];
        boolean selfInserted = false;
        for (int i = arr.length - 1; i > 0; i--) {
            if (curr > arr[i - 1]) {
                selfInserted=true;
                arr[i] = curr;
                Arrays.stream(arr).forEach(k->System.out.print(k+" "));
                System.out.println();
//                System.out.println(Arrays.toString(arr));
                break;
            } else {
//                selfInserted=true;
//                System.out.println(i);
//                if (i==0){
//                    arr[i-1]=curr;

//                } else {
                    arr[i] = arr[i - 1];
//                }
//
//            }

//                System.out.println(Arrays.toString(arr));
                Arrays.stream(arr).forEach(k->System.out.print(k+" "));
                System.out.println();
            }
//            if (i==0 &&!selfInserted){
//
//            }
        }

        if (!selfInserted){
            arr[0] = curr;
//                }
//
//            }

//                System.out.println(Arrays.toString(arr));
            Arrays.stream(arr).forEach(k->System.out.print(k+" "));
            System.out.println();
        }

    }
}
