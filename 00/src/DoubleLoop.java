public class DoubleLoop{
    public static void main(String[] args){
        for(Integer i = 0; i <= 4; i += 2){ // (1)
            for(Integer j = 0; j < 3; j++){ // (2)
            if(i != j){ // (3)
                System.out.printf("%d, %d%n", i, j); // (4)
            }
            }
        }

    }
}