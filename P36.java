package Huawei2023.second.fuxi_advP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/30 20:02
 */
public class P36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] edge = new int[2];
            edge[0] = scanner.nextInt();
            edge[1] = scanner.nextInt();
            list.add(edge);
        }
        System.out.println(solution(n, m, list));

    }

    public static int solution(int n, int m, List<int[]> list){
        int total = (int)Math.pow(2,n);
        int res = total;
        for (int i = 0; i < total; i++) {
            int temp = i;
            int[] ints = new int[n];
            for (int j = 0; j < n; j++) {
                ints[j] = temp % 2;
                temp /= 2;
            }

            for (int[] point :list) {
                if(ints[point[0]]==0 && ints[point[1]]==0){
                    res--;
                    break;
                }
            }

        }
        return res;
    }
}
