package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/27 18:43
 */
public class P16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer[] connects = Arrays.stream(scanner.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        String[] strArr = str.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        List<Integer[]> ranges = new ArrayList<>();
        for (int i = 0; i < strArr.length/2; i++) {
            int s = Integer.parseInt(strArr[2*i]);
            int e = Integer.parseInt(strArr[2*i+1]);
            ranges.add(new Integer[]{s, e});
        }
        System.out.println(solution(ranges, connects));
    }

    public static int solution(List<Integer[]> ranges, Integer[] connects){
        ranges.sort((a,b) -> a[0] - b[0]);
        LinkedList<Integer> links = new LinkedList<>(Arrays.asList(connects));


        LinkedList<Integer[]> stack = new LinkedList<>();
        stack.add(ranges.get(0));
        LinkedList<Integer> diff = new LinkedList<>();

        for (int i = 1; i < ranges.size(); i++) {
            Integer[] range = ranges.get(i);
            int s1 = range[0];
            int e1 = range[1];

            Integer[] top = stack.getLast();
            int s0 = top[0];
            int e0 = top[1];

            if(s1<=s0){
                if(e1<e0){
                    continue;
                }else {
                    stack.removeLast();
                    stack.add(new Integer[]{s1, e1});
                }
            }else if(s1 < e0){
                if(e1<e0){
                    break;
                }else{
                    stack.removeLast();
                    stack.add(new Integer[]{s0, e1});
                }
            }else{
                stack.add(range);
                diff.add(s1 - e0);
            }
        }

        diff.sort((a,b) -> b-a);
        links.sort((a,b) -> b-a);
        while (links.size()>0 && diff.size()>0){
            if(links.removeLast() >= diff.getLast()){
                diff.removeLast();
            }
        }
        return diff.size()+1;
    }
}
