/*
name : Frequencies.java
about : 第10講 練習問題10-06 freqコマンド: 与えられたテキストファイルに現れる単語の頻度を求める
        https://ksuap.github.io/2022autumn/lesson10/assignments/#6-freqコマンド与えられたテキストファイルに現れる単語の頻度を求める
date : 2023_Jul8, 9
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.io.*;       // 入出力を行うためにimport
import java.util.HashMap;       // HashMapを用いるためにimport
import java.util.Iterator;      // Iterator型を利用するためにimort
import java.util.Map;       // Map.Entry型をHashMapの要素として扱うためにimport


public class Frequencies {
    void run(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));        // ファイルからの入力を行単位で扱うための変数を設定
        String[] words = setArray(in);       // ファイルのデータを単語単位で配列に保存する。
        HashMap<String, Integer> wordsAndFreq = new HashMap<>();      // 単語とその頻度を保存するためのHashMap
        wordsAndFreq = setHashMap(words, wordsAndFreq);     // 単語とその頻度を保存するHashMapを作成する。
        printResult(wordsAndFreq);      // HashMapのデータをターミナルに表示する。
    }


    String[] setArray(BufferedReader in) throws IOException {        // ファイルのデータを単語単位で配列に保存するメソッド
        String line;        // ファイルからの入力を行うための変数
        String lines = null;       // ファイルからの入力を行うための変数

        while((line = in.readLine()) != null){      // ファイルに扱っていないデータがある限り、データを行単位で文字列に追加していく。
            lines += String.valueOf(line) + " ";        // 行単位で読み込んだファイルのデータを一つの文字列に結合していく。ただし、行と行の間には半角スペースを入れる（このスペースを入れないと、行の終わりの語と行の初めの語の間にスペースが入らず、ひとつながりの単語になってしまうから。）。
        }

        String[] words = lines.split(" ");       // 半角スペースごとに入力データを分割して配列に保存する。

        return words;
    }


    HashMap<String, Integer> setHashMap(String[] words, HashMap<String, Integer> wordsAndFreq) {        // 単語とその頻度を保存するHashMapを作成するメソッド
        for(Integer i = 0; i < words.length; i ++){     // wordsのデータをすべて処理する。
            if(wordsAndFreq.get(words[i]) == null){     // wordsのデータがwordsAndFreqに格納されていない場合
                wordsAndFreq.put(words[i], 1);      // そのwordsのデータをキーとして、バリューに0を設定する。
            }else{      // wordsのデータがwordsAndFreqに格納されている場合
                wordsAndFreq.put(words[i], wordsAndFreq.get(words[i]) + 1);     // そのwordsのデータをキーとするバリューの値をインクリメントする。
            }
        }

        return wordsAndFreq;
    }


    void printResult(HashMap<String, Integer> wordsAndFreq) {       // HashMapのデータをターミナルに表示するメソッド
        for(Map.Entry<String, Integer> entry: wordsAndFreq.entrySet()){     // wordsAndFreqのデータを一つずつすべて取り出していく。
            String key = entry.getKey();        // キーを取り出す。
            Integer value = entry.getValue();     // バリューを取り出す。
            System.out.printf("%s: %d%n", key, value);        // ターミナルに表示する。
        }
    }


    public static void main(String[] args) throws IOException {
        Frequencies frequencies = new Frequencies();
        frequencies.run(args);
    }
}
