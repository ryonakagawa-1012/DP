/*
name : GZip.java
about : 第10講 練習問題10-09 Gzip による圧縮
        https://ksuap.github.io/2022autumn/lesson10/assignments/#9-gzipによる圧縮
date : 2023_Jul16
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.io.*;       // InputStreamとOutputStream、IOExceptionを利用するためにimport
import java.util.zip.GZIPOutputStream;      // GZIPOutputStreamを利用するためにimport


public class GZip{
    void run(String[] args) throws IOException {
        for(Integer i = 0; i < args.length; i ++){
            inAndOut(args[i]);     // 指定されたファイルをgzipを用いて圧縮する。
            printResult(args[i]);      // 圧縮率の結果を表示する。
        }
    }


    void inAndOut(String arg) throws IOException {        // 指定されたファイルをgzipを用いて圧縮するメソッド
        FileInputStream in = new FileInputStream(arg);      // "args[0]"をファイル名とするファイルからの入力を行う変数を設定する。
        String to = arg + ".gz";        // 出力先のファイル名を設定する。
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(to));      // "args[0].gz"をファイル名とするファイルに出力を行うための変数を設定する。
        Integer data;       // 入力データを扱うための変数

        while((data = in.read()) != -1){        // ファイルのデータの最初から、ファイルにまだ扱っていないデータがある限り処理を行う
            out.write(data);
        }

        out.close();        // ファイルへの書き込みを終了する。
    }


    void printResult(String arg) throws IOException {     // 圧縮の結果を表示するメソッド
        File in = new File(arg);        // 入力元ファイルを扱うための変数を作成
        File out = new File(arg+".gz");     // 入力先ファイルを扱うための変数を作成
        Long before = in.length();      // 入力元ファイルのファイルサイズを保存
        Long after = out.length();      // 出力先ファイルのファイルサイズを保存
        Double rate = (double)after / before * 100;     // 圧縮率を百分率で表す。

        System.out.printf("%s: %d bytes -> %d bytes (%.2f%%)%n", arg, before, after, rate);
    }


    public static void main(String[] args) throws IOException {
        GZip gzip = new GZip();
        gzip.run(args);
    }
}
