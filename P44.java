package Huawei2023.second.fuxi_advP;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author liujie gong
 * @date 2023/3/29 22:05
 */
public class P44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] goods = new int[n];
        for (int i = 0; i < n; i++) {
            goods[i] = scanner.nextInt();
        }
        int[] types = new int[n];
        for (int i = 0; i < n; i++) {
            types[i] = scanner.nextInt();
        }
        int cars = scanner.nextInt();
        System.out.println(solution(n, goods, types, cars));
    }

    public static int solution(int n, int[] goods, int[] types, int cars) {
        int min = Arrays.stream(goods).max().getAsInt();
        int max = Arrays.stream(goods).sum();

        while (min <= max) {
            int limit = (max + min) / 2;
            if (canLoad(limit, goods, types, cars)) {
                max = limit - 1;
            } else {
                min = limit + 1;
            }
        }

        return min;
    }

    public static boolean canLoad(int limit, int[] goods, int[] types, int cars) {
        int sumWet = 0, sumDry = 0, carWet = 0, carDry = 0;
        for (int i = 0; i < goods.length; i++) {
            if(types[i]==0){
                if(sumDry + goods[i]<=limit){
                    sumDry += goods[i];
                }else{
                    if(carDry + 1 == cars){
                        return false;
                    }else{
                        carDry++;
                        sumDry = goods[i];
                    }
                }
            }else{
                if(sumWet + goods[i]<=limit){
                    sumWet += goods[i];
                }else{
                    if(carWet + 1 == cars){
                        return false;
                    }else{
                        carWet++;
                        sumWet = goods[i];
                    }
                }
            }
        }
        return true;
    }
}
