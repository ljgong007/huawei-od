package Huawei2023.second.jichu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/26 1:49
 */
public class P48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            link.add(scanner.nextInt());
        }
        System.out.println(solution(link, t));
    }

    public static int solution(LinkedList<Integer> link, int t) {
        link.sort((a, b) -> b - a);

        int sum = 0;
        for (Integer i : link) {
            sum += i;
        }

        while (t > 0) {
            LinkedList<Integer> link_cp = new LinkedList<>(link);
            if (canPartition(link_cp, sum, t)) return sum / t;
            t--;
        }
        return sum;
    }

    public static boolean canPartition(LinkedList<Integer> link, int sum, int t) {
        if (sum % t != 0) return false;
        int subSum = sum / t;
        if (subSum < link.get(0)) return false;

        while (link.size() > 0 && link.get(0) == subSum) {
            link.removeFirst();
            t--;
        }

        int[] buckets = new int[t];
        return partition(link, 0, buckets, subSum);
    }

    public static boolean partition(LinkedList<Integer> list, int index, int[] buckets, int subSum) {
        if (index == list.size()) return true;

        int selected = list.get(index);
        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (selected + buckets[i] <= subSum) {
                buckets[i] += selected;
                if (partition(list, index + 1, buckets, subSum)) return true;
                buckets[i] -= selected;
            }
        }
        return false;
    }
}
