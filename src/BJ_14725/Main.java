package BJ_14725;

//걍 쉬웠는데 사소한 실수가 시간을 많이 잡아 먹었음
//priorityqueue는 iterator로 전환할 때 순서가 보장되지 않는다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    int N;
    Node root = new Node("root", 0);
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            Node node = root;
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                node = add(node, s);
            }
        }
        Collections.sort(root.pq);
        for(Node node : root.pq){
            pf(node);
        }
    }
    void pf(Node node){
        Collections.sort(node.pq);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < node.depth; i++){
            sb.append("--");
        }
        sb.append(node.name);
        System.out.println(sb);
        for(Node tempNode : node.pq){
            pf(tempNode);
        }
    }
    Node add(Node node, String name){
        for (Node tempNode : node.pq) {
            if (tempNode.name.equals(name)) {
                return tempNode;
            }
        }
        Node ansNode = new Node(name, node.depth+1);
        node.pq.add(ansNode);
        return ansNode;
    }
}
class Node implements Comparable<Node>{
    String name;
    int depth;
    ArrayList<Node> pq = new ArrayList<>();
    public Node(String name, int depth){
        this.name = name;
        this.depth = depth;
    }
    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

