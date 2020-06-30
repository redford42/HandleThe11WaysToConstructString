package com.file;

import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;

/**
 * @author Hanz
 * @date 2020/6/30
 */
public class CsvExporter {
    private final static String DEFAULT_CHARSET = "UTF-8";
    private static byte[] utfBom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};

    private CsvExporter(String filePath, Collection<String[]> data) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        if (!"UTF-8".equalsIgnoreCase(DEFAULT_CHARSET)) {
            return;
        }
        try {
            RandomAccessFile accessFile = new RandomAccessFile(filePath, "rw");
            long length = accessFile.length();
            if (length > 0) {
                return;
            }
            accessFile.write(utfBom);
            accessFile.close();
        } catch (IOException e) {
            System.out.println("");
        }

    }

}
