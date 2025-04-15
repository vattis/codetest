package BJ_1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;

//다익스트라만 알면 그냥 풀리는 문제
public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}
class Solution{
    int N, E;
    Long ans;
    ArrayList<ArrayList<Node>> graph = new ArrayList<>(802);
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int v1_v2_dist = dijkstra(v1, v2);
        int A_v1_dist = dijkstra(1, v1);
        int A_v2_dist = dijkstra(1, v2);
        int B_v1_dist = dijkstra(v1, N);
        int B_v2_dist = dijkstra(v2, N);
        if(A_v1_dist + B_v2_dist < A_v2_dist + B_v1_dist){
            ans = (long)A_v1_dist+B_v2_dist+v1_v2_dist;
        }else{
            ans = (long)A_v2_dist+B_v1_dist+v1_v2_dist;
        }
        if(ans >= Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
    int dijkstra(int start, int end){
        boolean[] visited = new boolean[802];
        int[] dist = new int[802];
        int[] ans = new int[802];
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for(int i = 0; i < N; i++){
            int nodeValue = Integer.MAX_VALUE;
            int nodeIndex = 0;
            for(int j = 1; j <= N; j++){
                if(!visited[j] && nodeValue > dist[j]){
                    nodeValue = dist[j];
                    nodeIndex = j;
                }
            }
            visited[nodeIndex] = true;
            for(int j = 0; j < graph.get(nodeIndex).size(); j++){
                Node tempNode = graph.get(nodeIndex).get(j);
                if(dist[tempNode.end] > dist[nodeIndex] + tempNode.dist){
                    dist[tempNode.end] = dist[nodeIndex] + tempNode.dist;
                }
            }
        }
        return dist[end];
    }
}

class Node{
    public int end, dist;
    public Node(int end, int dist){
        this.end = end;
        this.dist = dist;
    }
}
