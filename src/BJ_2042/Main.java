package BJ_2042;

//전에 세그먼트 트리 문제를 본 적이 있어서 세그먼트 트리 문제라는 건 바로 알았음
//근데 구현을 못하겠더라 ㅋㅋㅋ
//걍 세그먼트 트리 구현하면 되는 문제 ㅇㅇ
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Long[] arr;
    int M, N, K;
    Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        SegmentTree segTree = new SegmentTree(N+1);
        segTree.init(arr, 1, 1, N);
        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){ //교환
                int b = Integer.parseInt(st.nextToken());
                Long c = Long.parseLong(st.nextToken());
                segTree.changeNum(1, 1, N, b, c-arr[b]);
                arr[b] = c;
            }else if(a == 2){ //합 구하기
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                System.out.println(segTree.findSum(1, 1, N, b, c));
            }
        }
    }

}
class SegmentTree{
    Long[] tree;
    int treeSize;
    public SegmentTree(int arrSize){
        int h = (int)Math.ceil(Math.log(arrSize)/Math.log(2));
        this.treeSize = (int)Math.pow(2, h+1);
        tree = new Long[treeSize];
    }
    public Long init(Long[] arr, int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }
        return tree[node] = init(arr, node*2, start, (start+end)/2)
                + init(arr, node*2+1, (start+end)/2+1, end);
    }
    public void changeNum(int node, int start, int end, int index, long diff){
        if(index < start || index > end){
            return;
        }
        tree[node] += diff;
        if(start != end){
            changeNum(node*2, start, (start+end)/2, index, diff);
            changeNum(node*2+1, (start+end)/2+1, end, index, diff);
        }
    }
    public Long findSum(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0L;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        return findSum(node*2, start, (start+end)/2, left, right)
                + findSum(node*2+1, (start+end)/2+1, end, left, right);
    }
}



