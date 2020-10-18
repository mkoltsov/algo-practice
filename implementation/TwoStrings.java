public class TwoStrings {
    public static void main(String[] args) {
        System.out.println(twoStrings("hello","world"));
        System.out.println(twoStrings("hi","world"));
    }

    static String twoStrings(String s1, String s2) {
        return s1.chars().anyMatch(c->s2.contains(String.valueOf((char) c)))? "YES":"NO";
    }
}
