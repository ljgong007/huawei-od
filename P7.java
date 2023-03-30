package Huawei2023.second.fuxi_advP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liujie gong
 * @date 2023/3/27 2:35
 */
public class P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ports = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ports[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, ports));
    }

    public static int solution(int n, int[][] ports){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!set.contains(i)){
                count++;
            }
            int[] sites = ports[i];
            for (int j = 0; j < n; j++) {
                if(ports[i][j]==1){
                    set.add(j);
                }
            }
        }
        return count;
    }
}
