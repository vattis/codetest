package BJ_1781;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    int N;
    Cup[] numList;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder ans = new StringBuilder();

    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numList = new Cup[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            numList[i] = new Cup(n1, n2);
        }

    }
}
class Cup{
    int num1, num2;
    public Cup(int n1, int n2){
        num1 = n1;
        num2 = n2;
    }
}


