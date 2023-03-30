package Huawei2023.second.jichu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/24 20:22
 */
public class P26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stings = scanner.nextLine().split(" ");
        solution(stings);
    }

    public static void solution(String[] strings){
        String str = strings[0];
        int n = Integer.parseInt(strings[1]);
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Character>());
        }
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int sign = (i/n) % 2;
            if(sign==0){
                list.get(i%n).add(c);
            }else{
                list.get(n-1-i%n).add(c);
            }
        }

        for (List<Character> chars :list) {
            StringBuilder sb = new StringBuilder();
            for (Character c :chars) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }
}

/*
ABCDEFG 3


AFG
BE
CD
 */
