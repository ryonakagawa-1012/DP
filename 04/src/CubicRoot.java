public class CubicRoot {
    void run(String[] args){
        for (String arg : args) {
            double x = Double.parseDouble(arg);
            double y = NewtonCubic(x);
            System.out.printf("cbrt(%f) = %f\n", x, y);
        }
    }

    Double NewtonCubic (double x){
        double y = x;
        double y0 = 0;
        while (Math.abs(y - y0) > 1.0e-15){
            y0 = y;
            y = y - (y*y*y - x) / (3*y*y);
        }
        return y;
    }

    public static void main(String[] args){
        CubicRoot app = new CubicRoot();
        app.run(args);
    }
}
