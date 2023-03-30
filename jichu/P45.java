package Huawei2023.second.jichu;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/26 0:23
 */
public class P45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int min_w = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(m, n, s, min_w, matrix));
    }

    public static int solution(int m, int n, int s, int min_w, int[][] matrix){
        int[][] preSum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int ans = 0;
        for (int i = s; i <= m; i++) {
            for (int j = s; j <= n; j++) {
                int square = preSum[i][j] - (preSum[i-s][j] + preSum[i][j-s]) + preSum[i-s][j-s];
                if(square>=min_w) ans++;
            }
        }

        return ans;
    }
}

/*
2 5 2 6
1 3 4 5 8
2 3 6 7 1    >    4
 */



/*
2 5 1 6
1 3 4 5 8
2 3 6 7 1    >    3
 */


/*
2 5 1 0
1 3 4 5 8
2 3 6 7 1    >     10
 */