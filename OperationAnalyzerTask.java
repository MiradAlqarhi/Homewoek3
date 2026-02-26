import java.io.*;
import java.util.List;

public class OperationAnalyzerTask implements Runnable {

    List<Book> catalog;
    String file;

    public OperationAnalyzerTask(List<Book> catalog, String file) {
        this.catalog = catalog;
        this.file = file;
    }

    public void run() {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String op = parts[0];
                String title = parts[1];

                for (Book b : catalog) {

                    if (b.title.equals(title)) {

                        if (op.equals("BORROW"))
                            b.borrowed = true;

                        if (op.equals("RETURN"))
                            b.borrowed = false;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}