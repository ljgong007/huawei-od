package Huawei2023.second.jichu;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 17:38
 */
public class P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long[][] arr = new long[T][2];
        for (int i = 0; i < T; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < T; i++) {
            System.out.println(solution(arr[i][0], arr[i][1]));
        }
    }

    public static String solution(long n, long k){
        if(n==1){
            return "red";
        }

        if(n==2){
            if(k==0) return "blue";
            else return "red";
        }

        long half = 1l << (n-2);
        if(k>half){
            return solution(n-1, k-half);
        }else{
            return solution(n-1, k).equals("red") ? "blue" : "red";
        }
    }
}

/*
5
1 0
2 1
3 2
4 6
5 8
 */
