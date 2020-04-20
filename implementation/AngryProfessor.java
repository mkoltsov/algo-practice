import java.util.stream.IntStream;

public class AngryProfessor {
    public static void main(String[] args) {
        System.out.println(angryProfessor(3, new int[]{-1, -3, 4 ,2}));
        System.out.println(angryProfessor(2, new int[]{0, -1, 2, 1}));
        System.out.println(angryProfessor(4, new int[]{-93, -86, 49, -62, -90, -63, 40, 72, 11, 67}));
        System.out.println(angryProfessor(10, new int[]{23, -35, -2, 58, -67, -56 ,-42, -73, -19, 37}));
        System.out.println(angryProfessor(9, new int[]{91, 56, -62, 96, -5, -84, -36, -46, -13}));
        System.out.println(angryProfessor(8, new int[]{67, 64, -50, -8 ,78, 84, -51, 99, 60}));
        System.out.println(angryProfessor(7,  new int[]{26, 94, -95 ,34 ,67, -97, 17 ,52, 1, 86}));
        System.out.println(angryProfessor(2, new int[]{29, -17, -71, -75, -27, -56, -53, 65, 83}));
        System.out.println(angryProfessor(10, new int[]{-32, -3 ,-70, 8, -40, -96 ,-18 ,-46, -21, -79}));
        System.out.println(angryProfessor(9, new int[]{-50, 0, 64, 14, -56, -91, -65, -36, 51, -28}));
        System.out.println(angryProfessor(6, new int[]{-58 ,-29, -35, -18, 43, -28, -76 ,43, -13, 6}));
        System.out.println(angryProfessor(1, new int[]{88 ,-17 ,-96, 43 ,83 ,99, 25, 90, -39, 86}));
    }

    static String angryProfessor(int k, int[] a) {
        return  (int) IntStream.of(a).boxed().filter(i->i<=0).count() >=k ? "NO": "YES";
    }
}
