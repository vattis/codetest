package BJ_11505;

//걍 세그먼트 트리 문제 왤케 한번에 안풀리지ㅅㅂ
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    int N, M, K;
    long[] arr;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segmentTree = new SegmentTree(N, arr);
        segmentTree.init(1, 1, N);
        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(type == 1){
                arr[b] = c;
                segmentTree.update(1, 1, N, b, c);
            }else if(type == 2){
                System.out.println((int)segmentTree.find(1, 1, N, b, (int)c));
            }
        }
    }
}
class SegmentTree{
    long[] tree;
    long[] arr;
    int getSize(int n){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        return (int)Math.pow(2, h+1);
    }

    SegmentTree(int n, long[] arr){
        tree = new long[getSize(n)+1];
        this.arr = arr;
    }

    long init(int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }
        int mid = (start + end)/2;
        return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end))%1000000007;
    }

    long update(int node, int start, int end, int idx, long new_num){
        if(idx < start || end < idx){
            return tree[node];
        }
        if(start == end){
            return tree[node] = new_num;
        }
        int mid = (start+end)/2;
        return tree[node] = (update(node*2, start, mid, idx, new_num)*update(node*2+1, mid+1, end, idx, new_num))%1000000007;
    }

    long find(int node, int start, int end, int left, int right){
        if(right < start || end < left){
            return 1;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start+end)/2;
        return (find(node*2, start, mid, left, right)
                *find(node*2+1, mid+1, end, left, right))%1000000007;
    }

}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

