import java.io.*;

public class Copy3{
    void run(String[] args) throws IOException {
        Arguments arguments = new Arguments();
        arguments.parse(args);

        if(arguments.help){
            this.printHelp();
        }else{
            this.performCopy(arguments);
        }
    }

    void printHelp() {
        System.out.println("Usage: java Copy3 [OPTIONS] from_file to_file");
        System.out.println("       java Copy3 [OPTIONS] from_file ... to_directory");
        System.out.println("OPTIONS");
        System.out.println("       -h: このメッセージを表示して終了する（help）。");
        System.out.println("       -i: コピー先のファイルが存在していた時，ユーザに上書き確認を求める（interactive）。");
        System.out.println("       -r: ディレクトリを再帰的にコピーする（recursive）。");
        System.out.println("       -u: コピー先のファイルが存在しない場合，もしくはコピー元のファイルの方が新しい場合のみコピーする（update）。");
        System.out.println("       -v: 実行内容を表示する（verbose）。");
    }

    void performCopy(Arguments arguments) throws IOException {
        if(arguments.list.size() < 2){
            System.out.println("cp: コマンドライン引数には少なくとも、コピー元とコピー先を指定する必要があります。");

            System.exit(0);
        }else{
            File to = new File(arguments.list.get(arguments.list.size() - 1));

            if(!(to.exists()) || (to.isFile())){
                if(arguments.list.size() > 2){
                    System.out.println("cp: 複数ファイルを一つのファイルにコピーできません。");

                    System.exit(0);
                }else{
                    File from = new File(arguments.list.get(0));

                    if(!(from.exists()) || (from.isDirectory())){
                        System.out.println(arguments.list.get(0)+": No such file");
                    }else{
                        copy(from, to, arguments);
                    }
                }
            }else if(to.isDirectory()){
                for(Integer i = 0; i < arguments.list.size() - 1; i ++){
                    File from = new File(arguments.list.get(i));
                    File toFile = new File(to, from.getName());

                    if(from.exists()){
                        copy(from, toFile, arguments);
                    }else{
                        System.out.println(arguments.list.get(0)+": No such file");
                    }
                }
            }
        }
    }

    void copy(File from, File to, Arguments arguments) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(from));
        PrintWriter out = new PrintWriter(new FileWriter(to));
        String line;

        while((line = in.readLine()) != null){
            out.println(line);
        }

        if(arguments.verbose){
            System.out.printf("%s -> %s%n", from.getPath(), to.getPath());
        }

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Copy3 copy = new Copy3();
        copy.run(args);
    }
}