package BJ_11505;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    int N, M, K;
    int[] arr;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<BigInteger, BigInteger> DP = new HashMap<>();

    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(type == 1){

            }else if(type == 2){
                
            }
        }
    }
}
class SegmentTree{
    double[] tree;
    int[] arr;
    int getSize(int n){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        return (int)Math.pow(2, h+1);
    }
    SegmentTree(int n, int[] arr){
        tree = new double[getSize(n)];
        this.arr = arr;
    }
    void init(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        init(node*2, start, mid);
        init(node*2+1, mid+1, end);
        tree[node] = (tree[node*2] * tree[node*2+1])%1000000007;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

