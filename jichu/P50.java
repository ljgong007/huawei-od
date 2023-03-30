package Huawei2023.second.jichu;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/26 15:23
 */
public class P50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr, m, n));
    }

    public static int solution(int[] arr, int m, int n){
        PriorityQueue<Sampler> pQ = new PriorityQueue<Sampler>((a,b) -> (int) (getAdd(b) - getAdd(a)));

        for (int i = 0; i < m; i++) {
            pQ.offer(new Sampler(0, arr[i]));
        }

        while (n>0){
            if(pQ.isEmpty() || pQ.peek().volunteer==4) break;
            Sampler s = pQ.poll();
            s.total += getAdd(s);
            s.volunteer += 1;

            pQ.offer(s);
            n--;
        }

        double ans = 0;
        while (!pQ.isEmpty()) ans += pQ.poll().total;

        return (int) ans;
    }

    public static double getAdd(Sampler s){
        if(s.volunteer==0) return s.base*0.2;
        else if(s.volunteer<=3) return s.base*0.1;
        else return 0;
    }
}

class Sampler{
    int volunteer = 0;
    double base = 0;
    double total = 0;

    public Sampler(int volunteer, double base){
        this.volunteer = volunteer;
        this.base = base;
        this.total = base * 0.8;
    }
}
