package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/23 23:41
 */
public class P15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer max = Collections.max(map.values());
        int minLen = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                int l = list.indexOf(key);
                int r = list.lastIndexOf(key);
                if (r - l < minLen) {
                    minLen = r - l + 1;
                }
            }
        }

        System.out.println(minLen);
    }
}

/*
5
1 2 2 4 1

7
1 2 2 4 2 1 1
 */
