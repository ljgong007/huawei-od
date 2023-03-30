package Huawei2023.second.jichu;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 3:24
 */
public class P34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = scanner.nextInt();
            tasks[i][1] = scanner.nextInt();
        }
        System.out.println(solution(tasks, T, n));
    }

    public static int solution(int[][] tasks, int T, int n) {
        int[][] dp = new int[n + 1][T + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < T + 1; j++) {
                if(i==0 || j==0) continue;

                int t = tasks[i-1][0];
                int w = tasks[i-1][1];
                if (t > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], w + dp[i - 1][j - t]);
                }
            }
        }

        return dp[n][T];
    }
}

/*
40 3
20 10
20 20
20 5    ->  30
 */
