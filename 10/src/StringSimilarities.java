/*
name : StringSimilarities.java
about : 第10講 練習問題10-11 2つの文字列間の類似度・距離
        https://ksuap.github.io/2022autumn/lesson10/assignments/#11-２つの文字列間の類似度距離
date : 2023_Jul18
coder : name : 武藤 太央 (Muto Tao)
        studentID : 254739
*/


import java.util.ArrayList;     // ArrayListを利用するためにimport
import java.util.HashMap;       // HashMapを利用するためにimport
import java.util.Objects;       // Objects.equals()を用いるためにimport


public class StringSimilarities {
    void run(String[] args) {
        calcSimpsonIndex(args[0], args[1]);     // simpson係数を計算して結果をターミナルに表示する。
        calcJaccardIndex(args[0], args[1]);     // jaccard係数を計算して結果をターミナルに表示する。
        calcDiceIndex(args[0], args[1]);        // dice係数を計算して結果をターミナルに表示する。
        calcCosineSimilarity(args[0], args[1]);     // コサイン類似度を計算して結果をターミナルに表示する。
        calcEditDistance(args[0], args[1]);     // 編集距離を算出してその結果をターミナルに表示する。
    }


    ArrayList<Character> getList(String item) {     // 文字列から重複なしの文字の集合を取得するメソッド
        ArrayList<Character> list = new ArrayList<Character>();     // 結果のデータを保存するためのArrayList

        for(Integer i = 0; i < item.length(); i++){     // 引数の文字列を一文字ずつ処理する。
            Character c = item.charAt(i);       // 文字列の一文字を文字型変数に入れる。
            if(!list.contains(c)){      // ある一文字がArrayListに含まれていなければ、その文字をArrayListに追加する。
                list.add(c);
            }
        }

        return list;
    }

    ArrayList<Character> getProductSet(String item1, String item2) {     // 二つの異なる文字の集合の積集合を求めるメソッド
        ArrayList<Character> list1 = new ArrayList<Character>();        // 結果のデータを保存するためのArrayList
        ArrayList<Character> list2 = new ArrayList<Character>();        // 結果のデータを保存するためのArrayList
        ArrayList<Character> list3 = new ArrayList<Character>();        // 結果のデータを保存するためのArrayList

        for(Integer i = 0; i < item1.length(); i++){     // 引数の文字列を一文字ずつ処理する。
            Character c = item1.charAt(i);       // 文字列の一文字を文字型変数に入れる。
            if(!list1.contains(c)){      // ある一文字がArrayListに含まれていなければ、その文字をArrayListに追加する。
                list1.add(c);
            }
        }

        for(Integer i = 0; i < item2.length(); i++){     // 引数の文字列を一文字ずつ処理する。
            Character c = item2.charAt(i);       // 文字列の一文字を文字型変数に入れる。
            if(!list2.contains(c)){      // ある一文字がArrayListに含まれていなければ、その文字をArrayListに追加する。
                list2.add(c);
            }
        }

        for(Integer i = 0; i < list1.size(); i ++){     // 引数の文字列1を一文字ずつ処理する。
            for(Integer j = 0; j < list2.size(); j ++){     // 文字列1の文字一つ一つに対して、それが文字列2に含まれているかどうかを確認する。
                if((Objects.equals(list1.get(i), list2.get(j))) && !(list3.contains(list1.get(i)))){       // 二つの文字列両方に含まれている文字がlist3にまだ含まれていなければ、その文字をlist3に追加する。
                    list3.add(list1.get(i));
                }
            }
        }

        return list3;
    }

    ArrayList<Character> getUnionSet(String item1, String item2) {      // 二つの異なる文字の集合の和集合を求めるメソッド
        ArrayList<Character> list = new ArrayList<Character>();     // 結果のデータを保存するためのArrayList

        for(Integer i = 0; i < item1.length(); i++){     // 引数の文字列を一文字ずつ処理する。
            Character c = item1.charAt(i);       // 文字列の一文字を文字型変数に入れる。
            if(!list.contains(c)){      // ある一文字がArrayListに含まれていなければ、その文字をArrayListに追加する。
                list.add(c);
            }
        }

        for(Integer i = 0; i < item2.length(); i++){     // 引数の文字列を一文字ずつ処理する。
            Character d = item2.charAt(i);       // 文字列の一文字を文字型変数に入れる。
            if(!list.contains(d)){      // ある一文字がArrayListに含まれていなければ、その文字をArrayListに追加する。
                list.add(d);
            }
        }

        return list;
    }

    ArrayList<Integer> setVector(String item, ArrayList<Character> union) {     // ある文字列がある集合の要素をいくつずつ持っているかを表すベクトルを作るメソッド
        ArrayList<Integer> vector = new ArrayList<>();      // ベクトルを表すためのArrayList
        HashMap<Character, Integer> freq = new HashMap<>();       // 各文字の出現頻度を保存するためのHashMap
        for(Character chr: union){     // freqを初期化する。unionの要素を全て順に処理する。
            freq.put(chr, 0);      // 各文字の頻度の初期値は0。
        }

        for(Integer i = 0; i < item.length(); i++){      // itemの文字を先頭から順に一つずつ全て処理する。
            freq.put(item.charAt(i), freq.get(item.charAt(i)) + 1);       // freqの、item.charAt(i)のバリューをインクリメントする。
        }

        for(Character chr: union){      // itemがunionの要素をいくつずつ持っているかを表すベクトルを作る。unionの要素を全て順に処理する。
            vector.add(freq.get(chr));      // freqにおけるunionの各要素に対応するバリューをArrayListに保存する。
        }

        return vector;
    }


    Double calcInnerProduct(ArrayList<Integer> vector1, ArrayList<Integer> vector2) {       // 二つのベクトルの内積を算出するメソッド
        Double sum = 0.0;        // 積の和を求めるための変数。

        for(Integer i = 0; i < vector1.size(); i ++){       // 二つのベクトルの対応する成分を全て順に処理する。
            sum += Double.valueOf(vector1.get(i)) * Double.valueOf(vector2.get(i));     // 積を累算していく。
        }

        return sum;
    }

    Double calcVectorMagnitude(ArrayList<Integer> vector) {     // ベクトルの大きさを算出するメソッド
        Double sum = 0.0;        // 2乗の和を求めるための変数。

        for(Integer i = 0; i < vector.size(); i ++){       // ベクトルの各成分を全て順に処理する。
            sum += Double.valueOf(vector.get(i)) * Double.valueOf(vector.get(i));     // 2乗した値を累算していく。
        }

        return Math.sqrt(sum);      // 累算値の平方、すなわちベクトルの大きさをreturn
    }

    Integer minThreeNums(Integer a, Integer b, Integer c) {        // 3つの整数値のうちの最小の値を返すメソッド
        Integer result;     // 結果を扱うための変数

        if(a < b){
            result = a;
        }else{
            result = b;
        }
        if(c < result){
            result = c;
        }

        return result;
    }


    Table<Integer> setTable(String item1, String item2) {       // Tableを初期化するメソッド
        Table<Integer> table = new Table<Integer>(item1.length()+1, item2.length()+1);

        for(Integer x = 0; x < item1.length()+1; x ++){     // マス(x, 0)の値をxにする。
            table.set(x, x, 0);
        }

        for(Integer y = 0; y < item2.length()+1; y ++){     // マス(0, y)の値をyにする。
            table.set(y, 0, y);
        }
        

        return table;
    }


    void calcSimpsonIndex(String item1, String item2) {     // Simpson係数を計算して結果をターミナルに表示するメソッド
        ArrayList<Character> product = getProductSet(item1, item2);     // 積集合を表すためのArrayListを設定する。
        ArrayList<Character> list1 = getList(item1);        // item1から重複なしの文字の集合を取得する。
        ArrayList<Character> list2 = getList(item2);        // item2から重複なしの文字の集合を取得する。
        Double result;      // Simpson係数を扱うための変数

        if(list1.size() < list2.size()){        // list1の集合の要素数の方が少なければ
            result = Double.valueOf(product.size()) / Double.valueOf(list1.size());     // list1の要素数で割る。
        }else{
            result = Double.valueOf(product.size()) / Double.valueOf(list2.size());     // list2の要素数で割る。
        }

        System.out.printf("simpson(%s, %s)=%f%n", item1, item2, result);        // 結果をターミナルに表示する。
    }

    void calcJaccardIndex(String item1, String item2) {     // Jaccard係数を計算して結果をターミナルに表示するメソッド
        ArrayList<Character> product = getProductSet(item1, item2);     // 積集合を表すためのArrayListを設定する。
        ArrayList<Character> union = getUnionSet(item1, item2);     // 和集合を表すためのArrayListを設定する。
        Double result = Double.valueOf(product.size()) / Double.valueOf(union.size());      // Jaccard係数を扱うための変数

        System.out.printf("jaccard(%s, %s)=%f%n", item1, item2, result);        // 結果をターミナルに表示する。
    }
    
    void calcDiceIndex(String item1, String item2) {        // Dice係数を計算して結果をターミナルに表示するメソッド
        ArrayList<Character> product = getProductSet(item1, item2);     // 積集合を表すためのArrayListを設定する。
        ArrayList<Character> list1 = getList(item1);        // item1から重複なしの文字の集合を取得する。
        ArrayList<Character> list2 = getList(item2);        // item2から重複なしの文字の集合を取得する。
        Double result = 2.0 * Double.valueOf(product.size()) / (Double.valueOf(list1.size()) + Double.valueOf(list2.size()));       // Dice係数を扱うための変数

        System.out.printf("dice(%s, %s)=%f%n", item1, item2, result);        // 結果をターミナルに表示する。
    }

    void calcCosineSimilarity(String item1, String item2) {     // コサイン類似度を計算して結果をターミナルに表示するメソッド
        ArrayList<Character> union = getUnionSet(item1, item2);     // 和集合を表すためのArrayListを設定する。
        ArrayList<Integer> item1Vector = setVector(item1, union);       // unionに対するitem1のベクトルを設定する。
        ArrayList<Integer> item2Vector = setVector(item2, union);       // unionに対するitem2のベクトルを設定する。

        Double result = calcInnerProduct(item1Vector, item2Vector) / (calcVectorMagnitude(item1Vector) * calcVectorMagnitude(item2Vector));     // 二つのベクトルのなす角をθとして、cosθの値を求める。

        System.out.printf("cosine(%s, %s)=%f%n", item1, item2, result);        // 結果をターミナルに表示する。
    }

    void calcEditDistance(String item1, String item2) {     // 編集距離を算出してその結果をターミナルに表示するメソッド
        Table<Integer> table = setTable(item1, item2);      // 編集距離を算出するためのTableを初期化する。

        for(Integer x = 1; x < item1.length()+1; x ++){
            for(Integer y = 1; y < item2.length()+1;  y ++){
                Integer topLeft = table.get(x-1, y-1);      // 今見ているマス、すなわちマス（x, y）の左上のマスの値を、それに1を加えた上で保存する。
                Integer top = table.get(x, y-1) + 1;        // 今見ているマス、すなわちマス（x, y）の上のマスの値を保存する。
                Integer left = table.get(x-1, y) + 1;       // 今見ているマス、すなわちマス（x, y）の左のマスの値を保存する。

                if(Objects.equals(item1.charAt(x-1), item2.charAt(y-1))){       // 今見ているマス、すなわちマス（x, y）に対応する文字列の文字が等しい場合
                    table.set(minThreeNums(topLeft, top, left), x, y);      // 今見ているマス、すなわちマス（x, y）の値を、その上のマスの値に1を加えた値、上のマスの値に1を加えた値、左上のマスの値のうち最も小さな値にする。
                }else{      // 等しくない場合
                    table.set(minThreeNums(topLeft+1, top, left), x, y);        // 今見ているマス、すなわちマス（x, y）の値を、その上のマスの値に1を加えた値、上のマスの値に1を加えた値、左上のマスの値に1を加えた値のうち最も小さな値にする。
                }
            }
        }

        System.out.printf("edit_distance(%s, %s)=%d%n", item1, item2, table.get(item1.length(), item2.length()));       // 結果をターミナルに表示する。
    }

    public static void main(String[] args) {
        StringSimilarities sSs = new StringSimilarities();
        sSs.run(args);
    }
}
