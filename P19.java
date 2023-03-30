package Huawei2023.second.fuxi_advP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 19:48
 */
public class P19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, nums));
    }

    public static int solution(int n, int k, int[] nums){

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while (l<n && r<n){
            Integer c = nums[r];
            map.put(c, map.getOrDefault(c, 0)+1);

            if(map.get(c)>=k){
                ans += n -r;

                map.put(nums[l], map.get(nums[l])-1);
                l++;
                map.put(c, map.get(c)-1);
                r--;
            }
            r++;
        }

        return ans;
    }
}
