//学籍番号:2354233
//氏名：蓮見考紘

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ScoreAnalyzer4 {

    static List<PersonalData> scoreList;
    //学籍番号をキーをとした個人成績のクラス（PersonalDataSet）のマップを作成
    HashMap<Integer, PersonalDataSet> dataMap = PersonalDataSet.createDataMap(scoreList);
    //メインメソッド(7行)
    public static void main(String[] args) throws IOException {
        //引数がない場合は終了
        if(args.length != 1){
            System.out.println("引数を入力してください");
            System.exit(1);
        }
        ScoreAnalyzer4 scoreAnalyzer = new ScoreAnalyzer4();
        //データを読み込みクラスとしてリストに格納
        scoreList = FileContents.readDataFromFile(args[0], null);
        //ヒートマップのピクセルデータを計算
        scoreAnalyzer.drawPixel();
    }

    //ヒートマップのピクセルデータを計算(15行)
    public void drawPixel() throws IOException {

        //1ドットのサイズを設定
        int scale = 3;
        //テスト受講者の人数をサイズにする
        //問題数を高さにする。問題数は全受講者で共通（未回答問題があってもAnalyzePersonalScore()で無効スコアを格納済み）のため任意のデータを取得。
        BufferedImage image = new BufferedImage(dataMap.size() * scale, dataMap.values().iterator().next().scoreMap.size() * scale, BufferedImage.TYPE_INT_RGB);
        //生徒の人数を初期化
        int studentNum = 0;
        //生徒の人数分だけ繰り返す
        for (Integer studentID : dataMap.keySet()) {
            //生徒一人の全てのスコアのリストを取得
            List<Integer> totalScore = getPersonalData(studentID, dataMap);
            //問題番号を初期化
            int question = 0;
            //全てのスコア(問題数分)に対してヒートマップのピクセルデータを作成
            for (Integer score : totalScore) {
                //ヒートマップのピクセルデータを描画
                drawImage(image, studentNum, question, score, scale);
                //次の問題番号に進む
                question++;
            }
            //次の生徒に進む
            studentNum++;
        }
    }

    //ヒートマップのピクセルデータを描画(15行)
    public void drawImage(BufferedImage image, int x, int y, int score, int scale) throws IOException {
        //デフォルトの色を白に設定
        int rgb = 16777215;
        //スコアが無効でない場合
        if (score != -1) {
            //最大スコアが0でない場合
            if (this.getMaxScore(scoreList, y + 1) != 0) {
                //スコアを最大スコアで割り、点数の取得率を計算
                double grade = ((double) score / (double) this.getMaxScore(scoreList, y + 1));
                //取得率を255倍してRGB値（青）を取得
                rgb = (int) Math.floor(grade * 255);
            } else {
                //最大スコアが0の場合はRGB値を0（黒）に設定
                rgb = 0;
            }
        }
        //スケール分だけピクセルを描画
        for (int i = x * scale; i < (x + 1) * scale; i++) {
            for (int j = y * scale; j < (y + 1) * scale; j++) {
                image.setRGB(i, j, rgb);
            }
        }
        //ヒートマップを画像として出力
        ImageIO.write(image, "png", new File("heatmap.png"));
    }


    //総合個人成績のリストを取得(６行)
    public List<Integer> getPersonalData(Integer studentID, HashMap<Integer, PersonalDataSet> personalMap) {
        //学籍番号に対応するPersonalDataSetをpersonalMapから取得
        PersonalDataSet personalDataSet = personalMap.get(studentID);
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

}
