import java.util.function.Function;

public class TheTimeInWords {
    public static void main(String[] args) {
        System.out.println(timeInWords(5, 47));
        System.out.println(timeInWords(3, 0));
        System.out.println(timeInWords(7, 15));
        System.out.println(timeInWords(5, 45));
    }

    static String timeInWords(int h, int m) {
        String[] symbolic = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", " fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        Function<Integer, String> convertMinutes = (Integer i) -> i == 15 ? "" : i == 1 ? "minute" : "minutes";

        Function<Integer, String> filterMinutes = (Integer i) -> i == 30 ? "half" : i > 20 ? String.format("%s %s %s", symbolic[20], symbolic[i % 20], convertMinutes.apply(i % 20)) : String.format("%s %s", symbolic[i], convertMinutes.apply(i));

        return m == 0 ? String.format("%s o' clock", symbolic[h]) : m >= 1 && m <= 30 ? String.format("%s past %s", filterMinutes.apply(m).trim().replaceAll(" +", " "), symbolic[h]) : String.format("%s to %s", filterMinutes.apply(60 - m).trim().replaceAll(" +", " "), symbolic[h + 1]);
    }

}
