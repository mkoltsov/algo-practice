import java.util.Arrays;

public class FindDigits {
    public static void main(String[] args) {
        System.out.println(findDigits(12));
        System.out.println(findDigits(1012));
    }
    static int findDigits(int n) {
        int i=0;
        int copy = n;
        while (copy!=0) {
            int part = copy % 10;
            if (part!=0 && n%part==0 ) {
                i++;
            }
            copy/=10;
        }
        return i;
    }

}
