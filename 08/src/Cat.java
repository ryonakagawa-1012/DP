// 第８講 Reader型 例題1 Catコマンドの作成
// https://ksuap.github.io/2022autumn/lesson08/reader/#例題-1-cat-コマンドの作成
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cat {
    void run(String[] args) throws IOException {
        cat(new File(args[0]));
    }

    void cat(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }

    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.run(args);
    }
}
