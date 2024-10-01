/*
name : Arguments.java
about : 第12講 練習問題12-3 オプション解析を行う
        https://ksuap.github.io/2023spring/lesson12/copy/#3-オプション解析を行う
        で用いるクラス
date : 2023_Jul18
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.util.ArrayList;     // ArrayListを利用するためにimport
import java.util.Objects;       // Objects.equals()を利用するためにimport


public class Arguments{
    Boolean help = false;
    Boolean interactive = false;
    Boolean recursive = false;
    Boolean update = false;
    Boolean verbose = false;
    ArrayList<String> list = new ArrayList<>();


    void run(String[] args) {
        setupArrayList(args);       // フィールドのArrayListを初期化する。
    }


    void setupArrayList(String[] args) {
        for(String str: args){      // argsの要素を順番に全て一つずつ処理する。
            list.add(str);      // listに追加する。
        }
    }


    void parse(String[] args){      // オプション解析を行うためのメソッド
        for(String arg: args){
            if(Objects.equals(arg, "-h")){
                this.help = true;
            }
            else if(Objects.equals(arg, "-i")){
                this.interactive = true;
            }
            else if(Objects.equals(arg, "-r")){
                this.recursive = true;
            }
            else if(Objects.equals(arg, "-u")){
                this.update = true;
            }
            else if(Objects.equals(arg, "-v")){
                this.verbose = true;
            }
            else{
                this.list.add(arg);
            }
        }
    }


    public static void main(String[] args) {
        Arguments arguments = new Arguments();
        arguments.run(args);
    }
}
