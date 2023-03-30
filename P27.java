package Huawei2023.second.fuxi_advP;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 1:50
 */
public class P27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        int total = str.length();
        int A = str.replaceAll("B", "").length();

        if (A == total || A == 0) return 0;
        int ans = Math.min(total - A, A);
        int leftA = 0;
        for (int i = 0; i < total; i++) {
            if (str.charAt(i) == 'A') leftA++;
            ans = Math.min(i + 1 - leftA + A - leftA, ans);
        }

        return ans;
    }
}
