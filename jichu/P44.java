package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/26 0:15
 */
public class P44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(array));
    }

    public static int solution(Integer[] array){
        Map<Integer, Integer> left = new HashMap<>();
        int friendship = 0;
        for (int i = 0; i < array.length; i++) {
            switch (array[i]){
                case 0:
                    left.put(i, friendship);
                    friendship = 0;
                    break;
                case 1:
                    friendship++;
                    break;
                case 2:
                    friendship = 0;
                    break;
            }
        }

        int ans = 0;
        friendship = 0;
        for (int i = array.length-1; i >=0 ; i--) {
            switch (array[i]){
                case 0:
                    ans = Math.max(ans, left.get(i) + friendship);
                    friendship = 0;
                    break;
                case 1:
                    friendship++;
                    break;
                case 2:
                    friendship = 0;

                    break;
            }
        }
        return ans;
    }
}
