import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("mom"));
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("kkkk"));
    }

    static int sherlockAndAnagrams(String s) {
        int len = s.length();
        int ans = 0;
        //counter map for substring
        Map<String,Integer> subMap= new HashMap<String,Integer>();
        //iterate through all the possible substring of s
        for(int i = 1;i<len;i++){//starting with size 1,2,3,4
            for(int j= 0;i+j<len+1; j++){
                String sub = s.substring(j,i+j);
                //before putting the substring into the map, sort the string
                //in this way abc, acb will result in abc abc pair
                char[] subArray = sub.toCharArray();
                Arrays.sort(subArray);
                String subSorted = new String(subArray);
                Integer subNumber = subMap.get(subSorted);
                if(subNumber==null )//check if the sequnece already exists
                    subMap.put(subSorted,1);//put in for the first time
                else{
                    subNumber++;//sub already inserted so update plus 1
                    subMap.put(subSorted,subNumber);
                    //if we have values o n for a sub
                    //increse ans with n*(n-1)/2 but removing the value of the preceding
//                    iteratrion -= (n-1)*(n-2)/2
                    ans -= ((subNumber-1)*(subNumber-2))/2;
                    System.out.println("ans first "+ans);
                    ans += (subNumber*(subNumber-1))/2;
                    System.out.println("ans second "+ ans);
                }

            }
        }
        return ans;
//        System.out.println(subMap);
//        return (int) subMap.values().stream().reduce(0, (acc, v)-> {
//            System.out.printf("%d %d %n", acc, v);
//            if (v==2) {
//            return acc+1;
//        } else if (v>2) {
//            return acc+=v;
//        } else return acc;
//        });
        //        int numPairs=0;
//        Map<Integer, Long> mm = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        char[] ca = s.toCharArray();
//        int curInd=0, curSize=1;
//        for (int j = 1; j < s.length(); j++) {
//            char[] cmp = Arrays.copyOfRange(ca,0,j);
//            for (int i = 1; i < s.length(); i++) {
////            if (i+2> s.length()){
////                break;
//
////                Arrays.
////            }
//                System.out.printf("%s - %s %n", Arrays.toString(cmp), Arrays.toString(Arrays.copyOfRange(ca,i,i+j)));
//                if (makeComparison(cmp, Arrays.copyOfRange(ca,i,i+j))) {
//
//                    numPairs++;
//                }
////            System.out.printf("%s - %s %n", s.substring(i,i+1), s.substring(i+1, i+2));
////            if (s.substring(curInd,curInd+curSize).equals(s.substring(i, i+1))){
////                System.out.printf("%s - %s %n", s.substring(i,i+1), s.substring(i+1, i+2));
////                numPairs++;
////            }
//
////            if (ca[i] == ca[i+1]){
//
////            }
//            }
//        }
//        return numPairs;
    }

    static boolean makeComparison(char[] a, char[] b){
        char[] c = Arrays.copyOf(a, a.length);
        Arrays.sort(c);
        char[] d = Arrays.copyOf(b, b.length);
        Arrays.sort(d);
        System.out.printf("%s - %s, %b %n", Arrays.toString(a), Arrays.toString(b), Arrays.equals(c,d));
        return Arrays.equals(c,d);
//        Arrays.sort(b);
    }
}

