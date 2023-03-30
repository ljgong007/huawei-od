package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/26 0:57
 */
public class P46 {
    public static int[] cache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        cache = new int[n];
        Arrays.fill(cache, -1);

        int k = scanner.nextInt();
        System.out.println(solution(matrix, k));
    }

    public static int solution(int[][] matrix, int k) {
        return dfs(k - 1, matrix);
    }

    public static int dfs(int k, int[][] matrix) {
        if (cache[k] != -1) return cache[k];

        int maxPretime = 0;
        int[] pre = matrix[k];
        for (int i = 0; i < pre.length; i++) {
            if (k != i && pre[i] != 0){
                maxPretime = Math.max(maxPretime, dfs(i, matrix));
            }
        }

        cache[k] = maxPretime + matrix[k][k];
        return cache[k];
    }
}

/*
3
5 0 0
1 5 0
0 1 5
3            ->     15
 */


/*
3
5 0 0
1 10 1
1 0 11
2            ->     26
 */



/*
4
2 0 0 0
0 3 0 0
1 1 4 0
1 1 1 5
4             ->      12
 */


/*
5
1 0 0 0 0
0 2 0 0 0
1 1 3 0 0
1 1 0 4 0
0 0 1 1 5
5             ->       11
 */


