import java.util.stream.IntStream;


public class BeautifulDayAtTheMovies {
    public static void main(String[] args) {
        System.out.println(beautifulDays(20, 23, 6));
        System.out.println(beautifulDays(49860, 205494, 155635764));
    }

    static int beautifulDays(int i, int j, int k) {
        return (int) IntStream.rangeClosed(i, j).filter(e -> Math.abs(e - reverse(e)) % k == 0).count();
    }

    public static int reverse(Integer i) {

        int reverse = 0;
        while(i!=0){
            reverse = 10*reverse +i%10;
            i = i/10;
        }
        reverse += i;
        return reverse;
//        char[] arr = String.valueOf(i).toCharArray();
//        int cnt = 0;
//        for (int j = arr.length - 1; j > 0; j--) {
//            char tmp;
//            tmp = arr[j];
//            arr[j] = arr[cnt];
//            arr[cnt] = tmp;
//            cnt++;
//        }
//        return Integer.parseInt(String.valueOf(arr));
    }
}
