package Huawei2023.second.fuxi_advP;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 13:23
 */
public class P9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(solution(s, t, a, b));
    }

    public static int solution(int s, int t, int a, int b) {
        int ans = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int temp = s - t;
            if ((temp - a * i) % b == 0 || (temp + a * i) % b == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
