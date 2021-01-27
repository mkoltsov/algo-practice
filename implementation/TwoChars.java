import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TwoChars {
    public static void main(String[] args) {
//        System.out.printf("%d  %n", alternate("beabeefeab"));
        System.out.printf("%d  %n", alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }
    // Complete the alternate function below.
    static int alternate(String s) {
        int[] dist = s.chars().distinct().toArray();

        int n = dist.length, max = 0, k = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                String temp = "[^" + (char)dist[i] + (char)dist[j] + "]";
                String f = s.replaceAll(temp,"");

                for(k = 0; k < f.length()-1; k++)
                {
                    if(f.charAt(k) == f.charAt(k+1))
                        break;
                }

                if(k == f.length()-1)
                    max = Math.max(f.length(),max);
            }
        }
        return max;

//        IntStream.range(0, dist.length).forEachOrdered(i->{cc[i]=(char) dist[i];});
////        System.out.println(11+Arrays.stream(dist).map(i->(char)i).);
//        permutation(String.valueOf(cc));
//        for (int i =0; i<dist.length;i++){
//            for (int j=i; j<dist.length;j++){
//                if (dist[i]== dist[j]){
//                    continue;
//                }
//                pairs.add(new int[]{dist[i], dist[j]});
//            }
//        }
//        AtomicInteger maxSize = new AtomicInteger();
//        pairs.forEach(i-> {
//            String replaced = s.replaceAll(String.valueOf((char) i[0]), "").replaceAll(String.valueOf((char) i[1]), "");
//            System.out.println(replaced);
//            System.out.println(isAlternating(replaced));
//                    if (replaced.chars().distinct().count()==2 && isAlternating(replaced)){
//                            if (maxSize.intValue()<replaced.length()){
//                                System.out.println(111+replaced + replaced.chars().distinct().count());
//                                maxSize.set(replaced.length());
//                            }
//                    }
//        });
//        System.out.println(maxSize.intValue());
////            pairs.to
//
////        }
////        pairs.forEach(i-> System.out.println(Arrays.toString(i)));
//        return 0;
    }

    static boolean isAlternating(String str){
        System.out.println(str);
        char[] s = str.toCharArray();
//        boolean isAlt = true
        for (int i=0; i<str.length();i++){
            if (i+1<str.length()){
                System.out.println(s[i] + " " + s[i+1]);
                if (s[i]==s[i+1]){

                return false;
            }
        }}
        return true;
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
