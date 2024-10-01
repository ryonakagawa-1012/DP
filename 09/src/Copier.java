/*
name : Copier.java
about : 第9講 小テスト UNIX の cp コマンドの簡易版
        コマンドライン引数で2つの文字列を受け取り，1つ目のファイルの内容を2つ目のファイルに書き込む。
date : 2023_Jun8
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.io.*;       // Reader系クラスとWriter系クラス、IOExceptionを使用するためにimport


public class Copier {
    void run(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));        // 第1コマンドライン引数で指定されたファイルからの入力を行うための実体を作成する。
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));     // 第2コマンドライン引数で指定されたファイルへの出力を行うための実体を作成する。

        copier(in, out);        // 入力ファイルから文字列を読み込んで、出力ファイルに書き込んでいく。

        in.close();     // 入力を終了する。
        out.close();        // 出力を終了する。
    }


    void copier(BufferedReader in, PrintWriter out) throws IOException {       // 入力ファイルから文字列を読み込んで、出力ファイルに書き込んでいくメソッド
        String line;        // 文字列の読み込みと書き込みを行うための変数

        while((line = in.readLine()) != null){      // 入力ファイルに処理していないデータがある限り処理を続ける。
            out.println(line);      // 行単位で入力ファイルの文字列を出力ファイルに書き込む。
        }
    }

    public static void main(String[] args) throws IOException {
        Copier copier = new Copier();
        copier.run(args);
    }
}
