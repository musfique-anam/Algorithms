import java.util.Scanner;
public class MergeSort { 
    
    void conq(int a[], int beg, int mid, int end) {        
    int i = beg;
    int j = mid + 1;
    int k = 0;   
    int[] tem = new int[end - beg + 1]; 
    
    while (i <= mid && j <= end) {
        if (a[i] <= a[j]) {
            tem[k] = a[i];
            i++;
        } else {
            tem[k] = a[j];
            j++;
        }
        k++;
    }    
    while (i <= mid) {
        tem[k] = a[i];
        i++;
        k++;
    }    
    while (j <= end) {
        tem[k] = a[j];
        j++;
        k++;
    }    
    for (k = 0; k < tem.length; k++) {
        a[beg + k] = tem[k];
    }
}

    void div(int a[], int beg, int end) {        
        if (beg < end) {           
            int mid = (beg + end) / 2;
            div(a, beg, mid);
            div(a, mid + 1, end);           
            conq(a, beg, mid, end);
        }
    }

    void printArray(int a[], int n) {        
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int a[] = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        MergeSort m = new MergeSort();
        m.div(a, 0, n - 1);
        System.out.println("\nAfter sorting array elements - ");
        m.printArray(a, n);
    }
    
}
