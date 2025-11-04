package practice;

import java.util.Scanner;

public class MethodPt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(fun(x));
        sc.close();
    }
    static int fun(int x){
        return x*x;
    }
}
