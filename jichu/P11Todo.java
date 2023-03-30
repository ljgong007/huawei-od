package Huawei2023.second.jichu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 21:38
 */
public class P11Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

    }

    public static int solution(String str){
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }

        int avg = str.length() / 4;
        int total = 0;
        boolean flag = true;
        for (Character c : count.keySet()) {
            if(count.get(c)>avg){
                flag = false;
                count.put(c, count.get(c)-avg);
                total += count.get(c);
            }else{
                count.put(c, 0);
            }
        }

        if(flag) return 0;

        int i = 0;
        int j = 0;
        int minLen = str.length()-1;
        while (j<str.length()){
            Character ch = str.charAt(j);
            if(count.get(ch)>0){
                total--;
            }
            count.put(ch, count.get(ch)-1);


        }


        return 0;

    }
}
