import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;


public class Factorizer {
    void run(String[] args){
        if (args.length != 0){
            for (String item: args){
                Integer num = Integer.valueOf(item);
                PrintFactorizer(num);
            }
        }
    }

    void PrintFactorizer(Integer num){
        System.out.printf("%d: ", num);

        Primes primes = new Primes();
        ArrayList<Integer> prime_list = primes.generatePrimes(num);

        TreeMap<Integer,Integer> FactorizeDict= new TreeMap<>();

        for (Integer key: prime_list){
            while (num % key == 0){
                num /= key;
                if (FactorizeDict.containsKey(key)){
                    FactorizeDict.put(key, FactorizeDict.get(key) + 1);
                } else {
                    FactorizeDict.put(key, 1);
                }
            }
        }

        for (Integer key: FactorizeDict.keySet()){
            for (int i = 0; i < FactorizeDict.get(key); i++){
                System.out.printf("%d ", key);
                if (Objects.equals(key, FactorizeDict.lastKey()) && i == FactorizeDict.get(key) - 1){
                    System.out.println();
                }
                else {
                    System.out.print("x ");
                }
            }
        }
    }

    public static void main(String[] args){
        Factorizer application = new Factorizer();
        application.run(args);
    }
}
