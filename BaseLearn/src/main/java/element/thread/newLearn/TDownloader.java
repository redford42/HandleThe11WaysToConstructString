package element.thread.newLearn;

/**
 * @author Hanz
 * @date 2020/3/4
 */
public class TDownloader extends Thread {
    public static void main(String[] args) {
        TDownloader td1 = new TDownloader("https://wx3.sinaimg.cn/mw690/005POrX4gy1ftb2wyg1z1j30bh0avmxd.jpg", "honey.jpg");
        TDownloader td2 = new TDownloader("https://wx3.sinaimg.cn/mw690/c7818caegy1gcfmf2usekj216y0o6whj.jpg", "master.jpg");
        TDownloader td3 = new TDownloader("https://wx4.sinaimg.cn/mw690/c7818caegy1gbntl9bh9gg20dw0efx6p.gif", "red.gif");
        td3.start();
        td1.start();
        td2.start();


    }

    private String url;
    private String name;

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
    }
}
