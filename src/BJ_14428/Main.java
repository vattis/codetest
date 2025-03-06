package BJ_14428;
//걍 평범한 세그먼트 트리 문제 ㅇㅇ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}
class Solution{
    Node[] tree;
    int[] arr;
    int N, M;
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+2];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int size = getSize(N);
        tree = new Node[size+2];
        init(1, N, 1);
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st  = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type == 1){
                update(new Node(a, b), 1, N, 1);
                arr[a] = b;
            }else if(type == 2){
                Node node = search(1, N, a, b, 1);
                System.out.println(node.index);
            }
        }
    }
    int getSize(int N){
        int h = (int)(ceil(log(N)/log(2))+1);
        return (int)pow(2, h);
    }
    Node init(int start, int end, int nodeIndex){
        if(start == end){
            tree[nodeIndex] = new Node(start, arr[start]);
            return tree[nodeIndex];
        }
        int mid = (start + end)/2;
        Node nodeLeft = init(start, mid, nodeIndex*2);
        Node nodeRight = init(mid + 1, end, nodeIndex*2+1);
        if(nodeLeft.compareTo(nodeRight) > 0){
            return tree[nodeIndex] = nodeRight;
        }else{
            return tree[nodeIndex] = nodeLeft;
        }
    }
    Node search(int start, int end, int l, int r, int node){
        if(start > r || end < l){
            return null;
        }
        if(l <= start && r >= end){
            return tree[node];
        }
        int mid = (start + end)/2;
        Node a = search(start, mid, l, r, node*2);
        Node b = search(mid + 1, end, l, r, node*2+1);
        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }
        if(a.compareTo(b) < 0){
            return a;
        }else{
            return b;
        }
    }
    void update(Node target, int start, int end, int nodeIndex) {
        if (target.index < start || end < target.index) {
            return;
        }
        if (start == end) {
            //System.out.println(target.index + " " + target.value);
            tree[nodeIndex] = target;
            return;
        }
        int mid = (start + end) / 2;
        update(target, start, mid, nodeIndex * 2);
        update(target, mid + 1, end, nodeIndex * 2 + 1);
        Node r = tree[nodeIndex*2];
        Node l = tree[nodeIndex*2+1];;
        if(r.compareTo(l) > 0){
            tree[nodeIndex] = l;
        }else{
            tree[nodeIndex] = r;
        }
    }
}
class Node implements Comparable<Node>{
    int index;
    int value;
    Node(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        if(this.value == o.value){
            return this.index - o.index;
        }
        return this.value - o.value;
    }
}
