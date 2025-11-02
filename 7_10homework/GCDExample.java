import java.math.BigInteger;

public class GCDExample {
    public static int euclideanGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

        int gcd = euclideanGCD(num1, num2);
        BigInteger n1 = BigInteger.valueOf(num1);
        BigInteger n2 = BigInteger.valueOf(num2);
        int gcd2 = n1.gcd(n2).intValue();
        if(gcd == gcd2){
            System.out.println("The gcd is:" + gcd + " is correct!");
        }
        else{
            System.out.println("The gcd is incorrect!");
        }
    }
}
