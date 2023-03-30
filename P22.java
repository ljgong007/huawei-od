package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 23:20
 */
public class P22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        Integer[] arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(m, arr));
    }

    public static int solution(int m, Integer[] arr){
        int l = 0, r = 0;
        int sum = 0, max = 0;
        while (r< arr.length){
            int newSum = sum + arr[r];

            if(newSum>m){
                sum -= arr[l];
                l++;
            }else if(newSum<m){
                sum += arr[r];
                r++;
            }else{
                return m;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
