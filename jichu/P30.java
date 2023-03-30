package Huawei2023.second.jichu;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 1:31
 */
public class P30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int time = Integer.parseInt(scanner.nextLine());
        System.out.println(solution(array, time));
    }

    public static int solution(Integer[] array, int time) {

        int l = 0;
        int r = l + time;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 0);
        count.put(1, 0);
        count.put(2, 0);

        int max = 0;

        for (int i = 0; i < Math.min(array.length, r); i++) {
            count.put(array[i], count.get(array[i]) + 1);
            max = Math.max(max, count.get(array[i]));
        }

        while (r < array.length) {
            Integer add = array[r++];
            Integer remove = array[l++];

            count.put(remove, count.get(remove) - 1);
            count.put(add, count.get(add) + 1);

            max = Math.max(max, count.get(add));
        }

        return max;
    }
}
