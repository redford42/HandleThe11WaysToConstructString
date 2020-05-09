package element.io;

import java.io.*;

/**
 * @author Hanz
 * @date 2020/3/3
 */
public class FileUtils {


    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("dragatha.txt");
            OutputStream os = new FileOutputStream("dracula.txt");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        byte[] datas = null;
//        // 文件到字节数组
//        try {
//            InputStream is = new FileInputStream("bang.png");
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            copy(is, os);
//            datas = os.toByteArray();
//            System.out.println(datas.length);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 字节数组到文件
//        try {
//            InputStream is = new ByteArrayInputStream(datas);
//            OutputStream os = new FileOutputStream("agatha.png");
//            copy(is, os);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 对接输入输出流
     *
     * @param is
     * @param os
     * @throws IOException
     */
    public static void copy(InputStream is, OutputStream os) throws IOException {
        try {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(is, os);
        }
    }


    private static void close(Closeable... ios) {
         for (Closeable io : ios) {
            try {
                if (null != io) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
