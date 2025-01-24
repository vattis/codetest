package BJ_2533;
// 걍 방법도 바로 알 수 있었음
//이진탐색을 나 혼자 만들걸 괜히 블로그꺼 퍼와서 오래걸림
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    int N;
    ArrayList<Integer>[] arr;
    int[][] DP;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][];
        arr = new ArrayList[N+1];
        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<>();
            DP[i] = new int[2];
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}