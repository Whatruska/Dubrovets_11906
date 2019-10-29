package Homework_8;

public class Complex {

    private static double[] formComplex(double realPart, double mnemoPart){
        double[] result = new double[2];
        setRealPart(result, realPart);
        setMnemoPart(result, mnemoPart);
        return result;
    }

    private static double getRealPart(double[] a){
        return a[0];
    }

    private static double getMnemoPart(double[] a){
        return a[1];
    }

    private static void setRealPart(double[] a, double real){
        a[0] = real;
    }

    private static void setMnemoPart(double[] a, double mnemo){
        a[1] = mnemo;
    }

    private static void writeComplex(double[] complex){
        System.out.println(getRealPart(complex) + " " + getMnemoPart(complex) + "i");
    }

    private static double[] addComplex(double[] complex1, double[] complex2){
        setRealPart(complex1, getRealPart(complex1) + getRealPart(complex2));
        setMnemoPart(complex1, getMnemoPart(complex1) + getMnemoPart(complex2));
        return complex1;
    }

    private static double[] subComplex(double[] complex1, double[] complex2){
        complex2 = multiplyToNum(complex2, -1);
        return addComplex(complex1, complex2);
    }

    private static double[] multiplyToNum(double[] complex, double num){
        setRealPart(complex,getRealPart(complex) * num);
        setMnemoPart(complex,getMnemoPart(complex) * num);
        return complex;
    }

    private static double[] divigeToNum(double[] complex, double num){
        return multiplyToNum(complex, 1/num);
    }

    private static double[] getConjugated(double[] complex){
        setMnemoPart(complex, getMnemoPart(complex) * -1);
        return complex;
    }

    private static double[] multiply(double[] complex1, double[] complex2){
        double a = getRealPart(complex1);
        double b = getMnemoPart(complex1);
        double c = getRealPart(complex2);
        double d = getMnemoPart(complex2);
        return formComplex((a * c) - (b * d),(a * d) + (c * b));
    }

    private static double[] divide(double[] complex1, double[] complex2){
        double c = getRealPart(complex2);
        double d = getMnemoPart(complex2);
        return divigeToNum(
               multiply(complex1, getConjugated(complex2)) , (c * c + d * d)
        );
    }

    private static double getArgument(double[] complex){
        return Math.atan2(getRealPart(complex), getMnemoPart(complex));
    }

    private static void setArgument(double[] complex, double arg){
        setRealPart(complex,getModulus(complex) * Math.cos(arg));
        setMnemoPart(complex,getModulus(complex) * Math.sin(arg));
    }

    private static double getModulus(double[] complex){
        double realPart = getRealPart(complex);
        double mnemoPart = getMnemoPart(complex);
        return Math.sqrt(realPart * realPart + mnemoPart * mnemoPart);
    }

    private static void setModulus(double[] complex, double modulus){
        setRealPart(complex,modulus * Math.cos(getArgument(complex)));
        setMnemoPart(complex,modulus * Math.sin(getArgument(complex)));
    }

    private static double[] pow(double[] complex, int n){
        double modulus = Math.pow(getModulus(complex), n);
        setArgument(complex, getArgument(complex) * n);
        return multiplyToNum(complex, modulus);
    }

    public static void main(String[] args) {
        double[] complex1 = formComplex(1,1);
        System.out.println(getArgument(complex1));
        System.out.println(getModulus(complex1));
        writeComplex(complex1);
        pow(complex1, 4);
        writeComplex(complex1);
        System.out.println(getArgument(complex1));
        System.out.println(getModulus(complex1));
    }
}
