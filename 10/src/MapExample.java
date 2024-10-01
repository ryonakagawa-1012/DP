/**
 * 以下のプログラムを実行する時に，次のファイル（grades.csv）をコマンドライン引数で渡した時
に，次の問に答えよ．
 *
 * grades.csv
 * ----------
 *
 * 010734,33
 * 195361,51
 * 218341,84
 * 282600,74
 * 304480,67
 * 343347,38
 * 381178,60
 * 404199,91
 * 434101,89
 * 435425,58
 * 480672,63
 * 493133,94
 * 506353,61
 * 517500,74
 * 604458,84
 * 617098,42
 * 621582,92
 * 635421,80
 * 649934,83
 * 679586,50
 * 691200,52
 * 697535,74
 * 771101,71
 * 780951,20
 * 800156,38
 * 825914,91
 * 827401,80
 * 900901,76
 * 903350,85
 * 923048,84
 * 950511,93
 * 966647,70
 *
 * 出力結果
 * -------
 *
 * 統計: 20, 94, average: 68.813
 * 秀: 5
 * 優: 8
 * 不可: 9
 * 良: 6
 * 可: 4
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class MapExample{
 void run(String gradeFile) throws IOException{
 HashMap<String, Integer> map = new HashMap<>();
 BufferedReader in = new BufferedReader(new FileReader(gradeFile));
 String line;
 Integer value1 = Integer.MAX_VALUE;
 Integer value2 = 0;
 Integer sum = 0;
 Integer count = 0;
 while((line = in.readLine()) != null){
 String[] items = line.split(",");
 Integer grade = parseAndPutGrade(map, items[1]);
 sum += grade; // (1)
 if(value1 > grade) value1 = grade; // (2)
 if(value2 < grade) value2 = grade; // (3)
 count++; // (4)
 }
 Double value3 = 1.0 * sum / count; // (5)
 this.printResult(map, value1, value2, value3);
 }
 void printResult(HashMap<String, Integer> map, Integer value1,
 Integer value2, Double value3){
 System.out.printf("統計: %d, %d, average: %2.3f%n", value1, value2,
value3);
 for(Map.Entry<String, Integer> entry: map.entrySet()){
 System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
 }
 }
 Integer parseAndPutGrade(HashMap<String, Integer> map, String
gradeString){
 Integer grade = new Integer(gradeString); // (6)
 if(grade < 60)
 map.put("不可", map.getOrDefault("不可", 0) + 1); // (5-1)
 else if(grade >= 60 && grade < 70)
 map.put("可", map.getOrDefault("可", 0) + 1); // (5-2)
 else if(grade >= 70 && grade < 80)
 map.put("良", map.getOrDefault("良", 0) + 1); // (5-3)
 else if(grade >= 80 && grade < 90)
 map.put("優", map.getOrDefault("優", 0) + 1); // (5-4)
 else if(grade >= 90)
 map.put("秀", map.getOrDefault("秀", 0) + 1); // (5-5)
 return grade;
 }

 public static void main(String[] args) throws IOException{
 MapExample example = new MapExample();
 example.run(args[0]);
 }
}