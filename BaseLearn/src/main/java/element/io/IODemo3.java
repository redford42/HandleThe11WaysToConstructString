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
public class IODemo3 {
    public static void main(String[] args) {
        File src = new File("IODemoOne.txt");
        InputStream is = null;

        // 选择流
        try {
            is = new FileInputStream(src);
            // 操作 读取
            byte[] flush = new byte[5];
            int len; //接受长度
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
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
