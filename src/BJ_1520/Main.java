package BJ_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.pow;
//그냥 dfs로 풀면 4^(500*500)의 시간 복잡도
//당연히 여기서 DP로 풀어야 한다고 생각하긴 했음
//문제는 DP로 어떻게 풀까
//DP[m][n]은 m,n에서 목적지까지 경로의 가짓수
//각 노드는 4방향을 dfs로 체크하기 때문에 한번 업데이트 되면 바뀌지 않음 <--- 이걸 몰랐음
//즉 목적지로 도달했을 때 1을 리턴하고
//각 노드는 현재 값에서 리턴된 값을 더하면 됨
class Solution {
    int N, M;
    int[][] arr;
    int[][] DP = new int[500][500];
    public Solution(int m , int n, int[][] a){
        M = m;
        N = n;
        arr = a;
        for(int i = 0; i < 500; i++){
            Arrays.fill(DP[i], -1);
        }
    }

    public int solution(int m, int n){
        if(n == N-1 && m == M-1){//목적지에 도달한 노드
            return 1;
        }
        if(DP[m][n] != -1){return DP[m][n];} //이미 계산이 된 노드
        DP[m][n] = 0;
        if(n > 0 && arr[m][n-1] < arr[m][n]){//좌
            DP[m][n] += solution(m, n-1);
        }
        if(n < N-1 && arr[m][n+1] < arr[m][n]){//우
            DP[m][n] += solution(m, n+1);
        }
        if(m > 0 && arr[m-1][n] < arr[m][n]){//상
            DP[m][n] += solution(m-1, n);
        }
        if(m < M-1 && arr[m+1][n] < arr[m][n]){//하
            DP[m][n] += solution(m+1, n);
        }
        return DP[m][n];
    }

}

public class Main {
    public static void main(String[] ars) throws IOException {
        int N, M;
        int[][] arr = new int[500][500];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution solution = new Solution(M, N, arr);
        System.out.println(solution.solution(0, 0));
    }
}

