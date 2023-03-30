package Huawei2023.second.jichu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liujie gong
 * @date 2023/3/23 20:45
 */
public class P9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        if (M < 1 || M > 10) {
            System.out.println("[[]]");
            return;
        }
        scanner.nextLine();
        List<TreeSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            List<Integer> tmp = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            if (tmp.size() < 1 || tmp.size() > 100) {
                System.out.println("[[]]");
                return;
            }
            list.add(new TreeSet<>(tmp));
        }
        System.out.println(solution(list, M));

    }

    public static String solution(List<TreeSet<Integer>> list, int M) {
        outer:
        while (true) {
            for (int i = M - 1; i >= 0; i--) {
                TreeSet<Integer> set1 = list.get(i);
                if (set1.size() <2) continue;
                for (int j = i - 1; j >= 0; j--) {
                    TreeSet<Integer> set2 = list.get(j);
                    if (set2.size() <2) continue;

                    if (hasTwoSameNumber(set1, set2)) {
                        set2.addAll(set1);
                        set1.clear();
                        continue outer;
                    }
                }
            }
            break;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeSet<Integer> set : list) {
            if (set.size() > 0) {
                ans.add(new ArrayList<>(set));
            }
        }

        return ans.toString();
    }

    public static boolean hasTwoSameNumber(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        for (Integer i : set1) {
            if (set2.contains(i)) {
                count++;
            }
            if (count >= 2) return true;
        }
        return false;
    }
}


/*
6
10
3,6,9,2
6,3,4
4,2,1
9
8            ->       [[10], [1, 2, 3, 4, 6, 9], [9], [8]]
 */


/*
3
2,3,1
4,3,2
5          ->    [[1, 2, 3, 4], [5]]
 */
