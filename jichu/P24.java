package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/24 15:13
 */
public class P24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] nums = new int[row][col];
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nums[i][j] = scanner.nextInt();
                map.putIfAbsent(nums[i][j], new ArrayList<>());
                map.get(nums[i][j]).add(new Integer[]{i, j});
            }
        }

        Integer[][] ans = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map.get(nums[i][j]).size() == 1) {
                    ans[i][j] = -1;
                } else {
                    List<Integer[]> list = map.get(nums[i][j]);
                    int minDiff = Integer.MAX_VALUE;
                    for (Integer[] ints : list) {
                        if (ints[0] == i && ints[1] == j) continue;
                        int diff = Math.abs(i - ints[0]) + Math.abs(j - ints[1]);
                        minDiff = Math.min(minDiff, diff);
                    }
                    ans[i][j] = minDiff;
                }
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(ans).map(Arrays::toString).toArray(String[]::new)));
    }
}

/*
3
5
0 3 5 4 2
2 5 7 8 3
2 5 4 2 4
 */
