package Huawei2023.second.fuxi_advP;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 18:39
 */
public class P17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static int solution(String str){
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='M'){
                if(i+1<str.length() && str.charAt(i+1)=='I'){
                    ans++;
                    i += 2;
                }else if(i-1>=0 && str.charAt(i-1)=='I'){
                    ans++;
                }else{
                    return -1;
                }
            }
        }
        return ans;
    }
}
