public class TwoCharacters {
    public static void main(String[] args) {
//        System.out.println(alternate("beabeefeab"));
//        System.out.println(alternate("abaacdabd"));
        System.out.println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }

    // Complete the alternate function below.
    static int alternate(String s) {
        int[] chars = s.chars().distinct().toArray();
        int maxSize = 0;

        for (int i = 0; i < chars.length; i++)
            for (int j = i + 1; j <= chars.length - 1; j++) {
                char c1 = (char) chars[i];
                char c2 = (char) chars[j];

                String aux = "";
                for (char c : s.toCharArray())
                    if (c == c1 || c == c2) aux += c;

                maxSize = isValid(aux) ? aux.length() > maxSize ? aux.length() : maxSize : maxSize;
            }
        return maxSize;
//        for (int i=0; i<chars.length; i++) {
//            String str = s.replace((char)chars[i], ' ').replaceAll("\\s+","");
//            if (!isValid(str)){
//                for (int j=i+1; j<chars.length; j++){
//                    String s2 = str.replace((char)chars[j], ' ').replaceAll("\\s+","");
//                    System.out.println(3333+s2);
//                    System.out.println(222222 + s2 + isValid(s2));
//                    if (isValid(s2)){
//                        System.out.println(1111 + s2);
//                        maxSize=Math.max(maxSize,s2.length());
//                    }
//                }
//            } else maxSize=Math.max(maxSize,str.length());
//            System.out.println(isValid(str));
//            System.out.println(str);
//        }
//
//
//            return maxSize;

    }

    static boolean isValid(String s){
        char[] symbols = s.toCharArray();
        char a=symbols[0],b=symbols[1];
        boolean result = true;

        if (a!=b){
            for (int i=2; i<s.length()-1; i+=2){
                System.out.printf("%s - %s %n", symbols[i], symbols[i+1]);
                if(symbols[i]!=a && symbols[i+1]!=b || symbols[i]==symbols[i+1]){
                    result=false;
                    break;
                }
            }
        } else result=false;
        return result;


    }
}
