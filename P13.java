package Huawei2023.second.fuxi_advP;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 15:06
 */
public class P13 {
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
        int[] highBits = new int[60];
        for (int i :nums) {
            String str = Integer.toBinaryString(i);
            int len = str.length();

            if("0".equals(str)){
                highBits[0]++;
            }else{
                highBits[len]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                ans += highBits[i] * highBits[j];
            }
        }

        return ans;

    }
}
