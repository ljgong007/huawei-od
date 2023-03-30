package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/26 0:02
 */
public class P43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().replace("[", "").replace("]", "");
        Integer[] arr = Arrays.stream(str.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        String num = scanner.nextLine();
        System.out.println(solutiton(arr, num));
    }

    public static String solutiton(Integer[] arr, String num) {
        List<Integer> link1 = new ArrayList<>();
        List<Integer> link2 = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> a - b);
        for (Integer i : arr) {
            if (i < 4) {
                link1.add(i);
            } else {
                link2.add(i);
            }
        }
        int len1 = link1.size();
        int len2 = link2.size();

        List<List<Integer>> ans = new ArrayList<>();

        switch (num) {
            case "1":
                if (len1 == 1 || len2 == 1) {
                    if (len1 == 1) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 1) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 3 || len2 == 3) {
                    if (len1 == 3) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 3) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 2 || len2 == 2) {
                    if (len1 == 2) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 2) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 4) dfs(link2, 0, 1, new ArrayList<>(), ans);
                }
                break;
            case "2":
                if (len1 == 2 || len2 == 2) {
                    if (len1 == 2) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 2) dfs(link2, 0, 2, new ArrayList<>(), ans);
                } else if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 4) dfs(link2, 0, 2, new ArrayList<>(), ans);
                } else if (len1 == 3 || len2 == 3) {
                    if (len1 == 3) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 3) dfs(link2, 0, 2, new ArrayList<>(), ans);
                }
                break;
            case "4":
                if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) ans.add(link1);
                    if (len2 == 4) ans.add(link2);
                }
                break;
            case "8":
                if (len1 == 4 && len2 == 4) {
                    List<Integer> list = Arrays.asList(arr);
                    ans.add(list);
                }
                break;
        }
        return ans.toString();
    }

    public static void dfs(List<Integer> list, int index, int level, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == level) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < list.size(); i++) {
            path.add(list.get(i));
            dfs(list, i + 1, level, path, res);
            path.remove(path.size() - 1);
        }
    }
}
