import java.io.*;

public class Grep {
    void run(String[] args) throws IOException {
        for(Integer i = 1; i < args.length; i ++){
            grep(args[0], args[i]);
        }
    }

    void grep(String input, String file) throws IOException {
        LineNumberReader in = new LineNumberReader(new BufferedReader(new FileReader(file)));
        String line;

        while((line = in.readLine()) != null){
            if(line.contains(input)){
                System.out.printf("%s:  ", file);
                System.out.println(line);
            }
        }

        in.close();
    }

    public static void main(String[] args) throws IOException {
        Grep grep = new Grep();
        grep.run(args);
    }
}