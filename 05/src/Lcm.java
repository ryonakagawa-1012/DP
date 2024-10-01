import com.sun.jdi.IntegerValue;

public class Lcm {
    void run(String[] args) {
        if (args.length < 2) return;

        System.out.print("Lmc(");
        System.out.printf(String.join(", ", args));
        System.out.printf(")=%d%n", lcmAll(args, 0));
    }

    Integer lcm(Integer a, Integer b) {
        return a * b / gcd(a, b);
    }

    Integer lcmAll(String[] args, int index) {
        if (index == args.length - 1) {
            return Integer.parseInt(args[index]);
        }
        return lcm(Integer.parseInt(args[index]), lcmAll(args, index + 1));
    }

    Integer gcd(Integer x, Integer y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public static void main(String[] args){
        Lcm app = new Lcm();
        app.run(args);
    }

}
