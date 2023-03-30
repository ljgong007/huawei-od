package Huawei2023.second.fuxi_advP;

import javafx.scene.transform.Scale;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/29 0:00
 */
public class P41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer[]> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        }
        System.out.println(solution(n, tasks));
    }

    public static int solution(int n, List<Integer[]> tasks){
        tasks.sort((a,b) -> a[0]-b[0]);
        LinkedList<Integer[]> queue = new LinkedList<>();
        int sum = 0, max = 0;
        for (Integer[] ints :tasks) {
            int s = ints[0];
            int e = ints[1];
            int p = ints[2];

            while (queue.size()>0){
                Integer[] top = queue.getLast();
                if(top[0]<=s){
                    Integer[] poll = queue.poll();
                    sum -= poll[1];
                }else{
                    break;
                }
            }
            queue.add(new Integer[]{e, p});
            sum += p;
            if(sum>max){
                max = sum;
            }
        }

        return max;


    }
}

/*
3
2 3 1
6 9 2
0 5 1
->   2
 */

/*
2
3 9 2
4 7 3
->   5
 */
