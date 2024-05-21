
public class MersenneNumbers {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Integer型でメルセンヌ数を求める");
        for (int i = 1; i <= n; i++) {
            int mersenne = powerOfTwo(i) - 1;
            System.out.println(i + "番目のメルセンヌ数: " + mersenne);
        }

        System.out.println("\nBigInteger型でメルセンヌ数を求める");
        for (int i = 1; i <= n; i++) {
            BigInteger result = mersenne(i);
            System.out.print(i + "番目のメルセンヌ数: " + result);
            if (result.isProbablePrime(n)) {
                System.out.print(" prime");
            }
            System.out.println();
        }
    }

    public static int powerOfTwo(int n) {
        return 1 << n;
    }

    public static BigInteger mersenne(int n) {
        return BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
    }
}
