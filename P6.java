package Huawei2023.second.fuxi_advP;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author liujie gong
 * @date 2023/3/27 2:31
 */
public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, arr));
    }

    public static String solution(int n, int[] arr){
        int[] rewards = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] < arr[j]){
                    rewards[i] = (j-i) * (arr[j] - arr[i]);
                    break;
                }
            }
            if(rewards[i]==0) rewards[i] = arr[i];
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i :rewards) {
            sj.add(i+"");
        }
        return sj.toString();

    }
}
