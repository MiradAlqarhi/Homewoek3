import java.util.*;

public class LibraryTracker {

    public static void main(String[] args) throws Exception {

        List<Book> catalog = new ArrayList<>();

        Thread t1 =
                new Thread(new FileReaderTask(catalog, args[0]));

        Thread t2 =
                new Thread(new OperationAnalyzerTask(catalog, args[1]));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        int count = 0;

        for (Book b : catalog)
            if (b.borrowed)
                count++;

        System.out.println(count);
    }
}