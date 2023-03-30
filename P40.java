package Huawei2023.second.fuxi_advP;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author liujie gong
 * @date 2023/3/28 23:59
 */
public class P40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='{'){
                stack.push("{");
            }else if(c=='}'){
                if(Character.isDigit(str.charAt(i+1))){
                    int p = i+1;
                    while (p<str.length() && Character.isDigit(str.charAt(p))) p++;
                    int num = Integer.parseInt(str.substring(i+1, p));
                    StringBuilder sbtemp = new StringBuilder();
                    while (!stack.peek().equals("{")){
                        sbtemp.append(stack.pop());
                    }
                    stack.pop();
                    String s = repeat(sbtemp.toString(), num);
                    stack.push(s);
                    i = p-1;
                }
            }else if(Character.isAlphabetic(c)){
                if(Character.isDigit(str.charAt(i+1))){
                    int p = i+1;
                    while (p<str.length() && Character.isDigit(str.charAt(p))) p++;
                    int num = Integer.parseInt(str.substring(i+1, p));
                    stack.push(repeat(c+"", num));
                    i=p-1;
                }else{
                    stack.push(c+"");
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

    public static String repeat(String str, int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}


/*
{{A3B1}5C2D2{E}2{FM}2}2
AAABAAABAAABAAABAAABCCDDEEFMFMAAABAAABAAABAAABAAABCCDDEEFMFM
 */
