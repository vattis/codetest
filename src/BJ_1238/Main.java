package BJ_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        int N, M, X;
        int[][] dist1 = new int[1001][1001];
        int[][] dist2 = new int[1001][1001];
        for(int i = 0; i < 1001; i++){
            Arrays.fill(dist1[i], 10000000);
            Arrays.fill(dist2[i], 10000000);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dist1[a][b] = d;
            dist2[b][a] = d;
        }
        Solution solution = new Solution(dist1, dist2, N, X);
        System.out.println(solution.solution());
    }
}
    class Solution{
        int[][] dist1;
        int[][] dist2;
        int[] xdist1 = new int[1001];
        int[] xdist2 = new int[1001];
        boolean[] visited1 = new boolean[1001];
        boolean[] visited2 = new boolean[1001];

        int N, X;
        public Solution(int[][] dist1_, int[][] dist2_, int N_, int X_){
            dist1 = dist1_;
            dist2 = dist2_;
            N = N_;
            X = X_;
            for(int i = 0; i <= N; i++){
                xdist1[i] = dist1[X][i];
                xdist2[i] = dist2[X][i];
            }
            Arrays.fill(visited1, false);
            Arrays.fill(visited2, false);
            visited1[X] = true;
            visited2[X] = true;
        }
        public int solution(){
            for(int i = 1; i <= N-1; i++){
                int index1 = findShortestNode1();
                int index2 = findShortestNode2();
                visited1[index1] = true;
                visited2[index2] = true;
                for(int j = 1; j <= N; j++){
                    if(!visited1[j]){
                        if(xdist1[index1] + dist1[index1][j] < xdist1[j]){
                            xdist1[j] = xdist1[index1] + dist1[index1][j];
                        }
                    }
                    if(!visited2[j]){
                        if(xdist2[index2] + dist2[index2][j] < xdist2[j]){
                            xdist2[j] = xdist2[index2] + dist2[index2][j];
                        }
                    }
                }
            }
            int ans = -1;
            for(int i = 1; i <= N; i++){
                int pp = xdist1[i] + xdist2[i];
                if(pp > ans && i != X){
                    ans = pp;
                }
            }
            return ans;
        }
        public int findShortestNode1(){
            int min = 100000000;
            int index = 0;
            for(int i = 1; i <= N; i++){
                if(xdist1[i] < min && !visited1[i]){
                    index = i;
                    min = xdist1[i];
                }
            }
            return index;
        }
        public int findShortestNode2(){
            int min = 100000000;
            int index = 0;
            for(int i = 1; i <= N; i++){
                if(xdist2[i] < min && !visited2[i]){
                    index = i;
                    min = xdist2[i];
                }
            }
            return index;
        }
}

