//0/1 knapsack

public class Knapsack {
    private static final int [] values ={300,200,400,500};
    private static final int [] weights ={2,1,5,3};
    private static final int capacity =10;

    private static int knapsackTabulation () {
        int n=values.length;
        int [][]tab =new int [n+1][capacity +1];

        //Populate the DP table
        for (int i=1;i<=n;i++) {
            for (int w=1;w<=capacity;w++){
                if(weights[i-1] <=w) {
                    int includeItem=values[i-1]+tab[i-1][w-weights[i-1]];
                    int excludeItem=tab[i-1][w];
                    tab[i][w]=Math.max(includeItem,excludeItem);
                }else{
                    tab[i][w]=tab[i-1][w];
                }
            }
        }

        //Backtrack to print the items included directly
        System.out.print("Items included: ");
        int w=capacity;
        for(int i=n;i>0;i--){
            if(tab[i][w] !=tab[i-1][w]){
                System.out.print((i)+" ");
                w-=weights[i-1];
            }
        }
        System.out.println();

        //return the maximum value
        return tab[n][capacity];
    }
    public static void main(String[] args) {
        System.out.println("Maximum value in knapsack = "+knapsackTabulation());
    }
}