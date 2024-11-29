public class FracKnapsack {
    static int n = 5;
    static int[] p = {3, 3, 2, 5, 1};
    static int[] w = {10, 15, 10, 12, 8};
    static int W = 10;

    public static void main(String[] args) {
        int cur_w = W;
        float tot_v = 0;
        int maxi;
        int[] used = new int[n];
        
        for (int i = 0; i < n; i++) {
            used[i] = 0;
        }
        
        while (cur_w > 0) {
            maxi = -1;
            for (int i = 0; i < n; i++) {
                if (used[i] == 0 && (maxi == -1 || (float) w[i] / p[i] > (float) w[maxi] / p[maxi])) {
                    maxi = i;
                }
            }
            used[maxi] = 1;
            cur_w = cur_w - p[maxi];
            tot_v = tot_v + w[maxi];
            
            if (cur_w < 0) {
                tot_v -= w[maxi];
                tot_v += (1 + (float) cur_w / p[maxi]) * w[maxi];
            }
        }
        
        System.out.println("Maximum total value obtained: " + tot_v);
    }
}
