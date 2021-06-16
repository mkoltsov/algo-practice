import java.util.Arrays;
import java.util.List;

public class InsSortPartOne {
    public static void main(String[] args) {
        insertionSort1(5, Arrays.asList(1,2,4,5,3));
    }

    public static void insertionSort1(int n, List<Integer> arr) {

        for (int i=n-1; i!=0; i--){
            if (arr.get(i)<arr.get(i-1)){
                int temp = arr.get(i);
                arr.set(i, arr.get(i-1));
                arr.set(i-1, temp);
            }

        }

        System.out.println(arr);
    }
}
