package Huawei2023.second.fuxi_advP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/29 19:26
 */
public class P47Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] teams = new int[n];
        for (int i = 0; i < n; i++) {
            teams[i] = scanner.nextInt();
        }
        System.out.println(solution(n, d, teams));
    }

    public static int solution(int n, int d, int[] teams) {
        Arrays.sort(teams);
        List<Integer> segment = new ArrayList<>();
        int ans = 0;
        boolean flag = true;

        for (int i = 1; i < n; i++) {
            int diff = teams[i] - teams[i - 1];
            if (diff > d) {
                if (segment.size() > 0) {
                    ans += getMinSum(segment);
                    flag = false;
                    segment = new ArrayList<>();
                }
            } else {
                segment.add(diff);
            }
        }

        if (segment.size() > 0) {
            ans += getMinSum(segment);
            flag = false;
        }

        if (flag) return -1;

        return ans;
    }

    public static int getMinSum(List<Integer> segment) {
        int n = segment.size();

        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = segment.get(0);
        if (n == 1) return dp[0][1];

        dp[1][0] = 1;
        dp[1][0] = Math.min(segment.get(0), segment.get(1));
        if (n == 2) return dp[1][0];

        for (int i = 2; i < n; i++) {
            int steal_count = dp[i - 2][0] + 1;
            int steal_val = dp[i - 2][1] + segment.get(i);

            int not_steal_count = dp[i - 1][0];
            int not_steal_val = dp[i - 1][1];
            if (steal_count > not_steal_count) {
                dp[i][0] = steal_count;
                dp[i][1] = steal_val;
            } else if (steal_count == not_steal_count) {
                if (steal_val >= not_steal_val) {
                    dp[i][0] = steal_count;
                    dp[i][1] = steal_val;
                } else {
                    dp[i][0] = not_steal_count;
                    dp[i][1] = not_steal_val;
                }
            } else {
                dp[i][0] = not_steal_count;
                dp[i][1] = not_steal_val;
            }
        }
        return dp[n-1][1];
    }
}

/*
8 10
65 44 45 58 40 60 46 47
->  4
 */


/*
30 5
47 100 82 7 97 52 74 9 20 80 76 1 98 64 98 55 63 44 11 29 23 61 2 23 44 70 41 78 21 31
->    27
 */
