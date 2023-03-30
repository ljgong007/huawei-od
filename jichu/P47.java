package Huawei2023.second.jichu;

import java.util.*;
import java.util.logging.Handler;

/**
 * @author liujie gong
 * @date 2023/3/26 1:37
 */
public class P47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        System.out.println(solution(strings));
    }

    public static String solution(String[] strings){
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sortStr(strings[i]);
        }
        Map<String, Integer> count = new HashMap<>();
        for (String s :strings) {
            count.put(s, count.getOrDefault(s, 0)+1);
        }

        Arrays.sort(strings, (a,b) -> !count.get(a).equals(count.get(b)) ?
                count.get(b) - count.get(a) :
                (a.length()!=b.length() ? a.length() - b.length() : a.compareTo(b)));

        StringJoiner sj = new StringJoiner(" ");
        for (String s : strings) {
            sj.add(s);
        }

        return sj.toString();
    }

    public static String sortStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}

/*
This is an apple    ->     an is This aelpp
 */


/*
My sister is in the house not in the yard    ->     in in eht eht My is not adry ehosu eirsst
 */
