package Semester_Works.Semester_1;

import Semester_Works.Semester_1.List.PolinomList;
import Semester_Works.Semester_1.List.PolinomListItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class Polinom3 {
    private PolinomList list = new PolinomList();

    public Polinom3(String filename) throws URISyntaxException, FileNotFoundException {
        list = formPolinomList(filename);
    }

    public Polinom3() {}

    //T = O(N), M = O(N)
    private PolinomList formPolinomList(String filename) throws URISyntaxException, FileNotFoundException {
        PolinomList result = new PolinomList();
        Scanner scanner = new Scanner(new File(Main.class.getResource(filename).toURI()));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++){
                numbers[i] = Integer.parseInt(parts[i]);
            }
            int coef = numbers[0];
            int x = numbers[1];
            int y = numbers[2];
            int z = numbers[3];
            result.add(coef, x, y, z);
        }
        return result;
    }

    //T = O(N)
    public void insert(int coef, int deg1, int deg2, int deg3){
        list.add(coef, deg1, deg2, deg3);
    }

    //T = O(K + N)
    public void add(Polinom3 polinom){
        PolinomList polinomList = polinom.list;
        PolinomList resultList = new PolinomList();
        PolinomListItem resultElem = resultList.getHead();
        PolinomListItem item2 = polinomList.getHead();
        PolinomListItem item1 = list.getHead();
        int size1 = list.size();
        int size2 = polinomList.size();
        int i = 0,j = 0;
        while (i < size1 && j < size2){
            int compare = item1.compareTo(item2);
            PolinomListItem selected;
            if (compare > 0){
                selected = item1;
                item1 = item1.getNext();
                i++;
            } else if (compare < 0){
                selected = item2;
                item2 = item2.getNext();
                j++;
            } else {
                selected = item1.copy();
                item1 = item1.getNext();
                selected.setCoef(item1.getCoef() + item2.getCoef());
                i++;
            }
            if (resultList.size() == 0){
                resultList.add(selected);
                resultElem = resultList.getHead();
            } else {
                resultElem.setNext(selected);
                resultElem = resultElem.getNext();
            }
        }
        while (i < size1){
            resultElem.setNext(item1);
            resultElem = resultElem.getNext();
            item1 = item1.getNext();
            i++;
        }
        while (j < size2){
            resultElem.setNext(item2);
            resultElem = resultElem.getNext();
            item2 = item2.getNext();
            j++;
        }

        resultList.setSize(list.size() + polinomList.size());
        list = resultList;
    }
    //T = O(N)
    public void delete(int xDeg, int yDeg, int zDeg){
        list.delete(xDeg, yDeg, zDeg);
    }

    //T = O(N^2)
    public void derivative(int i){
        PolinomList newList = new PolinomList();
        int size = list.size();
        PolinomListItem item = list.getHead();
        for (int j = 0; j < size; j++){
            int x = (i == 1 ? item.getXDegree() : i == 2 ? item.getYDegree() : item.getZDegree());
            if (x != 0){
                PolinomListItem copy = item.copy();
                copy.setCoef(item.getCoef() * x);
                if (i == 1){
                    copy.setXDegree(--x);
                } else if (i == 2){
                    copy.setYDegree(--x);
                } else {
                    copy.setZDegree(--x);
                }
                //T = O(N)
                newList.add(copy);
            }
            item = item.getNext();
        }
        list = newList;
    }

    //T = O(N)
    public int value (int x, int y, int z){
        int result = 0;
        PolinomListItem elem = list.getHead();
        int size = list.size();
        for (int i = 0; i < size; i++){
            int partResult = elem.getCoef();
            partResult *= x != 0 ? Math.pow(x, elem.getXDegree()) : 0;
            partResult *= y != 0 ? Math.pow(y, elem.getYDegree()) : 0;
            partResult *= z != 0 ? Math.pow(z, elem.getZDegree()) : 0;
            result += partResult;
            elem = elem.getNext();
        }
        return result;
    }

    @Override
    //T = O(N)
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom3 polinom3 = (Polinom3) o;
        return Objects.equals(list, polinom3.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    //T = O(N)
    public String toString() {
        return list.toString();
    }
}
