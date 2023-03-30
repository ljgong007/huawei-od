package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/25 0:09
 */
public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next();
            }
        }

        System.out.println(solution());
    }

    public static Set<String> checked = new HashSet<>();
    public static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int m = 0;
    public static int n = 0;
    public static String[][] matrix;


    public static String solution() {
        List<Integer[]> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ("O".equals(matrix[i][j]) && !checked.contains(i + "-" + j)) {
                    List<Integer[]> enter = new ArrayList<>();
                    int count = dfs(i, j, 0, enter);
                    if (enter.size() == 1) {
                        Integer[] pos = enter.get(0);
                        ans.add(new Integer[]{pos[0], pos[1], count});
                    }
                }
            }
        }

        if (ans.size() == 0) return "NUL";
        ans.sort((a, b) -> b[2] - a[2]);
        if (ans.size() == 1 || ans.get(0)[2] > ans.get(1)[2]) {
            StringJoiner sj = new StringJoiner(" ");
            for (Integer i : ans.get(0)) {
                sj.add(i + "");
            }
            return sj.toString();
        } else {
            return ans.get(0)[2] + "";
        }
    }

    public static int dfs(int i, int j, int count, List<Integer[]> enter) {
        String pos = i + "-" + j;
        if (i < 0 || i >= m || j < 0 || j >= n || "X".equals(matrix[i][j]) || checked.contains(pos)) {
            return count;
        }

        checked.add(pos);
        if(i==0 || i==m-1 || j==0 || j==n-1) enter.add(new Integer[]{i, j});

        count++;
        for (int[] offset : offsets) {
            int newI = i + offset[0];
            int newJ = j + offset[1];

            count = dfs(newI, newJ, count, enter);
        }
        return count;
    }
}


/*
5 4
X X X X
X O O O
X O O O
X O O X
X X X X       ->     NUL
 */


/*
5 4
X X X X
X O O O
X X X X
X O O O
X X X X       ->      3
 */



