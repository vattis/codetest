package BJ_1256;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    int N, M, K;
    int count = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder ans = new StringBuilder();

    public Solution() throws IOException {
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans.append("a".repeat(Math.max(0, N)));
        ans.append("z".repeat(Math.max(0, M)));

    }
    /*
    String func(int start, int n, int m){
        ans.setCharAt(start, 'z');
        ans.setCharAt(start+1, 'a');
        //makeDefault();
        func(start+1, 1, m-1);
    }
    */

    String makeDefault(int n, int m){
        String str = "";
        ans.append("a".repeat(Math.max(0, n)));
        ans.append("z".repeat(Math.max(0, m)));
        return str;
    }
}



