import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CutTheSticks {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(cutTheSticks(new int[]{5, 4, 4, 2, 2, 8})));
//        System.out.println(Arrays.toString(cutTheSticks(new int[]{1,2,3})));
        System.out.println(Arrays.toString(cutTheSticks(new int[]{66, 42, 68, 72, 68, 81, 91, 19, 40, 73, 44, 73, 89, 73, 44, 12, 77, 40, 44 ,17, 59, 99, 35, 92, 80, 51, 14, 30})));

    }

    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        int min=arr[0];
        int toRemove=1;
        List<Integer> l =new ArrayList<>();
        l.add(arr.length);
        int toAdd=arr.length;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==min){
                toRemove++;
            }
            if(arr[i]>min){
                min=arr[i];
                toAdd-=toRemove;
                toRemove=1;
                l.add(toAdd);
            }
        }
        return l.stream().mapToInt(x->x).toArray();
//        int[] result = new int[arr.length];
//        final AtomicInteger ind = new AtomicInteger(0);
//        Optional<Integer> minOpt = Arrays.stream(arr).boxed().min(Integer::compare);
//        int min = minOpt.orElse(0);
//        int[] temp = Arrays.copyOf(arr, arr.length);
//        while ( ind.get() < arr.length) {
//            System.out.println(222+Arrays.toString(temp));
//            System.out.println(333+Arrays.toString(result));
//            temp = Arrays.stream(temp).boxed().filter(i -> i > 0).mapToInt(i -> {
//                result[ind.get()]++;
//                return i - min;
//            }).toArray();
////            System.out.println(111 + Arrays.toString(result));
////            System.out.println(Arrays.toString(temp));
//            ind.incrementAndGet();
//        }
//        System.out.println(Arrays.toString(result));
//        return Arrays.stream(result).filter(i->i>0).toArray();
    }
}
