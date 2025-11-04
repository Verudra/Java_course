package practice;

import java.util.Scanner;

public class Scanner_practice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = sc.hasNext();
        int num = sc.nextInt();
        if(flag) System.out.print("True");
        else System.out.println("False");
        System.out.println(num);
        sc.close();
    }
}
