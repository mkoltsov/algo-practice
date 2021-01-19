import java.util.regex.Pattern;

public class StrongPassword {
    public static void main(String[] args) {
        System.out.println(minimumNumber(3, "Ab1"));
        System.out.println(minimumNumber(11,  "#HackerRank"));
        System.out.println(minimumNumber(5,  "2bbbbb"));
        System.out.println(minimumNumber(5,  "2bb#A"));
        System.out.println(minimumNumber(7,                "AUzs-nV"));

    }

    static int minimumNumber(int n, String password) {
        int numberOfChanges=0,missingCharacters =0;
        if (n<6) {
            missingCharacters+=(6-n);
        }


        if (! match(password,".*\\d.*")){
            numberOfChanges++;
//            System.out.println("!"+ numberOfChanges);
        }

        if (!match(password,".*[a-z].*")){
            numberOfChanges++;
//            System.out.println("!!"+numberOfChanges);
        }

        if (!match(password, ".*[A-Z].*")){
            numberOfChanges++;
//            System.out.println("!!!"+numberOfChanges);
        }

//        if (!Pattern.compile(".*!@#$%^&*()-+.*").matcher(password).matches()){
        if (!match(password, ".*[-!@#$%^&*()+].*")){
            numberOfChanges++;
//            System.out.println("!!!!"+numberOfChanges);

        }


        // Return the minimum number of characters to make the password strong
        return Math.max(numberOfChanges, missingCharacters);
    }

    static boolean match(String str, String pattern ){
        boolean isMatch = Pattern.compile(pattern).matcher(str).matches();
        if (!isMatch){
            System.out.println(pattern +" "+str);
        }
        return isMatch;

    }
}

