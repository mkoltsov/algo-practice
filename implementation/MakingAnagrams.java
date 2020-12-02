import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MakingAnagrams {
    public static void main(String[] args) {
        System.out.println(makingAnagrams("cde","abc"));
        System.out.println(makingAnagrams("abc","amnop"));
        System.out.println(makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj","djfladfhiawasdkjvalskufhafablsdkashlahdfa"));
    }

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
//        String firstString
//        int maxLength = Math.max(s1.length(), s2.length());
//        String maxString = s1.length()==maxLength ? s1:s2;
//        Map<Integer, Long> s1m = s1.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<Integer, Long> s2m = new HashMap<>();
//        for (char i: s2.toCharArray()) {
//            s2m.put((int)i, s2m.getOrDefault(i,0L)+1);
//        }
        int[] freq = new int[26];

        s1.chars().forEach(c -> freq[c - 'a']++);
        s2.chars().forEach(c -> freq[c - 'a']--);

        return Arrays.stream(freq).map(Math::abs).sum();

//
//        Map<Integer, Long> max = s1m.size()>s2m.size() ? s1m:s2m;
//        Map<Integer, Long> min = !s1m.equals(max) ? s1m:s2m;
//        AtomicInteger ai = new AtomicInteger();
//        System.out.println(s1m);
//        System.out.println(s2m);
//        max.forEach((k,v)-> {
//            System.out.printf("%d: %d, %d %n", k,v, min.getOrDefault(k, 0L));
//            ai.addAndGet((int) Math.abs(v - min.getOrDefault(k, 0L)));
//            min.remove(k);
//        });
//        min.forEach((k,v)-> {
//            System.out.printf("%d: %d, %d %n", k,v, max.getOrDefault(k, 0L));
////            min.remove()
//            ai.addAndGet((int) Math.abs(v - max.getOrDefault(k, 0L)));
//        });
//        System.out.println(s1m);
//        System.out.println(s2m);
//        System.out.println(ai.get());
//        int mutations =0;

//        StringBuilder sb2 = new StringBuilder(s2);

//        Map.Entry<Integer, StringBuilder> dif1 = findDiff(s1,s2);
//        System.out.println(dif1);
//        mutations+=findDiff(s1,s2);
//        Map.Entry<Integer, StringBuilder> dif2 = findDiff(s2,s1);
//        System.out.println(dif2);
//        mutations+=findDiff(s2,s1);
//        System.out.println(mutations);
//        if (dif1.getValue().toString().equals(dif2.toString())){
//            return mutations;
//        }

//        return mutations;

    }

    private static int findDiff(String s1,String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        int mutatationsNum =0;
        char[] max = s1.toCharArray();
        for (int i = 0; i< s1.length(); i++){
//            System.out.printf("%c %d %n",max[i], i );
            if (s2.indexOf(max[i]) == -1) {
//                System.out.println(1111);
//                sb1.deleteCharAt(i);
                mutatationsNum++;
            }

        }

        return  mutatationsNum;
    }

}
