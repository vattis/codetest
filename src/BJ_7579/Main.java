package BJ_7579;
//어디서 본 유형이라 DP를 떠올리긴 했음
//문제를 안읽어서 DP를 잘못 정했음
//DP를 DFS방식으로 해결하려 했지만 점화식으로 해결하는 문제였음 시발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    int N, M;
    int[][] DP = new int[101][10001];
    int ans = 10000001;

    Pro[] arr;
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Pro[N+1];
        for(int i = 0; i < 101; i++){
            Arrays.fill(DP[i], 0);
        }
        for(int i = 0; i <= N; i++){
            arr[i] = new Pro();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i].setMem(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i].setCost(Integer.parseInt(st.nextToken()));
        }
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= 10000; j++){
                if(j < arr[i].cost){
                    DP[i][j] = DP[i-1][j];
                }else{
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-arr[i].cost]+arr[i].mem);
                }
            }
        }
        int ans = 100000000;
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < 10001; j++){
                if(ans < j){
                    break;
                }
                if(DP[i][j] >= M){
                    if(ans > j){
                        ans = j;
                    }
                }
            }
        }
        System.out.println(ans);

    }

}
class Pro implements Comparable<Pro>{
    int cost, mem;
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setMem(int mem){
        this.mem = mem;
    }


    @Override
    public int compareTo(Pro o) {
        return this.mem - o.mem;
    }
}
public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

