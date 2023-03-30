package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 23:16
 */
public class P41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
        Integer[] f = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] s = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(f, s, M));
    }

    public static int solution(Integer[] f, Integer[] s, int M) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        for (int i = 0; i < f.length; i++) {
            int fid = f[i];
            count.put(fid, count.getOrDefault(fid, 0) + 1);
            size.putIfAbsent(fid, s[i]);
        }

        int ans = 0;
        for (Integer id : count.keySet()) {
            ans += Math.min(size.get(id) * count.get(id), size.get(id) + M);
        }

        return ans;
    }
}

/*
5
1 2 2 1 2 3 4
1 1 1 1 1 1 1     ->   7
 */

/*
5
2 2 2 2 2 5 2 2 2
3 3 3 3 3 1 3 3 3   ->   9
 */
