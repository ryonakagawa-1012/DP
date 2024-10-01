//学籍番号:2354233
//氏名：蓮見考紘

import java.io.IOException;
import java.util.*;

public class ScoreAnalyzer6 extends ScoreAnalyzer5{

    //メインメソッド(2行)
    public static void main(String[] args) throws IOException {
        ScoreAnalyzer6 scoreAnalyzer = new ScoreAnalyzer6();
        scoreAnalyzer.setUp(args);
    }

    //個人データのリスト(Time/Score)を取得(11行)
    @Override
    public List<Integer> getPersonalAllData(Integer studentID) {
        //学籍番号に対応するPersonalDataSetをpersonalMapから取得
        PersonalDataSet personalDataSet = sortedDataMap.get(studentID);
        //成績のリストを作成
        List<Integer> scoreList = new ArrayList<>();
        //全ての問題番号に対してスコアを取得。※timeMap.keySet()はscoreMap.keySet()と同じ。※createDataMap()で該当問題を解答していなかった際に、無効データ(-1)をいれてキーとして問題番号を作成しているため。
        for (Integer question : personalDataSet.scoreMap.keySet()) {
            //スコアマップの時はスコアを取得
            if(arguments.imgType==0){
                scoreList.add(personalDataSet.getScore(question));
            }
            //タイムマップの時は時間を取得
            else{
                scoreList.add(personalDataSet.getTime(question));
            }
        }
        return scoreList;
    }

    //最短時間を取得(7行)
    public Integer getMinTime(List<PersonalData> scoreList, Integer question) {
        int min = Integer.MAX_VALUE;
        //全ての個人成績をチェック
        for (PersonalData personaldata : scoreList) {
            //指定の問題番号でキャッシュデータより低ければ最小の時間を更新
            if (personaldata.getTime() < min && Objects.equals(personaldata.question, question) && personaldata.getTime() != -1){
                min = personaldata.getTime();
            }
        }
        return min;
    }

    //timeMapように色味の比率の計算を行う方法を追加(19行)
    @Override
    public int gradeRGB(Integer data, Integer y) {
        //デフォルトの色を白に設定
        int rgb = 16777215;
        //最大スコア又は最短時間
        int compareData;
        //最大得点（最短時間）に対する比率
        double grade = 0;
        //スコアマップの時は最大スコアを取得
        if(arguments.imgType==0){
            compareData = getMaxScore(scoreList, y + 1);
        }
        //タイムマップの時は最短時間を取得
        else{
            //最短時間が0の場合は無効になってしまうため1を加算
            compareData = getMinTime(scoreList, y + 1)+1;
        }
        //スコアや時間が無効でない場合
        if (data != -1) {
            //最大スコアが0(得点者なし)でなく、スコアマップを出力する場合。※getMaxScoreで-1(無効)は既に弾いている。
            if (compareData != 0 && arguments.imgType == 0) {
                //スコアを最大スコアで割り、点数の取得率を計算
               grade = (double) data / (double) compareData;
            }
            //最短時間が-1(無効)でなく、タイムマップを出力する場合。※1を加算しているため-1の場合は0になる
            else if(compareData != 0 && arguments.imgType == 1){
                grade = (double) compareData / (double) (data+1);
            }
            //段階を示す比率を255倍してRGB値（青）を取得
            rgb = (int) Math.floor(grade * 255);
        }
        return rgb;
    }
}
