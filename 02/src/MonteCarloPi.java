public class MonteCarloPi {
    void run(String[] args) {
        int n = 1000;
        if (args.length != 0) {
            n = Integer.parseInt(args[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y < 1) {
                count++;
            }
        }
        System.out.printf("pi = %g\n", 4.0 * count / n);
    }

    public static void main(String[] args) {
        MonteCarloPi application = new MonteCarloPi();
        application.run(args);
    }
}
