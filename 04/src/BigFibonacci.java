public class BigFibonacci {
    void run(String[] args) {
        if (args.length > 1) {
            for (String arg : args) {
                System.out.println(fib(Integer.parseInt(arg)));
            }
        }
        else {
            System.out.println(fib(10));
        }

    }

    Long fib(Integer n) {
        Long a = 0L;
        Long b = 1L;
        for (int i = 0; i < n; i++) {
            Long tmp = a;
            a = b;
            b = tmp + b;
        }
        return a;
    }

    public static void main(String[] args) {
        new BigFibonacci().run(args);
    }
}
