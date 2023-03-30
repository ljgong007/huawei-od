package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/29 0:00
 */
public class P42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
        }
        Arrays.sort(times);
        System.out.println(solution(n, T, times));
    }

    public static String solution(int n, int T, int[] times) {

        if(n<2){
            if(times[0] > T){
                return "0 0";
            }else{
                return "0 " + times[0];
            }
        }

        int[] dp = new int[n];
        dp[0] = times[0];
        dp[1] = getMax(times[0], times[1]);
        for (int i = 2; i < n; i++) {
            int a1 = dp[i-1] + times[0] + getMax(times[0], times[i]);
            int a2 = dp[i-2] + times[0] + getMax(times[i-1], times[i]) + times[1] + dp[1];
            dp[i] = Math.min(a1, a2);
            if(dp[i]>T) return i + " " + dp[i-1];
        }
        return n + " " + dp[n-1];
    }

    public static int getMax(int t1, int t2) {
        if (t1 * 10 < t2) {
            return t1 * 10;
        }
        return t2;
    }
}

/*
5
130
50 12 13 15 20
-> 5 128
 */


/*
7
171
25 12 13 15 20 35 20
7 171
 */
