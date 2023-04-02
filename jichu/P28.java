package Huawei2023.second.jichu;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 15:36
 */
public class P28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();
        int k = sc.nextInt();

        System.out.println(getResult(s1, s2, k));
    }

    public static int getResult(String s1, String s2, int k) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n2 < n1 + k) return -1;

        int[] count = new int[128];

        for (int i = 0; i < n1; i++) {
            int c = s1.charAt(i);
            count[c]++;
        }

        int total = n1;

        int maxI = n2 - n1 - k;
        int len = n1 + k;

        for (int j = 0; j < len; j++) {
            int c = s2.charAt(j);

            if (count[c]-- > 0) {
                total--;
            }

            if (total == 0) {
                return 0;
            }
        }

        for (int i = 1; i <= maxI; i++) {
            int remove = s2.charAt(i - 1);
            int add = s2.charAt(i - 1 + len);

            if (count[remove]++ >= 0) {
                total++;
            }

            if (count[add]-- > 0) {
                total--;
            }

            if (total == 0) {
                return i;
            }
        }
        return -1;
    }
}
