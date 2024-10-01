import java.util.Objects;

public class Combination {
    void run(String[] args){
        if (args.length != 2){
            System.out.println("java Combination n k");
            return;
        }

        Integer n = Integer.parseInt(args[0]);
        Integer k = Integer.parseInt(args[1]);

        System.out.printf("%dC%d = %d", n, k, combination(n, k));
    }

    Integer combination(Integer n, Integer k){
        if (k == 0 || Objects.equals(n, k)){
            return 1;
        }

        return combination(n-1, k-1) + combination(n-1, k);
    }

    public static void main(String[] args){
        Combination app = new Combination();
        app.run(args);
    }
}
