package BJ_13460;

//방법은 솔직히 바로 알 수 있었음
//구현 하는 데 시간이 좀 걸림
//사소한 부분을 놓치기도 했음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    int N, M;
    String[][] map;
    int[][][][] DP;


    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new String[N+2][M+2];
        for (int i = 0; i < N; i++) {
            map[i] = new String[M+2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
            }
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

