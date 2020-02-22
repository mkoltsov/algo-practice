import java.util.List;
import java.util.function.Supplier;

public class DayOfProgrammer {
    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1985));
        System.out.println(dayOfProgrammer(1984));
        System.out.println(dayOfProgrammer(2016));
        System.out.println(dayOfProgrammer(1800));
        System.out.println(dayOfProgrammer(2000));
        System.out.println(dayOfProgrammer(1918));
    }

    static String dayOfProgrammer(int year) {
        Supplier<Integer> february= () -> {
            if (year>=1919) {
                return (year % 4==0 && year %100!=0) || year %400==0 ? 29:28;
            } else if (year==1918) {
                return 15;
            }
            else {
                return year %4==0 ? 29:28;
            }
        };
        List<Integer> months = List.of(31,february.get() , 31, 30, 31, 30, 31, 31);

        int sum = months.stream().mapToInt(Integer::intValue).sum();

        return String.format("%2d.%02d.%d", 256 - sum, months.size()+1, year);
    }

}
