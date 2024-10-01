import java.io.*;
import java.util.Objects;

public class Copy4{
    void run(String[] args) throws IOException {
        Arguments arguments = new Arguments();
        arguments.parse(args);

        if(arguments.help){
            this.printHelp();
        }else{
            this.performCopy(arguments);
        }
    }

    Boolean isOverwriteAskToUser(File to) throws IOException {
        SimpleConsole console = new SimpleConsole();

        while(true){
            System.out.printf("%sを上書きしますか? (y/n [n]) ", to.getName());

            String line = console.readLine();
            line = line.trim();

            if(Objects.equals(line, "y")){
                return true;
            }else if(Objects.equals(line, "") || Objects.equals(line, "n")){
                System.out.println("上書きしません。");
                return false;
            }else{
                System.out.println("yかnを入力してください。");
            }
        }
    }

    Boolean isOverwrite(File to, Arguments args) throws IOException {
        if(to.exists() && to.isFile()){
            if(args.interactive && !isOverwriteAskToUser(to)){
                return false;
            }
        }
        return true;
    }

    void printHelp() {
        System.out.println("Usage: java Copy4 [OPTIONS] from_file to_file");
        System.out.println("       java Copy4 [OPTIONS] from_file ... to_directory");
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
        if(isOverwrite(to, arguments)){
            this.doCopy(from, to, arguments);

            if(arguments.verbose){
                System.out.printf("%s -> %s%n", from.getPath(), to.getPath());
            }
        }
    }

    void doCopy(File from, File to, Arguments arguments) throws IOException {
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
        Copy4 copy = new Copy4();
        copy.run(args);
    }
}