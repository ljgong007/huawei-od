package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 23:07
 */
public class P14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Integer[] nums = Arrays.stream(input.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(nums));
    }

    public static int solution(Integer[] nums){
        int len = nums.length;

        int[] leftMultis = new int[len];
        leftMultis[0] = 1;
        int temp = 1;
        for (int i = 1; i < len; i++) {
            temp *= nums[i-1];
            leftMultis[i] = temp;
        }

        int[] rightMultis = new int[len];
        rightMultis[len-1] = 1;
        temp = 1;
        for (int i = len-2; i >=0 ; i--) {
            temp *= nums[i+1];
            rightMultis[i] = temp;
        }
        int ans = -1;
        for (int i = 0; i < len; i++) {
            if(leftMultis[i]==rightMultis[i]){
                ans = i;
                break;
            }
        }

        return ans;
    }
}
