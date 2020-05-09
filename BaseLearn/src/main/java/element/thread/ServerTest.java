package element.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hanz
 * @date 2019/11/8
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        new ServerTest().start();
    }

    public void start() throws IOException {
        // 启动一个socket监听8888端口
        ServerSocket serverSocket = new ServerSocket(10241);
        Socket socket = null;
        System.out.println("启动web服务器");
        while (true) {
            socket = serverSocket.accept();
            Thread thread = new Thread(new HttpServerThread(socket));
            thread.start();
        }
    }

    // 内部类
    private class HttpServerThread implements Runnable {
        Socket socket = null;

        HttpServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream is = null;
            OutputStream os = null;
            BufferedReader br = null;
            try {
                is = this.socket.getInputStream();
                os = this.socket.getOutputStream();

                // 页面的请求
                br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                int i = 0;
                while (null != line && br.ready()) {
                    line = br.readLine();
                    System.out.println("第" + i + "行信息:" + line);
                    i++;
                }

                // 页面给请求方的响应
                String reply = "HTTP/1.1\n"; //响应头
                reply += "Content-type:text/html\n\n";
                reply += "服务器返回的消息";
                os.write(reply.getBytes());
            } catch (IOException e) {

            }
        }
    }
}
