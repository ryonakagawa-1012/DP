import java.io.*;

public class Tee {
    void run(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new FileWriter(new File(args[0])));

        tree(in, out);

        in.close();
        out.close();
    }

    void tree(BufferedReader in, PrintWriter out) throws IOException {
        String line;

        while((line = in.readLine()) != null){
            out.print(line);
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        Tee tee = new Tee();
        tee.run(args);
    }
}