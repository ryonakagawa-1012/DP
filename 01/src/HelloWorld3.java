import java.util.Objects;

public class HelloWorld3 {
    void run(String[] args){
        if (args.length == 0){
            System.out.println("Hello, World\n");
        }
        else if (Objects.equals(args[0], "World")){
            System.out.println("Hi, World\n");
        }
        else{
            System.out.printf("Hello, %s\n", args[0]);
        }
    }
    
    public static void main(String[] args){
        HelloWorld3 application = new HelloWorld3();
        application.run(args);
    }
}
