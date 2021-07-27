public class LibraryFine {
    public static void main(String[] args) {
        System.out.println(libraryFine(14, 7, 2018, 5, 7, 2018));
        System.out.println(libraryFine(6, 6, 2015, 5, 7, 2018));
        System.out.println(libraryFine(1, 1, 2015, 31, 12, 2014));
        System.out.println(libraryFine(28, 2, 2015, 15, 4, 2015));
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return 10000;
        } else if (y1==y2) {
            if (m1 > m2) {
                return (m1 - m2) * 500;
            } else if (d1>d2 && m1>=m2){
                return (d1 - d2) * 15;
            } else if (m1<m2){
                return 0;
            }
            else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
