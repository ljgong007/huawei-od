package Huawei2023.second.jichu;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/26 3:27
 */
public class P49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int days = scanner.nextInt();
        int[] item = new int[number];
        for (int i = 0; i < number; i++) {
            item[i] = scanner.nextInt();
        }

        int[][] item_price = new int[number][days];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                item_price[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(item, item_price, number, days));
    }

    public static int solution(int[] item, int[][] item_price, int number, int days){
        int ans = 0;
        for (int i = 0; i < number; i++) {
            int[] price = item_price[i];
            for (int j = 0; j < days-1; j++) {
                if(price[j] < price[j+1]){
                    ans += (price[j+1] - price[j]) * item[i];
                }
            }
        }

        return ans;
    }
}
