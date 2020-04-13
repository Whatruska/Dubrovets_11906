package Semester_Works.Semester_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        Polinom3 polinom1 = null;
        Polinom3 polinom2 = null;
        try {
            polinom1 = new Polinom3("input.txt");
            polinom2 = new Polinom3("input2.txt");
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File input : " + polinom1);
        System.out.println("File input : " + polinom2);

        polinom1.insert(1,2,4,8);
        System.out.println("Insert : " + polinom1);

        polinom1.delete(2,4,8);
        System.out.println("Delete : " + polinom1);

        polinom1.derivative(1);
        System.out.println("First derivative by x : " + polinom1);

        polinom1.derivative(2);
        System.out.println("XY-derivative : " + polinom1);

        System.out.println("First polinom : " + polinom1);
        System.out.println("Second polinom : " + polinom2);
        polinom1.add(polinom2);
        System.out.println("Polinoms sum : " + polinom1);

        System.out.println("Value of polinom " + polinom1 + " in (1,2,3) : " + polinom1.value(1,2,3));
    }
}
