import java.util.Arrays;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));
    }

    static int jumpingOnClouds(int[] c) {
        int numberOfJumps = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == 1) {
                continue;
            } else if (c[i] == 0 && i + 2 < c.length && c[i + 2] == 0) {
                numberOfJumps++;
                i++;
            } else {
                numberOfJumps++;
            }

        }
        return numberOfJumps;
    }
}
