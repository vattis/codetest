package BJ_2357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;


//세그먼트 트리 문제
//임의의 구간에 대하여 반복적인 연산을 요구한다면 한번쯤 생각해보자(그 연산이 덧셈이 아니더라도 ㅇㅇ)
//첫 노드를 1로두고 좌우로 node*2, node*2+1 로 뻗어나가는 트리 구조를 기억해두자
class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N, M;
    int[] arr1;
    Pair[] arr2;
    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N+1];
        arr2 = new Pair[N+1];
        for(int i = 1; i <= N; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree minSegmentTree = new SegmentTree(arr1, N);
        SegmentTree maxSegmentTree = new SegmentTree(arr1, N);
        minSegmentTree.init(0, 1, N, 1);
        maxSegmentTree.init(1, 1, N, 1);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(minSegmentTree.find(0, 1, 1, N, start, end, Integer.MAX_VALUE)
                    + " " + maxSegmentTree.find(1, 1, 1, N, start, end, Integer.MIN_VALUE));
        }
    }
}
class Pair{
    int start, end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class SegmentTree{
    int[] arr;
    int[] tree;
    SegmentTree(int[] arr, int n){
        this.arr = arr;
        tree = new int[getSize(n)+1];
    }
    int getSize(int n){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2))+1;
        return (int)Math.pow(2, h);
    }
    void init(int type, int start, int end, int node){
        if(start == end){
            tree[node] = arr[start];
        }
        else{
            int mid = (start + end)/2;
            init(type, start, mid, node*2);
            init(type, mid+1, end, node*2+1);
            if(type == 0){
                if(tree[node*2] < tree[node*2+1]){
                    tree[node] = tree[node*2];
                }else{
                    tree[node] = tree[node*2+1];
                }
            }else if(type == 1){
                if(tree[node*2] < tree[node*2+1]){
                    tree[node] = tree[node*2+1];
                }else{
                    tree[node] = tree[node*2];
                }
            }
        }
    }
    int find(int type, int node, int start, int end, int l, int r, int ans){
        if(l > end || r < start){
            if(type == 0){
                return Integer.MAX_VALUE;
            }else if(type == 1){
                return Integer.MIN_VALUE;
            }
        }
        if(l <= start && r >= end){
            if(type == 0){
                ans = min(ans, tree[node]);
            }else if(type == 1){
                ans = max(ans, tree[node]);
            }
            return ans;
        }
        int mid = (start + end)/2;
        int a = find(type, node*2, start, mid, l, r, ans);
        int b = find(type, node*2+1, mid + 1, end, l, r, ans);
        if(type == 0){
            ans = min(a, b);
        }
        else if(type == 1){
            ans = max(a, b);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

