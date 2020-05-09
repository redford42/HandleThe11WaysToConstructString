package element.io;

import java.io.File;

/**
 * @author Hanz
 * @date 2020/2/29
 */
public class DirCount {
    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }

    // 大小
    private long len;
    // 文件夹
    private String path;
    // 源
    private File src;

    public DirCount(String path) {
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    public static void main(String[] args) {
        DirCount dir = new DirCount("e:/Dracula");
        System.out.println(dir.getLen());
    }

    //统计大小
    private void count(File src) {
        // 获取大小
        if (null != src && src.exists()) {
            if (src.isFile()) {
                // 大小
                len += src.length();
            } else {
                // 子孙级
                for (File f : src.listFiles()) {
                    count(f);
                }

            }
        }
    }


}
