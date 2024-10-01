//学籍番号:2354233
//氏名：蓮見考紘

import java.io.IOException;
import java.util.*;

public class ScoreAnalyzer2 {

    //メインメソッド(7行)
    public static void main(String[] args) throws IOException {
        //引数がない場合は終了
        if(args.length != 1){
            System.out.println("引数を入力してください");
            System.exit(1);
        }
        ScoreAnalyzer2 scoreAnalyzer = new ScoreAnalyzer2();
        //ファイルからデータを読み込みリストに格納
        List<PersonalData> scoreList = FileContents.readDataFromFile(args[0],null);
        //個人成績をマップとして処理
        scoreAnalyzer.putMap(scoreList);
    }

    //個人成績をもとに全体の度数をカウント。マップとして処理(16行)
    private void putMap(List<PersonalData> dataList) {
        //問題番号をキーとしてTreeMap＜点数,人数＞を格納したマップ。自動で点数がソートされる
        HashMap<Integer, TreeMap<Integer, Integer>> questionMap = new HashMap<>();
        //記録のある点数のリスト
        List<Integer> scoreList = new ArrayList<>();
        //個人の各問題ごとの成績（PersonalDataクラス）をすべてチェック
        for (PersonalData personalData : dataList) {
            //記録のある点数のリストに含まれていない場合はリストにスコアを追加。無効点数(-1)は含めない
            if (!scoreList.contains(personalData.score) && personalData.score!= -1) {
                scoreList.add(personalData.score);
            }
            //問題番号がまだmapのキーに含まれていない場合は追加
            if (!questionMap.containsKey(personalData.question)) {
                //問題番号をキーとしてTreeMap＜点数,人数＞を格納
                questionMap.put(personalData.question, new TreeMap<>());
            }
            //無効な点数の場合は以下の処理をスキップ
            if(personalData.score == -1){
                continue;
            }
            //問題番号をキーとしてTreeMap＜点数,人数＞を取得し、点数をキーとして度数を更新
            int total = questionMap.get(personalData.question).getOrDefault(personalData.score, 0);
            questionMap.get(personalData.question).put(personalData.score, total + 1);
        }
        //まとめたデータを出力
        analyzeScore(questionMap, scoreList);
    }

    //個人成績を出力(16行)
    private void analyzeScore(HashMap<Integer, TreeMap<Integer, Integer>> questionMap, List<Integer> scoreList) {
        //記録のある点数のリストを昇順にソート
        scoreList.sort(Comparator.naturalOrder());
        //記録のある点数のリストを出力
        for (Integer score : scoreList) {
            System.out.print("," + score);
        }
        System.out.println();
        //questionMapを全て取り出す
        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : questionMap.entrySet()) {
            //問題番号を取得
            int question = entry.getKey();
            //問題番号に対応するTreeMap＜点数,人数＞を取得
            TreeMap<Integer, Integer> scoreMap = entry.getValue();
            //人数の合計を初期化
            int total = 0;
            //記録のある点数を全て取り出す
            for (Integer score : scoreList) {
                //点数が存在しない場合はその点数のvalueに0を追加
                scoreMap.putIfAbsent(score,0);
                //人数の合計を更新
                total += scoreMap.get(score);
            }
            //問題番号を出力
            System.out.print(question);
            //そのスコアの得点者の割合を出力
            printScore(scoreMap,scoreList,total);
        }
    }

    //そのスコアの得点者の割合を出力(9行)
    private void printScore(TreeMap<Integer,Integer> scoreMap,List<Integer> scoreList,int total){
        //記録のある点数のリストの順番で取り出す
        for (Integer score : scoreList) {
            //得点者が存在しない場合はカンマを出力
            if(scoreMap.get(score) == 0){
                System.out.print(",");
                continue;
            }
            //得点者の割合を出力
            System.out.printf(","+"%.3f", (double) scoreMap.get(score)/total*100);
        }
        System.out.println();
    }
}
