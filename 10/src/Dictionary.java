import java.util.HashMap;

public class Dictionary {
    HashMap<String, String> dic = new HashMap<>();

    void run(String[] args) {
        initialize();

        for(String arg: args){
            searchAndPrint(arg);
        }
    }

    void searchAndPrint(String arg) {
        System.out.println(arg + ": " + dic.getOrDefault(arg, "見つかりませんでした"));
    }

    void initialize() {
        this.dic.put("apple", "りんご");
        this.dic.put("chair", "椅子");
        this.dic.put("desk", "机");
        this.dic.put("get", "得る");
        this.dic.put("joke", "冗談");
        this.dic.put("minute", "分");
        this.dic.put("read", "読む");
        this.dic.put("take", "取る");
        this.dic.put("sun", "太陽");
        this.dic.put("watch", "腕時計, 懐中時計");
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.run(args);
    }
}