package BJ_2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.min;
import static java.lang.Math.pow;
//애초에 시작이 0부터였음;;
//DP 유형이 많이 부족하다고 느낌
//비트마스크는 할 만 한듯?
//N이 작을 때 사용하면 효과적
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
            Arrays.fill(DP[i], -1);
        }
    }
    public int solution(){
        int ans = LARGENUM;
        /*
        for(int i = 0; i < N; i++){
            visited[i] = true;
            int num = tsp(i, 1<<i, i);
            if(num < ans ){
                ans = num;
            }
            visited[i] = false;
        }
        */

        return tsp(0, 1, 0);
    }
    public int tsp(int start, int bits, int curNode){
        if(bits == (1<<N)-1){
            if(W[curNode][start] > 0){
                return W[curNode][start];
            }
            return LARGENUM;
        }

        if(DP[bits][curNode] > 0){
            return DP[bits][curNode];
        }
        DP[bits][curNode] = LARGENUM;

        for(int i = 0; i < N; i++){
            if(isValid(curNode, i)){
                visited[i] = true;
                DP[bits][curNode] =  min(DP[bits][curNode], tsp(start, bits|(1<<i), i) + W[curNode][i]);
                visited[i] = false;
            }
        }
        return DP[bits][curNode];
    }
    public boolean isValid(int curNode, int dest){
        return !visited[dest] && W[curNode][dest] > 0;
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
        System.out.println(solution.solution());
    }
}

