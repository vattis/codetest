package BJ_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;
import static java.lang.Math.pow;
//애초에 시작이 0부터였음;;
//DP 유형이 많이 부족하다고 느낌
//비트마스크는 할 만 한듯?
//N이 작을 때 사용하면 효과적
class Solution {
    int N, M;
    Set<Integer> n = new HashSet<>();
    List<Integer> m = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            n.add(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            m.add(Integer.parseInt(st.nextToken()));
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        int N;
        int[][] W = new int[16][];
        for(int i = 0; i < 16; i++){
            W[i] = new int[16];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                W[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        Solution solution = new Solution(N, W);
        System.out.println(solution.solution());
    }
}

