import java.util.ArrayList;
import java.util.List;

public class HighestValuePalindrome {
    public static void main(String[] args) {
        System.out.println(highestValuePalindrome("0011", 4,1));
        System.out.println(highestValuePalindrome("092282", 6,3));
    }

    static String highestValuePalindrome(String s, int n, int k) {

        if(s == null || s.isEmpty()) {
            return "-1";
        }

        int changes = 0;
        char[] text = s.toCharArray();

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if(text[i] != text[j]) {
                changes++;

                if(changes > k) {
                    return "-1";
                }
            }
        }

        if(k == 0) {
            return s;
        }

        int extraChanges = k - changes;

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if(text[i] == text[j]) {
                if(extraChanges >= 2 && text[i] != '9') {
                    text[i] = '9';
                    text[j] = '9';
                    extraChanges-= 2;
                }
            } else {
                if(extraChanges > 0) {
                    if(text[i] != '9' && text[j] != '9') {
                        text[i] = '9';
                        text[j] = '9';
                        extraChanges--;
                    } else if (text[i] == '9' || text[j] == '9') {
                        text[i] = '9';
                        text[j] = '9';
                    }
                } else {
                    char max = (char)Math.max(s.charAt(i), s.charAt(j));
                    text[i] = max;
                    text[j] = max;
                }
            }
        }

        if(extraChanges > 0 && text.length%2 == 1) {
            text[text.length/2] = '9';
        }

        return new String(text);
    }
//        int i = 0, j = n - 1, count = 0;
//        string visited = s;
//        while(i < j){
//            if(s[i] < s[j]){
//                s[i] = s[j];
//                visited[i] = 'x';
//                count++;
//            }
//            else if(s[i] > s[j]){
//                s[j] = s[i];
//                visited[j] = 'x';
//                count++;
//            }
//            i++;
//            j--;
//        }
//        int z = k - count;
//        if(z < 0){
//            return "-1";
//        }
//        else if(z == 0){
//            return s;
//        }
//
//        i = 0; j = n - 1;
//        while(z > 0 && i < j){
//            if(s[i] != '9'){
//                if(visited[i] == 'x' || visited[j] == 'x'){
//                    s[i] = '9';
//                    s[j] = '9';
//                    z -= 1;
//                }
//                else if(z > 1){
//                    s[i] = '9';
//                    s[j] = '9';
//                    z -= 2;
//                }
//            }
//            i++;
//            j--;
//        }
//        if(z > 0 && n % 2 != 0){
//            s[n/2] = '9';
//        }
//        return s;
        }

//    }
//}
