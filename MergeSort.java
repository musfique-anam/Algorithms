import java.util.Scanner;
public class MergeSort {
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n=scan.nextInt();
        int a[]=new int [n];

        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }


        MergeSort m=new MergeSort();
        m.div(a,0,n-1);
        System.out.println("\nAfter sorting:");
        m.printArray(a,n);
        
    }
}