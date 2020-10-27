public class StringConstruction {
    public static void main(String[] args) {
        System.out.println(stringConstruction("abcd"));
        System.out.println(stringConstruction("abab"));
        System.out.println(stringConstruction("bccb"));
    }

    static int stringConstruction(String s) {
        return (int)s.chars().distinct().count();
//        char[] newString = new char[s.length()];
//
//        int cost = 0;
//        for (int i = 0; i < s.length(); i++) {
//            newString[i] = s.charAt(i);
//            cost++;
//            System.out.printf("%s -%s, %b, %d - %d%n", String.valueOf(newString), s.substring(i+1), String.valueOf(newString).equals(s.substring(i+1)), String.valueOf(newString).trim().length(), s.substring(i+1).length());
//            if (String.valueOf(newString).trim().equals(s.substring(i+1)) || new StringBuilder(String.valueOf(newString).trim()).reverse().toString().equals(s.substring(i+1))) {
//                return cost;
//            }
//        }
//        return cost;
    }
}
