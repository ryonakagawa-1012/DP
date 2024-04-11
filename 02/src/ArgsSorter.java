
import java.util.Arrays;

public class ArgsSorter {
    void run(String[] args){
        // beforeを表示
        System.out.print("before: ");
        this.printArray(args);

        Arrays.sort(args);

        //afterを表示
        System.out.print("after: ");
        this.printArray(args);
    }

    void printArray(String[] args){
        for (Integer i = 0; i < args.length; i++){
            System.out.printf("%s, ", args[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        ArgsSorter application = new ArgsSorter();
        application.run(args);
    }
}
