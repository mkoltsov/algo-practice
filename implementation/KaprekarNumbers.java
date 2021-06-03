public class KaprekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(22223,99999);
    }

    public static void kaprekarNumbers(int p, int q) {
        boolean oneNumber=false;
        for (int i =p; i<=q;i++){
            long square = (long)Math.pow(i,2);
            if (i==1){
                System.out.print(1 +" ");
                continue;
            }
            String charVal = String.valueOf(square);
            if (charVal.length()<2){
                continue;
            }
            String l= charVal.substring(0, charVal.length()/2);
            String r= charVal.substring(charVal.length()/2);
//            System.out.printf("%s -%s -%d - %s %n", l,r,charVal.length(), charVal);
            if (Long.parseLong(l)+ Long.parseLong(r)==i){
                oneNumber=true;
                System.out.print(i+" ");
            }

        }
        if (!oneNumber) {
            System.out.println("INVALID RANGE");
        }
    }
}
