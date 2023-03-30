package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/24 17:50
 */
public class P25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(solution(array));
    }

    public static String solution(Integer[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int val = arr[i];
            count.put(val, count.getOrDefault(val, 0) + 1);
        }

        Map<String, LinkedList<Integer[]>> combine = new HashMap<>();
        combine.put("1", new LinkedList<Integer[]>());
        combine.put("2", new LinkedList<Integer[]>());
        combine.put("3", new LinkedList<Integer[]>());
        combine.put("3+2", new LinkedList<Integer[]>());
        combine.put("4", new LinkedList<Integer[]>());

        for (Integer key : count.keySet()) {
            Integer value = count.get(key);
            switch (value){
                case 1:
                    combine.get("1").add(new Integer[]{key});
                    break;
                case 2:
                    combine.get("2").add(new Integer[]{key});
                    break;
                case 3:
                    combine.get("3").add(new Integer[]{key});
                    break;
                default:
                    combine.get("4").add(new Integer[]{key, value});
            }
        }

        // 4
        combine.get("4").sort((a,b)->(a[1]==b[1] ? b[0] - a[0] : b[1] - a[1]));
        combine.get("3").sort((a,b)->(b[0] - a[0]));
        combine.get("2").sort((a,b)->(b[0] - a[0]));

        while (combine.get("3").size()>0){
            if(combine.get("2").size()==0 && combine.get("3").size()==1) break;

            Integer san_top = combine.get("3").removeFirst()[0];

            Integer tmp;

            if(combine.get("2").size()==0 || (combine.get("3").size()>0 && combine.get("3").get(0)[0] > combine.get("2").get(0)[0])){
                tmp = combine.get("3").removeFirst()[0];
                combine.get("1").add(new Integer[]{tmp});
            }else{
                tmp = combine.get("2").removeFirst()[0];
            }
            combine.get("3+2").add(new Integer[]{san_top, tmp});
        }

        // 1
        combine.get("1").sort((a,b)->(b[0] - a[0]));

        List<Integer> ans = new ArrayList<>();
        for (Integer[] ints :combine.get("4")) {
            int val = ints[0];
            int times = ints[1];
            for (int i = 0; i < times; i++) ans.add(val);
        }

        for (Integer[] ints :combine.get("3+2")) {
            int san = ints[0];
            int er = ints[1];
            for (int i = 0; i < 3; i++) ans.add(san);
            for (int i = 0; i < 2; i++) ans.add(er);
        }

        for (Integer[] ints :combine.get("3")) {
            int san = ints[0];
            for (int i = 0; i < 3; i++) ans.add(san);
        }

        for (Integer[] ints :combine.get("2")) {
            int er = ints[0];
            for (int i = 0; i < 2; i++) ans.add(er);
        }

        for (Integer[] ints :combine.get("1")) {
            int yi = ints[0];
            ans.add(yi);
        }

        return ans.toString();
    }
}

/*
1 3 3 3 2 1 5     -> 3 3 3 1 1 5 2

4 4 2 1 2 1 3 3 3 4      ->  4 4 4 3 3 2 2 1 1 3
 */
