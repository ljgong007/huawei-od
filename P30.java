package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 14:08
 */
public class P30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        Integer[] arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(m, arr));
    }

    public static int solution(int m, Integer[] arr){
        int[] dp = new int[m+1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 || j==0 || j<i) continue;
                dp[j] = Math.max(dp[j], dp[j-i] + arr[i-1]);
            }
        }
        return dp[m];
    }
}
