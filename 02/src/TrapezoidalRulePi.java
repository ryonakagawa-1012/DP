import org.xml.sax.ext.DefaultHandler2;

public class TrapezoidalRulePi {
    void run(String[] args) {
        Double width = 0.0001;

        if (args.length != 0){
            width = Double.parseDouble(args[0]);
        }

//        System.out.print((int) (1/width));

        Double x1 = (double) 0;
        Double x2 = width;
        Double h1 = calc_height(x1);
        Double h2 = calc_height(x2);
        Double area_sum = calc_area(x2, x1, h2, h1);
//        System.out.printf("%f, %f, %f, %f\n", x1,x2, h1, h2);
//        System.out.println(area_sum);
        for (Integer i = 0; i < (int) (1.0/width) - 1; i++){
            x1 += width;
            x2 += width;
            h1 = calc_height(x1);
            h2 = calc_height(x2);
            area_sum += calc_area(x2, x1, h2, h1);
/*
            System.out.println(i);
            System.out.printf("%f, %f, %f, %f\n", x1,x2, h1, h2);
            System.out.println(area_sum);
*/
        }

        System.out.printf("pi = %f", area_sum*4.0);

    }

    Double calc_height(Double x){
        return Math.sqrt(1-(x*x));
    }

    Double calc_area(Double x2, Double x1, Double h2, Double h1){
        return ((x2 - x1) * (h2 + h1)) / 2;
    }

    public static void main(String[] args) {
        TrapezoidalRulePi application = new TrapezoidalRulePi();
        application.run(args);
    }
}
