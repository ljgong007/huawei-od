package Huawei2023.second.fuxi_advP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liujie gong
 * @date 2023/3/27 20:40
 */
public class P21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        c = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j].equals("S")){
                    Set<String> set = new HashSet<>();
                    System.out.println(dfs(i, j, 0,0, 0, set) ? "YES" : "NO");
                }
            }
        }

    }
    public static int t;
    public static int c;
    public static int n;
    public static int m;
    public static String[][] matrix;
    public static int[][] offsets = {{-1,0,1},{1,0,2},{0,-1,3},{0,1,4}};

    public static boolean dfs(int i0, int j0, int lastDirect, int t0, int c0, Set<String> path){
        if(matrix[i0][j0].equals("T")){
            return true;
        }


        for (int[] offset :offsets) {
            int newI = i0 + offset[0];
            int newJ = j0 + offset[1];
            int direct = offset[2];

            boolean flag1 = false;
            boolean flag2 = false;
            if(newI>=0 && newI<n && newJ>=0 && newJ<m){
                String newPath = newI + "-" + newJ;
                if(path.contains(newPath)) continue;

                if(lastDirect!=0 && lastDirect!=direct){
                    if(t0+1>t) continue;
                    flag1 = true;
                }
                if("*".equals(matrix[newI][newJ])){
                    if(c0+1>c) continue;
                    flag2 = true;
                }

                path.add(i0+"-"+j0);
                boolean res = dfs(newI, newJ, direct, flag1?t0+1:t0, flag2?c0+1:c0, path);
                if (res) return true;
                path.remove(i0+"-"+j0);
            }

        }
        return false;
    }
}

/*
2 0
5 5
..S..
****.
T....
****.
.....
 */
