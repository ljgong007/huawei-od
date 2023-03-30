package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 3:28
 */
public class P36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solution(nums,n));
    }

    public static int solution(int[] nums, int n){
        if(n==1){
            return nums[0];
        }
        Arrays.sort(nums);

        if(n%2==0){
            return nums[n/2-1];
        }else{
            return nums[n/2];
        }
    }
}
