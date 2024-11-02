import java.util.Scanner;
public class QuickSort {

    int pivotValue(int a[],int start,int end){
        int pivot = a[start];
        int i =start +1;
        int j = end;

        while (i <= j){
            while (i<=end && a[i] <= pivot){
                i++;
            }
            while(j>=start && a[j] > pivot){
                j--;
            }
            if (i < j){
                int temp =a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[start];
        a[start]=a[j];
        a[j]=temp;

        return j;
    }

    void quick(int a[],int start,int end){
        if(start<end){
            int p=pivotValue(a,start,end);
            quick(a,start,p-1);
            quick(a,p+1,end);
        }
    }

    void print(int a[],int n){
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
    
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n=reader.nextInt();
        int []a=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++)
            a[i]=reader.nextInt();

        QuickSort q=new QuickSort();
        System.out.println("Before sorting:");
        q.print(a,n);
        System.out.println("\nAfter Sorting :");
        q.quick(a,0,n-1);
        q.print(a,n);

    }
    
}
