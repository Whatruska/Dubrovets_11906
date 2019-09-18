package Homework_1;

public class SecondTask {
    public static void main(String[] args) {
        int a = 10;
        int b = 100;
        int c = 613;
        int d = 4;
        int e = 7;

        int max = a;
        if (b > max){
            max = b;
        }
        if (c > max){
            max = c;
        }
        if (d > max){
            max = d;
        }
        if (e > max){
            max = e;
        }

        int min = a;
        if (b < min){
            min = b;
        }
        if (c < min){
            min = c;
        }
        if (d < min){
            min = d;
        }
        if (e < min){
            min = e;
        }

        System.out.println("Максимум : " + max);
        System.out.println("Минимум : " + min);
    }
}
