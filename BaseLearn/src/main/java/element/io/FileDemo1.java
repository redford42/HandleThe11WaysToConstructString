package element.io;

import java.io.File;
import java.io.IOException;

/**
 * @author Hanz
 * @date 2020/2/28
 */
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        // 相对路径和绝对路径
        // 有盘符，绝对路径
        String path = "E:/claes.png";
        File claes = new File(path);
        // 无盘符就是相对路径
        String path2 = "dolly.jpg";
        File dolly = new File("dolly.jpg");
        dolly.createNewFile();
        dolly.delete();
        System.out.println(dolly.exists());
        System.out.println(claes.getAbsolutePath());

    }
}
