package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 23:30
 */
public class P42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int days = scanner.nextInt();
        int[] fields = new int[m];
        for (int i = 0; i < m; i++) {
            fields[i] = scanner.nextInt();
        }
        System.out.println(solution(fields, m, days));
    }

    public static int solution(int[] fields, int m, int days) {
        if (days < m) return -1;
        Arrays.sort(fields);
        if (days == m) return fields[m - 1];

        int min = 1;
        int max = fields[m - 1];
        int ans = 0;
        while (min <= max) {
            int k = min + ((max - min) >> 1);
            int res = check(fields, days, k);
            if (res > 0) {
                min = k+1;
            } else {
                ans = k;
                max = k - 1;
            }
        }

        return ans;

    }

    public static int check(int[] fields, int days, int k) {
        int count = 0;
        for (int field : fields) {
            if (k >= field) count++;
            else {
                count += Math.ceil(field / (double) k);
            }
        }
        return count - days;
    }
}
