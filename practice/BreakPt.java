package practice;

import java.util.Scanner;

public class BreakPt {
    public static void main(String[] args){
        int[][] nums = new int[3][3];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 3;i ++){
            for(int j = 0;j < 3;j ++){
                nums[i][j] = sc.nextInt();
            }
        }
        outloop:for(int i = 0;i < 3;i ++){
            for(int j = 0;j < 3;j ++){
                if(i == 1 && j == 1) break outloop;
                System.out.printf("%d ",nums[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
