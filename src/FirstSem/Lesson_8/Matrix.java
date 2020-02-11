package FirstSem.Lesson_8;

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

        double[][] leftMatrix = addMatrix(A, B, n);
        leftMatrix = multiplyToScalar(leftMatrix, 5, n);
        leftMatrix = multiplyMatrix(leftMatrix, C, n);

        double[][] rightMatrix = subMatrix(C, D, n);
        rightMatrix = multiplyMatrix(rightMatrix, D, n);
        rightMatrix = multiplyToScalar(rightMatrix, 7, n);

        double[][] E = subMatrix(leftMatrix, rightMatrix, n);
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

    private static double[][] multiplyToScalar(double[][] matrix, double scalar, int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] *= scalar;
            }
        }
        return matrix;
    }

    private static double[][] addMatrix(double[][] matrix1, double[][] matrix2, int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix1[i][j] += matrix2[i][j];
            }
        }
        return matrix1;
    }

    private static double[][] subMatrix(double[][] matrix1, double[][] matrix2, int n){
        matrix2 = multiplyToScalar(matrix2, -1, n);
        matrix1 = addMatrix(matrix1, matrix2, n);
        return matrix1;
    }

    private static double[][] copyMatrix(double[][] srcMatrix, int n){
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = srcMatrix[i][j];
            }
        }
        return result;
    }

    private static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2, int n){
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                double[] row = matrix1[i];
                double[] vertical = formVertical(matrix2, j, n);
                result[i][j] = countMultiplyResult(row, vertical, n);
            }
        }
        return result;
    }

    private static double[] formVertical(double[][] matrix, int numOfVert, int n){
        double[] result = new double[n];
        for (int i = 0; i < n; i++){
            result[i] = matrix[i][numOfVert];
        }
        return result;
    }

    private static double countMultiplyResult(double[] row, double[] vertical, int n){
        double result = 0;
        for (int i = 0; i < n; i++){
            result += row[i] * vertical[i];
        }
        return result;
    }
}
