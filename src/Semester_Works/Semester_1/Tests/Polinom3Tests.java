package Semester_Works.Semester_1.Tests;

import Semester_Works.Semester_1.Polinom3;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Polinom3Tests {
    @Test
    public void correctFileInput() throws IOException {
        Polinom3 curr = new Polinom3("input2.txt");
        Polinom3 expected = new Polinom3();
        expected.insert(2,0,0,2);
        expected.insert(4,0,0,0);
        Assert.assertEquals(curr, expected);
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotExists() throws IOException {
        Polinom3 curr = new Polinom3("inpuz.txt");
        Polinom3 expected = new Polinom3();
        expected.insert(2,0,0,2);
        Assert.assertEquals(curr, expected);
    }

    @Test
    public void correctAdd() throws IOException {
        Polinom3 pol1 = new Polinom3("input.txt");
        Polinom3 pol2 = new Polinom3("input2.txt");
        pol1.add(pol2);
        Polinom3 expected = new Polinom3();
        expected.insert(4,1,2,2);
        expected.insert(2,0,0,2);
        expected.insert(4,0,0,0);
        Assert.assertEquals(pol1, expected);
    }

    @Test
    public void mergeAdd() {
        Polinom3 pol1 = new Polinom3();
        Polinom3 pol2 = new Polinom3();
        pol1.insert(1,1,1,2);
        pol2.insert(3,1,1,2);
        pol1.add(pol2);
        Polinom3 expected = new Polinom3();
        expected.insert(4,1,1,2);
        Assert.assertEquals(pol1, expected);
    }

    @Test
    public void commonDerivativeTest() throws IOException {
        Polinom3 pol1 = new Polinom3("input.txt");
        Polinom3 expected = new Polinom3();
        pol1.derivative(2);
        expected.insert(8,1,1,2);
        Assert.assertEquals(pol1, expected);
    }

    @Test
    public void nullDerivativeTest() throws IOException {
        Polinom3 pol1 = new Polinom3("input.txt");
        Polinom3 expected = new Polinom3();
        expected.insert(0,0,0,0);
        pol1.derivative(2);
        pol1.derivative(2);
        pol1.derivative(2);
        Assert.assertEquals(pol1, expected);
    }

    @Test
    public void valueOfNull() throws IOException {
        Polinom3 pol1 = new Polinom3("input.txt");
        pol1.delete(1,2,2);
        Assert.assertEquals(0, pol1.value(1,1,1));
    }

    @Test
    public void countCommonValue() throws IOException {
        Polinom3 pol1 = new Polinom3("input.txt");
        Assert.assertEquals(1152, pol1.value(2,3,4));
    }
}
