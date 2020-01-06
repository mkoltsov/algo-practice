public class CatsAndMouse {
    public static void main(String... args) {
        System.out.println(catAndMouse(1, 2, 3));
        System.out.println(catAndMouse(1, 3, 2));
    }

    static String catAndMouse(int x, int y, int z) {
        int catADistance = Math.abs(z-x);
        int catBDistance = Math.abs(z-y);
        return catADistance==catBDistance ? "Mouse C" :  catADistance>catBDistance ? "Cat B" : "Cat A";
    }
}
