package BJ_11049;
//집중하니까 금방 풀었음
//처음 방식으로 시간 초과가 났을 때 DP 밖에 방법이 없다는 걸 알았음
//괜히 풀어서 생각하지 말고 문제에서 알려준 대로 행렬로 생각하니까 쉬움
//DP+재귀 문제 ㅇㅇ

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int N;
    Pair[] arr = new Pair[501];
    int[][] DP = new int[501][501];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(r, c);
        }
        for(int i = 0; i < 501; i++){
            Arrays.fill(DP[i], Integer.MAX_VALUE);
        }
        System.out.println(recur(0, N-1));
    }
    public int recur(int start, int end){
        //System.out.print("start : " + start + " end: " + end);
        //System.out.println();
        if(DP[start][end] != Integer.MAX_VALUE){
            return DP[start][end];
        }
        int min = Integer.MAX_VALUE;
        if(start == end){return 0;}
        for(int i = start; i < end; i++){
            int temp = recur(start, i) + recur(i+1, end) + arr[start].r * arr[end].c * arr[i].c;
            if(temp < min){
                min = temp;
            }
        }
        DP[start][end] = min;
        return min;
    }
}
class Pair{
    int r, c;
    public Pair(int r_, int c_){
        r = r_;
        c = c_;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

