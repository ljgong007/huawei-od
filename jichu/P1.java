package Huawei2023.second.jichu;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/23 14:04
 */
public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(",");
        String[] dists = scanner.nextLine().split(",");
        System.out.println(solution(words, dists));
    }

    public static String solution(String[] words, String[] dists){
        List<String> newDists = new ArrayList<>();
        for (int i = 0; i < dists.length; i++) {
            newDists.add(getUnrepeatedAndSortedString(dists[i]));
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String newWords = getUnrepeatedAndSortedString(words[i]);
            if(newDists.contains(newWords)){
                int i1 = newDists.indexOf(newWords);
                ans.add(dists[i1]);
            }else{
                ans.add("not found");
            }
        }

        StringJoiner sj = new StringJoiner(",");
        for (String s :ans) {
            sj.add(s);
        }

        return sj.toString();
    }

    public static String getUnrepeatedAndSortedString(String str){
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char c :chars) {
            set.add(c);
        }

        return set.toString();
    }
}


/*
conection,fly
connection,today


conection
connection,today
 */


