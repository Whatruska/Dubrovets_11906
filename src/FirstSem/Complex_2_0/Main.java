package FirstSem.Complex_2_0;

public class Main {
    public static void main(String[] args) {
        ComplexNumber a = ComplexNumber.readComplex();
        ComplexNumber b = ComplexNumber.readComplex();
        ComplexNumber c = ComplexNumber.readComplex();
        ComplexNumber d = ComplexNumber.readComplex();
        ComplexNumber e = ComplexNumber.readComplex();

        ComplexNumber f = new ComplexNumber(a);
        f.addComplex(b);
        f.pow(5);
        f.multiplyToNum(5);
        f.addComplex(e);

        ComplexNumber second = new ComplexNumber(c);
        second.addComplex(d);
        second.pow(3);

        f.multiply(a);

        ComplexNumber third = new ComplexNumber(d);
        third.subComplex(e);
        third.pow(2);

        second.multiply(third);

        f.subComplex(second);

        f.writeComplex();
    }
}
