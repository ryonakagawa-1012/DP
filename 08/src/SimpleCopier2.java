// 第８講 InputStream/OutputStream型 例題5 単純なファイルコピー2
// https://ksuap.github.io/2022autumn/lesson08/inoutstream/#例題-5-単純なファイルコピー-2
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleCopier2 {
    void run(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream("output");
        this.copy(in, out);
        in.close();
        out.close();
    }

    void copy(FileInputStream in, FileOutputStream out) throws IOException {
        Integer data;
        while ((data = in.read()) != -1) { // １文字ずつ読み込み，
                                           // データが読み込めなくなるまで繰り返す．
            out.write(data); // データを１文字書き出す．
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleCopier2 copier = new SimpleCopier2();
        copier.run(args);
    }
}
