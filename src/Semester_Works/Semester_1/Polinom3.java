package Semester_Works.Semester_1;

import Semester_Works.Semester_1.List.PolinomList;
import Semester_Works.Semester_1.List.PolinomListItem;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Polinom3 {
    private PolinomList<PolinomListItem> list = new PolinomList<>();

    public Polinom3(String filename) throws IOException {
        list = formPolinomList(filename);
    }

    public Polinom3() {}

    //T = O(N), M = O(N)
    private PolinomList<PolinomListItem> formPolinomList(String filename) throws IOException {
        PolinomList<PolinomListItem> result = new PolinomList<>();
        Path p = Paths.get("src/Semester_Works/Semester_1/" + filename);
        File file = p.toFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null){
            StringTokenizer tokenizer = new StringTokenizer(line);
            int coef = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int z = Integer.parseInt(tokenizer.nextToken());
            result.add(coef, x, y, z);
            line = reader.readLine();
        }
        reader.close();
        return result;
    }

    //T = O(N)
    public void insert(int coef, int deg1, int deg2, int deg3){
        list.add(coef, deg1, deg2, deg3);
    }

    //T = O(K + N)
    public void add(Polinom3 polinom){
        PolinomList<PolinomListItem> polinomList = polinom.list;
        PolinomListItem item2 = polinomList.getHead();
        PolinomListItem item1 = list.getHead();
        int size1 = list.size();
        int size2 = polinomList.size();
        PolinomListItem[] items = new PolinomListItem[size1 + size2];
        int freeIndex = 0;
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
                selected.setCoef(item1.getCoef() + item2.getCoef());
                item1 = item1.getNext();
                i++;
                item2 = item2.getNext();
                j++;
            }
            items[freeIndex] = selected;
            freeIndex++;
        }
        while (i < size1){
            items[freeIndex] = item1;
            freeIndex++;
            item1 = item1.getNext();
            i++;
        }
        while (j < size2){
            items[freeIndex] = item2;
            freeIndex++;
            item2 = item2.getNext();
            j++;
        }

        list = new PolinomList<>(items);
    }
    //T = O(N)
    public void delete(int xDeg, int yDeg, int zDeg){
        list.delete(xDeg, yDeg, zDeg);
    }

    //T = O(N^2)
    public void derivative(int i){
        PolinomList<PolinomListItem> newList = new PolinomList<>();
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
        if (newList.size() == 0){
          newList.add(0,0,0,0);
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
    //T = O(N)
    public String toString() {
        return list.toString();
    }
}
