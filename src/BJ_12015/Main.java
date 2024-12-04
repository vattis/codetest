package BJ_12015;
//어디서 본 유형이라 DP를 떠올리긴 했음
//문제를 안읽어서 DP를 잘못 정했음
//DP를 DFS방식으로 해결하려 했지만 점화식으로 해결하는 문제였음 시발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int N;
    int[][] DP = new int[101][10001];
    int[] arr;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

