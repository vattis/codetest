package BJ_1029;
//시간초과 뜸 dp로 어떻게 표현해야할 지 모르겠음
//비트마스킹을 사용하면 좋다고 한다 
//검색해보니까 외판원 순회 문제를 알아두면 좋아보임
//일단 외판원 순회 문제를 풀고 다시 보자
//일반적인 2차원 dp가 아닌 3차원 dp를 만들어야 한다는 걸 파악하지 못했음
//dp 문제는 어렵구나...
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.min;

class Solution{
    int N;
    int ans = 0;
    int[][] arr;
    int[][][] dp = new int[1<<15][15][10];
    boolean[] visited = new boolean[15];

    static int max = 0;
    public Solution(int[][] arr_, int N_){
        N = N_;
        arr = arr_;
        for(int i = 0; i < 1<<15; i++){
            for(int j = 0; j < 15; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        Arrays.fill(visited, false);
        visited[0] = true;
    }
    public int solution(){
        tsp(1, 0, 0, 1);
        return ans;
    }

    public int tsp(int bits, int curCost, int curNode, int cnt){
        if(ans < cnt){
            ans = cnt;
            System.out.println("curNode: " + curNode + " bit: " + bits + " ans: " + ans);
        }
        if(bits == (1<<N)-1){ return curCost; }
        if(dp[bits][curNode][curCost] >= 0){ return dp[bits][curNode][curCost]; }

        if(dp[bits][curNode][curCost] == -1){ dp[bits][curNode][curCost] = 10; }

        for(int i = 1; i < N; i++){
            if(isValid(curCost, curNode, i)){
                visited[i] = true;
                dp[bits][curNode][curCost] = min(tsp(bits|(1<<i), arr[curNode][i], i, cnt+1), dp[bits][curNode][curCost]);
                visited[i] = false;
            }
        }

        return dp[bits][curNode][curCost];
    }
    public boolean isValid(int curCost, int curNode, int dest){
        return !visited[dest] && curCost <= arr[curNode][dest];
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        int[][] arr = new int[15][];
        for (int i = 0; i < 15; i++) {
            arr[i] = new int[15];
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - 48;
            }
        }
        Solution solution = new Solution(arr, N);

        System.out.println(solution.solution());
    }

}
