package element.io;

import java.io.*;

/**
 * @author Hanz
 * @date 2020/3/1
 */
public class IODemo2 {
    public static void main(String[] args) {
        File src = new File("IODemoOne.txt");
        InputStream is = null;

        // 选择流
        try {
            is = new FileInputStream(src);
            // 操作 读取
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.print((char) temp);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if (null != is) {
                    is.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
