package Homework_4;

public class TimeCheck {
    public static void main(String[] args) {
        int i = 0;
        long firstBegin = System.currentTimeMillis();
        while (i < 1000000){
            i++;
        }
        long time1 = System.currentTimeMillis() - firstBegin;

        i = 0;
        long secondBegin = System.currentTimeMillis();
        while (i < 1000000){
            i+=1;
        }
        long time2 = System.currentTimeMillis() - secondBegin;

        i = 0;
        long thirdBegin = System.currentTimeMillis();
        while (i < 1000000){
            i=i+1;
        }
        long time3 = System.currentTimeMillis() - thirdBegin;

        System.out.println("Time 1 = " + time1);
        System.out.println("Time 2 = " + time2);
        System.out.println("Time 3 = " + time3);
    }
}
