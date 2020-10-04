import java.util.Arrays;

public class SuperReducedString {
    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd"));
        System.out.println(superReducedString("aa"));
        System.out.println(superReducedString("baab"));
        System.out.println(superReducedString("mwkommokwmxjivkkvijxshscbbcshsgwdyqqydwgzpnlzzlnpzvfeaiiaefvyeqjccjqeymhqhiihqhmhaomkkmoahhddymmyddh"));
    }

    static String superReducedString(String s) {
        String result = s;
        for (int i=0; i<s.length()/2;i++){
            result = reduceString(result);
        }
        return result.trim().isEmpty() ? "Empty String": result.trim();
    }

    static String reduceString(String s) {
        char[] result = new char[s.length()];
        int rpi = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            char next = i + 1 != s.length() ? s.charAt(i + 1) : Character.MAX_VALUE;
//            System.out.println(String.format("%c - %c", curr, next));
            if (curr == next) {
                i++;
            } else {
                result[rpi] = curr;
                rpi++;
            }

        }
        return String.valueOf(result);
    }
}
