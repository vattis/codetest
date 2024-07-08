package BJ_1167;

import javax.management.BadAttributeValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    int V;
    ArrayList<Node>[] graph;
    boolean[] visited;
    int max = -1;
    int ansNode;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+2];
        visited = new boolean[V+2];
        Arrays.fill(visited, false);
        graph[0] = new ArrayList<>();
        for(int i = 0; i < V+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1){
                    break;
                }
                int length = Integer.parseInt(st.nextToken());
                Node node = new Node(end, length);
                graph[start].add(node);
            }
        }
    }
    int recur1(int curNode, int length){
        if(visited[curNode]){
            return -1;
        }
        visited[curNode] = true;
        if(max < length){
            max = length;
            ansNode = curNode;
        }
        for(int i = 0; i < graph[curNode].size(); i++){
            Node nextNode = graph[curNode].get(i);
            if(!visited[nextNode.endNode]){
                recur1(nextNode.endNode, length + nextNode.length);
            }
        }
        return ansNode;
    }
    int recur2(int curNode, int length){
        if(visited[curNode]){
            return -1;
        }

        visited[curNode] = true;
        if(max < length){
            max = length;
            ansNode = curNode;
        }
        for(int i = 0; i < graph[curNode].size(); i++){
            Node nextNode = graph[curNode].get(i);
            if(!visited[nextNode.endNode]){
                recur2(nextNode.endNode, length + nextNode.length);
            }
        }
        return max;
    }
    public void solution(){
        int n1 = recur1(1, 0);
        Arrays.fill(visited, false);
        max = -1;
        ansNode = -1;
        System.out.println(recur2(n1, 0));
    }
}
class Node{
    Node(int s, int l){
        endNode = s;
        length = l;
    }
    int endNode;
    int length;
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
        solution.solution();
    }
}
