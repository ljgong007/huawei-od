package Huawei2023.second.jichu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author liujie gong
 * @date 2023/3/25 2:40
 */
public class P35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        System.out.println(solution(prices, n, k, x));
    }

    public static String solution(int[] prices, int n, int k, int x) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(prices[i] - x);
            list.add(new Integer[]{prices[i], diff});
        }

        list.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i)[0]);
        }

        ans.sort((a, b) -> a - b);
        StringJoiner sj = new StringJoiner(" ");
        for (Integer i : ans) {
            sj.add(i + "");
        }
        return sj.toString();
    }
}

/*
10 5 6
1 2 3 4 5 6 7 8 9 10     >   4 5 6 7 8
 */


/*
10 4 6
10 9 8 7 6 5 4 3 2 1     >   4 5 6 7
 */




