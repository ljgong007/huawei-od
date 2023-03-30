package Huawei2023.second.jichu;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/24 23:15
 */
public class P27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[][] clockRecords = new String[N][];
        for (int i = 0; i < N; i++) {
            clockRecords[i] = scanner.nextLine().split(",");
        }

        System.out.println(solution(clockRecords));
    }

    public static String solution(String[][] clockRecords) {

        Set<Integer> ans = new TreeSet<>();
        Map<String, List<String[]>> employees = new HashMap<>();
        for (int i = 0; i < clockRecords.length; i++) {
            String[] newRecord = Arrays.copyOf(clockRecords[i], clockRecords[i].length + 1);
            newRecord[newRecord.length - 1] = i + "";

            String id = newRecord[0];
            String act_device = newRecord[3];
            String reg_device = newRecord[4];

            if(!act_device.equals(reg_device)) ans.add(i);

            employees.putIfAbsent(id, new ArrayList<>());
            employees.get(id).add(newRecord);
        }

        for (String key : employees.keySet()) {
            List<String[]> records = employees.get(key);

            records.sort((a,b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

            for (int i = 0; i < records.size(); i++) {
                int time1 = Integer.parseInt(records.get(i)[1]);
                int dist1 = Integer.parseInt(records.get(i)[2]);
                for (int j = i+1; j < records.size(); j++) {
                    int time2 = Integer.parseInt(records.get(j)[1]);
                    int dist2 = Integer.parseInt(records.get(j)[2]);

                    if(time2-time1>60) break;
                    else{
                        if(Math.abs(dist2-dist1)>5){
                            ans.add(Integer.parseInt(records.get(i)[5]));
                            ans.add(Integer.parseInt(records.get(j)[5]));
                        }
                    }
                }
            }
        }

        if(ans.isEmpty()) return "null";

        StringJoiner sj1 = new StringJoiner(";");
        for (Integer i : ans) {
            String[] str = clockRecords[i];
            StringJoiner sj = new StringJoiner(",");
            for (int j = 0; j < str.length; j++) {
                sj.add(str[j]);
            }
            sj1.add(sj.toString());
        }

        return sj1.toString();
    }
}
