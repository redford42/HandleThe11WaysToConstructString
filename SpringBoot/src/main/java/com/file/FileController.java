package com.file;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Hanz
 * @date 2020/6/23
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping("/download")
    public HttpServletResponse download(HttpServletResponse response) {
        try {
            File file = new File("drahgatha.txt");
            String filename = file.getName();

            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            InputStream fis = null;
            byte[] buffer = new byte[0];
            fis = new BufferedInputStream(new FileInputStream("dragatha.txt"));
            buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = null;

            toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();

        } catch (IOException ex) {
            response.setContentType("application/json");
            ex.printStackTrace();
        }
        return response;
    }


    @GetMapping("/download/csv")
    public HttpServletResponse downloadCsv(HttpServletResponse response) {
        return null;
    }
}
