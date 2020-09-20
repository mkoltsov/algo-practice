public class BeautifulString {
    public static void main(String[] args) {
        System.out.println(beautifulBinaryString("0101010"));
        System.out.println(beautifulBinaryString("01100"));
        System.out.println(beautifulBinaryString("0100101010"));
    }

    static int beautifulBinaryString(String b) {
        char[] source = b.toCharArray();
        int moves =0;
        for (int i =0; i<source.length-2; i++){
            char elem0=source[i];
            char elem1=source[i+1];
            char elem2=source[i+2];

            if (elem0=='0' && elem1=='1' && elem2=='0'){
                source[i +2]='1';
                moves++;
            }
        }
    return moves;
    }
}
