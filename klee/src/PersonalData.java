//学籍番号:2354233
//氏名：蓮見考紘

import java.util.Objects;

public class PersonalData {
    //日付,問題番号,学籍番号,点数,開始時間及び終了時間
    //フィールド変数の上限対策でfile名を省略し時間はString型で開始と終了を合わせて格納
    Integer date;
    Integer question;
    Integer studentID;
    Integer score;
    String time;

    //コンストラクタ
    public PersonalData(Integer date, Integer question, Integer studentID, Integer score, String time) {
        this.date = date;
        this.question = question;
        this.studentID = studentID;
        this.score = score;
        this.time = time;
    }


    //string型の時間をint型の分に変換(13行)
    public Integer getTime() {
        //start時刻からend時刻までの時間を返す
        //開始時間と終了時間に分割
        String[] str = time.split(",");
        //開始時間を時間と分に分割
        String[] start = str[0].split(":");
        //終了時間を時間と分に分割
        String[] end = str[1].split(":");
        //終了時間が-1(無効)の場合は-1(無効値)を返す
        if(Objects.equals(end[0], "-1") || Objects.equals(end[1], "-1")){
            return -1;
        }
        //時間の差を計算
        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int minute = Integer.parseInt(end[1])- Integer.parseInt(start[1]);
        if ( Integer.parseInt(end[1]) - Integer.parseInt(start[1])< 0) {
            hour--;
            minute += 60;
        }
        //分で返す
        return hour*60 + minute;
    }


}
