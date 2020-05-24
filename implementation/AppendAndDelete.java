public class AppendAndDelete {
    public static void main(String[] args) {
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("aba", "aba", 7));
        System.out.println(appendAndDelete("ashley", "ash",  2));
        System.out.println(appendAndDelete("uoiauwrebgiwrhgiuawheirhwebvjforidkslweufgrhvjqasw", "vgftrheydkoslwezxcvdsqjkfhrydjwvogfheksockelsnbkeq",  100));
        System.out.println(appendAndDelete("aaaaaaaaaa", "aaaaa",  7));
    }

    static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;
        for (int i = 0; i < s.length() && i< t.length(); i++) {
            if (s.toCharArray()[i] == t.toCharArray()[i]) {
                commonLength++;
            } else break;
        }
        //CASE A
        if((s.length()+t.length()-2*commonLength)>k){
            return "No";
        }
//CASE B
        else if((s.length()+t.length()-2*commonLength)%2==k%2){
            return "Yes";
        }
//CASE C
        else if((s.length()+t.length()-k)<0){
            return "Yes";
        }
//CASE D
        else{
            return "No";
        }

//        System.out.println(similarities);
//        int differences = t.length() - similarities;
//        System.out.println(differences);
//        if (t.length()-s.length()< 0 && similarities==t.length()) {
//            return k>=Math.abs(t.length()-s.length()) ? "Yes": "No";
//        }
//        return s.length()-t.length() == 0 ? differences * 2 <= k ? "Yes" : "No" :  Math.abs(s.length()-t.length()) *2 <= k ? "Yes" :"No";
    }
}
