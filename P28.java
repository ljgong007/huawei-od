package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/28 11:56
 */
public class P28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        Integer[] arr = Arrays.stream(scanner.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        solution(amount, arr);
    }

    public static void solution(int amount, Integer[] arr){
        LinkedList<Integer> track = new LinkedList<>();
        List<LinkedList<Integer>> res = new ArrayList<>();
        dfs(track, res,0, amount, arr, 0);
        System.out.println(res);
    }

    public static void dfs(LinkedList<Integer> track, List<LinkedList<Integer>> res, int start, int amount, Integer[] arr, int sum){
        if(sum==amount){
            res.add(new LinkedList<>(track));
            return;
        }
        if(sum>amount){
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if(sum+arr[i]>amount) continue;
            track.add(arr[i]);
            dfs(track, res,i, amount, arr, sum+arr[i]);
            track.removeLast();
        }
    }
}
