// 第８講 Writer型 例題2 指定された行数を出力するコマンド
// https://ksuap.github.io/2022autumn/lesson08/writer/#例題-2-指定された行数を出力するコマンド
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputN {
    void run(String[] args) throws IOException {
        Integer max = Integer.valueOf(args[0]);
        PrintWriter out = new PrintWriter(new FileWriter(new File(args[1])));
        for (Integer i = 1; i <= max; i++) {
            out.println(i);
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        OutputN output = new OutputN();
        output.run(args);
    }
}
