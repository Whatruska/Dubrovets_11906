package Lesson_8;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        System.out.println("Ввод матрицы А");
        double[][] A = readMatrix(n);

        System.out.println("Ввод матрицы B");
        double[][] B = readMatrix(n);

        System.out.println("Ввод матрицы C");
        double[][] C = readMatrix(n);

        System.out.println("Ввод матрицы D");
        double[][] D = readMatrix(n);

        double[][] leftMatrix = addMatrix(A, B);
        leftMatrix = multiplyToScalar(leftMatrix, 5);
        leftMatrix = multiplyMatrix(leftMatrix, C);

        double[][] rightMatrix = subMatrix(C, D);
        rightMatrix = multiplyMatrix(rightMatrix, D);
        rightMatrix = multiplyToScalar(rightMatrix, 7);

        double[][] E = subMatrix(leftMatrix, rightMatrix);
        writeMatrix(E);
    }

    private static double[][] readMatrix(int n){
        Scanner scanner = new Scanner(System.in);
        double [][] result = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = scanner.nextDouble();
            }
        }
        return result;
    }

    private static void writeMatrix(double[][] matrix){
        for (double[] arr : matrix){
            for (double elem : arr){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    private static double[][] multiplyToScalar(double[][] matrix, double scalar){
        double[][] result = matrix;
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] *= scalar;
            }
        }
        return result;
    }

    private static double[][] addMatrix(double[][] matrix1, double[][] matrix2){
        double [][] result = matrix1;
        int n = matrix1.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] += matrix2[i][j];
            }
        }
        return result;
    }

    private static double[][] subMatrix(double[][] matrix1, double[][] matrix2){
        double [][] result = matrix1;
        int n = matrix1.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] -= matrix2[i][j];
            }
        }
        return result;
    }

    private static double[][] copyMatrix(double[][] srcMatrix){
        double[][] result = new double[srcMatrix.length][srcMatrix.length];
        int n = srcMatrix.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = srcMatrix[i][j];
            }
        }
        return result;
    }

    private static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2){
        int n = matrix1.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                double[] row = matrix1[i];
                double[] vertical = formVertical(matrix2, j);
                result[i][j] = countMultiplyResult(row, vertical);
            }
        }
        return result;
    }

    private static double[] formVertical(double[][] matrix, int numOfVert){
        int n = matrix.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++){
            result[i] = matrix[i][numOfVert];
        }
        return result;
    }

    private static double countMultiplyResult(double[] row, double[] vertical){
        double result = 0;
        for (int i = 0; i < row.length; i++){
            result += row[i] * vertical[i];
        }
        return result;
    }
}
