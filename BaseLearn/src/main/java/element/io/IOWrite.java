package element.io;

import java.io.*;

/**
 * @author Hanz
 * @date 2019/7/17
 */
public class IOWrite {
    public static void main(String[] args) {
        read("E://test.mp4");
    }

    public static void read(String path) {
        try {
            File f = new File(path);
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int n;
                while ((n = fis.read(b)) != -1) {
                    bos.write(b, 0, n);

                }
                fis.close();
                bos.close();
                byte[] buffer;
                buffer = bos.toByteArray();

                File targetFile = new File("E://returnTest.mp4");
                FileOutputStream fos = new FileOutputStream(targetFile);
                OutputStream os = fos;
                os.write(buffer);
                fos.close();
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void write(String path, String content) {
        try {
            File f = new File(path);

            if (f.exists()) {
                System.out.println("文件存在");
            } else {
                System.out.println("文件不存在，正在创建...");
                if (f.createNewFile()) {
                    System.out.println("文件创建成功！");
                } else {
                    System.out.println("文件创建失败！");
                }
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            System.out.println(output);
            output.write(content);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
