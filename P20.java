package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 20:22
 */
public class P20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int m = Integer.parseInt(scanner.nextLine());
        //Integer min = Arrays.stream(array).min((a,b) -> a-b).get();
        Arrays.sort(array);
        System.out.println(dfs(array, 0, m));
    }

    public static int sum = 0;

    public static int dfs(Integer[] array, int index, int k) {
        if (sum == k) {
            return 1;
        }
        if(sum<k && k-sum<array[0]){
            return 1;
        }


        int count = 0;
        for (int i = index; i < array.length; i++) {
            if(array[i] + sum > k) continue;
            sum += array[i];
            count += dfs(array, i, k);
            sum -= array[i];
        }
        return count;
    }
}
