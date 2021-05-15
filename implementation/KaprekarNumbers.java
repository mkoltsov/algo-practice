public class KaprekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(1,100);
    }

    public static void kaprekarNumbers(int p, int q) {
        for (int i =p; i<=q;i++){
            int square = (int)Math.pow(i,2);
            if (i==1){
                System.out.println(1);
                continue;
            }
            String charVal = String.valueOf(square);
            if (charVal.length()%2!=0){
                continue;
            }
            String l= charVal.substring(0, charVal.length()/2);
            String r= charVal.substring(charVal.length()/2);
//            System.out.printf("%s -%s -%d - %s %n", l,r,charVal.length(), charVal);
            if (Integer.parseInt(l)+ Integer.parseInt(r)==i){
                System.out.println(i);
            }
        }
    }
}
