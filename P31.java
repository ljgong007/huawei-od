package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/28 14:17
 */
public class P31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            listA.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            listB.add(scanner.nextInt());
        }
        System.out.println(solution(m,n, listA, listB));
    }

    public static int solution(int m, int n, List<Integer> listA, List<Integer> listB){
        Set<Integer> setA = new HashSet<>(listA);
        Set<Integer> setB = new HashSet<>(listB);

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (Integer i : listA) {
            if(setB.contains(i)){
                mapA.put(i, mapA.getOrDefault(i, 0)+1);
            }
        }
        for (Integer i :listB) {
            if(setA.contains(i)){
                mapB.put(i, mapB.getOrDefault(i, 0)+1);
            }
        }

        int ans = 0;
        for (Integer i : mapA.keySet()) {
            ans += mapA.get(i) * mapB.get(i);
        }
        return ans;


    }
}
