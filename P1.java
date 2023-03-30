package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/21 11:07
 */
public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        int ans = digitSearch(R) - digitSearch(L-1);
        System.out.println(ans);
    }

    public static int digitSearch(int num){
        String str = Integer.toBinaryString(num);
        Integer[] arr = Arrays.stream(str.split("")).map(Integer::parseInt).toArray(Integer[]::new);
        int[][][] f = new int[str.length()][2][2];
        return dfs(0, f, arr, true, 0, 0);
    }

    public static int dfs(int p,int[][][] f, Integer[] arr, boolean limit, int pre, int prePre){
        if(p==arr.length){
            return 1;
        }
        if(!limit && f[p][pre][prePre]!=0) return f[p][pre][prePre];
        int up = limit ? arr[p] : 1;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            if(i==1 && pre==0 && prePre==1) continue;
            ans += dfs(p+1, f, arr, limit&&i==up, i, pre);
        }
        if(!limit) f[p][pre][prePre] = ans;

        return ans;
    }
}
