package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 22:36
 */
public class P13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer[] array = Arrays.stream(str.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(array));
    }

    public static int solution(Integer[] arr) {
        int len = arr.length;

        int[] dp = new int[len];
        dp[0] = arr[0];

        int[] delay = new int[len];
        delay[0] = 0;

        int[] scores = new int[len];
        scores[0] = arr[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.min(100, dp[i-1] + arr[i]);
            delay[i] = delay[i-1] + dp[i-1];
            scores[i] = dp[i] - delay[i];

            if(dp[i]>100) break;
        }

        return Arrays.stream(scores).max().getAsInt();
    }
}
