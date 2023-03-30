package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/25 0:49
 */
public class P29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        System.out.println(solution(strA, strB));
    }

    public static int solution(String strA, String strB){
        Map<Character, Integer> idxs = new HashMap<>();
        for (int i = 0; i < strB.length(); i++) {
            idxs.put(strB.charAt(i), i);
        }

        int[] count = new int[strB.length()];
        for (int i = 0; i < strA.length(); i++) {
            char c = strA.charAt(i);
            if (idxs.containsKey(c)){
                Integer idx = idxs.get(c);
                if (idx==0 || count[idx] < count[idx-1]){
                    count[idx]++;
                }
            }
        }
        return count[count.length-1];
    }
}
