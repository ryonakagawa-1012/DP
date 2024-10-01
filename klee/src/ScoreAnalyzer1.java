//学籍番号:2354233
//氏名：蓮見考紘

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ScoreAnalyzer1 {

    //メインメソッド(7行)
    public static void main(String[] args) throws IOException {
        //引数がない場合は終了
        if(args.length != 2){
            System.out.println("引数を入力してください");
            System.exit(1);
        }
        ScoreAnalyzer1 scoreAnalyzer = new ScoreAnalyzer1();
        //ファイルからデータを読み込みリストに格納
        List<PersonalData> scoreList = FileContents.readDataFromFile(args[1], Integer.valueOf(args[0]));
        //個人成績を出力
        scoreAnalyzer.analyzeScore(scoreList);
    }

//個人成績を出力(13行)
    private void analyzeScore(List<PersonalData> scoreList) {
        //スコアをキーとした全体成績のマップ
         HashMap<String, Integer> scoreMap = new HashMap<>();
        //個人の各問題ごとの成績（PersonalDataクラス）をすべてチェック
        for (PersonalData personalData : scoreList) {
            //スコア（キー）の初期化
            String score;
            //スコアをString型に変換
            score = personalData.score.toString();
            //スコアが-1の場合は空文字に変換
            if (personalData.score == -1) {
                score="";
            }
            //スコアをキーとして全体成績のマップの度数を更新
            scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
        }
        //全体成績を出力
        for (String key : scoreMap.keySet()) {
            System.out.println(key + ": " + String.format("%.3f", (double)scoreMap.get(key) / scoreList.size() * 100) + " (" + scoreMap.get(key) + "/" + scoreList.size() + ")");
        }
    }

}