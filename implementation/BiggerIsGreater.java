//import java.util.Arrays;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.BiFunction;
//import java.util.function.Function;
//
//public class BiggerIsGreater {
//    public static void main(String[] args) {
//        System.out.println(biggerIsGreater("abcd"));
//        System.out.println(biggerIsGreater("lmno"));
//        System.out.println(biggerIsGreater("abdc"));
//        System.out.println(biggerIsGreater("dkhc"));
//        System.out.println(biggerIsGreater("abcdefghxyzqwert"));
//    }
//
//    static Function<Integer, Integer> factorial = (i)-> {
//        if (i==0) {
//            return 1;
//        } else {
//            i=i*BiggerIsGreater.factorial.apply(--i);
//        }
//        return i;
//    };
//
//    static String biggerIsGreater(String w) {
//
//        BiFunction<Integer, Integer, String> swap = (source, destination) -> {
//            char[] str = w.toCharArray();
//            char tmp = str[source];
//            str[source] = str[destination];
//            str[destination] = tmp;
//            return String.valueOf(str);
//        };
//
//        char[] arr = w.toCharArray();
//        int i = arr.length - 1; // finding p --> i
//        while (i > 0 && arr[i - 1] >= arr[i]) {
//            i--;
//        }
//        if (i <= 0) { //System.out.println("Pretty much last one!!"); return "no answer"; }
//            int j = arr.length - 1;
//            while (arr[j] <= arr[i - 1]) {
//                j--;
//            }
//            char temp = arr[i - 1];
//            arr[i - 1] = arr[j];
//            arr[j] = temp;
//
//            j = arr.length - 1;
//            while (i < j) {
//                char tem = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tem;
//                j--;
//                i++;
//            }
//            String ret = new String(arr);
//            return ret;
////
////
////        String[] permuations = new String[factorial.apply(w.length())];
////        AtomicInteger ind = new AtomicInteger();
////        final BiFunction<Integer,Integer, String> permutate = new BiFunction<Integer, Integer, String>() {
////            @Override
////            public String apply(Integer start, Integer end) {
//////                return null;
////
////
////
//////        (start, end) ->
////
//////        {
////          if (start==end) {
////            return "";
////          } else {
////              permuations[ind.getAndIncrement()]=swap.apply(start, end);
////              permutate.apply(start, --end);
////          }
////             return "";
////        };
////           this.apply(0, w.length()-1);
//////        for (int i=0; i<w.length();i++) {
//////            if (w.charAt(i))
//////        }
////        //        return
//////                return Arrays.toString(w.chars().peek(System.out::println).mapToObj(i-> (char)i).toArray(Character[]::new));
//////                return "f";
////    return "";
//    }
//
//
//
//
//    static String swap(String s, int source, int destination) {
//        char[] str = s.toCharArray();
//        char tmp = str[source];
//        str[source] = str[destination];
//        str[destination]=tmp;
//        return String.valueOf(str);
//    }
//}
//
