public class StrassensMatrix {

    public static void mergeMatrix(int[][] child, int [][] parent, int rowStart, int colStart) {
        int size=child.length;
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++) {
                parent[i+rowStart][j+colStart]=child[i][j];
            }
        }
    }

    public static int [][] addMatrix(int [][] A, int [][]B) {
        int n=A.length;
        int[][] result =new int[n][n];
        for (int i=0; i<n;i++){
            for (int j=0;j<n;j++) {
                result[i][j] =A[i][j] +B[i][j];
            }
        }
        return result;
    }
    
    public static int [][] subMatrix (int [][] A, int [][] B) {
        int n=A.length;
        int [][] result =new int [n][n];
        for(int i=0;i < n;i++){
            for (int j=0;j<n;j++){
                result[i][j]=A[i][j] -B[i][j];
            }
        }
        return result;
    }

    public static void printMatrix (int [][] matrix) {
        for (int i=0;i < matrix.length;i++) {
            for (int j =0;j<matrix[i].length;j++){
                System.out.print(matrix [i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
