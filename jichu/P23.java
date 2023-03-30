package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author liujie gong
 * @date 2023/3/24 15:06
 */
public class P23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Integer[] array = Arrays.stream(input.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int taskA = array[0];
        int taskB = array[1];
        int num = array[2];
        System.out.println(solution(taskA, taskB, num));
    }

    public static String solution(int taskA, int taskB, int num){
        if(num==0) return "[]";
        if(taskA==taskB) return Arrays.toString(new int[]{taskA*num});

        Set<Integer> ans = new TreeSet<>();
        for (int i = 0; i <= num; i++) {
            int temp = taskA * i + taskB * (num-i);
            ans.add(temp);
        }

        return ans.toString();
    }
}

/*
1,2,3     ->  [3, 4, 5, 6]
 */
