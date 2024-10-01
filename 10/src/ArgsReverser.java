public class ArgsReverser {
    void run(String[] args) {
        for(Integer i = 0; i < args.length; i ++){
            System.out.printf("%s, ", args[i]);
            printReverse(args[i]);
            System.out.println();
        }
    }

    void printReverse(String arg) {
        for(Integer i = arg.length() - 1; i > -1; i --){
            System.out.printf("%c", arg.charAt(i));
        }
    }

    public static void main(String[] args) {
        ArgsReverser argsReverser = new ArgsReverser();
        argsReverser.run(args);
    }
}