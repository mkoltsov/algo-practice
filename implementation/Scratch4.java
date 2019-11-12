import java.util.Arrays;

public class Scratch4 {
    public static void main(String... args) {
        System.out.println(divisibleSumPairs(6, 5, new int[]{1, 2,3,4,5,6}));
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count =0;
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i; j < ar.length; j++) {
                System.out.println(ar[i] + "  "+ar[j]);
                if (i<j && (ar[i]+ar[j])%k==0) {
                    count++;
                }
            }
        }
        return count;
    }

}
