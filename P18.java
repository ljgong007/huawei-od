package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 19:18
 */
public class P18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[][] want = new String[m][];
        String[][] cant = new String[n][];
        for (int i = 0; i < m; i++) {
            want[i] = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < n; i++) {
            cant[i] = scanner.nextLine().split(" ");
        }
        System.out.println(solution(want, cant, m, n));
    }

    public static String solution(String[][] want, String[][] cant, int m, int n){
        Map<String, List<String>> wantMap = new HashMap<>();
        Map<String, List<String>> cantMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String path = want[i][1] + "-" + want[i][2];
            wantMap.putIfAbsent(path, new ArrayList<>());
            wantMap.get(path).add(want[i][0]);
        }

        for (int i = 0; i < n; i++) {
            String[] temp = cant[i];
            String path = temp[0] + "-" + temp[1];
            cantMap.putIfAbsent(path, new ArrayList<>());
            for (int j = 2; j < temp.length; j++) {
                cantMap.get(path).add(temp[j]);
            }

        }
        if(cantMap.size()==0) return "null";

        List<String> ans = new ArrayList<>();
        for (String s : cantMap.keySet()) {
            if(wantMap.containsKey(s)){
                List<String> list1 = wantMap.get(s);
                List<String> list2 = cantMap.get(s);
                for (String s1 : list2) {
                    if(list1.contains(s1)){
                        ans.add(s1);
                    }
                }

            }
        }
        ans.sort((a,b) -> a.compareTo(b));
        StringJoiner sj = new StringJoiner(" ");
        for (String s : ans) {
            sj.add(s);
        }

        return sj.toString();
    }
}
