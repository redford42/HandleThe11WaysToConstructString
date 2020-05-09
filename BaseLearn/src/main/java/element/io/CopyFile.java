package element.io;

import java.io.*;

/**
 * @author Hanz
 * @date 2020/3/3
 */
public class CopyFile {
    public static void main(String[] args) {
        streamCopy("e:/claes.png", "bang.png");
        writerCopy("dragatha.txt", "Agatha.txt");
    }


    public static void writerCopy(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dist = new File(destPath);
        Writer writer = null;
        Reader reader = null;
        try {
            writer = new FileWriter(dist);
            reader = new FileReader(src);
            char[] datas = new char[1024];
            int len;
            while ((len = reader.read(datas)) != -1) {
                writer.write(datas, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 文件拷贝
     *
     * @param srcPath
     * @param destPath
     */
    public static void streamCopy(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dist = new File(destPath);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dist);
            byte[] flush = new byte[1024];
            int len;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
