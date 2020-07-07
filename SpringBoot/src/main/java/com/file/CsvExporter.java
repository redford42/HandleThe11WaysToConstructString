package com.file;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.util.CollectionUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;

/**
 * @author Hanz
 * @date 2020/6/30
 */
public class CsvExporter {
    private final static String DEFAULT_CHARSET = "UTF-8";
    private static byte[] utfBom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};

    public CsvExporter() {

    }

    public static void appendMulti(String filePath, Collection<String[]> data) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        // prepareFileHeader
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

        CSVPrinter csvPrinter;
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName(DEFAULT_CHARSET),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            for (String[] str : data) {
                try {
                    csvPrinter.printRecord(str);
                } catch (IOException e) {
                    continue;
                }
            }
            csvPrinter.flush();
            csvPrinter.close(true);
        } catch (IOException e) {
            System.out.println("");
        }
    }

}
