package Huawei2023.second.fuxi_advP;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 14:25
 */
public class P32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println(solution(m, n, x));
    }

    public static int solution(int m, int n, int x) {
        dfs(m, n, 0, 0, x, 0);
        return ans;
    }
    public static int ans = Integer.MAX_VALUE;

    public static void dfs(int sheep, int wolf, int oppoSheep, int oppoWolf, int x, int count) {
        if (sheep == 0 && wolf == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if(sheep+wolf<=x){
            ans = Math.min(ans, count+1);
            return;
        }

        for (int i = 0; i <= x; i++) {  // 假设i为运送几只羊
            if (sheep - i > 0 && wolf - (x - i) > 0 && sheep - i <= wolf - (x - i)) continue;
            if (oppoSheep + i > 0 && oppoWolf + (x - i) > 0 && oppoSheep + i <= oppoWolf + (x - i)) continue;
            dfs(sheep - i, wolf - (x - i), oppoSheep + i, oppoWolf + (x - i), x, count+1);
        }

    }
}
