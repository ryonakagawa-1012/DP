//学籍番号:2354233
//氏名：蓮見考紘

import java.io.IOException;
import java.util.*;
public class ScoreAnalyzer3 {

    static  List<PersonalData> scoreList;
    //メインメソッド(8行)
    public static void main(String[] args) throws IOException {
        //引数がない場合は終了
        if(args.length != 1){
            System.out.println("引数を入力してください");
            System.exit(1);
        }
        ScoreAnalyzer3 scoreAnalyzer = new ScoreAnalyzer3();
        //ファイルからデータを読み込みリストに格納
        scoreList = FileContents.readDataFromFile(args[0],null);
        //個人成績を集計&&出力
        scoreAnalyzer.AnalyzePersonalScore();
        //全体成績を集計&&出力
        scoreAnalyzer.AnalyzeTotalScore();
    }


    //個人成績の統計を出力(11行)
    public void AnalyzePersonalScore(){
        //学籍番号をキーとした個人成績のクラス（PersonalDataSet）のマップを作成
        HashMap<Integer, PersonalDataSet> personalScoreMap = PersonalDataSet.createDataMap(scoreList);
        //全ての学籍番号のPersonalDataSetをpersonalScoreMapから取得
        for(PersonalDataSet personalDataSet : personalScoreMap.values()){
            //学籍番号を出力
            System.out.printf(String.valueOf(personalDataSet.studentID));
            //個人成績を出力
            for(Integer score : personalDataSet.scoreMap.values()){
                printPersonalScore(score);
            }
            //最大スコア、最小スコア、平均スコアを出力
            System.out.print(","+personalDataSet.getMaxScore());
            System.out.print(","+personalDataSet.getMinScore());
            System.out.print(","+personalDataSet.getAverageScore());
            System.out.println();
        }
    }

    //個人成績のスコアを出力(5行)
    public void printPersonalScore(Integer score){
        //スコアが-1(無効)の場合はカンマのみを出力
        if(score == -1){
            System.out.print(",");
            return;
        }
        //スコアを出力
        System.out.print(","+score);
    }

    //全体成績を取得(11行)
    public void AnalyzeTotalScore() {
        //問題番号,点数のリストのマップ。問題番号で自動ソートされている
        TreeMap<Integer, List<Integer>> questionMap = new TreeMap<>();
        //個人成績をすべて取得
        for(PersonalData personalData : scoreList){
            //問題番号がまだ出現していない場合は問題番号のキーとスコアを入れるリストを追加
            if(!questionMap.containsKey(personalData.question)){
                questionMap.put(personalData.question,new ArrayList<>());
            }
            //問題番号に対応するスコアリストを取得
            List<Integer> scores = questionMap.get(personalData.question);
            //スコアをリストに追加
            scores.add(personalData.score);
        }
        //全体成績を出力
        printTotalScore(questionMap);
    }

    //全体成績を出力(20行)
    public void printTotalScore(TreeMap<Integer, List<Integer>> questionMap){
        for(List<Integer> value : questionMap.values()){
            value.removeIf(score -> score == -1);
            System.out.print(","+value.stream().max(Integer::compareTo).orElse(0));
        }
        System.out.println();
        for(List<Integer> value : questionMap.values()){
            value.removeIf(score -> score == -1);
            System.out.print(","+value.stream().min(Integer::compareTo).orElse(0));
        }
        System.out.println();
        for(List<Integer> value : questionMap.values()){
            value.removeIf(score -> score == -1);
            int total = 0;
            for(Integer score : value){
                total += score;
            }
            System.out.print(","+(double)total/value.size());
        }
        System.out.println();

    }
}
