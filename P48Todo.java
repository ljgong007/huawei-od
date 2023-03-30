package Huawei2023.second.fuxi_advP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/29 17:48
 */
public class P48Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] positions = new double[n][2];
        for (int i = 0; i < n; i++) {
            positions[i][0] = scanner.nextInt();
            positions[i][1] = scanner.nextInt();
        }

    }

    public static int solution(int n, double[][] positions){
        List<Double> temp = new ArrayList<>();
        for (double[] pos : positions) {
            temp.add(pos[0]);
            temp.add(pos[1]);
        }
        temp.sort(Double::compareTo);
        return 0;

    }

}

/*
16
41 67
0 34
24 69
58 78
62 64
5 45
27 81
61 91
42 95
27 36
4 91
2 53
82 92
16 21
18 95
26 47
 */


/*
3
9999984 10000000
-500000 50000000
-800000 -600000
 */

