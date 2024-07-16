package BJ_1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    int n, k, s;
    boolean[][] arr;
    int[][] ans;
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            Arrays.fill(arr[i], false);
            arr[i][i] = true;
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            arr[a1][a2] = true;
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        ans = new int[s+1][2];
        for(int i = 0; i < s; i++){
            st = new StringTokenizer(br.readLine());
            ans[i][0] = Integer.parseInt(st.nextToken());
            ans[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    public void solution(){
        floyd();
        for(int i = 0; i < s; i++){
            int a1 = ans[i][0];
            int a2 = ans[i][1];
            if(arr[a1][a2]){
                System.out.println(-1);
            }
            else{
                if(arr[a2][a1]){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
    public void floyd(){
        for(int t = 1; t <= n; t++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(arr[i][t] && arr[t][j]){
                        arr[i][j] = true;
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
        solution.solution();
    }
}

