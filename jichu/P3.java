package Huawei2023.second.jichu;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 15:26
 */
public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        System.out.println(solution(text1, text2));
    }

    public static String solution(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        String ans = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        ans = text1.substring(i - max, i);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}

/*
hello123world
hello123abc4
 */
