public class Complex{
    Double real;
    Double imag;

    void print(){
        System.out.printf("%5.2f + %5.2f i", this.real, this.imag);
    }

    void println(){
        this.print();
        System.out.println();
    }

    public String toString(){
        return String.format("%5.2f + %5.2f i", this.real, this.imag);
    }

    Double absolute(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    Complex conjugate(){
        Complex complex = new Complex();
        complex.real = this.real;
        complex.imag = this.imag * -1;
        return complex;
    }

    Complex add(Complex value){
        // this + value の結果を返す．
        Complex ans = new Complex();
        ans.real = this.real + value.real;
        ans.imag = this.imag + value.imag;
        return ans;
    }

    Complex subtract(Complex value){
        // this - value の結果を返す．
        Complex ans = new Complex();
        ans.real = this.real - value.real;
        ans.imag = this.imag - value.imag;
        return ans;
    }

    Complex multiply(Complex value){
        // this * value の結果を返す．
        Complex ans = new Complex();
        ans.real = (this.real * value.real) - (this.imag * value.imag);
        ans.imag = (this.real * value.imag) + (this.imag * value.real);
        return ans;
    }

    Complex divide(Complex value){
        // this / value の結果を返す．
        Complex ans = new Complex();
        Double denominator = Math.pow(value.real, 2) + Math.pow(value.imag, 2);
        ans.real = ((this.real * value.real) + (this.imag * value.imag)) / denominator;
        ans.imag = ((this.imag * value.real) - (this.real * value.imag)) / denominator;
        return ans;
    }
}