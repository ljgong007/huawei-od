package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 22:27
 */
public class P12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer[] nums = Arrays.stream(str.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
            else if (nums[i] > 255) nums[i] = 255;
            sum += nums[i];
        }
        System.out.println(solution(nums, sum));
    }

    public static int solution(Integer[] nums, int sum) {
        int minDiff = Integer.MAX_VALUE;
        Integer ans = null;
        int len = nums.length;
        for (int k = -127; k <= 128; k++) {
            int temp = sum + len * k;

            int diff = Math.abs(temp - len * 128);
            if(diff<minDiff){
                minDiff = diff;
                ans = k;
            }else if(diff==minDiff && ans!=null){
                ans = Math.min(ans, k);
            }
        }
        return ans;
    }
}
