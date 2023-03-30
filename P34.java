package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liujie gong
 * @date 2023/3/30 16:38
 */
public class P34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int[] s1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(nums));
    }

    public static String solution(Integer[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i + 1]);
        }

        Set<Integer> lineSet = new HashSet<>();
        int[] lines = new int[n];
        for (int i = 1; i < n-1; i++) {
            int water = Math.max(0, Math.min(left[i], right[i]) - nums[i]);

            if (water != 0) {
                lines[i] = water + nums[i];
                lineSet.add(lines[i]);
            }
        }

        int[] ans = {0, 0, 0};

        for (Integer line : lineSet) {
            int l = 0, r = n - 1;

            while (lines[l] < line || nums[l] >= line) {
                l++;
            }

            while (lines[r] < line || nums[r] >= line) {
                r--;
            }
            int sum = 0;
            for (int i = l; i <= r; i++) {
                sum += Math.max(0, line - nums[i]);
            }

            if (sum > ans[2]) {
                ans[0] = l - 1;
                ans[1] = r + 1;
                ans[2] = sum;
            } else if (sum == ans[2]) {
                int curDis = r - l + 1;
                int midDis = ans[1] - ans[0] - 1;
                if (curDis < midDis) {
                    ans[0] = l - 1;
                    ans[1] = r + 1;
                }
            }
        }
        if (ans[2] == 0) return "0";

        return ans[0] + " " + ans[1] + ":" + ans[2];

    }
}
