package element.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串到字节
 * 解码：字节到字符串
 *
 * @author Hanz
 * @date 2020/2/29
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "吸血鬼和修女百年好合D";
        byte[] bytes = msg.getBytes();
        System.out.println(bytes.length);

        bytes = msg.getBytes("UTF-16LE");
        System.out.println(bytes.length);

        bytes = msg.getBytes("GBK");
        System.out.println(bytes.length);

        String msg2 = "修女和吸血鬼天长地久A";
        byte[] bytes2 = msg2.getBytes("UTF-8");
        String decodeMsg = new String(bytes2, 0, bytes2.length, "UTF-8");
        System.out.println(decodeMsg);

    }
}
