// 第９講 Map（連想配列）サンプルプログラム
// https://ksuap.github.io/2022autumn/lesson09/map/#サンプルプログラム
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    void run(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String arg : args) {
            this.putValueToMap(map, arg);
        }
        this.printMap(map);
    }

    void putValueToMap(HashMap<String, Integer> map,
            String string) {
        // , で文字列を区切っている．
        String[] items = string.split(",");
        Integer value = Integer.valueOf(items[1]);
        map.put(items[0], value);
    }

    void printMap(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d%n",
                    entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        HashMapExample app = new HashMapExample();
        app.run(args);
    }
}
