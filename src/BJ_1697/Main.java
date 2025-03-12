package BJ_1697;
//처음에 BFS로 안될 줄 알았는데 알고보니 맞았음
//애매한건 그냥 해보는게 좋은 습관일듯 ㅇㅇ
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution{
    int N, M;
    Queue<Node> queue = new LinkedList<>();
    int[] DP = new int[100002];
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        queue.add(new Node(N, 0));
        Arrays.fill(DP, 100001);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (DP[node.index] > node.cnt) {
                DP[node.index] = node.cnt;
            }else{
                continue;
            }
            if (node.index - 1 >= 0) { //뒤로
                Node node1 = Node.moveBack(node);
                queue.add(node1);
                //System.out.println("back:::" + "index: " + node1.index + " cnt: " + node1.cnt);
            }
            if (node.index + 1 <= 100000) { //앞으로
                Node node1 = Node.moveForward(node);
                queue.add(node1);
               // System.out.println("forward:::" + "index: " + node1.index + " cnt: " + node1.cnt);
            }
            if (node.index * 2 <= 100000) { //점프
                Node node1 = Node.jump(node);
                queue.add(node1);
               // System.out.println("jump:::" + "index: " + node1.index + " cnt: " + node1.cnt);
            }
        }
        System.out.println(DP[M]);
    }

}
class Node{
    int index;
    int cnt;
    Node(int index, int cnt){
        this.index = index;
        this.cnt = cnt;
    }
    static Node moveBack(Node node){
        return new Node(node.index-1, node.cnt+1);
    }
    static Node moveForward(Node node){
        return new Node(node.index+1, node.cnt+1);
    }
    static Node jump(Node node){
        return new Node(node.index*2, node.cnt+1);
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}