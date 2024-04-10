public class FizzBuzz {
    void run(String[] args){
        Integer max_limit = 15;

        if (args.length != 0){
            max_limit = Integer.valueOf(args[0]);
        }

        for (Integer i = 1; i <= max_limit; i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0){
                System.out.println("Fizz");
            }
            else if (i % 5 == 0){
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args){
        FizzBuzz application = new FizzBuzz();
        application.run(args);
    }
}
