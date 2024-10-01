// 学生番号:2354017
// 氏名:中川諒

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ScoreAnalyzer2 {
    void run(String[] args) throws IOException {
        File file = new File(args[0]);
        Analyzer(file);
    }

    void Analyzer(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line;
        Integer count = 0;
        TreeMap<Integer, TreeMap<Integer, Integer>> score_count = new TreeMap<>(); // {問題番号:{スコア:人数}}
        TreeSet<Integer> score_lst = new TreeSet<>();

        while ((line = in.readLine()) != null) {
            String[] data = line.split(",");
            Integer kadai_num = Integer.valueOf(data[2]);
            Integer score = Integer.valueOf(data[4]);
            score_lst.add(score);
            if (!score_count.containsKey(kadai_num)) {
                score_count.put(kadai_num, new TreeMap<>());
            }
            score_count.get(kadai_num).put(score, score_count.get(kadai_num).getOrDefault(score, 0) + 1); // {問題番号:{スコア:人数}}
        }
        in.close();
        Wright_Analyze_result(score_count, score_lst);
    }

    void Wright_Analyze_result(TreeMap<Integer, TreeMap<Integer, Integer>> score_count, TreeSet<Integer> score_lst) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("output.csv"))) {
            out.write(",");
            for (Integer score : score_lst) {
                out.write(score + ",");
            }
            out.newLine();
            for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : score_count.entrySet()) {
                Integer kadai_num = entry.getKey();
                TreeMap<Integer, Integer> scores = entry.getValue();
                int total = scores.values().stream().mapToInt(Integer::intValue).sum();
                out.write(kadai_num + ",");
                for (Integer score : score_lst) {
                    double percentage = scores.containsKey(score) ? (double) scores.get(score) / total * 100 : 0;
                    out.write(scores.containsKey(score) ? String.format("%.3f", percentage) + "," : ",");
                }
                out.newLine();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ScoreAnalyzer2 app = new ScoreAnalyzer2();
        app.run(args);
    }
}