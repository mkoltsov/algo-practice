import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WeightedUniformString {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(weightedUniformStrings("abbcccdddd", new int[]{1, 7, 5, 4, 15})));
    }
    static String[] weightedUniformStrings(String s, int[] queries) {
        HashSet<Integer> weights = new HashSet();
        int i=0,j=0;

        String [] r = new String[queries.length];
        while(j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                weights.add(((int)s.charAt(i)-96)*(j-i+1));
                j++;
            }else i++;
        }
        for(i=0;i<queries.length;i++){
            if(weights.contains(queries[i]))
                r[i]="Yes";
            else r[i]="No";
        }
        return r;
        //        List<Integer> uniform = new ArrayList<>();
//
//        uniform.add(calculateWeight(String.valueOf(s.charAt(0))));
//        String curr="";
//
//        for (int i =1; i<s.length(); i++){
//            String curChar = String.valueOf(s.charAt(i));
//            if(curr.startsWith(curChar)){
//             curr+=curChar;
//            }
//            else {
//                curr = curChar;
//            }
//            uniform.add(calculateWeight(curr));
//
//        }
//
//        return  Arrays.stream(queries).mapToObj(i ->{
//            if (uniform.contains(i)) {
//                return "Yes";
//            } else {
//                return "No";
//            }
//        }).toArray(String[]::new);
    }

    static int calculateWeight(String str) {
        int weight=0;

        for (char i:str.toCharArray()){
            weight+=((i-'a')+1);
        }
        return weight;
    }

}

