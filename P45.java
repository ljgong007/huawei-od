package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/29 11:50
 */
public class P45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] groups = new int[T][];
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] lines = new int[n];
            for (int j = 0; j < n; j++) {
                lines[j] = scanner.nextInt();
            }
            groups[i] = lines;
        }
        solution(T, groups, groups[0].length);
    }

    public static void solution(int T, int[][] groups, int n) {
        for (int[] group : groups) {
            boolean[] used = new boolean[n];
            Arrays.sort(group);
            System.out.println(dfs(0, group, used));
        }
    }

    public static int dfs(int index, int[] group, boolean[] used) {
        int ans = 0;
        for (int i = index; i < group.length; i++) {
            if (used[i]) continue;
            for (int j = i + 1; j < group.length; j++) {
                if (used[j]) continue;
                for (int k = j + 1; k < group.length; k++) {
                    if (used[k]) continue;
                    int a = group[i];
                    int b = group[j];
                    int c = group[k];
                    if (a * a + b * b == c * c) {
                        used[i] = true;
                        used[j] = true;
                        used[k] = true;
                        ans = Math.max(ans, dfs(i+1, group, used) + 1);
                        used[i] = false;
                        used[j] = false;
                        used[k] = false;
                    }
                }
            }
        }
        return ans;
    }

}
