package topInterviewQuestions.easy;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) {
//                System.out.println("duplicate");
            } else {
                k++;
            }
        }
        return k+1;
    }

}
