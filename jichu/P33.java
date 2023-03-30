package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/25 2:34
 */
public class P33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        Map<Integer, LinkedList<Integer>> idx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idx.putIfAbsent(arr[i], new LinkedList<>());
            idx.get(arr[i]).add(i);
        }

        int ans = -1;

        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = idx.get(arr[i]);
            if(list.size()>1){
                int diff = list.getLast() - list.getFirst();
                ans = Math.max(ans, diff);
            }
        }

        return ans;
    }
}


/*
5
1
2
3
1
4    ->  3
 */


/*
2
1
2    ->  -1
 */
