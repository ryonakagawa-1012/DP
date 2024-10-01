import java.io.*;

public class Head {
    void run(String[] args) throws IOException {
        Integer inputNumber = Integer.valueOf(args[0]);

        BufferedReader in = dicideIn(args);
        head(inputNumber, in);

        in.close();
    }

    BufferedReader dicideIn(String[] args) throws IOException {
        BufferedReader in;

        if(args.length == 1){
            in = new BufferedReader(new InputStreamReader(System.in));
        }else{
            in = new BufferedReader(new FileReader(args[1]));
        }

        return in;
    }

    void head(Integer inputNumber, BufferedReader in) throws IOException {
        LineNumberReader line = new LineNumberReader(in);

        for(; line.getLineNumber() < inputNumber;){
            System.out.println(line.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        Head head = new Head();
        head.run(args);
    }
}