package Tutor;
import java.util.*;

public class Array2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int k = 1; //Кол-во единиц

        int t = 2*n; //Пробелы между трегольниками

        for (int i = 0; i <n ; i++) {



            for (int j = 0; j < t ; j++) {

                System.out.print(" ");

            }

            for (int j = 0; j < k; j++) {

                System.out.print("1");

            }

            t--;

            k+=2;

            System.out.println();



        }
        //Печатает первый треугольник

        System.out.println();

        t = n-1; //кол-во пробелов слева

        k = 1; //кол-во единиц

        for (int i = 0; i <n ; i++) {
            //печатаем n строк

            for (int j = 0; j <t ; j++) {

                System.out.print(" ");

            }
            //Печатаем пробелы слева

            for (int j = 0; j <k ; j++) {

                System.out.print("1");

            }
            //Печатаем единицы

            for (int j = 0; j < 2*n+2-k ; j++) {

                System.out.print(" ");

            }
            //Печатаем пробелы между треугольниками

            for (int j = 0; j < k ; j++) {

                System.out.print("1");

            }
            //Печатаем единицы второй раз

            System.out.println();

            k+=2;

            t--;

        }
        //Печатает нижний ряд

    }

}
