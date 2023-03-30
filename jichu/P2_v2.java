package Huawei2023.second.jichu;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * @author liujie gong
 * @date 2023/3/23 15:05
 */
public class P2_v2 {
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

    public static int solution(int[] woods, int n, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(woods[i], map.getOrDefault(woods[i], 0) + 1);
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Integer key : map.keySet()) {
            queue.add(new Integer[]{key, map.get(key)});
        }

        while (m>0){
            if(queue.size()==1){
                Integer len = queue.peek()[0];
                Integer count = queue.peek()[1];
                return len + m / count;
            }

            Integer[] min1 = queue.poll();
            Integer[] min2 = queue.peek();

            int diff = min2[0] - min1[0];
            int total = diff * min1[1];

            if(total>m){
                return min1[0] + m/min1[1];
            }else if(total==m){
                return min2[0];
            }else{
                m -= total;
                min2[1] += min1[1];
            }
        }

        return queue.peek()[0];
    }
}
