public class HelloWorld2 {
    void run(String[] args){
        if (args.length == 0){
            System.out.println("Hello, World");
        }
        else {
            System.out.printf("Hello, %s", args[0]);
        }
    }
    public static void main(String[] args){
        HelloWorld2 application = new HelloWorld2();
        application.run(args);
    }
}
