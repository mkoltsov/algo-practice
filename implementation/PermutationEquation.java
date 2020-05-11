import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationEquation {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(permutationEquation(new int[]{5, 2, 1, 3, 4})));
//        System.out.println(Arrays.toString(permutationEquation(new int[]{2, 3, 1})));
        System.out.println(Arrays.toString(permutationEquation(new int[]{22, 5, 11, 10, 1, 14, 7, 3, 16, 9, 8, 6, 18, 12, 15, 17, 13, 4})));

    }

    static int[] permutationEquation(int[] p) {
//        String arr = IntStream.of(p).boxed().map(Object::toString).collect(Collectors.joining(""));
        Map<Integer, Integer> map =  IntStream.range(0, p.length).boxed().collect(Collectors.toMap( i->p[i] ,i->i ));
        System.out.println(map);
//        return IntStream.rangeClosed(1, p.length).map(i -> arr.indexOf(String.valueOf(i)) + 1)
        return IntStream
                .range(1, p.length)
//                .peek(System.out::println)
                .map(i -> map.get(i) + 1)
//                .peek(System.out::println)
//                .peek(System.out::println)
//                .map(i -> arr.indexOf(String.valueOf(i)) + 1)
                .map(i -> map.get(i) + 1)
//                .peek(System.out::println)
                .toArray();
//        int[] q = new int[p.length];
//        for(int i: p){
//            q[p[p[i-1]-1]-1] = i;
//        }
//        return q;

    }

//    static int search(int[] arr,int temp)
//    {
//        int i;
//        for(i=0;i<arr.length;i++)
//            if(arr[i]==temp)
//                break;
//        return i+1;
//    }
//    static int[] permutationEquation(int[] p) {
//        int[] res=new int[p.length];
//        int temp=0;
//        for(int i=0;i<p.length;i++)
//        {
//            temp=i+1;
//            int index=search(p,temp);
//            int index2=search(p,index);
//            res[i]=index2;
//        }
//        return res;
//    }

}
