import java.util.Arrays;
import java.util.Objects;

public class Echo {
    void run(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("-h")){
                System.out.println("Usage: java Echo [OPTIONS] <string...>");
                System.out.println("OPTIONS");
                System.out.println("    -h: このメッセージを表示して終了する．");
                System.out.println("    -n: 改行せずに出力する．");
            } else if (args[0].equals("-n")) {
                echo_n(Arrays.copyOfRange(args, 1, args.length));
            } else {
                echo(args);
            }
        }
    }

    void echo(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    void echo_n(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        new Echo().run(args);
    }
}
