package Huawei2023.second.fuxi_advP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 3:02
 */
public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        String str = scanner.next();
        System.out.println(solution(c, str));
    }

    public static int solution(char c, String str) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        int l = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (c == temp) {
                map.clear();
                l++;
                continue;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            while (map.get(temp)==3){
                char rm = str.charAt(l);
                l++;
                map.put(rm, map.get(rm)-1);
            }
            ans = Math.max(ans, i-l+1);
        }
        return ans;
    }
}
