package com.file;

import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
import java.util.Collection;

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
            fis = new BufferedInputStream(new FileInputStream("drahgatha.txt"));
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


    @RequestMapping(value = "/download/csv/{path}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpServletResponse downloadCsv(HttpServletResponse response, @PathVariable("path") String path) {
        Collection<String[]> collection = initHeader();
        String filePath = path + ".csv";
        for (int i = 0; i < 5; i++) {
            collection.add(new String[]{
                    String.valueOf(i + 1), "today", String.valueOf(i * 1000)});
        }
        CsvExporter.appendMulti(filePath, collection);
        try {
            File file = new File(filePath);
            String filename = file.getName();

            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            InputStream fis = null;
            byte[] buffer = new byte[0];
            fis = new BufferedInputStream(new FileInputStream(filePath));
            buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = null;
            response.setContentType("application/octet-stream");
            toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    private static Collection<String[]> initHeader() {
        String[] header = new String[]{"序号", "日期", "播放次数"};
        Collection<String[]> collection = Lists.newArrayListWithCapacity(1 << 10);
        collection.add(header);
        return collection;
    }
}
