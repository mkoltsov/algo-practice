import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SherlockAndTheNumberOfStrings {
    public static void main(String[] args) {
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("abc"));
        System.out.println(isValid("abcc"));
        System.out.println(isValid("abccc"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("aabbc"));
    }

    static String isValid(String s) {

        int prev = Integer.MAX_VALUE;
        boolean flag = true;
        int count=0;

        HashMap<Character ,Integer> map
                =new HashMap();
        for(char c:s.toCharArray())
            map.put(c, map.getOrDefault(c,0) + 1);
        prev = map.get(s.charAt(0));
        for(Integer i:map.values()){
            if(i==prev){
                count++;
                continue;

            }else if((Math.abs(i - prev)==1 || (i-1)==0) && flag){
                flag =false;
                count++;
            }
        }
        if(count==map.size())
            return "YES";
        else
            return "NO";
//        List<Long> elems = s.chars().boxed().collect(Collectors.groupingBy((Integer c) -> c, Collectors.counting())).values().stream().sorted().collect(Collectors.toList());
//        System.out.println(elems);
//        long first = elems.get(0);
//        int diff=0;
//        boolean flag = true;
//
////        HashMap<Character ,Integer> map
////                =new HashMap();
////        for(char c:s.toCharArray())
////            map.put(c, map.getOrDefault(c,0) + 1);
//        for (int i =1; i<elems.size();i++) {
//            if (elems.get(i)==first){
////                first=elems.get(i);
//                diff++;
//            } else if (Math.abs(elems.get(i)-first)==1 || (elems.get(i)-1==0) && flag) {
//                diff++;
//                flag =false;
//
//            }
//        }
////                .stream().collect(Collectors.groupingBy(c -> c, Collectors.counting())).values());
////        Stream<Long> str = ;
////        int maxVal = streamSupplier.get().mapToInt(Long::intValue).max().orElse(0);
//
////        AtomicInteger ai = new AtomicInteger();
//
////        int num = (int)streamSupplier.get().mapToInt(Long::intValue).distinct()
////                .peek(System.out::println)
////                .count();
////        int nE = (int)streamSupplier.get().mapToInt(Long::intValue).filter(i->i!=maxVal).count();
////        int e = (int)streamSupplier.get().filter(i->i==maxVal).count();
////        System.out.printf("%d %d", nE, e);
////            int num = 1 ;
//
//        if(diff==elems.size())
//            return "YES";
//        else
//            return "NO";
//        System.out.println(diff);
//            return diff>1 ? "NO" : "YES";
        }

    }
