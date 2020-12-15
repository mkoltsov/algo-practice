public class LoveLetterMystery {
    public static void main(String[] args) {
            System.out.println(isPalindrome("aba"));
            System.out.println(isPalindrome("abac"));
            System.out.println(isPalindrome("abaca"));
            System.out.println(isPalindrome("cba"));
            System.out.println(theLoveLetterMystery("abc"));
            System.out.println(theLoveLetterMystery("abcd"));
            System.out.println(theLoveLetterMystery("cba"));
    }

    static int theLoveLetterMystery(String s) {
        if (isPalindrome(s)) {
            return 0;
        }
        int numOperations = 0;
        for (int i=0; i<(s.length()/2); i++) {
            char left = s.charAt(i);
            char right = s.charAt(s.length()-1-i);
            if (left!=right){
                if (right>left) {
                    while (left!=right) {
                        numOperations++;
                        right=(char) (right-1);
                        System.out.printf("%c - %c %n",left, right);
                    }
                } else {
                    while (left!=right) {
                        numOperations++;
                        left=(char) (left-1);
                        System.out.printf("%c - %c %n",left, right);
                    }
                }
            }

        }
        return numOperations;
    }

    static boolean isPalindrome(String st) {
        for (int i=0; i<st.length()/2; i++) {
            if (st.charAt(i)!=st.charAt(st.length()-1-i))
            return false;
        }
    return true;
    }
}
