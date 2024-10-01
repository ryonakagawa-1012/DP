import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class Sorter {
    void run(String[] args) throws IOException {
        BufferedReader lines = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> strings = new ArrayList<>();

        strings = set(lines, strings);
        Collections.sort(strings);
        print(strings);
    }

    ArrayList<String> set(BufferedReader lines, ArrayList<String> strings) throws IOException {
        String line;

        while((line = lines.readLine()) != null){
            strings.add(line);
        }

        return strings;
    }

    void print(ArrayList<String> strings) {
        for(String line: strings){
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        Sorter sorter = new Sorter();
        sorter.run(args);
    }
}