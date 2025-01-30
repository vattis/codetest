package BJ_2213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;



//트리의 독립 문제
//DP를 잘 활용하자
class Solution {
    int N;
    ArrayList<Integer>[] graph;
    int[] values;
    boolean[] visited;
    int[][] DP;
    ArrayList<Integer>[][] history;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        values = new int[N+1];
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        DP = new int[N+1][];
        history = new ArrayList[N+1][];
        Arrays.fill(visited, false);
        for(int i = 0; i < N+1; i++){
            graph[i] = new ArrayList<>();
            DP[i] = new int[2];
            history[i] = new ArrayList[2];
            history[i][0] = new ArrayList<>();
            history[i][1] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            values[i] = Integer.parseInt(st.nextToken());
            DP[i][1] = values[i];
            history[i][1].add(i);
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        find(1);
        if(DP[1][0] < DP[1][1]){
            Collections.sort(history[1][1]);
            System.out.println(DP[1][1]);
            for(int i = 0; i < history[1][1].size(); i++){
                System.out.print(history[1][1].get(i) + " ");
            }

        }else{
            Collections.sort(history[1][0]);
            System.out.println(DP[1][0]);
            for(int i = 0; i < history[1][0].size(); i++){
                System.out.print(history[1][0].get(i) + " ");
            }
        }
    }
    void find(int x){
        visited[x] = true;
        for(int i = 0; i < graph[x].size(); i++){
            int temp = graph[x].get(i);
            if(!visited[temp]){
                find(temp);
                if(DP[temp][0] < DP[temp][1]){
                    DP[x][0] += DP[temp][1];
                    history[x][0].addAll(history[temp][1]);
                }else{
                    DP[x][0] += DP[temp][0];
                    history[x][0].addAll(history[temp][0]);
                }
                DP[x][1] += DP[temp][0];
                history[x][1].addAll(history[temp][0]);
            }
        }
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

