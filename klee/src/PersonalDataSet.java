//学籍番号:2354233
//氏名：蓮見考紘

import java.util.*;

public class PersonalDataSet {

    //学籍番号
    Integer studentID;
    //問題番号をキーとした全ての点数のマップ。問題番号で自動ソートされている
    TreeMap<Integer, Integer> scoreMap = new TreeMap<>();
    //問題番号をキーとした全ての所要時間のマップ。問題番号で自動ソートされている
    TreeMap<Integer, Integer> timeMap = new TreeMap<>();

    //コンストラクタ
    public PersonalDataSet(Integer studentID) {
        this.studentID = studentID;
    }

    //ユーティリティ関数(1行)
    public void setScoreMap(Integer question, Integer score) {
        scoreMap.put(question, score);
    }

    public void setTimeMap(Integer question, Integer time) {
        timeMap.put(question, time);
    }

    public Integer getScore(Integer question) {
        return scoreMap.get(question);
    }

    public Integer getTime(Integer question) {
        return timeMap.get(question);
    }


    //問題番号をキーとした点数のマップの平均値を返す(6行)
    public Double getAverageScore() {
        int total = 0;
        List<Integer> scoreList = removeIf(scoreMap.values(), -1);
        for (Integer score : scoreList) {
            total += score;
        }
        return (double) total / scoreList.size();
    }

    //問題番号をキーとした所要時間のマップの平均値を返す(6行)
    public Double getAverageTime() {
        int total = 0;
        List<Integer> timeList = removeIf(timeMap.values(), -1);
        for (Integer time : timeList) {
            total += time;
        }
        return (double) total / timeList.size();
    }

    //問題番号をキーとした点数のマップの最大値を返す(2行)
    public Integer getMinScore() {
        //-1を除いたmapのvalueの最小値を返す
        List<Integer> scoreList = removeIf(scoreMap.values(), -1);
        return scoreList.stream().min(Integer::compareTo).orElse(0);

    }

    //問題番号をキーとした点数のマップの最小値を返す(2行)
    public Integer getMaxScore() {
        //-1を除いたmapのvalueの最大値を返す
        List<Integer> scoreList = removeIf(scoreMap.values(), -1);
        return scoreList.stream().max(Integer::compareTo).orElse(0);
    }

    //データの無効を示す値-1が含まれると結果が変わるため-1を除いた値で計算する。(3行)
    //mapのvalueCollectionに指定の値が含まれている場合はその値を削除したリストを返す
    public static List<Integer> removeIf(Collection<Integer> mapValue, Integer value) {
        List<Integer> valueList = new ArrayList<>(mapValue);
        valueList.removeIf(score -> Objects.equals(score, value));
        return valueList;
    }

    //学籍番号をキーとした個人成績のマップを作成(20行)
    public static HashMap<Integer, PersonalDataSet> createDataMap(List<PersonalData> scoreList) {
        //学籍番号をキーとした個人成績のマップ
        HashMap<Integer, PersonalDataSet> personalScoreMap = new HashMap<>();
        //全ての出現した問題番号を格納するリスト
        List<Integer> questionList = new ArrayList<>();
        //Mapに成績を格納
        //個人の各問題ごとの成績（PersonalDataクラス）をすべてチェック
        for (PersonalData personalData : scoreList) {
            //問題番号がまだ出現済みリストに含まれていない場合は追加
            if (!questionList.contains(personalData.question)) {
                questionList.add(personalData.question);
            }
            //学籍番号がまだpersonalMapに含まれていない場合は追加
            if (!personalScoreMap.containsKey(personalData.studentID)) {
                personalScoreMap.put(personalData.studentID, new PersonalDataSet(personalData.studentID));
            }
            //学籍番号に対応するPersonalDataSetをpersonalMapから取得
            PersonalDataSet personalDataSet = personalScoreMap.get(personalData.studentID);
            //PersonalDataSetのスコアマップに問題番号をキーとしてスコアを格納
            personalDataSet.setScoreMap(personalData.question, personalData.score);
            //PersonalDataSetに時間マップに問題番号をキーとして時間を格納
            personalDataSet.setTimeMap(personalData.question, personalData.getTime());
        }
        //問題を飛ばしていた場合の処理（scoreListに入っていなかった場合）
        //全ての学籍番号のPersonalDataSetをpersonalMapから取得
        for (PersonalDataSet personalDataSet : personalScoreMap.values()) {
            //出現済み問題番号をすべて確認
            for (Integer question : questionList) {
                //問題番号がまだスコアマップに含まれていない（スコアが無効である）場合はスコアに-1を格納
                personalDataSet.scoreMap.putIfAbsent(question, -1);
                //問題番号がまだ時間マップに含まれていない（時間が無効である）場合は時間に-1を格納
                personalDataSet.timeMap.putIfAbsent(question, -1);
            }
        }
        return personalScoreMap;
    }


}
