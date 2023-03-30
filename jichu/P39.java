package Huawei2023.second.jichu;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 22:11
 */
public class P39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = scanner.nextInt();
        }
        int p_max = scanner.nextInt();
        System.out.println(solution(powers, n, p_max));
    }

    public static int solution(int[] powers, int n, int p_max){
        int[][] dp = new int[n+1][p_max+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < p_max+1; j++) {
                if(i==0 || j==0) continue;
                int power = powers[i-1];
                if(power > j) {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], power + dp[i-1][j- power]);
                }
            }
        }
        return dp[n][p_max];
    }
}
