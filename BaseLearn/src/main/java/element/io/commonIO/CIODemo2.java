package element.io.commonIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Hanz
 * @date 2020/3/4
 */
public class CIODemo2 {
    public static void main(String[] args) {
        try {
            FileUtils.copyFile(new File("agatha.png"), new File("claes.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
