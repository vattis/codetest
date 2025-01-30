package BJ_2533;
//dp문제인걸 생각 못했음
//아직 DP가 많이 부족하다
//비슷한 유형 문제를 풀어봐야겠다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

class Solution {
    int N;
    ArrayList<Integer>[] arr;
    boolean[] visited;
    int[][] DP;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][];
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        Arrays.fill(visited, false);
        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<>();
            DP[i] = new int[2];
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        find(1);
        System.out.println(min(DP[1][0], DP[1][1]));
    }
    void find(int node){
        visited[node] = true;
        DP[node][1] = 1;
        for(int i = 0; i < arr[node].size(); i++){
            int temp = arr[node].get(i);
            if(!visited[temp]){
                find(temp);
                //System.out.println("@@@@@@@@@@@@@@@@@@");
                DP[node][0] += DP[temp][1];
                DP[node][1] += min(DP[temp][0], DP[temp][1]);
            }
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}