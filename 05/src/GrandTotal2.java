public class GrandTotal2 {
    void run(String[] args){
        Integer max_range = Integer.parseInt(args[0]);
        System.out.printf("1から%dまでの総和は%dです.%n", max_range, calc(max_range, max_range));
    }

    Integer calc(Integer num, Integer count){
        count -= 1;
        if (count == 1){
            return num + 1;
        }
        return calc(num+count, count);
    }

    public static void main(String[] args){
        GrandTotal2 gt = new GrandTotal2();
        gt.run(args);
    }
}
