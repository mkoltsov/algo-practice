import java.util.ArrayList;
import java.util.List;

public class HighestValuePalindrome {
    public static void main(String[] args) {
        System.out.println(highestValuePalindrome("0011", 4,1));
        System.out.println(highestValuePalindrome("092282", 6,3));
    }

    static String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        List<Integer> nonComplaint= new ArrayList<>();
        for (int i=0;i<s.length()/2;i++){
            int left=Integer.parseInt(String.valueOf(chars[i])), right=Integer.parseInt(String.valueOf(chars[(s.length()-i)-1]));
            System.out.printf("%d -%d %n",left,right);
            if (left!=right){
                nonComplaint.add(i);
            }
        }
        System.out.println(nonComplaint.size());
        if (k-nonComplaint.size()<0){
            return "-1";
        }

        for (int i:nonComplaint){
            int left=Integer.parseInt(String.valueOf(chars[i])), right=Integer.parseInt(String.valueOf(chars[(s.length()-i)-1]));

        }
//            int left=Integer.parseInt(String.valueOf(chars[i])), right=Integer.parseInt(String.valueOf(chars[(s.length()-i)-1]));
//            if (left==right && k-2>=0){
//                chars[i]='9';
//                chars[(s.length()-i)-1]='9';
//                k-=2;
//
//            } else if (left != right && k-2>=0){
//                chars[i]='9';
//                chars[(s.length()-i)-1]='9';
//                k-=2;
//            } else if (left != right && k-2>=0){
        return String.valueOf(nonComplaint.size());
        }

    }
//}
