package DataStructuresAlgorithms;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch{
    int binarySearch(int a[], int start,int end,int m){
        while (start <= end) {
            int mid = (start + end) / 2;
            if(a[mid] == m) {
                return mid;
            }else if (a[mid] > m) {
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }return -1;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the total number of elements :");
        int n=scan.nextInt();
        int [] a=new int[n];
        System.out.println("Enter the elements :");
        for (int i=0; i < n; i++)
            a[i] = scan.nextInt();

        Arrays.sort (a);
        System.out.println("Sorted form :");
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i] +" ");
        }
        System.out.println();

        BinarySearch b=new BinarySearch();
        System.out.println("Enter the element to search :");
        int m=scan.nextInt();
        int result = b.binarySearch(a, 0, n - 1,m);
        if(result == -1)
            System.out.println("Element not found !");
        else
            System.out.println("Element founf at index : "+ result);
    }
}