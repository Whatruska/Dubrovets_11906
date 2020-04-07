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
        polinom1.add(polinom2);
        System.out.println(polinom1);
    }
}
