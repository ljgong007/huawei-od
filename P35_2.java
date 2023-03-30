package Huawei2023.second.fuxi_advP;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/30 20:02
 */
public class P35_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] nodes = new int[n][];
        for (int i = 0; i < n; i++) {
            nodes[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(solution(n, nodes, x, y));
    }

    public static String solution(int n, int[][] nodes, int x, int y){
        if(x<0 || y<0) return "{}";
        List<Integer> res = new ArrayList<>();
        calc(nodes, 0, x, res);
        if(res.size()<=y){
            return "{}";
        }

        return "{" + res.get(y) + "}";

    }

    public static void calc(int[][] nodes, int index, int n, List<Integer> res){
        int[] node = nodes[index];
        if(n==0){
            res.add(node[n]);
            return;
        }
        if(node.length==1){
            return;
        }

        for (int i = 1; i < node.length; i++) {
            calc(nodes, node[i], n-1, res);
        }
    }
}
