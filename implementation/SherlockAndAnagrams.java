import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("mom"));
    }

    static int sherlockAndAnagrams(String s) {
        int numPairs=0;
        Map<Integer, Long> mm = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        char[] ca = s.toCharArray();
        int curInd=0, curSize=1;
        for (int i =0; i<s.length(); i++){
//            if (i+2> s.length()){
//                break;
//            }
//            System.out.printf("%s - %s %n", s.substring(i,i+1), s.substring(i+1, i+2));
            if (s.substring(curInd,curInd+curSize).equals(s.substring(i, i+1))){
//                System.out.printf("%s - %s %n", s.substring(i,i+1), s.substring(i+1, i+2));
                numPairs++;
            }

//            if (ca[i] == ca[i+1]){

//            }
        }
        return numPairs;
    }
}

