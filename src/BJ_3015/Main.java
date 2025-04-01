package BJ_3015;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    int N;
    int[] arr = new int[500001];

    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}