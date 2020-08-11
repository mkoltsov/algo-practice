import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class RepeatedString {
    public static void main(String[] args) {
//        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
    }

    static long repeatedString(String s, long n) {
        long cnt = s.chars().filter(i->i=='a').count();
        System.out.println(cnt);

        long factor = (n/s.length());
        long rem = (n%s.length());
        cnt =  factor*cnt  ;
        for(int i=0;i<rem;i++)
            if(s.charAt(i)=='a')
                cnt++;

//        while (index<n) {
//            index+=s.length();
//            acc+=cnt;
//            System.out.println(String.format("current index = %d, acc = %d", index, acc));
//        }
        return cnt;
//        StringBuilder sb = new StringBuilder(s);
//        String ss = Stream.iterate("", i-> i+s).limit(n).collect(Collectors.joining());
//        System.out.println(ss);
//return 0L;
//        StringBuilder sb = new StringBuilder(s);
//        LongStream.range(0, n).forEach(i -> sb.append(s));
//        long index = 0;
//        long acc =0;
//        for (char i : sb.toString().toCharArray()) {
//            if (index==n) {
//                break;
//            }
//            if (i=='a') {
//                acc++;
//            }
//            index++;
//        }
//    return acc;
    }
}
