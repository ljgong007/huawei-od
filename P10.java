package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 13:44
 */
public class P10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str){
        Map<Character, Integer> unused = new HashMap<>();
        Map<Character, Integer> reserve = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            unused.put(c, unused.getOrDefault(c, 0)+1);
            reserve.putIfAbsent(c, 0);
        }

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(reserve.get(c)==2){
                unused.put(c, unused.get(c)-1);
                continue;
            }

            while (stack.size()>0){
                Character top = stack.getLast();
                if(top<c && unused.get(top) + reserve.get(top) >=3){
                    stack.removeLast();
                    reserve.put(top, reserve.get(top)-1);
                }else {
                    break;
                }
            }
            stack.add(c);
            unused.put(c, unused.get(c)-1);
            reserve.put(c, reserve.get(c)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c :stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
