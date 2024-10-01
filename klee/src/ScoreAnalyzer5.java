//学籍番号:2354233
//氏名：蓮見考紘

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ScoreAnalyzer5 {
    List<PersonalData> scoreList = new ArrayList<>();
    TreeMap<Integer, PersonalDataSet> sortedDataMap;
    Arguments arguments;

    public static void main(String[] args) throws IOException {
        ScoreAnalyzer5 scoreAnalyzer = new ScoreAnalyzer5();
        scoreAnalyzer.setUp(args);
    }

    public void setUp(String[] args) throws IOException {
        arguments = new Arguments(args);
        scoreList = FileContents.readDataFromFile(arguments.csvName, null);
        sortedDataMap =sort();
        drawPixel();
        printData();

    }

    //ヒートマップのピクセルデータを計算(12行)
    public void drawPixel() throws IOException {
        //1ドットのサイズを設定
        int scale = 3;
        //問題数を高さにする。問題数は全受講者で共通（未回答問題があってもAnalyzePersonalScore()で無効スコアを格納済み）のため任意のデータを取得。
        //テスト受講者の人数を幅にする
        BufferedImage image = new BufferedImage(sortedDataMap.size() * scale, sortedDataMap.values().iterator().next().scoreMap.size() * scale, BufferedImage.TYPE_INT_RGB);
        //生徒の人数を初期化
        int studentNum = 0;
        //生徒の人数分だけ繰り返す
        for (Integer studentID : sortedDataMap.keySet()) {
            //生徒一人の全てのスコアのリストを取得
            List<Integer> totalData = getPersonalAllData(studentID);
            //問題番号を初期化
            int question = 0;
            //全てのスコア(問題数分)に対してヒートマップのピクセルデータを作成
            for (Integer data : totalData) {
                //ヒートマップのピクセルデータを描画
                drawImage(image, studentNum, question,data, scale);
                //次の問題番号に進む
                question++;
            }
            //次の生徒に進む
            studentNum++;
        }
    }

    //ヒートマップのピクセルデータを描画(15行)
    public void drawImage(BufferedImage image, int x, int y, int data, int scale) throws IOException {
        //ファイル名から画像のフォーマットを取得
        String format = arguments.imgName.substring(arguments.imgName.length() - 3);
        //スケール分だけピクセルを描画
        for (int i = x * scale; i < (x + 1) * scale; i++) {
            for (int j = y * scale; j < (y + 1) * scale; j++) {
                //gradeRGBメソッドで取得したRGB値をセット
                image.setRGB(i, j, gradeRGB(data, y));
            }
        }
        //ヒートマップを画像として出力
        ImageIO.write(image, format, new File(arguments.imgName));
    }


    //総合個人成績のリストを取得(６行)
    public List<Integer> getPersonalAllData(Integer studentID) {
        //学籍番号に対応するPersonalDataSetをpersonalMapから取得
        PersonalDataSet personalDataSet = sortedDataMap.get(studentID);
        //成績のリストを作成
        List<Integer> scoreList = new ArrayList<>();
        //問題番号ですべて取得
        for (Integer question : personalDataSet.scoreMap.keySet()) {
            //問題番号に対応するスコアをリストに追加
            scoreList.add(personalDataSet.getScore(question));
        }
        return scoreList;
    }

    //指定の問題番号における最大スコアを取得(8行)
    public Integer getMaxScore(List<PersonalData> scoreList, Integer question) {
        int max = 0;
        //全ての個人成績をチェック
        for (PersonalData personaldata : scoreList) {
            //指定の問題番号でキャッシュデータより高ければ最大スコアを更新
            if (personaldata.score > max && Objects.equals(personaldata.question, question)) {
                max = personaldata.score;
            }
        }
        return max;
    }

    //ヒートマップの色味を計算(1行)
    public int gradeRGB(Integer data, Integer y) {
        //デフォルトの色を白に設定
        int rgb = 16777215;
        //スコアが無効でない場合
        if (data != -1) {
            //最大スコアが0でない場合
            if (this.getMaxScore(scoreList, y + 1) != 0) {
                //スコアを最大スコアで割り、点数の取得率を計算
                double grade = (double) data / (double) this.getMaxScore(scoreList, y + 1);
                //取得率を255倍してRGB値（青）を取得
                rgb = (int) Math.floor(grade * 255);
            } else {
                //最大スコアが0の場合はRGB値を0（黒）に設定
                rgb = 0;
            }
        }
        return rgb;
    }

    //ソート処理(18行)
    public TreeMap<Integer, PersonalDataSet> sort() {
        HashMap<Integer, PersonalDataSet> personalMap = PersonalDataSet.createDataMap(scoreList);
        //学籍番号でソート
        if (arguments.sortType == 0) {
            return new TreeMap<>(personalMap);
        } else if (arguments.sortType == 1) {
            //スコアの平均値でソート
            TreeMap<Integer, PersonalDataSet> sortedMap =  new TreeMap<>((o1, o2) -> {
                int compare = personalMap.get(o1).getAverageScore().compareTo(personalMap.get(o2).getAverageScore());
                return (compare != 0) ? compare : o1.compareTo(o2);
            });
            sortedMap.putAll(personalMap);
            return sortedMap;
        } else {
            //所要時間の平均値でソート
            TreeMap<Integer, PersonalDataSet> sortedMap = new TreeMap<>((o1, o2) -> {
                int compare = personalMap.get(o1).getAverageTime().compareTo(personalMap.get(o2).getAverageTime());
                return (compare != 0) ? compare : o1.compareTo(o2);
            });
            sortedMap.putAll(personalMap);
            return sortedMap;
        }
    }

    //データを出力(13行)
    public void printData() {
        for (Map.Entry<Integer, PersonalDataSet> entry : sortedDataMap.entrySet()) {
            System.out.print(entry.getKey());
            PersonalDataSet personalDataSet = entry.getValue();
            for (int i=1;i<=personalDataSet.scoreMap.size(); i++) {
                printPersonalData(personalDataSet.getScore(i));
                printPersonalData(personalDataSet.getTime(i));
            }
            System.out.print("," + personalDataSet.getMaxScore());
            System.out.print("," + personalDataSet.getMinScore());
            System.out.print("," + personalDataSet.getAverageScore());
            System.out.println();
        }
        AnalyzeTotalScore();
    }


    //個人成績のスコアを出力(5行)
    public void printPersonalData(Integer data) {
        if (data == -1) {
            System.out.print(",");
            return;
        }
        System.out.print("," + data);
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
