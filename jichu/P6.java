package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/23 16:14
 */
public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        String[] orders = new String[N];
        Map<Integer, LinkedList<Integer[]>> map = new HashMap<>();


        List<LinkedList<Integer[]>> in = new ArrayList<>();

        Map<Integer, PriorityQueue<Integer[]>> tt = new HashMap<>();

        LinkedList<Integer> out = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String temp = scanner.nextLine();
            if (temp.startsWith("IN")) {
                String[] strings = temp.split(" ");
                int printNum = Integer.parseInt(strings[1]);
                int priority = Integer.parseInt(strings[2]);
                tt.putIfAbsent(printNum, new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : a[0] - b[0])));
                tt.get(printNum).add(new Integer[]{i + 1, priority});
            } else {
                out.add(Integer.parseInt(temp.split(" ")[1]));
            }
        }

        for (Integer i : out) {
            if (!tt.get(i).isEmpty()) {
                System.out.println(tt.get(i).poll()[0]);
            } else {
                System.out.println("NULL");
            }
        }
    }
}

/*
7
IN 1 1
IN 1 2
IN 1 3
IN 2 1
OUT 1
OUT 2
OUT 2


5
IN 1 1
IN 1 3
IN 1 1
IN 1 3
OUT 1
 */
