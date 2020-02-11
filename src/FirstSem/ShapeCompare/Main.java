package FirstSem.ShapeCompare;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.E);

        double E = 1 * Math.pow(10, -24);

        double curr = 0;
        double last = 0;

        //Считаем lim n -> inf (1 + 1/n)^2, т.е Неперово число (e = 2,7....)
        for (long i = 0; i < Long.MAX_VALUE; i++){
            last = curr;
            curr = Math.pow((1.0 + 1.0/(i + 1)),i + 1);
            if (Math.abs(curr - last) < E && i > 1){
                break;
            }
        }

        System.out.println(last);
    }
}
