package week1;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        plusMinus(Arrays.asList(1,1,0,-1,-1));
    }

    public static void plusMinus(List<Integer> arr) {
        int positives=0, negatives=0, zeros =0;

        for (int i: arr){
            if (i>0){
                positives++;
            } else if (i<0) {
                negatives++;
            } else
                zeros++;
        }

        System.out.println((double)positives/(double) arr.size());
        System.out.println((double)negatives/(double) arr.size());
        System.out.println((double)zeros/(double) arr.size());

    }

}
