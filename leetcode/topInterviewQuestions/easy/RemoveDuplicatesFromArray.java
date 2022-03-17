package topInterviewQuestions.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {

//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{1, 1}));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int currentIndex = 0;
        int currentNumber = nums[k];

        while (currentIndex != nums.length - 1) {
            currentIndex++;
            if (currentNumber == nums[currentIndex] && currentIndex<nums.length - 1) {
                while (currentNumber == nums[currentIndex]) {
                    currentIndex++;
                }
            }
            k++;
            currentNumber = nums[currentIndex];
            nums[k] = currentNumber;
        }
        System.out.println(Arrays.toString(nums));

        return k+1;
    }

}
