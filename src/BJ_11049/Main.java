package BJ_11049;
//딱봐도 DP 사용해서 시간 줄이는 문제
//문제는 DP를 어떻게 사용하느냐
//그냥 2차 배열 DP를 만들어서 DP[시작][끝] = 팰린드롬 여부

import java.io.*;
import java.util.StringTokenizer;

class Solution {
    int N;
    int[] arr = new int[503];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(0);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(arr, 0));
    }
    public int recur(int[] arr, int count){
        int min = 2000000000;
        if(count == N-2){
            int ans = 1;
            for(int i = 0; i <= N; i++){
                //System.out.print(arr[i] + " ");
                ans *= arr[i];
            }
            return Math.abs(ans);
        }
        for(int i = 1; i <= N-1; i++){
            if(arr[i] == -1){
                continue;
            }
            int[] temp = arr.clone();
            temp[i] = -1;
            int s = i-1, e = i+1;
            while(arr[s] == -1){
                s--;
            }
            while(arr[e] == -1){
                e++;
            }
            int t = recur(temp, count+1) + arr[i]*arr[s]*arr[e];
            //System.out.println(t);
            if(min > t){
                min = t;
            }
        }
        return min;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

