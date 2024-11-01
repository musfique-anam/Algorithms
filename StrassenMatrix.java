import java.util.Scanner;

public class StrassenMatrix {

    public static int[][] multiplication(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = A[0][0] * B[0][0];
        } else {
            int half = n / 2;
            
            int[][] A11 = new int[half][half];
            int[][] A12 = new int[half][half];
            int[][] A21 = new int[half][half];
            int[][] A22 = new int[half][half];
            int[][] B11 = new int[half][half];
            int[][] B12 = new int[half][half];
            int[][] B21 = new int[half][half];
            int[][] B22 = new int[half][half];
            
            splitMatrix(A, A11, 0, 0);
            splitMatrix(A, A12, 0, half);
            splitMatrix(A, A21, half, 0);
            splitMatrix(A, A22, half, half);
            
            splitMatrix(B, B11, 0, 0);
            splitMatrix(B, B12, 0, half);
            splitMatrix(B, B21, half, 0);
            splitMatrix(B, B22, half, half);

            int[][] P = multiplication(addMatrix(A11, A22), addMatrix(B11, B22));
            int[][] Q = multiplication(addMatrix(A21, A22), B11);
            int[][] R = multiplication(A11, subMatrix(B12, B22));
            int[][] S = multiplication(A22, subMatrix(B21, B11));
            int[][] T = multiplication(addMatrix(A11, A12), B22);
            int[][] U = multiplication(subMatrix(A21, A11), addMatrix(B11, B12));
            int[][] V = multiplication(subMatrix(A12, A22), addMatrix(B21, B22));

            int[][] C11 = addMatrix(subMatrix(addMatrix(P, S), T), V);
            int[][] C12 = addMatrix(R, T);
            int[][] C21 = addMatrix(Q, S);
            int[][] C22 = addMatrix(subMatrix(addMatrix(P, R), Q), U);

            mergeMatrix(C11, result, 0, 0);
            mergeMatrix(C12, result, 0, half);
            mergeMatrix(C21, result, half, 0);
            mergeMatrix(C22, result, half, half);
        }
        return result;
    }

    public static void splitMatrix(int[][] parent, int[][] child, int rowStart, int colStart) {
        int size = child.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                child[i][j] = parent[i + rowStart][j + colStart];
            }
        }
    }

    public static void mergeMatrix(int[][] child, int[][] parent, int rowStart, int colStart) {
        int size = child.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                parent[i + rowStart][j + colStart] = child[i][j];
            }
        }
    }

    public static int[][] addMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the dimension of matrix (n*n):");
        int n = scan.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scan.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = scan.nextInt();
            }
        }
        int[][] result = multiplication(A, B);

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);
        System.out.println("Resultant Matrix:");
        printMatrix(result);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
