package element.io;

import java.io.*;

/**
 * 操作步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 *
 * @author Hanz
 * @date 2020/3/1
 */
public class IODemo1 {
    public static void main(String[] args) {
        File src = new File("IODemoOne.txt");
        // 选择流
        try {
            InputStream is = new FileInputStream(src);
            // 操作 读取
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();
            int data5 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)data4);
            System.out.println(data5);
            // 释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
