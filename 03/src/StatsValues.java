import java.util.ArrayList;
import java.util.Random;

public class StatsValues {
    void run(){
        Random random = new Random();

        ArrayList<Integer> random_list = new ArrayList<>();

        int sun = 0;
        float max = Float.NEGATIVE_INFINITY;
        float min = Float.POSITIVE_INFINITY;
        for (int i = 0; i < 100; i++){
            int item = random.nextInt(1000);
            random_list.add(item);
            sun += item;
            max = Math.max(item, max);
            min = Math.min(item, min);
        }

        System.out.printf("合計: %d, 最大値: %d, 最小値: %d, 平均値: %f", sun, (int) max, (int) min, sun/100.0);
        for (int i = 0; i < 100; i++){
            System.out.printf("%d ", random_list.get(i));
            if (i % 9 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        StatsValues application = new StatsValues();
        application.run();
    }
}
