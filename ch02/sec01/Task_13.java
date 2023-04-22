package ch02.sec01;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public static void main(String[] args) throws Exception {
        String csvFile = "path/file.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        List<String[]> lines = reader.readAll();
        for (String[] line : lines) {
            for (String value : line) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }
}

