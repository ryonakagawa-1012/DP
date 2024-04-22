public class MaxMinAverage {
    void run(String [] args) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (String arg : args) {
            int num = Integer.parseInt(arg);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            sum += num;
        }
        System.out.printf("Values: %s\n", String.join(" ", args));
        System.out.printf("max: %d, min: %d, average: %f\n", max, min, (double)sum / args.length);
    }

    public static void main(String [] args) {
        MaxMinAverage app = new MaxMinAverage();
        app.run(args);
    }
}
