import java.util.Arrays;

public class InsertionSort2 {
    public static void main(String[] args) {
        insertionSort2(6, new int[]{1, 4, 3, 5, 6, 2});
//        insertionSort2(6, new int[]{1, 3, 4, 5, 6, 2});
    }

    // Complete the insertionSort2 function below.

    static int[] shiftRight(int[] arr, int positionSource, int positionDestination){
        int copied = arr[positionSource];
        arr[positionSource]=Integer.MAX_VALUE;

//        arr[positionDestination]=arr[positionSource];
        int numberOfShifts= Math.abs(positionDestination-positionSource);
        int shift=0;
        System.out.printf("%d %d %n", positionDestination, positionSource);
        int prev=arr[positionDestination+shift];
        while (numberOfShifts>0){
            System.out.println(11111);
            System.out.printf("%d %d %d %d %n", positionDestination, positionSource, shift, numberOfShifts);
            prev = arr[positionDestination+(shift+1)];
            arr[positionDestination+(shift+1)]=prev;
            System.out.println(222+Arrays.toString(arr));
            shift++;
            numberOfShifts--;
        }
        arr[positionDestination]=copied;
        return arr;
//        for (int i=positionDestination; i<arr.length-1;i++){
//            if (arr[i+1]==Integer.MAX_VALUE){
//
//            }
//        }



    }
    static void insertionSort2(int n, int[] arr) {

        for (int i = 0; i < arr.length ; i++) {
            int curr =arr[i];
            for (int j = 0; j < i; j++) {
                System.out.printf("indi=%d indj=%d val1=%d val2=%d %n", i, j, curr, arr[j]);
                if (curr<arr[j]){
                    System.out.println(444+Arrays.toString(shiftRight(arr,i,j)));
//                    System.out.println(333+Arrays.toString(arr));
                }
//                if (curr > arr[j - 1]) {
////                    selfInserted=true;
//                    arr[j] = curr;
//                    Arrays.stream(arr).forEach(k->System.out.print(k+" "));
//                    System.out.println();
////                System.out.println(Arrays.toString(arr));
//                    break;
//                } else {
////                selfInserted=true;
////                System.out.println(i);
////                if (i==0){
////                    arr[i-1]=curr;
//
////                } else {
//                    arr[j] = arr[j - 1];
////                }
////
////            }
//
////                System.out.println(Arrays.toString(arr));
//                    Arrays.stream(arr).forEach(k->System.out.print(k+" "));
//                    System.out.println();
//                }

//                if (arr[i] < arr[i]) {

//                } else
            }
        }

    }
}
