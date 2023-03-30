package Huawei2023.second.jichu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author liujie gong
 * @date 2023/3/23 15:36
 */
public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(solution(text));
    }

    public static String solution(String text){
        String[] strings = text.split(" ");   // yM eman si boB.    // woh era uoy ? I ma enif.
        for (int i = 0; i < strings.length; i++) {
            char c0 = strings[i].charAt(0);
            if(Character.isAlphabetic(c0)){
                if(strings[i].contains(".") || strings[i].contains("?") || strings[i].contains(",")){
                    String temp = strings[i];
                    StringBuilder sb = new StringBuilder(temp.substring(0, temp.length()-1));
                    strings[i] = sb.reverse().append(temp.charAt(temp.length()-1)).toString();
                }else{
                    strings[i] = new StringBuilder(strings[i]).reverse().toString();
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (String s :strings) {
            sj.add(s);
        }

        return sj.toString();
    }
}
