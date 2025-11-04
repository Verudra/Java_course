package practice;

import java.io.IOException;

public class read_practice {
    public static void main(String[] args){
        byte[] sa = new byte[10];
        try {
            System.out.println("请输入至少3个字符后回车：");
            int len = System.in.read(sa, 1, 3); // 从标准输入读取最多3个字节，放入sa[1]~sa[3]
            System.out.println("实际读取字节数: " + len);
            System.out.print("读取的内容是: ");
            for (int i = 1; i < 1 + len; i++) {
                // if(sa[i] >= 'a' && sa[i] < 'z')
                    System.out.print((char)sa[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
