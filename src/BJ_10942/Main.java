package BJ_10942;
//딱봐도 DP 사용해서 시간 줄이는 문제
//문제는 DP를 어떻게 사용하느냐
//그냥 2차 배열 DP를 만들어서 DP[시작][끝] = 팰린드롬 여부

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    int N, M;
    int[] arr = new int[2002];
    boolean[][] DP = new boolean[2002][2002];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <= N; i++){
            DP[i][i] = true;
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(palFunc(start, end)){
                int s = start, e = end;
                bw.write(1+"\n");
                while(s <= e){
                    if(DP[s][e]){ break; }
                    DP[s][e] = true;
                    s++; e--;
                }
            }else{
                bw.write( 0+"\n");
            }
        }
        bw.close();
    }
    boolean palFunc(int start, int end){
        if(DP[start][end]){ return true; }
        int s = start, e = end;
        while(s <= e){
            if(DP[s][e]){ return true; }
            if(arr[s] != arr[e]){ return false; }
            s++; e--;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

