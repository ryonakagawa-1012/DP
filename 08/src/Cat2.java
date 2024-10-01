import java.io.*;

public class Cat2 {
    void run(String[] args) throws IOException {
        for(Integer i = 0; i < args.length; i ++){
            cat(new File(args[i]));
        }
    }

    void cat(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        LineNumberReader lineNumber = new LineNumberReader(in);
        String line;

        while ((line = lineNumber.readLine()) != null) {
            System.out.printf("%d   ", lineNumber.getLineNumber());
            System.out.println(line);
        }

        lineNumber.close();
    }

    public static void main(String[] args) throws IOException {
        Cat2 cat2 = new Cat2();
        cat2.run(args);
    }
}