//学籍番号:2354233
//氏名：蓮見考紘

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileContents {


    //ファイルを読み込み各行をPersonalDataクラスに変換してリストに格納する。question（問題番号）がnullでない場合は、questionが一致する行のみをリストに格納する(16行)
    public static List<PersonalData>  readDataFromFile(String fileName, Integer question) throws IOException {
        final List<PersonalData> scoreList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            List<String> parts = new ArrayList<>(List.of(line.split(",")));
            //parts.get(2)は問題番号
            if(question!= null  && !Objects.equals(parts.get(2), question.toString()) ) {
                line = reader.readLine();
                continue;
            }
            //無効データ(null)のエラー対策
            fixData(parts);
            //行のデータをインスタンス化
            PersonalData personalData = new PersonalData(Integer.valueOf(parts.get(0)), Integer.valueOf(parts.get(2)), Integer.valueOf(parts.get(3)), Integer.valueOf(parts.get(4)), parts.get(5) +","+ parts.get(6));
            scoreList.add(personalData);
            line = reader.readLine();
        }
        reader.close();
        return scoreList;
    }

    //エラー対策(5行)
    private static void fixData(List<String> parts) {
        //エラー対策
        //日付はint型で格納するため、/を削除
        parts.set(0, parts.get(0).replace("/", ""));
        //問題未回答の場合はスコアを-1とする
        if(Objects.equals(parts.get(4), "")) {
            parts.set(4, "-1");
            //終了時間も記録がないため0としてリストに追加
            parts.add("-1");
        }
    }
}
