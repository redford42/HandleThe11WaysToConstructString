package element.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author Hanz
 * @date 2019/7/17
 */
public class IOWrite {
    public static void main(String[] args) {
        write("E://af.txt", "hello");
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
