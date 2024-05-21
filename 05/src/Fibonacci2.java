public class Fibonacci2 {
    void run(String[] args){
        Integer max_limit = args.length != 0 ? Integer.parseInt(args[0]) : 10;
        System.out.printf("fibonacci(%d) = %d\n", max_limit, calc(max_limit, 0, 1));
    }

    Integer calc(Integer count, Integer a, Integer b){
        if (count == 0){
            return a;
        }
        return calc(count - 1, b, a + b);
    }

    public static void main(String[] args){
        Fibonacci2 application = new Fibonacci2();
        application.run(args);
    }
}
