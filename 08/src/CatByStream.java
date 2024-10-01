// 第８講 InputStream/OutputStream型 例題4 InputStreamを利用した Cat
// https://ksuap.github.io/2022autumn/lesson08/inoutstream/#例題-4-inputstream-を利用した-cat
import java.io.FileInputStream;
import java.io.IOException;

public class CatByStream {
    void run(String[] args) throws IOException {
        for (Integer i = 0; i < args.length; i++) {
            this.cat(args[i]);
        }
    }

    void cat(String file) throws IOException {
        System.out.printf("========== %s ==========%n", file);
        FileInputStream in = new FileInputStream(file);
        this.printFileContent(in);
        in.close();
    }

    void printFileContent(FileInputStream in) throws IOException {
        Integer data;
        while ((data = in.read()) != -1) {
            System.out.write(data);
        }
    }

    public static void main(String[] args) throws IOException {
        CatByStream cat = new CatByStream();
        cat.run(args);
    }
}
