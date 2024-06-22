package BJ_1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution());
    }
    public static class Solution {
        int n, ans;
        int[][] arr = new int[500][500];
        int[][] DP = new int[500][500];
        final int[] moveX = {0, 0, -1, 1};
        final int[] moveY = {-1, 1, 0, 0};
        public Solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(DP[i], 1);
            }
        }
        public void recur(int x, int y, int count){
            int curX, curY;
            for(int i = 0; i < 4; i++){
                curX = x + moveX[i];
                curY = y + moveY[i];
                if(curX<0 || curY<0 || curX>=n || curY>=n || DP[curY][curX] > count || arr[curY][curX]>=arr[y][x]){
                    continue;
                }
                DP[curY][curX] = count+1;

                recur(curX, curY, count+1);
            }
        }
        public int solution(){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(DP[j][i] == 1){
                        if()
                        recur(j, i, 1);
                    }
                }
            }
            int ans = -2;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(ans < DP[i][j]){
                        ans = DP[i][j];
                    }
                }
            }
            return ans;
        }
    }
}

