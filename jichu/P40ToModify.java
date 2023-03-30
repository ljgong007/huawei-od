package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/25 23:00
 */
public class P40ToModify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        String word = scanner.nextLine();
        System.out.println(solution(content, word));
    }

    public static int solution(String content, String word){
        if(word.length()>content.length()) return 0;
        String sortWord = sortStr(word);
        if(word.length()==content.length()){
            return sortStr(content).equals(sortWord) ? 1 : 0;
        }

        int len1 = word.length();
        int len2 = content.length();
        int count = 0;
        for (int i = 0; i < len2-len1; i++) {
            String tmp = content.substring(i, len1+i);
            if(sortWord.equals(sortStr(tmp))){
                count++;
            }
        }

        return count;
    }

    public static String sortStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = String.valueOf(chars);
        return sortedStr;
    }
}

/*
qweebaewqd
qwe   ->  2
 */
