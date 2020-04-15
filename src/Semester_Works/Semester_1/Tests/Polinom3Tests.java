package Semester_Works.Semester_1.Tests;

import Semester_Works.Semester_1.Polinom3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Polinom3Tests {
    Polinom3 inputPolinom;
    Polinom3 emptyPolinom;

    @Before
    public void createPolinoms(){
        try {
            inputPolinom = new Polinom3("input.txt");
            emptyPolinom = new Polinom3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void correctFileInput() throws IOException {
        Polinom3 curr = new Polinom3("input2.txt");
        emptyPolinom.insert(2,0,0,2);
        emptyPolinom.insert(4,0,0,0);
        Assert.assertEquals(curr, emptyPolinom);
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotExists() throws IOException {
        Polinom3 curr = new Polinom3("inpuz.txt");
        emptyPolinom.insert(2,0,0,2);
        Assert.assertEquals(curr, emptyPolinom);
    }

    @Test
    public void emptyFileInput() throws IOException {
        Polinom3 curr = new Polinom3("empty.txt");
        Assert.assertEquals(curr, emptyPolinom);
    }

    @Test
    public void correctAdd() throws IOException {
        Polinom3 pol2 = new Polinom3("input2.txt");
        inputPolinom.add(pol2);
        emptyPolinom.insert(4,1,2,2);
        emptyPolinom.insert(2,0,0,2);
        emptyPolinom.insert(4,0,0,0);
        Assert.assertEquals(inputPolinom, emptyPolinom);
    }

    @Test
    public void mergeAdd() {
        Polinom3 pol2 = new Polinom3();
        emptyPolinom.insert(1,1,1,2);
        pol2.insert(3,1,1,2);
        emptyPolinom.add(pol2);
        Polinom3 expected = new Polinom3();
        expected.insert(4,1,1,2);
        Assert.assertEquals(emptyPolinom, expected);
    }

    @Test
    public void emptyAdd() {
        emptyPolinom.add(new Polinom3());
        Assert.assertEquals(emptyPolinom, new Polinom3());
    }

    @Test
    public void commonDerivativeTest() throws IOException {
        inputPolinom.derivative(2);
        emptyPolinom.insert(8,1,1,2);
        Assert.assertEquals(inputPolinom, emptyPolinom);
    }

    @Test
    public void nullDerivativeTest() throws IOException {
        emptyPolinom.insert(0,0,0,0);
        inputPolinom.derivative(2);
        inputPolinom.derivative(2);
        inputPolinom.derivative(2);
        Assert.assertEquals(inputPolinom, emptyPolinom);
    }

    @Test
    public void emptyDerivative() {
        Polinom3 pol1 = new Polinom3();
        pol1.derivative(2);
        Assert.assertEquals(pol1, emptyPolinom);
    }

    @Test
    public void valueOfNull() throws IOException {
        inputPolinom.delete(1,2,2);
        Assert.assertEquals(0, inputPolinom.value(1,1,1));
    }

    @Test
    public void constValue() throws IOException {
        inputPolinom.delete(1,2,2);
        inputPolinom.insert(4,0,0,0);
        Assert.assertEquals(4, inputPolinom.value(1,1,1));
    }

    @Test
    public void countCommonValue() throws IOException {
        Assert.assertEquals(1152, inputPolinom.value(2,3,4));
    }
}
