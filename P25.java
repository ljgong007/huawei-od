package Huawei2023.second.fuxi_advP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 1:28
 */
public class P25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(m, n, matrix));

    }

    public static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int solution(int m, int n, int[][] matrix) {
        UnionFindSet unionSet = new UnionFindSet(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] offset : offsets) {
                    int newI = i + offset[0];
                    int newJ = j + offset[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        if (Math.abs(matrix[i][j] - matrix[newI][newJ]) <= 1) {
                            unionSet.union(i * n + j, newI * n + newJ);
                        }
                    }
                }
            }
        }
        int total = m * n;
        if (unionSet.count == 1) return total;
        for (int i = 0; i < total; i++) {
            unionSet.find(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : unionSet.parent) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.values().stream().max((a, b) -> a - b).get();
    }
}

class UnionFindSet {
    public int[] parent;
    public int count;

    public UnionFindSet(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (x != this.parent[x]) {
            return this.parent[x] = this.find(this.parent[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        int xVal = find(x);
        int yVal = find(y);
        if (xVal != yVal) {
            this.parent[y] = xVal;
            this.count--;
        }
    }
}
