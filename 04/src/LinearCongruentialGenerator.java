import java.util.ArrayList;

public class LinearCongruentialGenerator {
    void run(String[] args){
        Integer num = 10;
        if (args.length > 0) {
            num = Integer.parseInt(args[0]);
        }
        Integer A_YourBirthDay = 1012;
        Integer B = 1;
        Integer M = 65535;

        ArrayList<Double> randomNumbers = new ArrayList<Double>();

        randomNumbers = generateRandomNumbers(num, A_YourBirthDay, B, M);

        System.out.println(randomNumbers);

    }

    ArrayList<Double> generateRandomNumbers(Integer num, Integer A, Integer B, Integer M){
        ArrayList<Double> randomNumbers = new ArrayList<Double>();
        Integer X = 1;
        for (int i = 0; i < num; i++) {
            X = (A * X + B) % M;
            randomNumbers.add((double)X / M);
        }
        return randomNumbers;
    }



    public static void main(String[] args) {
        LinearCongruentialGenerator application = new LinearCongruentialGenerator();
        application.run(args);
    }
}
