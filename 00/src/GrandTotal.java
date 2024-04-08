public class GrandTotal {
    public static void main (String[] args){
        Integer result = 0;
        Integer max_range = 10;

        for (Integer i = 1; i <= max_range; i++){
            result += i;
        }
        System.out.printf("1から%dまでの総和は%dです.%n", max_range, result);
    }
}
