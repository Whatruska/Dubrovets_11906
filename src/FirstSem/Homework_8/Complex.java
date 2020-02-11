package FirstSem.Homework_8;

import java.util.Scanner;

public class Complex {
    static Scanner scanner = new Scanner(System.in);

    public static double[] readComplex(){
        double realPart = scanner.nextDouble();
        double mnemoPart = scanner.nextDouble();
        return formComplex(realPart, mnemoPart);
    }

    public static double[] formComplex(double realPart, double mnemoPart){
        double[] result = new double[2];
        setRealPart(result, realPart);
        setMnemoPart(result, mnemoPart);
        return result;
    }
    public static double getRealPart(double[] complex){
        return complex[0];
    }

    public static double getMnemoPart(double[] complex){
        return complex[1];
    }

    public static void setRealPart(double[] complex, double real){
        complex[0] = real;
    }

    public static void setMnemoPart(double[] complex, double mnemo){
        complex[1] = mnemo;
    }

    public static void writeComplex(double[] complex){
        System.out.println(getRealPart(complex) + " " + getMnemoPart(complex) + "i");
    }

    public static double[] addComplex(double[] complex1, double[] complex2){
        setRealPart(complex1, getRealPart(complex1) + getRealPart(complex2));
        setMnemoPart(complex1, getMnemoPart(complex1) + getMnemoPart(complex2));
        return complex1;
    }

    public static double[] subComplex(double[] complex1, double[] complex2){
        complex2 = multiplyToNum(complex2, -1);
        return addComplex(complex1, complex2);
    }

    public static double[] multiplyToNum(double[] complex, double num){
        setRealPart(complex,getRealPart(complex) * num);
        setMnemoPart(complex,getMnemoPart(complex) * num);
        return complex;
    }

    public static double[] divigeToNum(double[] complex, double num){
        return multiplyToNum(complex, 1/num);
    }

    public static double[] getConjugated(double[] complex){
        setMnemoPart(complex, getMnemoPart(complex) * -1);
        return complex;
    }

    public static double[] multiply(double[] complex1, double[] complex2){
        double a = getRealPart(complex1);
        double b = getMnemoPart(complex1);
        double c = getRealPart(complex2);
        double d = getMnemoPart(complex2);
        return formComplex((a * c) - (b * d),(a * d) + (c * b));
    }

    public static double[] divide(double[] complex1, double[] complex2){
        double c = getRealPart(complex2);
        double d = getMnemoPart(complex2);
        return divigeToNum(
               multiply(complex1, getConjugated(complex2)) , (c * c + d * d)
        );
    }

    public static double getArgument(double[] complex){
        return Math.atan2(getRealPart(complex), getMnemoPart(complex));
    }

    public static void setArgument(double[] complex, double arg){
        double modulus = getModulus(complex);
        setRealPart(complex,modulus * Math.cos(arg));
        setMnemoPart(complex,modulus * Math.sin(arg));
    }

    public static double getModulus(double[] complex){
        double realPart = getRealPart(complex);
        double mnemoPart = getMnemoPart(complex);
        return Math.sqrt(realPart * realPart + mnemoPart * mnemoPart);
    }

    public static void setModulus(double[] complex, double modulus){
        double arg = getArgument(complex);
        setRealPart(complex,modulus * Math.cos(arg));
        setMnemoPart(complex,modulus * Math.sin(arg));
    }

    public static double[] pow(double[] complex, int n){
        double modulus = Math.pow(getModulus(complex), n);
        setArgument(complex, getArgument(complex) * n);
        return multiplyToNum(complex, modulus);
    }

    public static void main(String[] args) {
        double[] a = readComplex();
        double[] b = readComplex();
        double[] c = readComplex();
        double[] d = readComplex();
        double[] e = readComplex();

        double[] f = addComplex(a,b);
        f = pow(f, 5);
        f = multiplyToNum(f, 5);
        f = addComplex(f,e);

        double[] second = addComplex(c,d);
        second = pow(second, 3);
        second = multiply(f, a);
        second = multiply(second, pow(subComplex(d,e), 2));

        f = subComplex(f, second);
        writeComplex(f);
    }
}
