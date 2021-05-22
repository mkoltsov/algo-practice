public class JumpingOnCloudsRevisited {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0}, 2));
        System.out.println("-------------");
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2));
    }

    static int jumpingOnClouds(int[] c, int k) {
        int initialEnergy = 100;
        int iter = 0;
        for (int i = 0; i < c.length; i = (i + k) % c.length) {
            if (i == 0 & iter > 0) {
                break;
            }
//        System.out.println(i);
            iter++;
            initialEnergy -= 1;

            if (c[i] == 1) {
                initialEnergy -= 2;
            }


//        System.out.println(initialEnergy);
        }
        return initialEnergy;
    }
}
