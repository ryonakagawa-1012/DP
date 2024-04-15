import java.util.ArrayList;

public class Primes {
    void run(String[] args) {
        Integer num = args.length != 0 ? Integer.parseInt(args[0]) : 200;
        ArrayList<Integer> prime = generatePrimes(num);

        for (int i = 0; i < prime.size(); i++){
            if (i != 0 && i % 10 == 0) System.out.println();
            System.out.printf("%3d ", prime.get(i));
        }
    }


    ArrayList<Integer> generatePrimes(Integer num){
        boolean[] prime = new boolean[num+1];
        for(int i=2;i<=num;i++) {
            prime[i] = true;
        }

        for(int p = 2; p*p <=num; p++){
            if(prime[p]){
                for(int i = p*p; i <= num; i += p)
                    prime[i] = false;
            }
        }

        ArrayList<Integer> prime_list = new ArrayList<>();

        for (int i = 0; i < prime.length; i++){
            if (prime[i]) prime_list.add(i);
        }

        return prime_list;
    }



    public static void main(String[] args){
        Primes application = new Primes();
        application.run(args);
    }
}
