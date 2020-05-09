package element.thread.newLearn;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载图片
 * @author Hanz
 * @date 2020/2/28
 */
public class WebDownloader {
    /**
     * 下载图片
     * @param url
     * @param name
     */
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
