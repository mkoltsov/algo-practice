import java.util.Arrays;

public class CeasarsCipher {
    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz",2));
        System.out.println(caesarCipher("www.abc.xy",87));
    }

    static String caesarCipher(String s, int k) {
        String temp="abcdefghijklmnopqrstuvwxyz";
        String temp1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] c={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] c1={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(temp.contains(String.valueOf(s.charAt(i))))
            {
                int res=((s.charAt(i)-'a'+k)%26);
                sb.append(String.valueOf(c[res]));
            }
            else if(temp1.contains(String.valueOf(s.charAt(i))))
            {
                int res=((s.charAt(i)-'A'+k)%26);
                sb.append(String.valueOf(c1[res]));
            }
            else
                sb.append(String.valueOf(s.charAt(i)));
        }
        return sb.toString();
    }

//    static String caesarCipher(String s, int k) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        char[] alph = alphabet.toCharArray();
//        char[] shifted = new char[alph.length];
//        char[] result = new char[s.length()];
//
//        for (int i=0; i<alph.length; i++){
////            int base = Character.isLowerCase(c) ? 'a' : 'A';
////            return (char)((c + k - base) % 26);
//            shifted[((i+alph.length)-k)%alph.length]=alph[i];
//        }
//        System.out.println(Arrays.toString(shifted));
//
//        for (int i=0; i<s.length();i++) {
//            boolean isUpper = Character.isUpperCase(s.toCharArray()[i]);
//            int res=((s.charAt(i)-'a'+k)%26);
//            result[i]=alph[res];
////            int inShifted = alphabet.indexOf(isUpper ? Character.toLowerCase(s.toCharArray()[i]): s.toCharArray()[i]);
//
////            result[i]=inShifted==-1?s.toCharArray()[i]:shifted[inShifted];
////            result[i]=isUpper?Character.toUpperCase(result[i]):result[i];
////            System.out.printf("%c - %c - %d - %d %n",s.toCharArray()[i], result[i], i,inShifted );
//        }
//
//        return String.valueOf(result);
//
//    }
}

//0->3
//1->4