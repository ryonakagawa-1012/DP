// 第９講 Map（連想配列）例題1 お弁当の料金表
// https://ksuap.github.io/2022autumn/lesson09/map/#例題-1-お弁当の料金表
import java.util.HashMap;

public class LunchBoxPrices {
    HashMap<String, Integer> prices;

    void run(String[] args) {
        this.initialize();
        for (String arg : args) {
            this.searchAndPrint(arg);
        }
    }

    void searchAndPrint(String lunchBoxName) {
        // お弁当の料金を検索する．
        Integer price = this.prices.get(lunchBoxName);
        if (price == null) { // お弁当が見つからなかった．
            // ここに見つからなかった旨を出力する処理を書く．
            System.out.printf("%s: 見つかりませんでした%n", lunchBoxName);
        } else {
            // お弁当の料金を出力する．
            System.out.printf("%s: %d円%n", lunchBoxName, price);
        }
    }

    void initialize() { // お弁当の料金表を作成するメソッド．
        this.prices = new HashMap<>();
        prices.put("日の丸弁当", 200);
        // 他のお弁当の料金も追加する（10個程度）．
        prices.put("のり弁当", 350);
        prices.put("幕ノ内弁当", 400);
        prices.put("ステーキ弁当", 800);
        prices.put("ハンバーグ弁当", 550);
        prices.put("唐揚げ弁当", 450);
        prices.put("サービス弁当", 350);
        prices.put("おにぎり弁当", 250);
        prices.put("上幕ノ内弁当", 800);
        prices.put("サンドウィッチ弁当", 400);
    }

    public static void main(String[] args) {
        LunchBoxPrices lbp = new LunchBoxPrices();
        lbp.run(args);
    }
}
