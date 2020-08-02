import java.util.Arrays;
import java.util.stream.Collectors;

public class FlatlandSpaceStation {
    public static void main(String[] args) {
//        System.out.println(flatlandSpaceStations(5, new int[]{0, 4}));
        System.out.println(flatlandSpaceStations(20, new int[]{13, 1, 11, 10, 6}));
    }

    static int flatlandSpaceStations(int n, int[] c) {
        int[] flatLand = new int[n];

        for (int i = 0; i < c.length; i++) {
            int elem = c[i];
            flatLand[elem] = 1;
        }
        System.out.println(Arrays.toString(flatLand));
//        String textRepres = Arrays.stream(flatLand).mapToObj(String::valueOf).collect(Collectors.joining(""));
//        String reversedString =  new StringBuilder(textRepres).reverse().toString();
        int maxDistance=0;
        for (int i = 0; i < flatLand.length; i++) {
            System.out.println(i);
            int distanceRight = 0, distanceLeft = 0;
            boolean foundRight=false, foundLeft = false;
            for (int j = i; j < flatLand.length; j++) {
                if (flatLand[j] == 1) {
                    foundRight=true;
                    break;
                }
                distanceRight++;
            }
            distanceRight=foundRight ? distanceRight:Integer.MAX_VALUE;
            System.out.println("reight" + distanceRight);

            for (int k = i; k > 0; k--) {

                if (flatLand[k] == 1) {
                    foundLeft=true;
                    break;
                }
                distanceLeft++;
            }
            distanceLeft=foundLeft ? distanceLeft:Integer.MAX_VALUE;
            System.out.println("left" + distanceLeft);
            System.out.println("___________________");
            maxDistance=Math.max(maxDistance,Math.min(distanceLeft, distanceRight));
        }
    return maxDistance;

//        Arrays.sort(c);
//        int start = c[0];
//        int trail = n - c[c.length-1];
//        int max = start;
//        // System.out.println("start: "+start + " trail: "+trail);
//        //for(int p : c){
//        //    System.out.print(p + " ");
//        //}
//        for(int i = 1 ; i < c.length ; i++){
//            int local = (c[i] - c[i-1])/2;
//            max = local > max ? local : max;
//        }
//        if(max < trail){
//            return trail-1;
//        }
//        if(max <= start){
//            return start;
//        }
//
//        // System.out.println("max: "+max);
//        return max;
    }
}
