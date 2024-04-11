public class QuadraticEquation {
    void run(String[] args){
        Double a = convertToDouble(args[0]);
        Double b = convertToDouble(args[1]);
        Double c = convertToDouble(args[2]);
        Double d = discriminant(a, b, c); // 判別式によりDの値を求める．
        solve(a, b, c, d); // 判別式から実数解，重解，虚数解に場合分けして結果を出力する．
    }

    Double convertToDouble(String str){
        return Double.parseDouble(str);
    }

    Double discriminant(Double a, Double b, Double c){
        return b * b - 4 * a * c;
    }

    void solve(Double a, Double b, Double c, Double d){
        if(d > 0){
            System.out.print("answer =．");
            System.out.printf("%g, ", (-b + Math.sqrt(d)) / (2 * a));
            System.out.printf("%g\n", (-b - Math.sqrt(d)) / (2 * a));
        }else if(d == 0){
            System.out.print("answer = ");
            System.out.printf("%g\n", -b / (2 * a));
        }else{
            System.out.print("answer = ");
            System.out.printf("%g + %g i, ", -b / (2 * a), Math.sqrt(-d) / (2 * a));
            System.out.printf("%g - %g i\n", -b / (2 * a), Math.sqrt(-d) / (2 * a));
        }
    }

    public static void main(String[] args){
        QuadraticEquation application = new QuadraticEquation();
        application.run(args);
    }
}
