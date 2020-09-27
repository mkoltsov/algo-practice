public class AlternatingCharacters {
    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AABAAB"));
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABAB"));
        System.out.println(alternatingCharacters("BABABA"));
        System.out.println(alternatingCharacters("AAABBB"));
    }

    static int alternatingCharacters(String s) {
        int ops = 0;

        for (int i=0; i<s.length()-1;i ++) {
            char current = s.charAt(i);
            char next = s.charAt(i+1);
            if (next!=current) {
            } else {
                ops++;}
        }
    return ops;
    }
}
