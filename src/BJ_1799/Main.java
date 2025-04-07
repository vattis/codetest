package BJ_1799;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    int N;
    int Max = 0;
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
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j]){
                    recur(arr, 0, i, j);
                    System.out.println(Max);
                    return;
                }
            }
        }
    }
    private int recur(boolean[][] arr, int cnt, int i, int j){
        System.out.println("i: " + i + ", j: " + j);
        if(j >= N){
            return cnt;
        }
        if(Max < cnt){
            Max = cnt;
        }
        if(arr[i][j]){
            boolean[][] a = arr.clone();
            a[i][j] = false;
            int z = i, x = j;
            while(z < N && x < N){
                a[z++][x++] = false;
            }
            z = i; x = j;
            while(z < N && x >= 0){
                a[z++][x--] = false;
            }
            z = i; x = j;
            while(z >= 0 && x < N){
                a[z--][x++] = false;
            }
            z = i; x = j;
            while(z >= 0 && x >= 0){
                a[z--][x--] = false;
            }
            if(i >= N-1){
                recur(a, cnt+1, 0, j+1);
            }else{
                recur(a, cnt+1, i+1, j);
            }
        }
        if(i >= N-1){
            recur(arr, cnt, 0, j+1);
        }else{
            recur(arr, cnt, i+1, j);
        }
        return cnt;
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}