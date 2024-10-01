import java.io.*;

public class Copy2{
    void run(String[] args) throws IOException {
        if(args.length < 2){
            System.out.println("cp: コマンドライン引数には少なくとも、コピー元とコピー先を指定する必要があります。");

            System.exit(0);
        }

        File to = new File(args[args.length - 1]);

        if(!(to.exists()) || (to.isFile())){
            if(args.length > 2){
                System.out.println("cp: 複数ファイルを一つのファイルにコピーできません。");

                System.exit(0);
            }else{
                File from = new File(args[0]);

                copy(from, to);
            }
        }else if(to.isDirectory()){
            for(Integer i = 0; i < args.length - 1; i ++){
                File from = new File(args[i]);
                File toFile = new File(to, from.getName());

                copy(from, toFile);
            }
        }
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
        Copy2 copy = new Copy2();
        copy.run(args);
    }
}