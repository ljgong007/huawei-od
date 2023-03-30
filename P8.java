package Huawei2023.second.fuxi_advP;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 2:44
 */
public class P8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        used = new boolean[n];
        System.out.println(solution(matrix, n));
    }
    public static boolean[] used;
    public static int min = Integer.MAX_VALUE;
    public static LinkedList<Integer> track = new LinkedList<>();

    public static int solution(int[][] matrix, int n){
        dfs(n, matrix);
        return min;
    }

    public static void dfs(int n, int[][] matrix){
        if(track.size()==n-1){
            int sum = matrix[0][track.get(0)];
            for (int i = 0; i < track.size()-1; i++) {
                sum += matrix[track.get(i)][track.get(i+1)];
            }
            sum += matrix[track.getLast()][0];
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < n; i++) {
            if(used[i]) continue;
            track.add(i);
            used[i] = true;
            dfs(n, matrix);
            used[i] = false;
            track.removeLast();
        }


    }
}
