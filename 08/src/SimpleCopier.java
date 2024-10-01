// 第８講 Writer型 例題3 単純なファイルコピー
// https://ksuap.github.io/2022autumn/lesson08/writer/#例題-3-単純なファイルコピー
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleCopier {
    void run(String[] args) throws IOException {
        FileReader in = new FileReader(args[0]);
        FileWriter out = new FileWriter("output");
        this.copy(in, out);
        in.close();
        out.close();
    }

    void copy(FileReader in, FileWriter out) throws IOException {
        int data;
        while ((data = in.read()) != -1) { // １文字ずつ読み込み，
                                           // データが読み込めなくなるまで繰り返す．
            out.write(data); // データを１文字書き出す．
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleCopier copier = new SimpleCopier();
        copier.run(args);
    }
}
