import java.util.ArrayDeque;
import java.util.Deque;

public class Fibonacci {
    void run(String[] args){
        Integer max_limit = 20;

        if (args.length != 0){
            max_limit = Integer.valueOf(args[0]);
        }

        Deque<Integer> deque = new ArrayDeque<>(2);

        Integer ans = 1;
        for (Integer i = 0; i < max_limit; i++){
            if (i == 0 | i == 1){
                deque.add(1);
            }
            else {
                ans += deque.removeFirst();
                deque.add(ans);
            }
            System.out.println(ans);
        }
    }
    public static void main(String[] args){
        Fibonacci application = new Fibonacci();
        application.run(args);
    }
}
