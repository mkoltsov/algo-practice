public class PalindromeIndex {
    public static void main(String[] args) {
        System.out.println(palindromeIndex("bcbc"));
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
    }
    static int palindromeIndex(String s) {
        if (isPalindrome(s)) {
            return -1;
        }
        int n=s.length();
        int index=0;
        for (int i=0; i<(n/2);i++){
            if (s.charAt(i)!=s.charAt(n-i-1)){
//                System.out.printf("%c - %c, %d - %d %n",s.charAt(i), s.charAt(n-i-1), i, n-i-1);
                boolean deleteFirst = isPalindrome(new StringBuilder(s).deleteCharAt(i).toString());
                boolean deleteLast = isPalindrome(new StringBuilder(s).deleteCharAt(n-i-1).toString());

                if (deleteFirst || deleteLast){
//                    System.out.println(111);
                    return deleteFirst? i : n-i-1;//index=i;
                } else {
                    return -1;
                }
            }
        }
        return index;
    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

}
