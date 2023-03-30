package Huawei2023.second.jichu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 23:27
 */
public class P14_BigInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(array));
    }

    public static int solution(Integer[] array){
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 0; i < array.length; i++) {
            fact = fact.multiply(BigInteger.valueOf(array[i]));
        }

        BigInteger left = BigInteger.valueOf(1);
        BigInteger right = fact.divide(BigInteger.valueOf(array[0]));
        if(left.compareTo(right)==0){
            return 0;
        }

        for (int i = 1; i < array.length; i++) {
            left = left.multiply(BigInteger.valueOf(array[i-1]));
            right = right.divide(BigInteger.valueOf(array[i]));

            if(left.compareTo(right)==0) return i;
        }

        return -1;
    }
}
