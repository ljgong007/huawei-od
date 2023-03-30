package Huawei2023.second.jichu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liujie gong
 * @date 2023/3/23 21:38
 */
public class P10Using_RegExp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        System.out.println(solution(arr));
    }

    public static int solution(String[] arr){
        String reg = "(\\d+)((CNY)|(JPY)|(HKD)|(EUR)|(GBP)|(fen)|(cents)|(sen)|(eurocents)|(pence))";
        Map<String, Double> exchange = new HashMap<>();
        exchange.put("CNY", 100.0);
        exchange.put("JPY", 100.0 / 1825 * 100);
        exchange.put("HKD", 100.0 / 123 * 100);
        exchange.put("EUR", 100.0 / 14 * 100);
        exchange.put("GBP", 100.0 / 12 * 100);
        exchange.put("fen", 1.0);
        exchange.put("cents", 100.0 / 123);
        exchange.put("sen", 100.0 / 1825);
        exchange.put("eurocents", 100.0 / 14);
        exchange.put("pence", 100.0 / 12);

        double ans = 0.0;
        Pattern p = Pattern.compile(reg);
        for (String s : arr) {
            Matcher matcher = p.matcher(s);
            while (matcher.find()){
                Double amount = Double.parseDouble(matcher.group(1));
                String unit = matcher.group(2);
                ans += amount * exchange.get(unit);
            }
        }
        return (int) ans;
    }
}
