package csv;

//import org.supercsv.cellprocessor.FmtBool;
//import org.supercsv.cellprocessor.FmtDate;
//import org.supercsv.cellprocessor.Optional;
//import org.supercsv.cellprocessor.constraint.LMinMax;
//import org.supercsv.cellprocessor.constraint.NotNull;
//import org.supercsv.cellprocessor.constraint.UniqueHashCode;
//import org.supercsv.cellprocessor.ift.CellProcessor;
//import org.supercsv.io.CsvBeanWriter;
//import org.supercsv.io.ICsvBeanWriter;
//import org.supercsv.prefs.CsvPreference;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Hanz
 * @date 2019/7/29
 */
public class csvLearn {
    //    CsvPreference csvPreference =new CsvPreference.Builder('"', '|', "\n").build();
//    BufferedWriter bufferedWriter;
//
//    {
//        try {
//            bufferedWriter = new BufferedWriter(new FileWriter("csv.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    CsvBeanWriter cvsWriter1 = new CsvBeanWriter(bufferedWriter,csvPreference);
// create the customer beans
    public static void main(String args[]) throws Exception {

//            ICsvMapWriter writer = new CsvMapWriter(new FileWriter("test.csv"),CsvPreference.STANDARD_PREFERENCE);
//            try {
//                final String[] header = new String[]{"name", "city", "zip"};
//                // set up some data to write
//                final HashMap<String, ? super Object> data1 = new HashMap<String, Object>();
//                data1.put(header[0], "Karl");
//                data1.put(header[1], "Tent city");
//                data1.put(header[2], 5565);
//                final HashMap<String, ? super Object> data2 = new HashMap<String, Object>();
//                data2.put(header[0], "Banjo");
//                data2.put(header[1], "River side");
//                data2.put(header[2], 5551);
//                // the actual writing
//                writer.writeHeader(header);
//                writer.write(data1, header);
//                writer.write(data2, header);
//            } finally {
//                writer.close();
//            }
//        writeWithCsvBeanWriter();
        Collection<String[]> collection = initHeader();
        for (int i = 0; i < 5; i++) {
            collection.add(new String[]{
                    String.valueOf(i + 1), "today", String.valueOf(i * 1000)});
        }
        CsvExporter.appendMulti("defaultName.csv", collection);
    }


    private static Collection<String[]> initHeader() {
        String[] header = new String[]{"序号", "日期", "播放次数"};
        Collection<String[]> collection = Lists.newArrayListWithCapacity(1 << 10);
        collection.add(header);
        return collection;
    }
//    private static void writeWithCsvBeanWriter() throws Exception {
//        final CustomerBean john = new CustomerBean("1", "John", "Dunbar",
//                new GregorianCalendar(1945, Calendar.JUNE, 13).getTime(),
//                "1600 Amphitheatre Parkway\nMountain View, CA 94043\nUnited States", false, 0,
//                "\"May the Force be with you.\" - Star Wars", "jdunbar@gmail.com", 0L);
//        final CustomerBean bob = new CustomerBean("2", "Bob", "Down",
//                new GregorianCalendar(1919, Calendar.FEBRUARY, 25).getTime(),
//                "1601 Willow Rd.\nMenlo Park, CA 94025\nUnited States", true, 0,
//                "\"Frankly, my dear, I don't give a damn.\" - Gone With The Wind", "bobdown@hotmail.com", 123456L);
//        final List<CustomerBean> customers = Arrays.asList(john, bob);
//
//        ICsvBeanWriter beanWriter = null;
//        try {
//            try {
//                beanWriter = new CsvBeanWriter(new FileWriter("writeWithCsvBeanWriter.csv"),
//                        CsvPreference.STANDARD_PREFERENCE);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // the header elements are used to map the bean values to each column (names must match)
//            final String[] header = new String[]{"customerNo", "firstName", "lastName", "birthDate",
//                    "mailingAddress", "married", "numberOfKids", "favouriteQuote", "email", "loyaltyPoints"};
//            final CellProcessor[] processors = getProcessors();
//
//            // write the header
//            try {
//                beanWriter.writeHeader(header);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // write the beans
//            for (final CustomerBean customer : customers) {
//                try {
//                    beanWriter.write(customer, header, processors);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } finally {
//            if (beanWriter != null) {
//                beanWriter.close();
//            }
//        }
//    }

//    private static CellProcessor[] getProcessors() {
//
//        final CellProcessor[] processors = new CellProcessor[]{
//                new UniqueHashCode(), // customerNo (must be unique)
//                new NotNull(), // firstName
//                new NotNull(), // lastName
//                new FmtDate("dd/MM/yyyy"), // birthDate
//                new NotNull(), // mailingAddress
//                new Optional(new FmtBool("Y", "N")), // married
//                new Optional(), // numberOfKids
//                new NotNull(), // favouriteQuote
//                new NotNull(), // email
//                new LMinMax(0L, LMinMax.MAX_LONG) // loyaltyPoints
//        };
//
//        return processors;
//    }
}
