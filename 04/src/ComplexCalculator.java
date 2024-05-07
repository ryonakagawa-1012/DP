public class ComplexCalculator{
    void run(){
        Complex c1 = this.createComplex(5.0, -6.0);
        Complex c2 = this.createComplex(3.0, 2.0);

        System.out.printf("absoluate(%s) = %f%n", c1, c1.absolute());
        System.out.printf("conjugate(%s) = %s%n", c1, c1.conjugate());
        System.out.printf("%s + %s = %s%n", c1, c2, c1.add(c2));
        System.out.printf("%s - %s = %s%n", c1, c2, c1.subtract(c2));
        System.out.printf("%s * %s = %s%n", c1, c2, c1.multiply(c2));
        System.out.printf("%s / %s = %s%n", c1, c2, c1.divide(c2));
    }

    Complex createComplex(Double realValue, Double imagValue){
        Complex c = new Complex();
        c.real = realValue;
        c.imag = imagValue;
        return c;
    }

    public static void main(String args[]){
        ComplexCalculator cc = new ComplexCalculator();
        cc.run();
    }
}