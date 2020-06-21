import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HappyladyBugs {
    public static void main(String[] args) {
        System.out.println(happyLadybugs("AABBC"));
        System.out.println(happyLadybugs("AABBC_C"));
        System.out.println(happyLadybugs("DD__FQ_QQF"));
        System.out.println(happyLadybugs("AABCBC"));
        System.out.println(happyLadybugs("RBY_YBR"));
        System.out.println(happyLadybugs("X_Y__X"));
        System.out.println(happyLadybugs("B_RRBR"));
    }

    static String happyLadybugs(String b) {
        boolean flag=false;
        if(b.length()==1&&b.charAt(0)!='_'){
            return "NO";
        }
        int count=0;
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)=='_'){
                flag=true;
                count++;
            }
        }
        if(count==b.length()){
            return "YES";
        }
        if(!flag){
            for(int i=1;i<b.length();i++){
                if(i==b.length()-1){
                    if(b.charAt(i)!=b.charAt(i-1)){
                        return "NO";
                    }
                    return "YES";
                }
                if(b.charAt(i)!=b.charAt(i-1)&&b.charAt(i)!=b.charAt(i+1)){
                    return "NO";
                }

            }
            return "YES";
        }
        else{
            char[] arr=b.toCharArray();
            Arrays.sort(arr);
            if(arr[0]!=arr[1]){
                return "NO";
            }
            for(int i=1;i<arr.length;i++){
                if(arr[i]=='_'){
                    if(arr[i-1]!=arr[i-2]){
                        return "NO";
                    }
                    return "YES";
                }
                if(arr[i]!=arr[i-1]&&arr[i]!=arr[i+1]){
                    return "NO";
                }

            }
        }
        return "YES";




//        Map<Character, String> chars = new HashMap<>();
////        Map<Character, Integer> chars2 = new HashMap<>();
//        char[] arrChars = b.toCharArray();
//        Arrays.sort(arrChars);
//
//        for (int i=0; i<arrChars.length; i++) {
//            char ladyBug = arrChars[i];
//            chars.putIfAbsent(ladyBug, "NO");
//            for (int j=0; j<arrChars.length;j++){
//                if (i==j) {
//                    continue;
//                }
////                System.out.println(b.charAt(i));
//                if (arrChars[j]==ladyBug){
//                    if (j==i-1 || j==i+1) {
//                        chars.put(ladyBug, "YES");
//                    }
////                    else
////                        {
//////                        String padding = b.substring(Math.min(i, j), Math.max(i, j));
//////                        if (padding.contains("_")) {
////                        Arrays.sort(b.toCharArray());
////                        int underscorePosition = b.indexOf('_', Math.min(i, j));
////                        if (underscorePosition>0) {
//////                            System.out.println(1111);
//////                            int spacing = padding.indexOf('_',Math.min(i, j));
////                            char[] source = b.toCharArray();
////                            source[underscorePosition]=b.charAt(j);
////                            source[j]='_';
////                            b=String.valueOf(source);
////                            //b.toCharArray()[j]
//////                            System.out.println(padding);
//////                            chars.put(b.charAt(i), "Yes");
////                        }
////                    }
//                }
//
//            }
////            System.out.println(b);
//
////            chars2.putIfAbsent(b.charAt(i), 0);
////            chars2.computeIfPresent(b.charAt(i), (key, oldValue)-> oldValue+1);
//        }
//
////        char[] arrChars = b.toCharArray();
////        Arrays.sort(arrChars);
////        System.out.println(chars);
////        System.out.println(arrChars);
////        System.out.println(chars2);
////        System.out.println(chars);
//        chars.remove('_');
////        System.out.println(chars);
//        if (chars.size()==0) {
//            return "YES";
//        }
////        chars.entrySet().stream().map((k,v)-> )
//        return chars.containsValue("NO") ? "NO": "YES";
    }
}

//"RBY_YBR"
//"RBYRYB_"
//"RB_RYBY"