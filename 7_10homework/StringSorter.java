import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StringSorter {

    public static List<String> generateRandomStrings(int count, int length) {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static void main(String[] args) {
        // 1. 生成随机字符串序列
        List<String> strings = generateRandomStrings(10, 5); // 生成10个长度为5的字符串

        System.out.println("原始字符串序列：");
        strings.forEach(System.out::println);

        // 2. 使用lambda表达式进行倒序字典排序
        strings.sort((s1, s2) -> s2.compareTo(s1)); // 倒序排序

        System.out.println("\n排序后的字符串序列：");
        strings.forEach(System.out::println);

        // 3. 写入文件 a.data，使用缓冲处理流提高效率
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("a.data"))) {
            for (String s : strings) {
                writer.write(s);
                writer.newLine();
            }
            System.out.println("\n排序结果已写入文件 a.data");
        } catch (IOException e) {
            System.err.println("写入文件时出错: " + e.getMessage());
        }
    }
}
