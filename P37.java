package Huawei2023.second.fuxi_advP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie gong
 * @date 2023/3/28 19:59
 */
public class P37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] isConnected = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, isConnected));

    }

    public static int solution(int n, int[][] isConnected){

        UnionFindSet ufs = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j]==1){
                    ufs.union(i,j);;
                }
            }
        }

        Map<Integer, Integer> connected = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = ufs.find(ufs.parent[i]);
            connected.put(parent, connected.getOrDefault(parent, 0)+1);
        }

        return connected.values().stream().max((a,b) -> a-b).get();
    }

    public static class UnionFindSet{
        public int[] parent;
        public int count;

        public UnionFindSet(int n){
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) this.parent[i] = i;
        }

        public int find(int x){
            if(x!=parent[x]){
                return this.parent[x] = this.find(this.parent[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot!=yRoot){
                this.parent[y] = xRoot;
                this.count--;
            }
        }
    }
}

/*
5
1 1 0 0 0
1 1 0 0 0
0 0 1 1 1
0 0 1 1 1
0 0 1 1 1
 */


