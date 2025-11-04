package practice;
import java.util.Scanner;
public class Scanner_practice2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int in1 = sc.nextInt();
        double dou1 = sc.nextDouble();
        boolean bool1 = sc.nextBoolean();
        String str1 = sc.next();
        sc.nextLine();
        String str3 = sc.nextLine();
        System.out.println(in1+" "+dou1+" "+bool1+" "+str1);
        System.out.println(str3);
        sc.close();
    }
}
