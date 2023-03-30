package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/25 16:46
 */
public class P37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] boxes = scanner.nextLine().split(" ");
        System.out.println(solution(boxes));
    }

    public static String solution(String[] boxes){
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(boxes));
        list.sort((a,b) -> a.length()!=b.length() ? a.length()-b.length() : a.compareTo(b));
        Set<String> set = new HashSet<>(list);

        String ans = "";
        while (list.size()>0){
            String str = list.removeLast();
            int end = str.length()-1;

            if(end==0 && "".equals(ans)){
                ans = str;
                continue;
            }

            while (set.contains(str.substring(0, end))){
                if(end==1){
                    return str;
                }else{
                    end--;
                }
            }
        }
        return ans;
    }
}

/*
h he hel hell hello    ->  hello
 */
