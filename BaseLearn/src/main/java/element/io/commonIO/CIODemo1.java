package element.io.commonIO;


import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @author Hanz
 * @date 2020/3/4
 */
public class CIODemo1 {
    public static void main(String[] args) {
        // 文件大小
        long len = FileUtils.sizeOf(new File("bang.png"));
        System.out.println("bang.png" + len);
        // 目录大小
        len = FileUtils.sizeOf(new File("e:/AFFile"));
        System.out.println("affile" + len);
    }
}
