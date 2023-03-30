package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/25 1:46
 */
public class P31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Integer[] clockNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        List<Integer[]> clockRecords = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Integer[] everyday = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            clockRecords.add(everyday);
        }

        Map<Integer, Integer[]> count = new HashMap<>();
        for (int i = 0; i < clockRecords.size(); i++) {
            for (Integer id :clockRecords.get(i)) {
                if(count.containsKey(id)){
                    count.get(id)[0]++;
                }else{
                    count.put(id, new Integer[]{1, i});
                }
            }

        }

        List<Integer[]> list = new ArrayList<>();
        for (Integer id :count.keySet()) {
            Integer[] value = count.get(id);
            list.add(new Integer[]{id, value[0], value[1]});
        }

        list.sort((a,b) -> a[1]!=b[1] ? b[1] - a[1] : (a[2]!=b[2] ? a[2]-b[2] : a[0]-b[0]));
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            sj.add(list.get(i)[0] + "");
        }

        System.out.println(sj.toString());
    }
}

/*
11
4 4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
0 1 7 10
0 1 6 10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
10
6 10
7 10      ->    10 0 1 7 6
 */


/*
7
6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5
0 1 2 3 4 5     ->   0 1 2 3 4
 */



/*
2
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
0 1
0 1     ->   1 0
 */
