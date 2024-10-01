/*
name : Tail.java
about : 第10講 練習問題10-07 tailコマンド: 与えられたテキストファイルの最後の数行を出力する
        https://ksuap.github.io/2022autumn/lesson10/assignments/#7-tailコマンド与えられたテキストファイルの最後の数行を出力する
date : 2023_Jul13
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.io.*;       // ファイル入出力とIOexceptionを利用するためにimport
import java.util.ArrayList;       // ArrayListを利用するためにimport


public class Tail {
    void run(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();       // ファイルのデータを行単位で扱うためのArrayList
        Integer lineNumber = Integer.valueOf(args[0]);      // コマンドライン引数の数字をInteger型で扱うための変数

        lines = read(lines, args[1]);      // ファイルの入力を行単位でArrayListに格納する。
        print(lineNumber, lines);      // 指定された行をターミナルに表示する。
    }


    ArrayList<String> read(ArrayList<String> lines, String arg) throws IOException {      // ファイルの入力を行単位でArrayListに格納するメソッド
        BufferedReader in = new BufferedReader(new FileReader(arg));      // ファイルからの入力を行うための変数を設定する。
        String line;        // ファイルからの入力を扱うための変数
        
        while((line = in.readLine()) != null){        // ファイルのデータを最初から最後まで行単位で順に処理する。
            lines.add(line);        // データをArrayListに格納する。
        }

        return lines;
    }


    void print(Integer lineNumber, ArrayList<String> lines) {       // 指定された行をターミナルに表示するメソッド
        Integer lineNumberFirst = lines.size() - lineNumber;        // ファイルのうちの出力する行を指定するための変数を設定する。
        if(lineNumberFirst < 0){        // もしコマンドライン引数で指定された値がファイルの行数を上回っていたら
            lineNumberFirst = 0;        // ファイルの最初の行から順に出力するようにする。
        }

        for(Integer i = lineNumberFirst; i < lines.size(); i ++){     // コマンドライン引数で指定された分だけArrayListのデータを後ろから順に扱う。
            System.out.printf("%s%n", lines.get(i));       // ターミナルに表示する。
        }
    }
    

    public static void main(String[] args) throws IOException {
        Tail tail = new Tail();
        tail.run(args);
    }
}
