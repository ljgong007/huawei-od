package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 2:08
 */
public class P32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr, m));
    }

    public static int solution(int[] arr, int m){
        Arrays.sort(arr);

        int i = 0, j = arr.length-1;
        int count = 0;
        while (i<j){
            if(arr[i]+arr[j]<=m) i++;
            j--;
            count++;
        }

        if(i==j) count++;
        return count;
    }
}
