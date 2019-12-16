package Complex_2_0;

import java.util.Scanner;

public class ComplexNumber {
    static Scanner scanner = new Scanner(System.in);

    private double realPart;
    private double mnemoPart;

    public ComplexNumber(double realPart, double mnemoPart) {
        this.realPart = realPart;
        this.mnemoPart = mnemoPart;
    }

    public ComplexNumber(ComplexNumber complexNumber) {
        this.realPart = complexNumber.getRealPart();
        this.mnemoPart = complexNumber.getMnemoPart();
    }

    public static ComplexNumber readComplex(){
        double realPart = scanner.nextDouble();
        double mnemoPart = scanner.nextDouble();
        return new ComplexNumber(realPart, mnemoPart);
    }

    public double getRealPart(){
        return realPart;
    }

    public double getMnemoPart(){
        return mnemoPart;
    }

    public void setRealPart(double realPart){
        this.realPart = realPart;
    }

    public void setMnemoPart(double mnemoPart){
        this.mnemoPart = mnemoPart;
    }

    public void writeComplex(){
        System.out.println(this.getRealPart() + " " + this.getMnemoPart() + "i");
    }

    public void addComplex(ComplexNumber complexNumber){
        this.setRealPart(this.getRealPart() + complexNumber.getRealPart());
        this.setMnemoPart(this.getMnemoPart() + complexNumber.getMnemoPart());
    }

    public void subComplex(ComplexNumber complexNumber){
        complexNumber.multiplyToNum( -1);
        this.addComplex(complexNumber);
    }

    public void multiplyToNum(double num){
        this.setRealPart(this.getRealPart() * num);
        this.setMnemoPart(this.getMnemoPart() * num);
    }

    public void divigeToNum(double num){
        multiplyToNum(1/num);
    }

    public ComplexNumber getConjugated(){
        ComplexNumber result = new ComplexNumber(this.realPart, this.mnemoPart);
        result.setMnemoPart(this.mnemoPart * -1);
        return result;
    }

    public void multiply(ComplexNumber complexNumber){
        double a = this.getRealPart();
        double b = this.getMnemoPart();
        double c = complexNumber.getRealPart();
        double d = complexNumber.getMnemoPart();
        this.setRealPart((a * c) - (b * d));
        this.setMnemoPart((a * d) + (c * b));
    }

    public void divide(ComplexNumber complexNumber){
        double c = complexNumber.getRealPart();
        double d = complexNumber.getMnemoPart();
        this.multiply(complexNumber.getConjugated());
        this.divigeToNum(
                (c * c + d * d)
        );
    }

    public double getArgument(){
        return Math.atan2(this.getRealPart(), this.getMnemoPart());
    }

    public void setArgument(double arg){
        double modulus = this.getModulus();
        this.setRealPart(modulus * Math.cos(arg));
        this.setMnemoPart(modulus * Math.sin(arg));
    }

    public double getModulus(){
        double realPart = this.getRealPart();
        double mnemoPart = this.getMnemoPart();
        return Math.sqrt(realPart * realPart + mnemoPart * mnemoPart);
    }

    public void setModulus(double modulus){
        double arg = this.getArgument();
        this.setRealPart(modulus * Math.cos(arg));
        this.setMnemoPart(modulus * Math.sin(arg));
    }

    public void pow(int n){
        double modulus = Math.pow(this.getModulus(), n);
        this.setArgument(this.getArgument() * n);
        this.multiplyToNum(modulus);
    }
}
