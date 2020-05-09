package element.io;

import java.io.*;

/**
 * 字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容
 * 4.释放资源）
 *
 * @author Hanz
 * @date 2020/3/1
 */
public class IODemo4 {
    public static void main(String[] args) {
        //1.create resource
        File dest = new File("dragatha.txt");
        //2.chose stream
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest,true);
            // option
            String msg = "Dragatha is real!";
            byte[] datas = msg.getBytes();
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
