package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/23 19:45
 */
public class P8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] newspaper = scanner.nextLine().split(" ");
        String[] anonymousLetter = scanner.nextLine().split(" ");
        System.out.println(solution(newspaper, anonymousLetter));
    }

    public static boolean solution(String[] newspaper, String[] anonymousLetter){
        Map<String, Integer> newsMap = new HashMap<>();
        for (int i = 0; i < newspaper.length; i++) {
            String temp = sortString(newspaper[i]);
            newsMap.put(temp, newsMap.getOrDefault(temp, 0)+1);
        }

        for (int i = 0; i < anonymousLetter.length; i++) {
            String sorted = sortString(anonymousLetter[i]);
            if(newsMap.containsKey(sorted) && newsMap.get(sorted)>0){
                newsMap.put(sorted, newsMap.get(sorted)-1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
