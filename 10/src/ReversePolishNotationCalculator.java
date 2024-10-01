/*
name : ReversePolishNotationCalculator.java
about : 第10講 練習問題10-10 逆ポーランド記法の計算機
        https://ksuap.github.io/2022autumn/lesson10/assignments/#10-逆ポーランド記法の計算機
date : 2023_Jul16,17
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.util.ArrayList;     // ArrayListを利用するためにimport
import java.util.Objects;       // Objects.equals()を用いるためにimport


public class ReversePolishNotationCalculator{
    ArrayList<Double> stack = new ArrayList<>();       // 数値を保存しておくためのArrayList


    void run(String[] args) {
        for(Integer i = 0; i < args.length; i ++){      // コマンドライン引数一つ一つを順に処理
            String[] elements = args[i].split(" ");     // 文字列をスペースで区切って一つ一つを配列に保存する。
            calc(elements);     // 計算を行う。
            Double result = stack.get(0);       // 計算の結果を求める。
            printResult(result, args[i]);        // 結果をターミナルに表示する。
            stack.remove(0);        // 次の計算に備えて、stackを空にする。
        }
    }


    void calc(String[] elements) {      // 逆ポーランド記法を利用した計算を行うメソッド
        for(Integer i = 0; i < elements.length; i ++){      // 引数の配列の要素を前から順に処理する。
            if(Objects.equals(elements[i], "+")){       // 配列の要素が「+」なら
                calcPlus();     // stack的な処理で和を求める求める。
            }else if(Objects.equals(elements[i], "-")){       // 配列の要素が「-」なら
                calcMinus();        // stack的な処理で差を求める求める。
            }else if(Objects.equals(elements[i], "*")){       // 配列の要素が「*」なら
                calcMultipl();      // stack的な処理で積を求める求める。
            }else if(Objects.equals(elements[i], "/")){       // 配列の要素が「/」なら
                calcDivi();     // stack的な処理で商を求める。
            }else if(Objects.equals(elements[i], "%")){       // 配列の要素が「%」なら
                calcMod();      // stack的な処理で剰余を求める。
            }else{      // 配列の要素が上記5つの記号ではないなら、すなわち数字なら
                stack.add(Double.valueOf(elements[i]));     // Double型でスタックに値を保存する。
            }
        }
    }


    void calcPlus() {       // stack的な処理で和を求めるメソッド
        Double result = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);      // stackの最後の2要素の和を求める。
        stack.remove(stack.size() - 1);     // スタックの最後の要素を削除する。
        stack.remove(stack.size() - 1);     // スタックの最後から2番目の要素を削除する。
        stack.add(result);
    }


    void calcMinus() {      // stack的な処理で差を求めるメソッド
        Double result = stack.get(stack.size() - 2) - stack.get(stack.size() - 1);      // stackの最後の2要素の差を求める。
        stack.remove(stack.size() - 1);     // スタックの最後の要素を削除する。
        stack.remove(stack.size() - 1);     // スタックの最後から2番目の要素を削除する。
        stack.add(result);
    }


    void calcMultipl() {        // stack的な処理で積を求めるメソッド
        Double result = stack.get(stack.size() - 1) * stack.get(stack.size() - 2);      // stackの最後の2要素の積を求める。
        stack.remove(stack.size() - 1);     // スタックの最後の要素を削除する。
        stack.remove(stack.size() - 1);     // スタックの最後から2番目の要素を削除する。
        stack.add(result);
    }


    void calcDivi() {       // stack的な処理で商を求めるメソッド
        Double result = stack.get(stack.size() - 1) / stack.get(stack.size() - 2);      // stackの最後の2要素の商を求める。
        stack.remove(stack.size() - 1);     // スタックの最後の要素を削除する。
        stack.remove(stack.size() - 1);     // スタックの最後から2番目の要素を削除する。
        stack.add(result);
    }


    void calcMod() {        // stack的な処理で剰余を求めるメソッド
        Double result = stack.get(stack.size() - 1) % stack.get(stack.size() - 2);      // stackの最後の2要素の剰余を求める。
        stack.remove(stack.size() - 1);     // スタックの最後の要素を削除する。
        stack.remove(stack.size() - 1);     // スタックの最後から2番目の要素を削除する。
        stack.add(result);
    }


    void printResult(Double result, String arg) {       // 計算の結果と元の式をターミナルに表示するメソッド
        System.out.printf("%f (%s)%n", result, arg);
    }


    public static void main(String[] args) {
        ReversePolishNotationCalculator rpnc = new ReversePolishNotationCalculator();
        rpnc.run(args);
    }
}
