package Huawei2023.second.fuxi_advP;

import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/27 15:20
 */
public class P14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        solution(m, n, str);
    }

    public static void solution(int m, int n, String str){

        int[] used = new int[n];
        int need = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='A'){
                need = 1;
            }else if(c=='B'){
                need = 2;
            }else if(c=='C'){
                need = 8;
            }
            for (int j = 0; j < n; j++) {
                if(m-need>=used[j]){
                    used[j] += need;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if(j<used[i]){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }
            System.out.println(sb.toString());
        }


    }
}
