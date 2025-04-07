package BJ_1799;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    int N;
    boolean[][] arr;

    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = new boolean[N];
            Arrays.fill(arr[i], true);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1){
                    arr[i][j] = false;
                }else{
                    arr[i][j] = true;
                }
            }
        }

    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}