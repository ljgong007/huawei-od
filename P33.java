package Huawei2023.second.fuxi_advP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liujie gong
 * @date 2023/3/30 2:49
 */
public class P33 {
    public static int m;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int i0 = 0;
        int j0 = 0;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] > 0) {
                    i0 = i;
                    j0 = j;
                }
            }
        }
        int tx = scanner.nextInt();
        int ty = scanner.nextInt();
        System.out.println(solution(i0, j0, matrix, tx, ty));
    }

    public static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int solution(int i0, int j0, int[][] matrix, int tx, int ty) {
        LinkedList<Integer[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(new Integer[]{i0, j0});
        set.add(i0 + "-" + j0);
        while (queue.size() > 0) {
            Integer[] top = queue.removeFirst();
            int si = top[0];
            int sj = top[1];

            if (matrix[si][sj] > 1) {
                for (int[] offset : offsets) {
                    int newI = si + offset[0];
                    int newJ = sj + offset[1];
                    String path = newI + "-" + newJ;

                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] != -1 && !set.contains(path)) {
                        matrix[newI][newJ] = matrix[si][sj] - 1;
                        queue.add(new Integer[]{newI, newJ});
                        set.add(path);
                    }
                }
            }else{
                break;
            }
        }

        return matrix[tx][ty];
    }
}

/*
6 5
0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
 */


