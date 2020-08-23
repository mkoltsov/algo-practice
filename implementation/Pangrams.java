import java.util.stream.Collectors;

public class Pangrams {
    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
    }

    static String pangrams(String s) {
        return " abcdefghijklmnopqrstuvwxyz".equals(String.join("", s.toLowerCase().trim().chars().boxed().map(i -> String.valueOf((char) i.intValue())).collect(Collectors.toSet()))) ? "pangram" :"not pangram";
    }
}
