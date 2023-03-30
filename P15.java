package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 15:29
 */
public class P15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Integer[]> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ranges.add(Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new));
        }
        System.out.println(solution(ranges));
    }

    public static int solution(List<Integer[]> ranges){
        ranges.sort((a,b) -> a[0] - b[0]);
        LinkedList<Integer[]> stack = new LinkedList<>();
        stack.add(ranges.get(0));

        for (int i = 1; i < ranges.size(); i++) {
            Integer[] range = ranges.get(i);
            int s1 = range[0];
            int e1 = range[1];

            while (true){
                if(stack.size()==0){
                    stack.add(ranges.get(i));
                    break;
                }

                Integer[] top = stack.getLast();
                int s0 = top[0];
                int e0 = top[1];
                if(s1<=s0){
                    if(e1<=e0){
                        break;
                    }else{
                        stack.removeLast();
                    }
                }else if(s1 < e0){
                    if(e1<=e0){
                        break;
                    }else{
                        stack.add(new Integer[]{e0, e1});
                        break;
                    }
                }else{
                    stack.add(range);
                    break;
                }

            }

        }

        return stack.size();
    }
}


/*
3
1,4
2,5
3,6    ->   2

8
0,4
1,2
1,4
3,7
6,8
10,12
11,13
12,14    ->   5

3
1,10
5,12
8,11     ->   2
 */
