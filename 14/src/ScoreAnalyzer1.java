// 学生番号:2354017
// 氏名:中川諒


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeMap;

public class ScoreAnalyzer1 {
    void run(String[] args) throws IOException {
        String target_kadai_num = args[0];
        File file = new File(args[1]);

        Analyzer(target_kadai_num, file);
    }

    void Analyzer(String target_kadai_num, File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line;
        Integer count = 0;
        TreeMap<String, Integer> score_count = new TreeMap<>();

        while ((line = in.readLine()) != null) {
            String[] data = line.split(",");
            String kadai_num = data[2];
            String score = data[4];
            if (Objects.equals(kadai_num, target_kadai_num)) {
                score_count.put(score, score_count.getOrDefault(score, 0) + 1);
                count++;
            }
        }
        in.close();
        Print_Analyze_result(score_count, count);
    }

    void Print_Analyze_result(TreeMap<String, Integer> score_count, Integer count) {
        for (String key : score_count.keySet()) {
            System.out.println(String.format("%2s: %6.3f (%3d/%d)", key, (double) score_count.get(key) / count * 100, score_count.get(key), count));
        }
    }

    public static void main(String[] args) throws IOException {
        ScoreAnalyzer1 app = new ScoreAnalyzer1();
        app.run(args);
    }
}
