public class StrassensMatrix {
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
}
