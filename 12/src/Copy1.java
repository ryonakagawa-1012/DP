import java.io.*;

public class Copy1{
    void run(String[] args) throws IOException {
        if(args.length < 2){
            System.out.println("cp: コマンドライン引数には少なくとも、コピー元とコピー先を指定する必要があります。");

            System.exit(0);
        }

        File from = new File(args[0]);
        File to = new File(args[1]);

        copy(from, to);
    }

    void copy(File from, File to) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(from));
        PrintWriter out = new PrintWriter(new FileWriter(to));
        String line;

        while((line = in.readLine()) != null){
            out.println(line);
        }

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Copy1 copy = new Copy1();
        copy.run(args);
    }
}