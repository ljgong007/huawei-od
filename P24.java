package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/28 0:39
 */
public class P24 {
    public static Map<Character, Character[]> dict = new HashMap<Character, Character[]>(){
        {
            put('0', new Character[]{'a', 'b', 'c'});
            put('1', new Character[]{'d', 'e', 'f'});
            put('2', new Character[]{'g', 'h', 'i'});
            put('3', new Character[]{'j', 'k', 'l'});
            put('4', new Character[]{'m', 'n', 'o'});
            put('5', new Character[]{'p', 'q', 'r'});
            put('6', new Character[]{'s', 't'});
            put('7', new Character[]{'u', 'v'});
            put('8', new Character[]{'w', 'x'});
            put('9', new Character[]{'y', 'z'});
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        String filter = scanner.nextLine();
        dfs(chars, 0, filter);
        StringJoiner sj = new StringJoiner(" ");
        for (String s : res) {
            sj.add(s);
        }
        System.out.println(sj.toString());

    }
    public static List<String> res = new ArrayList<>();
    public static LinkedList<Character> track = new LinkedList<>();
    
    public static boolean contains(LinkedList<Character> str, String filter){
        if(filter.length()>str.size()) return false;
        for (int i = 0; i < filter.length(); i++) {
            char c = filter.charAt(i);
            if(!str.contains(c)){
                return false;
            }
        }
        return true;
    }

    public static void dfs(char[] chars, int index, String filter){
        if(track.size()== chars.length){
            if(!contains(track, filter)){
                StringBuilder sb = new StringBuilder();
                for (Character chr : track) {
                    sb.append(chr);
                }
                res.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < chars.length; i++) {
            char c = chars[i];
            if(dict.containsKey(c)){
                for (Character chr : dict.get(c)) {
                    track.add(chr);
                    dfs(chars, i+1, filter);
                    track.removeLast();
                }

            }
        }
    }

}
