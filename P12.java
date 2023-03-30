package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 14:25
 */
public class P12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] pos = scanner.nextLine().split(",");
        Integer[][] ranges = new Integer[pos.length][2];
        for (int i = 0; i < pos.length; i++) {
            Integer[] s = Arrays.stream(pos[i].split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            ranges[i][0] = s[0];
            ranges[i][1] = s[1];
        }
        solution(text, ranges);

    }

    public static void solution(String text, Integer[][] ranges){

        List<Integer> indexOfSpace = new ArrayList<>();
        String[] split = text.split("");
        boolean flag = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if( i+1<text.length() && c==' ' && text.charAt(i+1)==' ' && !flag ){
                indexOfSpace.add(i);
            }
            if(c=='\''){
                flag = !flag;
            }
        }

        for (int i = indexOfSpace.size()-1; i >=0 ; i--) {
            int del = indexOfSpace.get(i);
            split[del] = "";
            for (int j = 0; j < ranges.length; j++) {
                if(del < ranges[j][0]){
                    ranges[j][0]--;
                    ranges[j][1]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
        }
        System.out.println(sb.toString());

        StringBuilder sb2 = new StringBuilder();
        for (Integer[] ints :ranges) {
            sb2.append(Arrays.toString(ints));
        }
        System.out.println(sb2.toString());
    }
}

/*
Life is painting a        picture, not doing 'a  sum'.
8 15,26 32,49 51
->  Life is painting a picture, not doing 'a  sum'.
    [8, 15][19, 25][42, 44]
 */
