package algo.dynamic.programming;

import org.junit.Test;

import java.util.Arrays;

public class RodCutting {
    /**
     *
     */
    public int maxProfit(int[] p, int n){
        int[] r = new int[n+1];
        r[0] = 0;
        int q;
        for (int i = 1; i <= n; i++) {
            q = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                q = q > (p[j] + r[i-j-1]) ? q : p[j] + r[i-j-1];
            }
            r[i] = q;
        }
        return r[n];
    }

    public int[] maxProfitSolution(int[] p, int n){
        int[] r = new int[n+1];
        int[] s = new int[n];
        r[0] = 0;
        int q;
        for (int i = 1; i <= n; i++) {
            q = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if((p[j] + r[i-j-1]) > q){
                    q = p[j] + r[i-j-1];
                    s[i-1] = j+1;
                }
            }
            r[i] = q;
        }
        return s;
    }



    @Test
    public void testMaxProfit(){
        int[] p = new int[]{1,5,8,9,10,17,17,20,24,30};
        System.out.println(maxProfit(p,10));
        int[] s = maxProfitSolution(p,10);
        System.out.println(Arrays.toString(s));
    }
}
