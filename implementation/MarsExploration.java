public class MarsExploration {
    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSOSSOSSOS"));
        System.out.println(marsExploration("SOSSPSSQSSOR"));
        System.out.println(marsExploration("SOSSOT"));
        System.out.println(marsExploration("SOSSOSSOS"));
    }

    static int marsExploration(String s) {
        int ind=0;
        int diffs=0;
        char[] source = s.toCharArray();
        for (int i=0; i<(s.length()/3);i++){
            diffs+=checkChar(source[i+ind], 'S');
            diffs+=checkChar(source[i+ind+1], 'O');
            diffs+=checkChar(source[i+ind+2], 'S');
            ind+=2;

        }
        return diffs;
    }

    static int checkChar(char source, char reference){
        if (source!=reference){
            return 1;
        }
        return 0;
    }
}
