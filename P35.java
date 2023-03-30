package Huawei2023.second.fuxi_advP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 19:31
 */
public class P35 {
    public static List<Integer[]> nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        }
        int tx = scanner.nextInt();
        int ty = scanner.nextInt();
        System.out.println(solution(n, nodes, tx, ty));
    }

    public static String solution(int n, List<Integer[]> nodes, int tx, int ty) {
        if (tx < 0 || ty < 0) return "{}";
        Integer[] node = nodes.get(0);
        List<List<Integer>> matrix = new ArrayList<>();
        dfs(matrix, node, 0);
        if (tx < matrix.size() && ty < matrix.get(tx).size()) {
            return "{" + matrix.get(tx).get(ty) + "}";
        } else {
            return "{}";
        }
    }

    public static void dfs(List<List<Integer>> matrix, Integer[] node, int level) {
        if (node == null) return;
        int val = node[0];
        if (level < matrix.size()) {
            matrix.get(level).add(val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(val);
            matrix.add(list);
        }

        for (int i = 1; i < node.length; i++) {
            dfs(matrix, nodes.get(node[i]), level + 1);
        }
    }
}


/*
14
0 1 2 3 4
-11 5 6 7 8
113 9 10 11
24 12
35
66 13
77
88
99
101
102
103
25
104
2 5       ->    {102}
 */