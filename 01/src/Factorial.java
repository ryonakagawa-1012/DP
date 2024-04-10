public class Factorial {
    void run(String[] args){
        if (args.length == 0){

        }
        else {
            Integer number = Integer.valueOf(args[0]);
            Integer factorial = 1;

            for (Integer i = 1; i <= number; i++){
                factorial *= i;
            }

            System.out.printf("%d! = %d%n", number, factorial);
        }
    }

    public static void main(String[] args){
        Factorial application = new Factorial();
        application.run(args);
    }
}
