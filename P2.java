package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/21 11:23
 */

/*
示例1
14 7
2 3 2 5 5 1 4   ->[0,1,0,3,3,0,2]

示例2
3 3
1 2 3    ->[0,1,2]
 */
public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int bucketBallNums = scanner.nextInt();
        int[] balls = new int[bucketBallNums];
        int total = 0;
        for (int i = 0; i < bucketBallNums; i++) {
            balls[i] = scanner.nextInt();
            total += balls[i];
        }

        if (total <= sum) {
            System.out.println("[]");
            return;
        }

        System.out.println(solution(balls, total, sum, bucketBallNums));
    }

    public static String solution(int[] balls, int total, int sum, int bucketBallNums) {
        int max = Arrays.stream(balls).max().getAsInt();
        int min = sum / bucketBallNums;
        Integer[] ans = new Integer[bucketBallNums];

        while (min < max-1) {
            int remain = total;
            int mid = min + ((max - min) >> 1);
            for (int i = 0; i < bucketBallNums; i++) {
                int r = balls[i] > mid ? balls[i] -mid : 0;
                remain -= r;
                ans[i] = r;
            }
            if (remain > sum) {  // 剩余的
                max = mid;
            } else if (remain < sum) {
                min = mid;
            } else {
                break;
            }
        }

        return Arrays.toString(ans);
    }
}
