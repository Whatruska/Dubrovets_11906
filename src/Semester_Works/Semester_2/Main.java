package Semester_Works.Semester_2;

import Semester_Works.Semester_2.Texts.ResultPair;

import java.io.*;
import java.util.*;

public class Main {
    public static final String FOLDER_PATH = "src/Semester_Works/Semester_2/Texts/";
    public static final int CIRCLE_COUNT = 3;
    public static void main(String[] args) throws IOException, InterruptedException {

        RandomGen.generateInput();

        File file = new File(FOLDER_PATH + "array_output.csv");
        PrintWriter arrWriter = new PrintWriter(file);
        file = new File(FOLDER_PATH + "list_output.csv");
        PrintWriter listWriter = new PrintWriter(file);
        file = new File(FOLDER_PATH + "input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line = reader.readLine();
        int n = Integer.parseInt(line);
        for (int i = 0; i < n; i++){
            line = reader.readLine().trim();
            StringTokenizer token = new StringTokenizer(line);
            int size = Integer.parseInt(token.nextToken());

            Integer[] arr = new Integer[size];
            int freeIndex = 0;
            LinkedList<Integer> list = new LinkedList<>();

            for (int j = 0; j < size; j++){
                int elem = Integer.parseInt(token.nextToken());
                arr[freeIndex++] = elem;
                list.add(elem);
            }

            ResultPair arrPair = smoothSort(arr);
            arrWriter.println(arrPair.getSize() + "," + arrPair.getIters() + "," + arrPair.getTime());
            ResultPair listPair = smoothSort(list);
            listWriter.println(listPair.getSize() + "," + listPair.getIters() + "," + listPair.getTime());
        }

        arrWriter.close();
        listWriter.close();
    }

    private static long shift(int startIndex, ArrayList<Node<Integer>> nodes, long iter){
        for (int i = startIndex; i > 0; i--){
            iter++;
            Node<Integer> n = nodes.get(i);
            Node<Integer> n2 = nodes.get(i - 1);
            if (n2.getValue() > n.getValue()){
                int temp = n2.getValue();
                n2.setValue(n.getValue());
                n.setValue(temp);
                n2.sort();
                n.sort();
            }
        }
        return iter;
    }

    public static ResultPair smoothSort(Integer[] arr){
        Iterable<Integer> iterable = Arrays.asList(arr);
        return smoothSort(iterable);
    }

    public static ResultPair smoothSort(Iterable<Integer> container){
        long totalTime = 0;
        long totalIter = 0;
        int totalSize = 0;
        for (int count = 0; count < CIRCLE_COUNT; count++){
            ArrayList<Node<Integer>> nodes = new ArrayList<>();
            long start = System.nanoTime();
            long iter = 0;
            int i = 0;
            for (int a : container){
                Node<Integer> node = new Node<>(a);
                int size = nodes.size();
                Node<Integer> prelast = null;
                Node<Integer> last = null;
                if (i == 0){
                    node.setHeight(1);
                }
                if (size > 0){
                    last = nodes.get(size - 1);
                }
                if (size > 1){
                    prelast = nodes.get(size - 2);
                }
                if (prelast != null && prelast.getHeight() - last.getHeight() == 1){
                    node.setLeftChild(prelast);
                    node.setRightChild(last);
                    node.setHeight(Math.max(prelast.getHeight(), last.getHeight()) + 1);
                    node.sort();
                    nodes.remove(prelast);
                    nodes.remove(last);
                } else if (last != null && last.getHeight() != 1){
                    node.setHeight(1);
                } else {
                    if (i != 0) node.setHeight(0);
                }
                nodes.add(node);
                size = nodes.size();
                for (int j = size - 1; j > 0; j--){
                    iter++;
                    Node<Integer> n = nodes.get(j);
                    Node<Integer> n2 = nodes.get(j - 1);
                    if (n2.getValue() > n.getValue()){
                        int temp = n2.getValue();
                        n2.setValue(n.getValue());
                        n.setValue(temp);
                        n2.sort();
                        n.sort();
                    }
                }
                i++;
            }
            totalSize = i;
            int size = nodes.size();
            for (int j = size - 1; j >= 0; ){
                iter++;
                Node<Integer> node = nodes.get(j);
                Node<Integer> right = node.getRightChild();
                Node<Integer> left = node.getLeftChild();
                nodes.remove(node);
                if (left != null) nodes.add(left);
                if (right != null) nodes.add(right);
                iter = shift(nodes.indexOf(left), nodes, iter);
                iter = shift(nodes.indexOf(right), nodes, iter);
                j = nodes.size() - 1;
            }
            totalIter += iter;
            totalTime += System.nanoTime() - start;
        }

        //System.out.println(System.nanoTime() - start);
        //System.out.println(iter);

        return new ResultPair(totalSize, totalIter/CIRCLE_COUNT, totalTime/CIRCLE_COUNT);
    }
}
