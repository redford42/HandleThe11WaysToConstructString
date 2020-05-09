package element.io;

import java.io.*;

/**
 * 图片读取到字节数组
 * 字节数组写出到文件
 *
 * @author Hanz
 * @date 2020/3/3
 */
public class BinaryIODemo {


    public static void main(String[] args) {
        byte[] datas = fileToByteArray("bang.png");
        byteArrayToFile(datas,"dracula.png");
        System.out.println(datas.length);
    }

    /**
     * 图片到程序
     * 程序到字节数组
     *
     * @param filePath
     */
    public static byte[] fileToByteArray(String filePath) {
        File file = new File(filePath);
        byte[] dest = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                baos.write(flush, 0, len);

            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void byteArrayToFile(byte[] src, String filePath) {
        File dest = new File(filePath);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);

            }
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
