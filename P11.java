package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 14:00
 */
public class P11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        Integer[] nums = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(nums, m));
    }

    public static String solution(Integer[] nums, int m){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length-m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < i+m; j++) {
                min = Math.min(min, nums[j]);
            }
            ans.add(min);
        }
        StringJoiner sj = new StringJoiner(",");
        for (Integer i : ans) {
            sj.add(i+"");
        }
        return sj.toString();


    }
}
