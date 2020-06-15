import java.util.Arrays;

public class CavityMap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(cavityMap(new String[]{"1112", "1912", "1892", "1234"})));
//        System.out.println(Arrays.toString(cavityMap(new String[]{"1912"})));
//        System.out.println(Arrays.toString(cavityMap(new String[]{"1892"})));
//        System.out.println(Arrays.toString(cavityMap(new String[]{"1234"})));
    }

    static String[] cavityMap(String[] grid) {
        for (int i =1 ; i<grid.length-1; i++) {
            for (int j=1;j<grid[i].length()-1;j++){
                int elem = grid[i].charAt(j);
                int elemLeft = grid[i].charAt(j-1);
                int elemRight = grid[i].charAt(j+1);
                int elemTop = grid[i-1].charAt(j);
                int elemBottom = grid[i+1].charAt(j);
                if (elem>elemLeft && elem> elemRight && elem> elemTop && elem> elemBottom) {
                    StringBuilder sb = new StringBuilder(grid[i]);
                    sb.setCharAt(j, 'X');
                    grid[i] = sb.toString();
                }
            }
        }
//         return Arrays.stream(grid).map(i -> i.replace('0', 'X')).toArray(String[]::new);
    return grid;
    }
}
