package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 23:32
 */
public class P23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();
        int relationsNum = scanner.nextInt();
        int[][] relations = new int[relationsNum][2];
        for (int i = 0; i < relationsNum; i++) {
            relations[i][0] = scanner.nextInt();
            relations[i][1] = scanner.nextInt();
        }

    }

    public static int solution(int taskNum, int relationsNum, int[][] relations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[taskNum];

        for (int i = 0; i < relationsNum; i++) {
            int[] temp = relations[i];
            map.putIfAbsent(temp[0], new ArrayList<>());
            map.get(temp[0]).add(temp[1]);
            indegree[temp[1]]++;
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        int t = 1;

        for (int i = 0; i < taskNum; i++) {
            if (indegree[i] == 0) {
                queue.add(new Integer[]{i, t});
            }
        }

        while (queue.size()>0){
            Integer[] tmp = queue.removeFirst();
            int task = tmp[0];
            int time = tmp[1];

            if(map.containsKey(task) && map.get(task).size()>0){
                for (Integer in : map.get(task)) {
                    if(--indegree[in]==0){
                        t = time+1;
                        queue.add(new Integer[]{in, time+1});
                    }
                }

            }
        }

        return t;

    }
}
