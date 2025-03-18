package BJ_2263;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution{
    int N;
    int[] inOrder;
    int[] postOrder;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        inOrder = new int[N+1];
        postOrder = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}