package BJ_1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//우선 이 문제 상황을 그래프로 표현 할 생각을 못했음....
//플로이드 와샬 알고리즘은 모든 노드에서 모든 노드까지 최소값을 찾는 알고리즘이지만
//단순히 갈 수 있는지 계산하는 방식으로도 활용가능
//솔직히 플로이드 와샬 알고리즘을 완전하게 이해하진 못했음(그냥 외우자) => 시간복잡도 = n^3
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

