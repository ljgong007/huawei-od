package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 14:26
 */
public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] woods = new int[n];
        for (int i = 0; i < n; i++) {
            woods[i] = scanner.nextInt();
        }

        System.out.println(solution(woods, n, m));
    }

    public static int solution(int[] woods, int n, int m){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(woods[i]);
        }

        while (m>0){
            Integer top = queue.poll();
            top++;
            m--;
            queue.add(top);
        }
        return queue.peek();
    }
}
