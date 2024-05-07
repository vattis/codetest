package BJ_2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

class Solution {
    private final int LARGENUM = 100000000;
    int N, T;
    int ans = LARGENUM;
    int[][] DP = new int[65536][16];
    int[][] W;
    boolean[] visited = new boolean[16];
    public Solution(int N_, int[][] W_){
        N = N_;
        W = W_;
        T = (int)pow(2, N);
        Arrays.fill(visited, false);
        for(int i = 0; i < 65536; i++){
            Arrays.fill(DP[i], LARGENUM);
        }
    }
    public int solution(){
        for(int i = 0; i < N; i++){
            visited[i] = true;
            recur(1<<i, i, 0);
            visited[i] = false;
        }
        return ans;
    }
    public void recur(int bit, int curNode, int curCost){
        System.out.println(curNode);
        if(bit == T-1){
            for(int i = 0; i < N; i++){
                if(curCost < ans){
                    ans = curCost;
                    System.out.println(ans + "|" + curNode);
                }
            }
        }
        for(int i = 0; i < N; i++){
            if(!visited[i] && W[curNode][i] != 0 && DP[bit|(1<<i)][i] >= curCost+W[curNode][i]){
                DP[bit|(1<<i)][i] = curCost+W[curNode][i];
                visited[i] = true;
                recur(bit|(1<<i), i, curCost+W[curNode][i]);
                visited[i] = false;
            }
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        int N;
        int[][] W = new int[16][];
        for(int i = 0; i < 16; i++){
            W[i] = new int[16];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                W[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        Solution solution = new Solution(N, W);
        solution.solution();
        System.out.println(solution.ans);
    }
}
