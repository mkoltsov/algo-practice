import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encryption {
    public static void main(String[] args) {
        System.out.println(encryption("have a nice day"));
        System.out.println(encryption("feedthedog"));
        System.out.println(encryption("chillout"));
    }

    static String encryption(String s) {
        StringBuilder sbReturn=new StringBuilder();
        if(s.contains(" "))
            s=s.replaceAll(" ", "");
        int rows=(int) Math.sqrt(s.length());
        int column=rows+1;
        if(rows*rows >= s.length())
            column=rows;
        if((rows*column) <= s.length())
            rows=rows+1;
        for(int i=0;i<column;i++)
        {
            for(int j=i;j<s.length();)
            {
                sbReturn.append(s.charAt(j));
                j=j+column;
            }
            sbReturn.append(" ");
        }
        return sbReturn.toString().replace("[", "").replace("]", "");


//        String sanitized = s.replaceAll(" ","");
//        System.out.println(sanitized);
//        double length = Math.sqrt((double) sanitized.length());
//        System.out.println(length);
//        int columns = (int) Math.ceil(length);
//        int rows = (int) Math.floor(length) ;
//        if (!(rows*columns>=sanitized.length())) {
//            rows++;
//        }
//        System.out.println(rows);
//        System.out.println(columns);
//        List<List<Character>> result = new ArrayList<>();
//        char[] r = new char[(rows*columns)+rows];
//        char[] source = sanitized.toCharArray();
//        int p=0;
//        for (int i=0; i<rows; i++) {
//            System.out.println("new row");
//            List<Character> row = new ArrayList<>();
//            result.add(row);
//            for (int j=0; j<columns && p<source.length; j++) {
//               row.add(source[p]);
//               p++;
//            }
//        }
//        System.out.println(result);
//        p=0;
//        for (int i=0;i<columns;i++) {
//            for (int j=0;j<rows&& i< result.get(j).size();j++) {
//                r[p]=result.get(j).get(i);
//                p++;
//            }
//            if (p+1<r.length) {
//                r[p++] = ' ';
//            }
//        }
//        return String.valueOf(r).replaceAll("\u0000","");
    }
}
