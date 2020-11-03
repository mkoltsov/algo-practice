import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(anagram("abccde"));
        System.out.println(anagram("aaabbb"));
        System.out.println(anagram("xaxbbbxx"));
        System.out.println(anagram("fdhlvosfpafhalll"));

    }

    // Complete the anagram function below.
    static int anagram(String s) {
        if (s.length() % 2 != 0)
            return -1;

        StringBuilder a = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder b = new StringBuilder(s.substring(s.length() / 2));

        for (char c : b.toString().toCharArray()) {
            int index = a.indexOf(String.valueOf(c));
            if (index > -1)
                a = a.delete(index, index + 1);
        }

        return a.length();

//        if (s.length() %2!=0) {
//            return -1;
//        }
//
//        String partOne = s.substring(0, s.length()/2);
//        String partTwo = s.substring(s.length()/2);
//
//        Map<Integer, Long> map1 = countLetters(partOne);
//        Map<Integer, Long> map2 = countLetters(partTwo);
//        System.out.println(map1);
//        System.out.println(map2);
//        System.out.printf("%s - %s%n", partOne, partTwo);
//        AtomicLong ai = new AtomicLong(0);
//        map2.forEach((k,v)-> {
//            long val = map1.getOrDefault(k, 0L);
//            if (val !=v) {
//                ai.addAndGet(Math.abs(val-v));
//            }  });
//
////        map1.entrySet().stream().reduce(0, (Integer k, Long v)->  )
//        return ai.intValue();
    }

    static Map<Integer, Long> countLetters(String s){
        return s.chars().boxed().collect(Collectors.groupingBy((Integer i) -> i, Collectors.counting()));
    }
}
