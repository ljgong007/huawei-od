package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 2:13
 */
public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solution(n, nums));
    }
    
    public static int solution(int n, int[] nums){
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new Integer[]{i, j});
            }
        }

        int max = 1;
        for (Integer key : map.keySet()) {
            List<Integer[]> list = map.get(key);
            list.sort((a,b) -> a[1] - b[1]);
            int t = list.get(0)[1];
            int count = 1;
            for (int i = 1; i < list.size(); i++) {
                int l = list.get(i)[0];
                int r = list.get(i)[1];
                if(l>t){
                    t = r;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;

    }
}
