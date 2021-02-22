import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BearAndSteadyGame {
    public static void main(String[] args) {
        System.out.println(steadyGene("ACTGAAAG"));
    }

    public static boolean balanced(int N, Map<Character, Integer> map) {
        if (map.get('A') <= N && map.get('C') <= N && map.get('G') <= N
                && map.get('T') <= N)
            return true;

        return false;
    }

    static int steadyGene(String gene) {
        Map<Character, Integer> counted = gene.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .filter(i->gene.length()/4!=i.getValue())
                .collect(Collectors.toMap(i->((char)i.getKey().intValue()), i->(int)i.getValue().longValue()));
    int N=gene.length()/4;
        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while (i < gene.length() && j < gene.length()) {
            if (!balanced(N, counted)) {
                counted.put(gene.charAt(j), counted.get(gene.charAt(j)) - 1);
                //System.out.println(map);
                j++;
            } else {
                min = Math.min(min, j - i);
                counted.put(gene.charAt(i), counted.get(gene.charAt(i)) + 1);
                //System.out.println(map);
                i++;
            }
        }

        return min;

//
//        boolean a=false,c=false,t=false,g=false;
////        counted.entrySet().stream()
//        System.out.println(counted);
//        return 0;
    }
}
