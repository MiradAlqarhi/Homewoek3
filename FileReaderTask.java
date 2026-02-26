import java.io.*;
import java.util.List;

public class FileReaderTask implements Runnable {

    List<Book> catalog;
    String file;

    public FileReaderTask(List<Book> catalog, String file) {
        this.catalog = catalog;
        this.file = file;
    }

    public void run() {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                catalog.add(new Book(line));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}