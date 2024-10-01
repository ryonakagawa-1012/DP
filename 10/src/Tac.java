import java.io.*;
import java.util.ArrayList;


public  class Tac {
    void run(String[] args) throws IOException {
        for(Integer i = 0; i < args.length; i ++){
            BufferedReader in = new BufferedReader(new FileReader(args[i]));
            ArrayList<String> lines = new ArrayList<>();

            lines = set(in, lines);

            for(Integer j = lines.size() - 1; j > -1; j --){
                System.out.println(lines.get(j));
            }
        }
    }


    ArrayList<String> set(BufferedReader in, ArrayList<String> lines) throws IOException {
        String line;

        while((line = in.readLine()) != null){
            lines.add(line);
        }

        return lines;
    }


    public static void main(String[] args) throws IOException {
        Tac tac = new Tac();
        tac.run(args);
    }
}