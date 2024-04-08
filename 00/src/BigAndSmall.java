public class BigAndSmall{
    public static void main(String[] args){
        Double value = Math.random();
        // valueには0から1の乱数が代入されている．
        System.out.printf("value: %f: ", value);

        // ここに判定のプログラムを書いていく．
        if (value < 0.5) {
            System.out.println("Small");
        } else {
            System.out.println("Big");
        }
    }
}