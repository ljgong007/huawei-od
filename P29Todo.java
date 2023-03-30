package Huawei2023.second.fuxi_advP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 12:07
 */
public class P29Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        System.out.println(solution(arr));
    }

    public static String solution(String[] arr){
        Arrays.sort(arr, (a,b) -> (a+b).compareTo(b+a));
        if(arr[0].startsWith("0")){
            for (int i = 1; i < arr.length; i++) {
                if(!arr[i].startsWith("0")){
                    arr[0] = arr[i] +arr[0];
                    arr[i] = "";
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s :arr) {
            sb.append(s);
        }
        String res = sb.toString().replaceAll("^0+", "");

        return "".equals(res) ? "0" : res;
    }
}
