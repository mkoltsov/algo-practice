public class TaumBDay {
    public static void main(String[] args) {
        System.out.println(taumBday(3,5, 3,4,1));
        System.out.println(taumBday(10, 10,              1, 1, 1));
        System.out.println(taumBday(5, 9,                2, 3, 4));
        System.out.println(taumBday(3, 6,                9, 1, 1));
        System.out.println(taumBday(27984, 1402,
                619246, 615589, 247954));
    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        return (long)b*Math.min((long)bc, (long)wc + (long)z)+(long)w*Math.min((long)wc, (long)bc + (long)z);
    }
}
