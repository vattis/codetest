package BJ_1275;

//세그먼트 트리 << 부분합이 필요할 때 사용하면 좋은 알고리즘
//이 문제는 세그먼트 트리를 떠 올릴 수 있는가? 그리고 세그먼트 트리를 구현 할 수 있는지 확인하는 문제임
//세그먼트 트리는 살짝 복잡해서 몇번 더 봐두자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    int N, Q;
    long[] numList;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder ans = new StringBuilder();

    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numList = new long[N+1];
        for(int i = 1; i <= N; i++){
            numList[i]= Long.parseLong(st.nextToken());
        }
        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(numList, 1, 1, N);
        for(int j = 1; j <= Q; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x > y){ int temp = x; x = y; y = temp; }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long s = segmentTree.sum(1, 1, N, x, y);
            System.out.println(s);
            segmentTree.change(1, 1, N, a, b-numList[a]);
            numList[a] = b;
        }
    }
}
class SegmentTree{
    int treeSize;
    long[] tree;
    public SegmentTree(int size){
        int h = (int) Math.ceil(Math.log(size)/ Math.log(2));
        treeSize = (int)Math.pow(2, h+1);
        tree = new long[treeSize];
    }
    long init(long[] arr, int node, int start, int end){
        if(start == end){
            //System.out.println("node: " + node + ", start: " + start + ", value: " + arr[start]);
            return tree[node] = arr[start];
        }
        else{
            return tree[node] = init(arr, node*2, start, (start+end)/2)
                    + init(arr, node*2+1, (start+end)/2+1, end);
        }
    }
    long sum(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }
            if(left <= start && end <= right){
            return tree[node];
        }
        return sum(node*2, start, (start+end)/2, left, right)
                + sum(node*2+1, (start+end)/2+1, end, left, right);
    }
    void change(int node, int start, int end, int idx, long diff){
        if(start > idx || end < idx){
            return;
        }
        tree[node] += diff;
        if(start != end){
            change(node*2, start, (start+end)/2, idx, diff);
            change(node*2+1, (start+end)/2+1, end, idx, diff);
        }
    }
}



